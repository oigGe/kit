package georggross;

import georggross.Grammar.Checker;

public class Main {
    public static void main(String[] args) {
        String input = "(90 + 4000i)";
        System.out.println(input.matches(Checker.COMPLEX_REGEX));

    }
}
