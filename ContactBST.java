public class ContactBST {

 public ContactNode root,current;

 public ContactBST(){
    root = current = null;
 }
 public boolean empty(){
 return root == null;
 }
 public Contact retrieve() { 
    if (current != null) {
        return current.contact;
    } else {
        return null;
    }
}
public void update(Contact newContact) {
    if (current != null) {
        current.contact = newContact;
    } else {
        throw new IllegalStateException("Cannot update a null node. Set 'current' before updating.");
    }
}

public boolean insert(Relative rel, Contact contact){
    switch(rel) {
        case ROOT:
        if(!empty()) return false;
        current = root = new ContactNode(contact, null, null);
                return true;
        case PARENT:
                return false;
        case LEFT_CHILD:
        if(current.left != null) return false;
        current.left = new ContactNode(contact,null,null);
        current = current.left;
                return true;
        case RIGHT_CHILD: 
        if (current.right != null) return false;
        current.right =new ContactNode(contact,null,null);
        current = current.right;
        return true;
        default:
                return false;
    }
}

public boolean find(Relative rel){
switch(rel){
    case ROOT:
    current = root;
    return true;
    case PARENT:
    if(current == root) return false;
    current = findparent(current, root);
    return true;
    case LEFT_CHILD:
    if(current.left == null) return false;
    current = current.left;
    return true;
    case RIGHT_CHILD:
    if(current.right == null) return false;
    current = current.right;
    return true;
    default:
    return false;
}
}
private ContactNode findparent(ContactNode p , ContactNode t){
    if (t == null) {
        return null; // empty tree
    }

    if (t.right == null && t.left == null) {
        return null;
    } else if (t.right == p || t.left == p) {
        return t; // parent is t
    } else {
        ContactNode q = findparent(p, t.left);
        if (q != null) {
            return q;
        } else {
            return findparent(p, t.right);
}
}
}


}




