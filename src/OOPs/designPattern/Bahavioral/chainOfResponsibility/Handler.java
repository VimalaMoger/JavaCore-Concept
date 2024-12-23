package OOPs.designPattern.Bahavioral.chainOfResponsibility;

public abstract class Handler {
    private  Handler newHandler;

    public Handler(Handler newHandler){
        this.newHandler = newHandler;
    }
    public void handle(HttpRequest request){
        if(doHandle(request))
            return;
        if(newHandler != null)
            newHandler.handle(request);
    }
    public  abstract  boolean doHandle(HttpRequest request);
}
