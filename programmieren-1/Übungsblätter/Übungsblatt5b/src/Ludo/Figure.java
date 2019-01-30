package Ludo;

public class Figure {
    private int position;
    private String name;


    public Figure(String name) {
        this.position = 0;
        this.name = name;
    }

    public Figure(String name, int position) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
