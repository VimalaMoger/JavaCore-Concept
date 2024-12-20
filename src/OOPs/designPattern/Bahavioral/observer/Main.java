package OOPs.designPattern.Bahavioral.observer;

/**
 * Observer allows an object notify other objects when its state changes
 */
public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        SpreadSheet sheet = new SpreadSheet();
        Chart chart = new Chart();

        dataSource.addObserver(sheet);
        dataSource.addObserver(chart);

        //dataSource.notifyObservers();
        dataSource.setValue(1);
    }
}
