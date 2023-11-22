public class ContactNode {
    public Contact contact;
    public ContactNode left;
    public ContactNode right;

    public ContactNode(Contact contact) {
        this.contact = contact;
        this.left = null;
        this.right = null;
    }
    public ContactNode(Contact contact, ContactNode left, ContactNode right) {
        this.contact = contact;
        this.left = left;
        this.right = right;
    }
}