public class ListCell {
    public int content;
    public ListCell next;

    public ListCell(int content, ListCell next) {
        this.content = content;
        this.next = next;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public ListCell getNext() {
        return next;
    }

    public void setNext(ListCell next) {
        this.next = next;
    }
}
