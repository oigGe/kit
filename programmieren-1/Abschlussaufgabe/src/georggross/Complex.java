package georggross;

public class Complex {
    private int a;
    private int b;

    public Complex(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "(" + a + " + " + b + "i)";
    }
}
