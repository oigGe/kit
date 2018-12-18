public class List {
    private ListCell head;

    public List(){
        head = null;
    }

    public void addFirst(int content){
        ListCell newHead = new ListCell(content,this.head);
        this.head = newHead;
    }

    public void addLast(int content){
        if (this.head == null){
            this.head = new ListCell(content,null);
            return;
        }
        ListCell c = this.head;
        while (c.getNext() != null){
            c = c.getNext();
        }
        c.next = new ListCell(content,null);
    }

    public class Iterator{
        private ListCell cursor;
        private Iterator (ListCell start){
            this.cursor = start;

        }

        public boolean hasNext(){
            return (this.cursor != null);
        }


        public int next(){
            int currentContent = this.cursor.content;
            this.cursor = this.cursor.next;
            return currentContent;
        }
    }

    public Iterator iterator() {
        return new Iterator(this.head);
    }
}
