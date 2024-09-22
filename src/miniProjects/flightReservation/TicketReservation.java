package miniProjects.flightReservation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class TicketReservation {

    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;
    private List<Passenger> confirmedList = new ArrayList<>();
    private Deque<Passenger> waitingList = new ArrayDeque<>();

    /**      
     * Returns true if passenger could be added into either confirmedList or      
     * waitingList. Passenger will be added to waitingList only if confirmedList      
     * is full.      
     *      
     * Return false if both passengerList & waitingList are full      
     */     
     public boolean bookFlight(String firstName , String lastName, int age, String gender, String travelClass, String confirmationNumber) {
    	 Passenger p = new Passenger(firstName,lastName,age,gender,travelClass, confirmationNumber);
    	 boolean reserve = false;
    	 if(confirmedList.size() < TicketReservation.CONFIRMEDLIST_LIMIT) {
    		 confirmedList.add(p);
    		 reserve = true;
    	 }else if(waitingList.size() < TicketReservation.WAITINGLIST_LIMIT){
    		 waitingList.add(p);
    		 reserve = true;
    	 }else
    		 reserve = false;
		return reserve;
    }

     public void display() {
    	 for(Passenger p : confirmedList) {
			 System.out.println(p.toString());
		 }
    	 for(Passenger p : waitingList) {
    		 System.out.println(p.toString());
    	 }
     }

    /**      
     * Removes passenger with the given confirmationNumber. Passenger could be      
     * in either confirmedList or waitingList. The implementation to remove the      
     * passenger should go in removePassenger() method and removePassenger method      
     * will be tested separately by the uploaded model.test scripts.
     
     * If passenger is in confirmedList, then after removing that passenger, the      
     * passenger at the front of waitingList (if not empty) must be moved into      
     * passengerList. Use poll() method (not remove()) to extract the passenger      
     * from waitingList.      
     */     
    public boolean cancel(String confirmationNumber) {
    	Iterator it = waitingList.iterator();
    	Iterator it1 = confirmedList.iterator();
	      boolean bool1= removePassenger(it,confirmationNumber);
	      boolean bool2= removePassenger(it1,confirmationNumber);
	      if(bool2) {
	    	  if(!waitingList.isEmpty()) {
	    		  Passenger p = waitingList.pop();
	    		  confirmedList.add(p);
	    	  }
	    	  return true;
	      }else if(bool1) {
	    	  return true;
	      }
	      
	     return false;
    }

    /**      
     * Removes passenger with the given confirmation number.      
     * Returns true only if passenger was present and removed. Otherwise, return false.      
     */     
    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {   
        boolean confirm=false;

        while(iterator.hasNext()){
            Passenger p = iterator.next();
            if(p.getConfirmationNumber() == confirmationNumber) {
                iterator.remove();
                confirm= true;
            }
        }
        return confirm;
    }

    public static void main(String[] args) {
    
    	TicketReservation reserve = new TicketReservation();

    	boolean confirm =  reserve.bookFlight("Tracy", "John", 43, "femala","economy" , "a1");
    	confirm =  reserve.bookFlight("Levi", "James", 43, "male","economy" , "a2");
    	confirm =  reserve.bookFlight("Leo", "Jack", 43, "male","economy" , "a3");
    	confirm =  reserve.bookFlight("Henry", "John3", 43, "male","economy" , "a4");
    	confirm =  reserve.bookFlight("Amy", "Kohls", 43, "female","economy" , "a5");
    	confirm =  reserve.bookFlight("Nancy", "Dave", 43, "female","economy" , "a6");
    	
    	confirm =  reserve.bookFlight("Acura", "Neel", 43, "female","economy" , "a7");
    	confirm =  reserve.bookFlight("Rocky1", "Oliver", 43, "male","economy" , "a8");
    	confirm =  reserve.bookFlight("Shally", "Rocks", 43, "female","economy" , "a9");
    	confirm =  reserve.bookFlight("James", "Willium", 43, "male","economy" , "a10");

	boolean confirmRocky4 =  reserve.bookFlight("Rocky4", "Dave3", 43, "femala","economy" , "a11");

	System.out.println("confirm Rocky4\n " + confirmRocky4);
    	reserve.display();

    	boolean cancelled =reserve.cancel("a11");
    	System.out.println("cancelled a11-confirmation Number\n " +cancelled);

	System.out.println("After removing a11\n");
    	reserve.display();
    
    }

}
