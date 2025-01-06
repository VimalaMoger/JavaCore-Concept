package OOPs.designPattern.creational.prototype;

public class ContextMenu {
    public Component duplicate(Component component){
      return component.clone();
    }
}
