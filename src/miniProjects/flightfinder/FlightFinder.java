package miniProjects.flightfinder;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@Data
public class FlightFinder {
	private Map<String, List<Flight>> allFlights = new HashMap<>();

	public FlightFinder(Map<String, List<Flight>> allFlights) {
		this.allFlights = allFlights;
	}

	public List<NavigableSet<Flight>> findFlights(int dayOfMonth, int month, int year,
	        int preferredDepartureStartHour, int preferredDepartureEndHour,
	        String departureCity, String arrivalCity, String finalArrivalCity,
			String departureCityTimeZone, String arrivalCityTimeZone) {
		
		List<NavigableSet<Flight>> result = new ArrayList<>();
        int min =0;
        int sec =0;
        int nano =0;
        // Step 1: Construct ZonedDateTime objects to represent User-specified time interval when flights depart
        ZonedDateTime zonedDateTime=  ZonedDateTime.of(year,month,dayOfMonth,preferredDepartureStartHour,min,sec,nano,ZoneId.of(arrivalCityTimeZone));

        // Step 2: Find departing flights at departureCity
        System.out.println("\n departureCity.. "+departureCity);
        List<Flight> allDepartingFlights = allFlights.get(departureCity);
        
        System.out.println("\n allDepartingFlights... "+ allDepartingFlights);
        NavigableSet<Flight> departingflights = new TreeSet<>();
  
     
        for(Flight flight : allDepartingFlights){
        	
        	//DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:ss:mm");  
            LocalDateTime dt1 = LocalDateTime.of(year, month, dayOfMonth, preferredDepartureStartHour, min,sec);
          
            LocalDateTime dt2 = flight.getDepartureTime();  //returns in localdatetime format
            System.out.println(dt2.getHour()); //extract hour
            LocalDateTime dt3 = LocalDateTime.of(year, month, dayOfMonth, preferredDepartureEndHour, min,sec);
         
     
            if(dt2.getHour()>=preferredDepartureStartHour && dt2.getHour()<=preferredDepartureEndHour){
                departingflights.add(flight);
            }
        }
        for(Flight f2: departingflights) {
        	System.out.println("departingFlights "+f2);     
        }
        // Step 3: Find connecting flights
        //   Constraint 1: Departing at arrivalCity (e.g., Dubai) and arrive at finalArrivalCity (e.g., Mumbai)
        //   Constraint 2: Should start at least two hours after the arrival time of the first flight in the above navigable set
        System.out.println("\n arrivalCity.. "+arrivalCity);
        List<Flight> allConnectingFlights = allFlights.get(arrivalCity);     
        System.out.println("\nconnectingFlights "+allConnectingFlights);   
        
        for(Flight f2: allConnectingFlights) {
        	System.out.println("connectingFlights "+f2);     
        }
        NavigableSet<Flight> connectingflights = new TreeSet<>();        
        for(Flight flight: allConnectingFlights){
           LocalDateTime dt =((Flight) departingflights).getArrivalTime();
         
            LocalDateTime twoHoursAfter = dt.plusHours(2);
            LocalDateTime dt2 = flight.getDepartureTime();
            if(dt2.getHour() >= twoHoursAfter.getHour()){
                connectingflights.add(flight);
            }
        }
        result.add(departingflights);
        result.add(connectingflights);

        return result;
	}

	public static void main(String[] args) {
		ArrayList<String> list= new ArrayList();
		 	Flight f1 = new Flight(1, "1", "Emirates", "New York", "Dubai",LocalDateTime.of(2017, 12, 20, 9, 0,0), LocalDateTime.of(2017, 12, 20,9, 0,0));
			Flight f2 = new Flight(2, "2", "Delta", "San Francisco", "Paris",
					LocalDateTime.of(2017, 12, 20, 9, 0,0), LocalDateTime.of(2017, 12, 20, 9, 0,0));
			Flight f3 = new Flight(3, "3", "Delta", "San Francisco", "Rome",
					LocalDateTime.of(2017, 12, 20, 9, 0,0), LocalDateTime.of(2017, 12, 20, 9, 0,0));
			Flight f4 = new Flight(4, "4", "Emirates", "San Francisco", "Dubai",
					LocalDateTime.of(2017, 12, 20, 8, 0,0), LocalDateTime.of(2017, 12, 20, 8, 0,0));
			
			Map<String, List<Flight>> allFlights = new HashMap<>();
			
			allFlights.put("New York", Arrays.asList(f1));
			allFlights.put("San Francisco", Arrays.asList(f2, f3, f4));
			List<NavigableSet<Flight>> result = new FlightFinder(allFlights).findFlights(20, 12, 2017, 9, 10, "San Francisco", "Dubai", "Mumbai", "America/Los_Angeles", "Asia/Dubai");
			for(NavigableSet<Flight> flight: result) {
				System.out.println(flight);
			}
			//System.out.println(new FlightFinder(allFlights).findFlights(0, 0, 0, 0, 0, null, null, null, null, null))
		//	System.out.println("\n" +allFlights.get("New York"));
		
	}

}
