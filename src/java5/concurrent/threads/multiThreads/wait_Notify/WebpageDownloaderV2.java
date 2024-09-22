package java5.concurrent.threads.multiThreads.wait_Notify;

import java5.concurrent.threads.multiThreads.webpage_Downloader.HttpConnect;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * For N web links, this approach creates 2 * N threads.
 * htmlPage is not declared as volatile in Weblink, applying wait/notify
 * CPU cycles are not wasted in Indexer as it is waiting for page to be downloaded
 */

public class WebpageDownloaderV2 {
	
	private Deque<Weblink> queue = new ArrayDeque<>();
	
	private static class Weblink {
		private long id;
	    private String title;
		private String url;
	    private String host;

	    private String htmlPage;

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
					String htmlPage = HttpConnect.download(weblink.getUrl());
					weblink.setHtmlPage(htmlPage);
					weblink.notifyAll();
				}//lock is released
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
			synchronized (weblink) {
				String htmlPage = weblink.getHtmlPage();
				while (htmlPage == null) {
					try {
						System.out.println(weblink.getId() + " not yet downloaded");
						weblink.wait();// this thread suspends itself, not wasting cpu cycles
						System.out.println("thread with id " +weblink.getId() + " awakened !");
						htmlPage = weblink.getHtmlPage();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
				//index(htmlPage);
				System.out.println("\nIndexed: " + weblink.getId() + "\n");
			}
		}
	}

	public void go() {
		while (queue.size() > 0) {
			Weblink weblink = queue.remove();
			Thread downloaderThread = new Thread(new Downloader(weblink));
			Thread indexerThread = new Thread(new Indexer(weblink));
			
			downloaderThread.start();
			indexerThread.start();
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
		WebpageDownloaderV2 thread = new WebpageDownloaderV2();

		thread.add(thread.createWeblink(2000, "Nested Classes", "https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html","httpz://docs.oracle.com"));
		thread.add(thread.createWeblink(2001,"Java SE Downloads", "https://www.oracle.com/technetwork/java/javase/downloads/index.html","http://www.oracle.com"));
		thread.add(thread.createWeblink(2002, "Interface vs Abstract Class", "https://www.mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com"));
		thread.add(thread.createWeblink(2004, "Virtual Hosting and Tomcat", "https://tomcat.apache.org/tomcat-9.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org"));
		
		thread.go();
	}
}
