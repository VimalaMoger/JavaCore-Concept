package basics.controlstatements;

public class BreakAsGoTo {
    public static void main(String[] args) {
        boolean t = true;
        first:{
            second:{
                third: {
                    System.out.println("Before the break ");
                    if(t){
                        break second;
		    }	
                    System.out.println("This won't execute ");
                }
                System.out.println("This won't execute ");
            }
            System.out.println("This statement inside first block, so will surely execute ");
        }
    }
}
