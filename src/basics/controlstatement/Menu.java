package basics.controlstatements;

import java.io.IOException;

public class Menu {
    public static void main(String[] args) throws IOException {
        char choice;
        do{
            System.out.println("Help on: ");
            System.out.println("1. If");
            System.out.println("2. Switch");
            System.out.println("3. While");
            System.out.println("4. doWhile");
            System.out.println("5. For");
            choice = (char)System.in.read();

        }while(choice < '1' ||  choice > '5');
        System.out.println("\n");
	//switch-case
        switch (choice){
            case '1':
                System.out.println("If : \n");
                System.out.println("if/else condition");
                break;
            case '2':
                System.out.println("Switch: \n");
                System.out.println("switch(expression) and case constant - options");
                break;
            case '3':
                System.out.println("While: \n");
                System.out.println("While(condition)");
                break;
            case '4':
                System.out.println("doWhile: \n");
                System.out.println("do(statement) - while(condition");
                break;
            case '5':
                System.out.println("For: \n");
                break;

        }
    }
}
