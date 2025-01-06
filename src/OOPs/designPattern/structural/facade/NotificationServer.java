package OOPs.designPattern.structural.facade;

public class NotificationServer {
   // connect to server connect() -> Connection
    // authenticate(appID, key) -> AuthToken
    //send(authToke, message,target)
    //con.disconnect()
    public Connection connect(String ipAddress){
        return  new Connection();
    }
    public AuthToken authenticate(String appID, String key){
        return new AuthToken();
    }
    public void send(AuthToken authToken, Message message, String target){
        System.out.println("Sending a message");
    }
}
