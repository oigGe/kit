public class LinkedList {
    private class ListCell {
        public int element;
        public ListCell next;

        public ListCell(int element, ListCell next) {
            this.element = element;
            this.next = next;
        }

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
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

    public void add(int e) {
        int newValue = e;
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
        } else if (newValue >= max) {
            max = newValue;

            System.out.println("addLast expected");
            System.out.println("Max: " + max);
            System.out.println("Min: " + min);
            addLast(e);
        } else {
            System.out.println("add between expected because input inbetween min and max");

            int thisValue = this.head.getElement();

            System.out.println("newValue: " + newValue + ", thisValue: " + thisValue);
            ListCell temp = this.head;
            while (newValue > thisValue) {
                System.out.println("while loop active");
                System.out.println("searching value: " + newValue + ", current value: " + thisValue);
//                temp = this.head;
                this.head = this.head.next;
                thisValue = this.head.getElement();
                System.out.println("upcoming Value: " + thisValue);
            }
            System.out.println("While loop finished");

            addBetween(e);
            this.head = temp;
        }


    }
    public void addVeryFirst(int element) {
        ListCell newHead = new ListCell(element, null);
        this.head = newHead;
//        firstListCell = newHead;

        System.out.println("addVeryFirst called");
    }

    public void addFirst(int element) {
        ListCell newHead = new ListCell(element, this.head);
        this.head = newHead;
//        firstListCell = newHead;

        System.out.println("addFirst called");
    }

    public void addLast(int element) {
        ListCell c = this.head;
        while (c.next != null) {
            c = c.next;
        }
        c.next = new ListCell(element,  null);
//        lastListCell = this.head;

        System.out.println("addLast called");
    }

    public void addBetween(int element) {
       ListCell temp = new ListCell(element,this.head.getNext());
        this.head.setNext(temp);
//        this.head = temp;


        System.out.println("addBetween called");

    }

    public class Iterator {
        private ListCell cursor;

        private Iterator(ListCell start) {
            this.cursor = start;
        }

        public boolean hasNext() {
            return (this.cursor != null);
        }

        public int next() {
            int currentContent = this.cursor.getElement();
            this.cursor = this.cursor.next;
            return currentContent;
        }

    }

    public Iterator iterator() {
        return new Iterator(this.head);
    }
}