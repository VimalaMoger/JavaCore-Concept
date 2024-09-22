package java5.concurrent.threads.multiThreads.wait_Notify_Interrupt;

import java5.concurrent.threads.multiThreads.webpage_Downloader.HttpConnect;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebPageDownloaderV3 {

    private Deque<Weblink> queue = new ArrayDeque<>();
    private List<Thread> downloadThreadGroup = new ArrayList<>();
    private List<Thread> indexerThreadGroup = new ArrayList<>();

    private static class Weblink {
        private long id;
        private String title;
        private String url;
        private String host;

        private String htmlPage;
        private volatile boolean stop;
        public void setStop(boolean stop){
            this.stop = stop;
        }
        public boolean isStop(){
            return stop;
        }

        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getUrl() {
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }
        public String getHost() {
            return host;
        }
        public void setHost(String host) {
            this.host = host;
        }
        public String getHtmlPage() {
            return htmlPage;
        }
        public void setHtmlPage(String htmlPage) {
            this.htmlPage = htmlPage;
        }
    }

    private static class Downloader implements Runnable {
        private Weblink weblink;

        public Downloader(Weblink weblink) {
            this.weblink = weblink;
        }

        public void run() {
            try {
                synchronized (weblink) {
                    InputStream in = HttpConnect.getInputStream(weblink.getUrl());

                    // Background thread for stopping download process
                    Thread bgThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                while (!weblink.isStop()) {
                                    TimeUnit.SECONDS.sleep(1);
                                }
                                System.out.println("Time out. Closing stream for " + weblink.getId());
                                in.close();
                            } catch (InterruptedException e) {
                                System.out.println("bgThread interrupted -- " + weblink.getId());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    bgThread.start();

                    String htmlPage;
                    try {
                        htmlPage = HttpConnect.download(in);
                        System.out.println(weblink.getId() + " download complete ...");
                        weblink.setHtmlPage(htmlPage);

                        bgThread.interrupt();

                        weblink.notifyAll();
                    } catch (IOException e) {
                        System.out.println(weblink.getId() + " could not be downloaded. Terminating as stream closed!!!");;
                    }
                }
                // lock is released

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Indexer implements Runnable {
        private Weblink weblink;

        private Indexer(Weblink weblink) {
            this.weblink = weblink;
        }

        public void run() {

            try {
                // Threads waiting here on intrinsic locks are uninterruptible
                synchronized (weblink) {
                    String htmlPage = weblink.getHtmlPage();

                    while (htmlPage == null) {
                        try {
                            System.out.println(weblink.getId() + " not yet downloaded. Waiting ...");
                            weblink.wait();
                            System.out.println(weblink.getId() + " awakened!");
                            htmlPage = weblink.getHtmlPage();
                        } catch (InterruptedException e) {
                            throw e;
                        } // WAITING
                    }
                    System.out.println("\nIndexed: " + weblink.getId() + "\n");
                }
            } catch (InterruptedException e) {
                System.out.println(weblink.getId() + " (indexer) interrupted!!");

                // Clean-up: Stopping downloader thread indirectly
                weblink.setStop(true);
            }
        }
    }

    public void go() {
        while (queue.size() > 0) {
            Weblink weblink = queue.remove();
            Thread downloaderThread = new Thread(new Downloader(weblink));
            downloaderThread.setName("Downloader thread with ID: "+ weblink.getId());

            Thread indexerThread = new Thread(new Indexer(weblink));
            indexerThread.setName("Indexer thread with ID: "+ weblink.getId());

            downloadThreadGroup.add(downloaderThread);
            indexerThreadGroup.add(indexerThread);

            downloaderThread.start();
            indexerThread.start();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Interrupting downloader threads that got BLOCKED
            System.out.println("\nTime Up!!\n");
            for (int i = 0; i < downloadThreadGroup.size(); i++) {
                Thread threadOne = downloadThreadGroup.get(i);
                if (threadOne.isAlive()) {
                    System.out.println(threadOne.getName() + " is still active. Stopping it ...");
                    indexerThreadGroup.get(i).interrupt();
                }
            }

        }
    }

    public void add(Weblink link) {
        queue.add(link);
    }

    public Weblink createWeblink(long id, String title, String url, String host) {
        Weblink weblink = new Weblink();
        weblink.setId(id);
        weblink.setTitle(title);
        weblink.setUrl(url);
        weblink.setHost(host);
        return weblink;
    }

    public static void main(String[] args) {
        WebPageDownloaderV3 thread = new WebPageDownloaderV3();

        thread.add(thread.createWeblink(2000, "Nested Classes", "https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html","httpz://docs.oracle.com"));
        thread.add(thread.createWeblink(2001,"Java SE Downloads", "https://www.oracle.com/technetwork/java/javase/downloads/index.html","http://www.oracle.com"));
        thread.add(thread.createWeblink(2002, "Interface vs Abstract Class", "https://www.mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com"));
        thread.add(thread.createWeblink(2004, "Virtual Hosting and Tomcat", "https://tomcat.apache.org/tomcat-9.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org"));

        thread.go();
    }
}