package georggross.tests;

public class TestStrings {
    public static final String[] test1 = {
        "valueLength",
        assign1Complex("valueLength", 10, 30),
        assign1Complex("valueWidth", 90, 20),
        "valueComposition =       valueLength +valueWidth",
        "valueComposition = valueLength - valueWidth",
        "valueComposition = valueLength * valueWidth",
        "valueComposition = " + MyStringBuilder.buildComplex(1, 2) + " / " + complex(10, 5),
        "valueComposition = " + complex(5, 20) + " / " + complex(10, 5),
        "valueComposition = [valueLength + valueWidth] - valueLength",
        "valueLength",
        "valueComposition =  valueComposition",
        "valueComposition = valueLength + valueLength *valueWidth",
        "valueComposition = valueLength + valueLength",
        "valueLength = valueLength + valueWidth",
        "quit"
    };


    public static final String[] testerrors = {
        "valueLength",
        assign1Complex("valueLength", 10, 30),
        assign1Complex("valueWidth", 90, 20),
        "valueComposition =  valueLength + valueWidth",
        "valueComposition = valueLength - valueWidth",
        "valueComposition = valueLength * valueWidth",
        "valueComposition = " + MyStringBuilder.buildComplex(1, 2) + " / " + complex(10, 5),
        "valueComposition = " + complex(5, 20) + " / " + complex(10, 5),
        "valueComposition = [valueLength + valueWidth] - valueLength ",
        "valueLength",
        "valueComposition =  valueComposition",
        "valueComposition = valueLength + valueLength * valueWidth",
        "valueComposition = valueLength + valueLength",
        "valueLength = valueLength + valueWidth",
        "quit"
    };

    public static final String[] test7 = {
        "valueLength",
        assign1Complex("valueLength", 10, 30),
        assign1Complex("valueWidth", 90, 20),

        "valueComposition = valueLength + valueLength * valueWidth",

        "quit"
    };


    public static final String[] test2 = {
        assign1Complex("quit", 1, 1),
        "hallo",
        "hallo = hallo - hallo",
        assign1Complex("hallo", 1, 1),
        "hallo = hallo - hallo",
        "hallo",
        "hallo = hallo / hallo",
        "hallo",
        assign1Complex("hallo", -1222, -12321),
        assign1Complex("hallo", +1222, +12321),

    };

    public static final String[] test3 = {
        "a = [(1 + 3i) + (6 + 7i)] * (2 + 7i)",
        "c = [(1 + 4i) + (6 + 5i)] * (3 + 3i)",
        "b = [(7 + 3i) + (8 + 7i)] * (1 + 1i)",
        "d = [[a + b]]] + ["
    };


    public static final String[] test4 = {
        "a = [(1 + 3i) + (6 + 7i) ] * (3 + 7i)",
        "a = [ (1 + 3i) + (6 + 7i)] * (3 + 7i)",
        "a = [(1 + 3i) + (6 + 7i)] * (3 + 7 i)",
        "a = [(1 + 3i) + (6 + 7i)] * (3 + 7i)",
        "a",
        "23442rfw++++++++++",
        "a = [][[[[[[]]]]]]]]]] ",
        "a = (100 + 1i) ",
        "a = (100 + 1i)",
        "a ",
        "a",
        "a = ([1 + 2i])",
        "a + a = (1 + 2i)",
        " a = 0"

    };

    public static final String[] ilias = {
        "x = [(1 + 0i) / (3 + +0i)] * (4 + 0i)",
    };

    public static final String[] test6 = {

    };

    public static final String[] test5 = {
        assign1Complex("a", 2, 3),
        assign1Complex("b", 5, 6),
        assign1Complex("c", 7, 1),
        "f = [[c - a] + [[[a - b] + a] * b] - a]"
    };


    private static String complex(int a, int b) {
        return MyStringBuilder.buildComplex(a, b);
    }

    private static String assign1Complex(String name, int a, int b) {
        return MyStringBuilder.buildSingleComplexZuweisung(name, a, b);
    }


}
