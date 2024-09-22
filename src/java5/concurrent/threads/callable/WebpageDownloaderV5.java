package java5.concurrent.threads.callable;

import java5.concurrent.threads.multiThreads.webpage_Downloader.HttpConnect;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.*;


/**
     *  Created only 4 threads, Executor framework is used for managing threads
     *  Downloader implements Callable
     *  htmlPage is not declared volatile in Weblink, bcos of more visibility
     *  CPU cycles not wasted
     *  Thread blocking can be an issue
     */

    public class WebpageDownloaderV5 {

        private Deque<Weblink> queue = new ArrayDeque<>();

        // Executors
        ExecutorService downloadExecutor = Executors.newFixedThreadPool(2);
        ExecutorService indexerExecutor = Executors.newFixedThreadPool(2);

        private static class Weblink {
            private long id;
            private String title;
            private String url;
            private String host;

            private volatile String htmlPage;

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

        private static class Downloader<T extends Weblink> implements Callable<T> {
            private T weblink;
            public Downloader(T weblink) {
                this.weblink = weblink;
            }
            public T call() {
                try {
                    String htmlPage = HttpConnect.download(weblink.getUrl());
                    weblink.setHtmlPage(htmlPage);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                return weblink;
            }
        }

        private static class Indexer implements Runnable {
            private Weblink weblink;
            private Indexer(Weblink weblink) {
                this.weblink = weblink;
            }
            public void run() {
                    String htmlPage = weblink.getHtmlPage();
                    System.out.println("\nIndexed: " + weblink.getId() + "\n");
            }
        }

        public void go() {
            List<Future<Weblink>> futures = new ArrayList<>();

            while (queue.size() > 0) {
                Weblink weblink = queue.remove();
                futures.add(downloadExecutor.submit(new Downloader(weblink)));
            }
            for(Future<Weblink> future: futures){
                try {
                    indexerExecutor.execute(new Indexer(future.get()));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
            downloadExecutor.shutdown();
            indexerExecutor.shutdown();
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
            WebpageDownloaderV5 thread = new WebpageDownloaderV5();

            thread.add(thread.createWeblink(2000, "Nested Classes", "https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html","httpz://docs.oracle.com"));
            thread.add(thread.createWeblink(2001,"Java SE Downloads", "https://www.oracle.com/technetwork/java/javase/downloads/index.html","http://www.oracle.com"));
            thread.add(thread.createWeblink(2002, "Interface vs Abstract Class", "https://www.mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com"));
            thread.add(thread.createWeblink(2004, "Virtual Hosting and Tomcat", "https://tomcat.apache.org/tomcat-9.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org"));

            thread.go();
        }
}

