package basics.controlstatements;

public class ForIteration {
    public static void main(String[] args) {
        int a,b;
        for(a=1, b=4; a<b; a++, b--){
            System.out.println(" a is "+ a + " b is "+ b);
        }

        //endless loop with condition
        int i = 0;
        boolean done = false;
        for( ; !done ;){
            System.out.println("i is "+ i);
            if( i == 10){
                done =true;  //break;
            }
            i++;
        }

        //nested for loop
       for(int j =0; j < 5;j++){
           for(int k=j; k<5; k++){
               System.out.print("*");
           }
           System.out.println();
       }

    }
}
