public class LinkedList {


    private class ListCell {
        public ListElement element;
        public ListCell next;
        public ListCell prev;


        public ListCell(ListElement element, ListCell prev, ListCell next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
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

        public ListCell getPrev() {
            return prev;
        }

        public void setPrev(ListCell prev) {
            this.prev = prev;
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


    public void addVeryFirst(ListElement element) {
        ListCell newHead = new ListCell(element, null, null);
        this.head = newHead;
        firstListCell = newHead;

        System.out.println("addVeryFirst called");
    }

    public void addFirst(ListElement element) {
        ListCell newHead = new ListCell(element, null, this.head);
        this.head = newHead;
        firstListCell = newHead;

        System.out.println("addFirst called");
    }

    public void addLast(ListElement element) {
        ListCell c = this.head;
        while (c.next != null) {
            c = c.next;
        }
        c.next = new ListCell(element, c, null);
        lastListCell = this.head;

        System.out.println("addLast called");
    }

    public void addBetween(ListElement element) {
        ListCell tempPrev = this.head;
        ListCell tempNext = this.head.next;
        ListCell newHead = new ListCell(element,this.head.getPrev(),tempNext);
//        this.head = newHead;
        tempPrev.setNext(newHead);
        tempNext.setPrev(newHead);


        System.out.println("addBetween called");

    }


    public void add(ListElement e) {
        int newValue = e.getElement();
        System.out.println("Input value: " + newValue);

        if (this.head == null) {
            max = newValue;
            min = newValue;

            System.out.println("addVeryFirst expected");
            System.out.println("Max: " + max);
            System.out.println("Min: " + min);
            addVeryFirst(e);
        } else if (newValue <= min) {
            min = newValue;

            System.out.println("add first expected because input smaller than min");
            System.out.println("Max: " + max);
            System.out.println("Min: " + min);
            addFirst(e);
        } else if (newValue > max) {
            max = newValue;

            System.out.println("addLast expected");
            System.out.println("Max: " + max);
            System.out.println("Min: " + min);
            addLast(e);
        } else {
            System.out.println("add between expected because input inbetween min and max");
            int thisValue = this.head.element.getElement();
            ListCell c = this.head;
            System.out.println("newValue: " + newValue + ", thisValue: " + thisValue);
            while (newValue > thisValue) {
                System.out.println("while loop active");
                System.out.println("searching value: " + newValue + ", current value: " + thisValue);
                this.head = this.head.next;
                thisValue = this.head.element.getElement();
                System.out.println("upcoming Value: " + thisValue);
            }
            System.out.println("While loop finished");

            this.head = this.head.prev;

            addBetween(e);
        }
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
            ListElement currentContent = this.cursor.element;
            this.cursor = this.cursor.next;
            return currentContent;
        }

    }

    public Iterator iterator() {
        return new Iterator(this.head);
    }
}
