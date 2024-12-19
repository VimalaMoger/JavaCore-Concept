package OOPs.designPattern.Bahavioral.observer;

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
