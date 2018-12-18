public class LinkedList {
    private class ListCell{
        Content content;
        ListCell next;

        public ListCell(Content content, ListCell next) {
            this.content = content;
            this.next = next;
        }

        public Content getContent() {
            return content;
        }

        public void setContent(Content content) {
            this.content = content;
        }

        public ListCell getNext() {
            return next;
        }

        public void setNext(ListCell next) {
            this.next = next;
        }
    }


    private ListCell head;
        public static int listIndex = 0;

    public LinkedList(){
        this.head = null;
    }

    public void addFirst(Content content){
        ListCell newHead = new ListCell(content,this.head);
        this.head = newHead;
    }


    public void add(int newContent, LinkedList list) {
        Iterator it = list.iterator();

        if (it.next() == null){

        }
    }




    public class Iterator{
        private ListCell cursor;
        private Iterator (ListCell start){
            this.cursor = start;
        }
        public boolean hasNext(){
            return (this.cursor != null);
        }
        public Content next(){
           Content currentContent = this.cursor.content;
            this.cursor = this.cursor.next;
            return currentContent;
        }
    }
    public Iterator iterator(){
        return new Iterator(this.head);
    }

}
