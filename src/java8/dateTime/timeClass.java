package java8.dateTime;

import java.time.LocalDateTime;
import java.time.Month;

public class timeClass {

	public static void main(String[] args) {

		//with String parsing
		 LocalDateTime dt1 = LocalDateTime.parse("2018-11-03T12:45:30");
		 LocalDateTime dt2 = LocalDateTime.parse("2016-12-04T12:45:30");
		 System.out.println(dt1.isAfter(dt2));
		 //with specific date and time
		 //LocalDateTime.of method is a factory method to create instance
		 LocalDateTime aDateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
		 LocalDateTime twoHoursAfter=aDateTime.plusHours(2);
		 System.out.println(aDateTime);
		 System.out.println(twoHoursAfter);
	}
}
