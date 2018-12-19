import edu.kit.informatik.Terminal;

public class LinkedList {
    private class ListCell {
        public ListElement element;
        public ListCell next;
        private ListCell firstCell;


        public ListCell(ListElement element, ListCell next) {
            this.element = element;
            this.next = next;
        }

        public ListElement getElement() {
            return element;
        }

        public void setElement(ListElement element) {
            this.element = element;
        }

        public ListCell getNext() {
            return next;
        }

        public void setNext(ListCell next) {
            this.next = next;
        }
    }

    private ListCell head;
    private static ListCell firstListCell;
    private static ListCell lastListCell;
    private static int min;
    private static int max;

    public LinkedList() {
        this.head = null;
    }

    public void add(ListElement e) {
        int newValue = e.getValue();


        if (this.head == null) {

            max = newValue;
            min = newValue;
            addVeryFirst(e);

        } else if (newValue <= min) {

            min = newValue;
            addFirst(e);
        } else if (newValue >= max) {

            max = newValue;
            addLast(e);
        } else {

            int thisValue = this.head.element.getValue();
            ListCell temp = this.head;
            ListCell loopTemp = this.head;
            while (newValue > thisValue) {

                loopTemp = this.head;
                this.head = this.head.next;
                thisValue = this.head.element.getValue();

            }

            this.head = loopTemp;
            addBetween(e);
            this.head = temp;
        }


    }

    public void addVeryFirst(ListElement element) {

        ListCell newHead = new ListCell(element, null);
        this.head = newHead;
        firstListCell = newHead;
        lastListCell = newHead;
        giveIndex();


    }

    public void addFirst(ListElement element) {

        ListCell newHead = new ListCell(element, this.head);
        this.head = newHead;
        firstListCell = newHead;
        giveIndex();
    }

    public void addLast(ListElement element) {

        ListCell c = this.head;
        lastListCell = c;
        while (c.next != null) {
            c = c.next;
        }
        c.next = new ListCell(element, null);
        giveIndex();

    }

    public void addBetween(ListElement element) {
        ListCell temp = new ListCell(element, this.head.getNext());
        this.head.setNext(temp);
        giveIndex();


    }

    public void giveSize(LinkedList l) {
        LinkedList.Iterator it = l.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += 1;
            it.next();
        }
        Terminal.printLine(size);
    }

    public void giveIndex() {
        ListCell current = firstListCell;
        int count = 0;
        while (current != null) {
            current.element.setIndex(count);
            count++;
            current = current.next;
        }
    }

    public void print(LinkedList l) {
        LinkedList.Iterator it = l.iterator();

        String list = "";
        while (it.hasNext()) {
            list += it.next().getValue();
            if (it.hasNext()) {
                list += ",";

            }
        }
        Terminal.printLine("[" + list + "]");
    }

    public void isEmpty(LinkedList l) {
        LinkedList.Iterator it = l.iterator();
        boolean empty = true;
        if (it.hasNext()) {
            empty = false;
        }
        Terminal.printLine(empty);
    }

    public void clear() {
        this.head = null;
    }

    public void getElementAtIndex(LinkedList l, int whichIndex) {
        LinkedList.Iterator it = l.iterator();

        while (it.cursor.getElement().getIndex() < whichIndex) {
            it.next();
        }
        Terminal.printLine(it.cursor.getElement().getValue());

    }

    public class Iterator {
        private ListCell cursor;

        private Iterator(ListCell start) {
            this.cursor = start;
        }

        public boolean hasNext() {
            return (this.cursor != null);
        }

        public ListElement next() {
            ListElement currentContent = this.cursor.getElement();
            this.cursor = this.cursor.next;
            return currentContent;
        }

    }

    public Iterator iterator() {
        return new Iterator(this.head);
    }


}