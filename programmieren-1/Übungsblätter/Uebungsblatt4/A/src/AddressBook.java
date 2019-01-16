public class AddressBook {

    public class AddressListCell{
        public Contact contact;
        public AddressListCell next;

        public AddressListCell(Contact contact, AddressListCell next) {
            this.contact = contact;
            this.next = next;
        }

        public Contact getContact() {
            return contact;
        }

        public void setContact(Contact contact) {
            this.contact = contact;
        }

        public AddressListCell getNext() {
            return next;
        }

        public void setNext(AddressListCell next) {
            this.next = next;
        }
    }


}

