package java16;

public record UserRecord(String username, String email, int userId) {
    /**
     * compiler includes all the following auto generated we found boilerplate code in User class
     * A constructor with all declared fields.
     * The equals() and hashCode() methods.
     * The toString() method for printing the values of all fields in the record as usual.
     * The getter methods similar to field names i.e. id(), name(), age() and email(). It doesn’t prefix ‘get’ into it.
     * It does not generate any setter method that indicates a record instance is immutable.
     * The class extends java.lang.Record by default, which is the base class for all records. Hence a record cannot extend any other class.
     * The class is final, so we cannot create a subclass of it.
     */

    public UserRecord {
        if (userId < 1) {
            throw new IllegalArgumentException("UserId can not be less than 1");
        }
    }

    // class (static) variable
    public static final String invalidEmailMessage = "INVALID EMAIL";

    // instance variable - not allowed. Will throw Error.
    public static String defaultEmail = "unknown@yopmail.com";

    // Class function
    public static void sayMyName() {
        System.out.println("Heisenberg");
    }
    // instance function
    public String emailDomain() {
        return defaultEmail.split("@")[1];
    }

}
