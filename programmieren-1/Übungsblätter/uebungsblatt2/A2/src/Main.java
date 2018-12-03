public class Main {
    public static void main(String[] args) {
        int xn = 0;
        int n = 4;
        int[] elements = new int[21];

//      check for natural number without 0
        if (n <= 0 || n != (int)n ) {
            System.out.println("Not defined for " + n);

        } else {
            for (int i = 0; i <= 20; i++) {
//                check if n is even
                if (n % 2 == 0) {
                    xn = 7 - 3 * n;
                }

//                check if a is uneven
                if (n % 2 == 1) {
                    xn = (-7) + 3 * n;
                }
//                store elements in array
                elements[i] = xn;
                n++;
            }
            for (int i = 0; i <= 20; i++) {
                System.out.print(elements[i] + ";");
            }
        }
    }
}

