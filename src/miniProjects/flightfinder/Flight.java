package miniProjects.flightfinder;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Flight implements Comparable<Flight> {
		private int id; 
		private String flightNumber;
		private String airline;
		private String departureCity;
		private String arrivalCity;
		private LocalDateTime departureTime; // Local time at the time zone of the departure city
		private LocalDateTime arrivalTime; // Local time at the time zone of the arrival city
		
		@Override
		public int compareTo(Flight flight) {
			return this.getArrivalTime().compareTo(flight.getArrivalTime());
		}
}


