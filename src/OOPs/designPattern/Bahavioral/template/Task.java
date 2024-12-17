package OOPs.designPattern.Bahavioral.template;
//refactored the code with Single Responsibility(SOLID) and open for extension and closed for modification(one
//of the SOLID principles)
//also Inheritance concept for reusable purpose, for using pre-existing code

public abstract class Task {
    private AuditTrail auditTrail;

    public Task(){
        this.auditTrail = new AuditTrail();
    }

    public Task(AuditTrail auditTrail){
        this.auditTrail = auditTrail;
    }
    public void execute(){
        auditTrail.record();
        doExecute();
    }
    protected abstract  void doExecute();
}
