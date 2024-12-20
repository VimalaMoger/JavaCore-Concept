package OOPs.designPattern.Bahavioral.command;

import OOPs.designPattern.Bahavioral.command.fx.*;

/**
 * Command allows decouple a sender from a receiver. The sender will talk to the receiver through
 * a command. Commands can be undone and persisted
 */

public class Main {
    public static void main(String[] args) {
        CustomerService service = new CustomerService();
        Command command = new AddCustomerCommand(service); //delegating the request
        Button button = new Button(command);
        button.click();

        //we can combine multiple commands and execute them later
        var composite = new CompositeCommand();
        composite.add(new ResizeCommand());
        //composite.add(new AddCustomerCommand());
        composite.add(new BlackAndWhiteCommand());
        composite.execute();
    }
}
