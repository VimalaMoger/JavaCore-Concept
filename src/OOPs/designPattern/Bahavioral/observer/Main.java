package OOPs.designPattern.Bahavioral.observer;

/**
 * Observer allows an object notify other objects when its state changes
 * DataSource class sets the value to 1 and calls its inherited method to notify all the observers
 */
public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        SpreadSheet sheet = new SpreadSheet();
        Chart chart = new Chart();

        dataSource.addObserver(sheet);
        dataSource.addObserver(chart);

        dataSource.setValue(1);
    }
}
