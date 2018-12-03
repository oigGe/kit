public class Main {
    public static void main(String args[]) {
//        "==" is the wrong operator. It checks if the values of two operands are equal. In our case we want to assign
//        a new value. We need to use "=".
//        The String value John needs to be in quotation marks for in Java strings must be enclosed in quotation marks
//        to be recognized as such. Object variables should be in lower camel case. "newHuman" might also be to   
//        trivial in some situations. "john" might be a better choice. 
        Human newHuman = new Human("John", 20, 180);
//        there was a + missing between " is " and newHuman.age.
//        the closing quotation mark in "years old." was missing.
        System.out.println(newHuman.name + " is " + newHuman.age + "years old.");
    }
}
