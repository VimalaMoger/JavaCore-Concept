package java5.enumExamples;

public enum UserType {

    USER("User"),
    EDITOR("Editor"),
    CHIEF_EDITOR("ChiefEditor");

    private UserType(String type) {
        this.type =type;
    }

    private String type;
    public String getType() {
        return type;
    }
}
