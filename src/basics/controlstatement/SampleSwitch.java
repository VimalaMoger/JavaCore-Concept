package basics.controlstatements;

public class SampleSwitch {
    public static void main(String[] args) {
        for(int i=0; i<6; i++){
	    //switch-case	
            switch (i){
                case 0:
                    System.out.println("i is " + i);
                    break;
                case 1:
                    System.out.println("i is " + i);
                    break;
                case 2:
                    System.out.println("i is " + i);
                    break;
                case 3:
                    System.out.println("i is " + i);
                    break;
                default:
                    System.out.println("i is greater than 3 i.e " + i);
                    break;
            }


        }
    }
}
