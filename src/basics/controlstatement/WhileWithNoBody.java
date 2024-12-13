package basics.controlstatements;

public class WhileWithNoBody {
    public static void main(String[] args) {
        int i, j; //i and j variables
        i = 100;
        j = 200;
        //find midpoint between i and j
        while(++i < --j);
        System.out.println("Midpoint of i and j is " +  i + j);

    }
}
