package OOPs.types.abstraction;

public class Main {
    public static void main(String[] args) {
        var mailService  = new MailService();
        mailService.sendEmail(); //visible to main class
    }
}
