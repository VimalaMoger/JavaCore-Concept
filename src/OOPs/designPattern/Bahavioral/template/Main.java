package OOPs.designPattern.Bahavioral.template;

/**
 *Task is superclass acts a template,contains some
 * concrete methods, specific behaviors are implemented in the derived classes
 * Inheritance used
 */
public class Main {
    public static void main(String[] args) {
        Task task = new GenerateReportTask();
        task.execute();
    }
}
