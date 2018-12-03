public class Main {
    public static void main(String[] args) {

        System.out.println(A1(0));
        System.out.println(A2(4));
        System.out.println(A3(45, 82));
        System.out.println(A4(30));
    }

    private static String A1(int initVal) {

        String resultA1 = new String();
        int elementVal = initVal;
        int nextElementVal;
        int numberOfElements = 35;


        // I use the for loop because the number of iteartions is fixed to 35
        for (int i = 0; i < numberOfElements; i++) {
//          The initial value wont be processed.
            if (i == 0) {
                nextElementVal = initVal;
//          Check if the element can be divided by 12.
            } else if (elementVal % 12 != 0) {
                nextElementVal = (elementVal * 2) + 4;
            } else {
                nextElementVal = (elementVal / 3) + 1;
            }
//          Add elements to the string.
            resultA1 += nextElementVal + ";";

//          Set the value of the next element.
            elementVal = nextElementVal;
        }
        return resultA1;
    }


    private static String A2(int initVal) {

        String resultA2 = new String();
        int elementVal = initVal;
        int nextElementVal;


        //      check for natural number without 0
        if (initVal > 0) {
            for (int i = 0; i < 20; i++) {
                if (i == 0) {
                    nextElementVal = initVal;
                } else if (elementVal % 2 == 0) {
                    nextElementVal = (-7) + 3 * elementVal;
                }
//                check if a is uneven
                else {
                    nextElementVal = (7) - 3 * elementVal;
                }
                resultA2 += nextElementVal + ";";

                elementVal = nextElementVal;
            }
        } else {
            System.out.println("Not defined for " + initVal);
        }
        return resultA2;
    }

    private static int A3(int x1, int x2) {

        int sum = 0;

        while (x1 <= x2) {
            sum += x1;
            x1++;
        }
        return sum;
    }

    private static double A4(int n) {

        double sumElement;
        double index = 0;
        double sum = 0;

        while (index <= n) {
            sumElement = (Math.pow((-1), index)) / (2 * index + 1);
            sum += sumElement;
            index++;

        }
        return sum;
    }
}
