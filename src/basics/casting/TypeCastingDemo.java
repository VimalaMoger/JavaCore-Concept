package basics.casting;

public class TypeCastingDemo {
    public static void main(String[] args) {
        //implicit casting
        float f1 = 3.133f;
        float f2 = 4.135f;
        double addf1f2 = f1 + f2;
        double multiplyf1f2 = f1 * f2;
        System.out.println("addf1f2 " + addf1f2);
        System.out.println("multipy "+ multiplyf1f2);

        //int to long
        int x =42; long y;
        y = x;
        System.out.println("y "+ y);

        //char to int
        char cChar ='A';
        int iInt = cChar;
        System.out.println("iInt "+ iInt );

        //byte to char using an explicit cast
        byte bByte = 65;
        cChar =(char)bByte; //special conversion (widening from byte --> int followed by narrowing from int --> char)
        System.out.println("cChar "+ cChar);

        //explicit casting

        //double avg = (2 + 3)/2;
        double avg = (double)(2 + 3)/2;
        System.out.println("avg "+ avg);

        long j = 42;
        //int i = j;
        int i = (int) j;

        //information loss due to out-of range assignment
        //byte narrowedByte = 123456;
        //byte narrowedByte =  128;
        byte narrowedByte = (byte) 123456;
        byte narrowedByte2 = 127;    //byte type takes this value
        System.out.println("narrowedByte "+ narrowedByte);

        //Truncation
        //int iTruncated = 0.99;
        int iTruncated = (int)0.99;
        System.out.println("iTruncated "+ iTruncated);
    }
}
