public class AddressBookList {
    public class BookListCell {

        public AddressBook addressBook;
        public BookListCell next;

        public BookListCell(AddressBook addressBook, BookListCell next) {
            this.addressBook = addressBook;
            this.next = next;
        }

        public AddressBook getAddressBook() {
            return addressBook;
        }

        public void setAddressBook(AddressBook addressBook) {
            this.addressBook = addressBook;
        }

        public BookListCell getNext() {
            return next;
        }

        public void setNext(BookListCell next) {
            this.next = next;
        }
    }

    private BookListCell head;

    public AddressBookList(){
        this.head = null;
    }




    //  Iterator
    public class Iterator {
        private BookListCell cursor;

        private Iterator(BookListCell start) {
            this.cursor = start;
        }
        //  hasNext method to check if next ListElement exists
        public boolean hasNext() {
            return (this.cursor != null);
        }
        // next method to get the current content and go to the next ListElement
        public AddressBook next() {
            AddressBook currentContent = this.cursor.getAddressBook();
            this.cursor = this.cursor.next;
            return currentContent;
        }

    }

    public Iterator iterator() {
        return new Iterator(this.head);
    }
}
