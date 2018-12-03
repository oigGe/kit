public class Main {
    public static void main(String[] args) {

//        System.out.println(A1(0));
        System.out.println(A12(0));
        System.out.println(A2(4));
        System.out.println(A3(45, 82));
//        System.out.println(A4(30));
        System.out.println(A41(30));

    }

    public static String A1(int initVal) {
        String resultA1 = new String();
        int elementVal = initVal;
        int nextElementVal;
        int numberOfElements = 35;
// I use the for loop because the number of iteartions is fixed to 35
        for (int i = 0; i < numberOfElements; i++) {
            if (i == 0) {
                nextElementVal = initVal;
            } else if (elementVal % 12 == 0) {
                nextElementVal = (elementVal / 3) + 1;
            } else {
                nextElementVal = (elementVal * 2) + 4;
            }
            resultA1 += nextElementVal + ";";
            elementVal = nextElementVal;
        }
        return resultA1;
    }

    public static String A12(int initVal) {
        String resultA1 = new String();
        int elementVal = initVal;
        int nextElementVal;
        int numberOfElements = 35;
        int z = 1;
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
            resultA1 += z + ":" + nextElementVal + "; ";
            z++;
//          Set the value of the next element.
            elementVal = nextElementVal;
        }
        return resultA1;
    }


//    public static String A12(int initVal) {
//        String resultA1 = new String();
//        int elementVal = initVal;
//        int nextElementVal;
//        int numberOfElements = 35;
//        int whichCase;
//// I use the for loop because the number of iteartions is fixed to 35
//
//        for (int i = 0; i < numberOfElements; i++) {
//
//            if (elementVal != initVal) {
//                whichCase = 1;
//            }
//            else if (elementVal % 12 != 0) { whichCase
//
//            elementValMod12 = elementVal % 12;
//
//            switch (elementValMod12) {
//
//                case 0:
//                    nextElementVal = (elementVal / 3) + 1;
//                    break;
//                default:
//                    nextElementVal = (elementVal * 2) + 4;
//                    break;
//            }
//
//            resultA1 += nextElementVal + ";";
//            elementVal = nextElementVal;
//        }
//        return resultA1;
//    }


//
//    public static String A111(int initVal) {
//        String result = new String();
//        int elementVal = initVal;
//        int xn;
//
//        for (int i = 0; i < 35; i++) {
//            if (i == 0) {
//                xn = initVal;
//            } else if (elementVal % 12 == 0) {
//
//                xn = (elementVal / 3) + 1;
//            } else {
//                xn = (elementVal * 2) + 4;
//            }
//
//            result += xn + ";";
//            elementVal++;
//        }
//        return result;
//    }

//    public static String A11(int initVal) {
//        String result = new String();
//
//        int elementVal = initVal;
//        int nextElementVal;
//        int i = 0;
//
//        do {
//
//            if (elementVal % 12 == 0) {
//                nextElementVal = (elementVal / 3) + 1;
//                result += nextElementVal + ";";
//                elementVal = nextElementVal;
//
//            } else {
//                nextElementVal = (elementVal * 2) + 4;
//                result += nextElementVal + "!";
//                elementVal = nextElementVal;
//            }
//            i++;
//
//
//        }
//        while (i < 35);
//        return result;
//    }
//check for not defined in the beginning
//    public static String A2(int initVal) {
//
//        int elementVal = initVal;
//        int nextElementVal;
//        String resultA2 = new String();
//        int z = 1;
////      check for natural number without 0
//        if (initVal <= 0) {
//            System.out.println("Not defined for " + initVal);
//        } else {
//            for (int i = 0; i < 20; i++) {
//                if (i == 0) {
//                    nextElementVal = initVal;
//                } else if (elementVal % 2 == 0) {
//                    nextElementVal = (-7) + 3 * elementVal;
//                }
////                check if a is uneven
//                else {
//                    nextElementVal = (7) - 3 * elementVal;
//                }
//                resultA2 += z + ":" + nextElementVal + "; ";
//                z++;
//                elementVal = nextElementVal;
//            }
//        }
//        return resultA2;
//    }

    //check for not defined in the end
    public static String A2(int initVal) {

        int elementVal = initVal;
        int nextElementVal;
        String resultA2 = new String();
        int z = 1;
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
                resultA2 += z + ":" + nextElementVal + "; ";
                z++;
                elementVal = nextElementVal;
            }


        } else {
            System.out.println("Not defined for " + initVal);
        }
        return resultA2;
    }

    public static int A3(int x1, int x2) {
        int sum = 0;
        while (x1 <= x2) {
            sum += x1;
            x1++;
        }
        return sum;

    }

//    public static double A4 (int n){
//        double sumElement;
//        double index = 0;
//        double sum = 0;
//THIS IS WRONG: DO...WHILE DOESNT MAKE SENSE HERE
//        do{
//          sumElement = (Math.pow((-1),index))/(2*index +1);
//            System.out.println(index + ": " + sumElement);
//            sum += sumElement;
//            index++;
//
//        }
//        while (index <= n);
//        return sum ;
//
//    }


    public static double A41(int n) {
        double sumElement;
        double index = 0;
        double sum = 0;

        while (index <= n) {
            sumElement = (Math.pow((-1), index)) / (2 * index + 1);
//            System.out.println(index + ": " + sumElement);
            sum += sumElement;
            index++;

        }

        return sum;

    }


}
