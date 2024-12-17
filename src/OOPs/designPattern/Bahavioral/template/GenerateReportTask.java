package OOPs.designPattern.Bahavioral.template;

public class GenerateReportTask extends Task{
    //inheritance used here for code reuse
    @Override
    public void doExecute() {
        System.out.println("Generate Report");
    }
}
