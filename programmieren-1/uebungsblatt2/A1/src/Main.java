public class Main {


    public static void main(String[] args) {
        int x1 = 0;
        int xn;
        int[] elements = new int[100];


        for (int i = 0; i < 35; i++) {
            if (i == 0){
                xn = x1;
            }

            else if (x1 % 12 == 0) {

                xn = (x1 / 3) + 1;
            } else {
                xn = (x1 * 2) + 4;

            }
//
            elements[i] = xn;

            x1++;
        }

        for (int i = 0; i < 35 ; i++) {
            System.out.print( elements[i] + ",");
        }

    }
}
