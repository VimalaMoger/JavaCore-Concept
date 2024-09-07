package java16;

public class mainClass {


    public static void main(String[] args) {

        // Initialize the record.
        UserRecord userRecord = new UserRecord("rana", "rana@yopmail.com", 1234);
        // get the properties
        System.out.println(userRecord.email());
        System.out.println(userRecord.toString());

        // calling instance method using object
        System.out.println(userRecord.emailDomain());

        // calling static method using Class.
        UserRecord.sayMyName();
    }


}
