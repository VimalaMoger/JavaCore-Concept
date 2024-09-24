package java16;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {
    /**
     User and sale made by a user are record classes.
     The aggregation of a user and their total monthly sales is modeled with a local record
     class, UserSales, which is declared inside the findTopUsers method
     */
    List<UserRecord> findTopUsers(List<Sale> sales, List<UserRecord> users, int year, Month month){

        //local record class
        record UserSales(UserRecord user, double sales){}

        return users.stream()
                .map(u -> new UserSales(u, this.computeSales(sales, u, year, month)))
                .sorted((m1, m2) -> Double.compare(m2.sales(),m1.sales()))
                .map(u -> u.user)
                .collect(Collectors.toList());
    }

    double computeSales(List<Sale> sales, UserRecord user, int yr, Month month){
        return sales.stream()
                .filter(s -> s.user().username().equals(user.username()) && s.date().getYear() == yr && s.date().getMonth() == month)
                .mapToDouble(Sale::value)
                .sum();
    }

    public static void main(String[] args) {

        // Initialize the record.
        UserRecord userRecord = new UserRecord("Raj", "raj@yahoo.com", 1, 12);
        // get the properties
        System.out.println(userRecord.email());
        System.out.println(userRecord.toString());

        // calling instance method using object
        System.out.println(userRecord.emailDomain());

        // calling static method using Class.
        UserRecord.sayMyName();

        //invoking nested class method
        UserRecord.Age age = new UserRecord.Age();
        System.out.println("user is: "+ age.getAgeGroup(userRecord.age()));

        System.out.println("\n");

        // list of user records
        UserRecord sneha = new UserRecord("Sneha", "sneha@yahoo.com", 1, 11);
        UserRecord raj = new UserRecord("Raj", "raj@yahoo.com", 2, 23);
        UserRecord florence = new UserRecord("Florence", "Florence@yahoo.com", 3, 33);
        UserRecord leo = new UserRecord("Leo", "leo@yahoo.com", 4, 13);

        List<UserRecord> userList = List.of(sneha, raj, florence, leo);

        List<Sale> salesList = List.of(
                new Sale(sneha,    LocalDate.of(2020, Month.NOVEMBER, 13), 11034.20),
                new Sale(raj,      LocalDate.of(2020, Month.NOVEMBER, 20),  8234.23),
                new Sale(florence, LocalDate.of(2020, Month.NOVEMBER, 19), 10003.67),
                new Sale(leo,      LocalDate.of(2020, Month.NOVEMBER,  4),  9645.34),
                new Sale(leo,      LocalDate.of(2020, Month.NOVEMBER,  4),  9645.34));
        MainClass app = new MainClass();
        List<UserRecord> topUsers = app.findTopUsers(salesList, userList, 2020, Month.NOVEMBER);
        System.out.println("Top users: ");
        topUsers.stream().forEach(u -> System.out.println(u.username()));

    }
}
record Sale(UserRecord user, LocalDate date, double value){}
