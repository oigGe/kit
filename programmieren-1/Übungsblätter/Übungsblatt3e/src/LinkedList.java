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

            int thisValue = this.head.element.getValue();

            System.out.println("newValue: " + newValue + ", thisValue: " + thisValue);
            ListCell temp = this.head;
            ListCell loopTemp =this.head;
            while (newValue > thisValue) {
                System.out.println("while loop active");
                System.out.println("searching value: " + newValue + ", current value: " + thisValue);
                loopTemp = this.head;
                this.head = this.head.next;
                thisValue = this.head.element.getValue();
                System.out.println("upcoming Value: " + thisValue);
            }
            System.out.println("While loop finished");

            this.head = loopTemp;
            addBetween(e);
            this.head = temp;
        }


    }
    public void addVeryFirst(ListElement element) {
        ListCell newHead = new ListCell(element, null);

        this.head = newHead;
        firstListCell = newHead;
//        firstListCell = newHead;
        giveIndex();

        System.out.println("addVeryFirst called");
    }

    public void addFirst(ListElement element) {
        ListCell newHead = new ListCell(element, this.head);


        this.head = newHead;
        firstListCell = newHead;

        giveIndex();
        System.out.println("addFirst called");
    }

    public void addLast(ListElement element) {
        ListCell c = this.head;
        while (c.next != null) {
            c = c.next;
        }
        c.next = new ListCell(element,  null);
//        lastListCell = this.head;

        System.out.println("addLast called");
        giveIndex();
    }

    public void addBetween(ListElement element) {
       ListCell temp = new ListCell(element,this.head.getNext());
        this.head.setNext(temp);
//        this.head = temp;
        giveIndex();

        System.out.println("addBetween called");

    }

    public void giveIndex(){
        ListCell current = firstListCell;
        int count = 0;
        while (current != null){
            current.element.setIndex(count);
            count++;
            current = current.next;
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
            ListElement currentContent = this.cursor.getElement();
            this.cursor = this.cursor.next;
            return currentContent;
        }

    }

    public Iterator iterator() {
        return new Iterator(this.head);
    }




}