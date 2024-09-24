package java16;

public record UserRecord(String username, String email, int userId, int age) {

    //Canonical Constructor
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

    // Nested record class
    record Age() {
        private static String ageGroup;

        public String getAgeGroup(int age) {
            if (age >= 13 && age <= 17)
                ageGroup = "Teenager";
            else if (age >= 18)
                ageGroup = "Adult";
            else
                ageGroup = "Child";
            return ageGroup;
        }
    }
}


