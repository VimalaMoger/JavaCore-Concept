package java5.concurrent.threads.executor;

import java5.concurrent.threads.multiThreads.webpage_Downloader.HttpConnect;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *  Created only 4 threads, Executor framework is used for managing threads
 *  htmlPage is declared volatile in Weblink
 *  Limitation:CPU cycles still being wasted
 */

public class WebPageDownloaderV4 {

    private Deque<Weblink> queue = new ArrayDeque<>();

    // Executors
    Executor downloadExecutor = Executors.newFixedThreadPool(2);
    Executor indexerExecutor = Executors.newFixedThreadPool(2);

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

    private static class Downloader implements Runnable {
        private Weblink weblink;
        public Downloader(Weblink weblink) {
            this.weblink = weblink;
        }
        public void run() {
            try {
                String htmlPage = HttpConnect.download(weblink.getUrl());
                weblink.setHtmlPage(htmlPage);
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
            while (true) {
                String htmlPage = weblink.getHtmlPage();
                if (htmlPage != null) {
                    System.out.println("\nIndexed: " + weblink.getId() + "\n");
                    break;
                } else {
                    System.out.println(weblink.getId() + " not yet downloaded!");
                }
            }
        }
    }

    public void go() {
        while (queue.size() > 0) {
            Weblink weblink = queue.remove();
            downloadExecutor.execute(new Downloader(weblink));
            indexerExecutor.execute(new Indexer(weblink));
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
        WebPageDownloaderV4 thread = new WebPageDownloaderV4();

        thread.add(thread.createWeblink(2000, "Nested Classes", "https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html","httpz://docs.oracle.com"));
        thread.add(thread.createWeblink(2001,"Java SE Downloads", "https://www.oracle.com/technetwork/java/javase/downloads/index.html","http://www.oracle.com"));
        thread.add(thread.createWeblink(2002, "Interface vs Abstract Class", "https://www.mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com"));
        thread.add(thread.createWeblink(2004, "Virtual Hosting and Tomcat", "https://tomcat.apache.org/tomcat-9.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org"));

        thread.go();
    }
}
