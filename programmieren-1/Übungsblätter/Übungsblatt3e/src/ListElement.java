public class ListElement {

    private static int count = 0;
    private int value;
    private int index;

    public ListElement(int value) {
        this.value = value;
        count += 1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static int getCount() {
        return count;
    }
}
