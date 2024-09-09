package basics.classReference;

public class MethodOverloading {

    static void go(int[] array){
        System.out.println("array[0] called "+ array[0]);
    }
    static void go(int i){
        System.out.println("go(int i) called ");
    }
    static void go(short i){
        System.out.println("go(short i) called ");
    }
    //void go(int i){}  //error.... method already defined
    //int go(int i){return 23;}   //error already defined

    static void varargsOverload(boolean bool, int i, int j, int k){
        System.out.println("without varargs ...");
    }
    static void varargsOverload(boolean bool, int... list){
        System.out.print("with varargs ...");
        System.out.println("list.length "+ list.length);
    }


    public static void main(String[] args) {
        int[] array = {1,2};
        go(array);
        System.out.println(array[1]);
        go(1000);
        go(1000);
        byte b =56;
        go(b);

        varargsOverload(true, 1,2,3);
        varargsOverload(true, 1,2,3,4,5,6,7);
        varargsOverload(true);
    }
}
