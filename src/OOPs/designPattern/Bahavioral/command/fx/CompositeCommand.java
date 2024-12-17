package OOPs.designPattern.Bahavioral.command.fx;

import java.util.ArrayList;
import java.util.List;

public class CompositeCommand implements Command{
    private List<Command> commandList = new ArrayList<>();

    public void add(Command command){
        commandList.add(command);
    }

    @Override
    public void execute() {
        for(var command : commandList){
            command.execute();
        }
    }
}
