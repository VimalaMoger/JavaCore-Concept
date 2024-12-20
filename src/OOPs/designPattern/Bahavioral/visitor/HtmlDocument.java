package OOPs.designPattern.Bahavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class HtmlDocument {
    private List<HtmlNode> nodes = new ArrayList<>();
    public void add(HtmlNode node){
        nodes.add(node);
    }
    public void execute(Visitor visitor){
        for(var node : nodes){
            node.execute(visitor);  //takes an operation object
        }
    }
}
