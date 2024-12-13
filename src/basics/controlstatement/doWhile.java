package basics.controlstatements;

import java.io.IOException;
import java.util.Scanner;

public class doWhile {
    public static void main(String[] args) {
        char ch;
        Scanner scanner = new Scanner(System.in);
        try {
            do {
                System.out.println("Let's play a game ");
                System.out.println("2. Display a square of two ");
                System.out.println("3. Display a cube of two");
                int in = scanner.nextInt();
                if(in == 2){
                    System.out.println("square of 2 is 4");
                }else if (in ==3 )
                    System.out.println("cube of 2 is 8");
                System.out.println("Do you want to play more? y/n");

                ch = (char) System.in.read();
            } while (ch != 'n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
