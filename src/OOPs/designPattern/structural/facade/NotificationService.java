package OOPs.designPattern.structural.facade;

public class NotificationService {
    public void send(String message, String target ){
        var server = new NotificationServer();
        var conn =  server.connect("ip");
        var authToken = server.authenticate("appID", "key");
        server.send(authToken, new Message(message), target);
        conn.disconnect();
    }
}
