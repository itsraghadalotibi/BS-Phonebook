public class BSNode {
    public Contact contact;
    public BSNode left;
    public BSNode right;

    public BSNode(Contact contact) {
        this.contact = contact;
        this.left = null;
        this.right = null;
    }
    public BSNode(Contact contact, BSNode left, BSNode right) {
        this.contact = contact;
        this.left = left;
        this.right = right;
    }
}