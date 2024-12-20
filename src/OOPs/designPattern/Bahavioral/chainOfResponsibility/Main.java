package OOPs.designPattern.Bahavioral.chainOfResponsibility;

/**
 Chain of Responsibility allows building a chian of objects to process a request
 */
public class Main {
    public static void main(String[] args) {
        //Authenticator -> Compressor -> Encryptor
        //replace logger with Encryptor
        //var logger = new Logger(null);
        var encryptor = new Encryptor(null);
        var compressor = new Compressor(encryptor);
        var authenticator = new Authenticator(compressor);
        var webServer = new WebServer(authenticator);
        webServer.handle(new HttpRequest("admin", "1234"));
    }
}
