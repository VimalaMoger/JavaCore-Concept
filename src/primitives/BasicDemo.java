package primitives;

public class BasicDemo {
    public static void main(String[] args) {
        //java 7
        int intBinary = 0b100_0001;
        System.out.println("intBinary "+ intBinary);
        int intOctal = 0100;
        char charInt = 65;
        System.out.println("charInt "+ (int)charInt);
        //char charInt2 = -1; //outside the range of char
        int intChar = 'A';
        System.out.println("intChar "+ (char)intChar);
        char charHex = 0x0041;
        char charBinary = 0b100_0001;

    }
}
