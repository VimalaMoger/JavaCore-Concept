package basics.arrays;

public class ThreeDArray {
    public static void main(String[] args) {
        int[][][] array = {
                {{0, 1}, {2, 3}, {8,9}},     //1st row, oth set{}, third element
                {{4, 5, 9}, {6, 7}},
                {{3, 4}, {5, 6, 8}}
        };
        System.out.println("element at [1][0][2] " + array[1][0][2]);

        System.out.println("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print("{");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("{");
                for (int k = 0; k < array[i][j].length; k++) {
                    System.out.print(array[i][j][k]);
                    if(k < array[i][j].length-1)
                        System.out.print(", ");
                }
                System.out.print("}");
                if(j < array[i].length-1)
                    System.out.print(",");
            }
            System.out.println("},");

        }
        System.out.println("}");
    }
}
