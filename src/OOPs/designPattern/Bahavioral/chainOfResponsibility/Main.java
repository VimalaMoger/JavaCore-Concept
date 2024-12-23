package OOPs.designPattern.Bahavioral.chainOfResponsibility;

/**
 Chain of Responsibility allows building a chain of objects to process a request
 webserver points to authenticator object, runs its handle method, which in turn invokes handle
 method of Handler
 new handler is initialized in handler/super class, checked if not null, and process the next operation
 Abstraction, open/closed, single responsibility
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
