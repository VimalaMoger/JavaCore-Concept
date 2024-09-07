package java1.jdbc.jdbcConnection;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employees {
    long id;
    private String email;
    private String firstName;
    private String lastName;
}
