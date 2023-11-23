public class ContactBST {

    private BSNode<Contact> root;
    private BSNode<Contact> current;
 public ContactBST(){
    root = current = null;
 }
 public boolean empty(){
 return root == null;
 }
 public Contact retrieve() { 
    return current.data;
}
public boolean update(String key, Contact data){
     remove_key(current.key);
    return insert(key, data);
    }

    public boolean insert(String k, Contact val){
        BSNode<Contact> p, q = current;
        if(findkey(k)) {
            current = q;
            return false;
        }
        p = new BSNode<>(k, val);

        if (empty()) {
            root = current = p;
            return true;
        }
        else {
            if (k.compareTo(current.key) < 0) {
            current.left = p;}
            else { 
            current.right = p;}
            current=p;
            return true ;
        }
}

public boolean findkey(String tkey) {
    BSNode<String> p = root , q = null;
    if(empty()){ 
    return false;}

    while(p != null) {
        q = p;

        int comparisonResult = tkey.compareTo(p.key); 

        if (comparisonResult == 0) {
             current = p;
             return true;
        }
        else if(comparisonResult < 0){  
        p = p.left;}
        else{ 
        p = p.right;
    }}
    current = q;
    return false;
} 


public void deleteSubtree(){
    if(current == root){
        current = root = null;
 }
    else {
        ContactNode p = current;
        find(Relative.PARENT);
        if(current.left == p)
        current.left = null;
        else
        current.right = null;
        current = root;

}

}

public boolean removeKey(String tkey) {
    Boolean removed = false;
    BSNode<Contact> p = removeAux(tkey, root, removed);
    current = root = p;
    return removed;
}

public class BooleanWrapper {
    boolean value;

    public BooleanWrapper(boolean value) {
        this.value = value;
    }

    public void set(boolean value) {
        this.value = value;
    }

    public boolean get() {
        return value;
    }
}

private BSNode<Contact> removeAux(String key, BSNode<Contact> p, BooleanWrapper flag) {
    BSNode<Contact> q, child = null;

    if (p == null) {
        return null;
    }
    int compareResult = key.compareTo(p.key);

    if (compareResult < 0) {
        p.left = removeAux(key, p.left, flag); // go left
    } else if (compareResult > 0) {
        p.right = removeAux(key, p.right, flag); // go right
    } else { // key is found
        flag.set(true);

        if (p.left != null && p.right != null) { // two children
            q = findMin(p.right);
            p.key = q.key;
            p.data = q.data;
            p.right = removeAux(q.key, p.right, flag);
        } else {
            if (p.right == null) { // one child
                child = p.left;
            } else if (p.left == null) { // one child
                child = p.right;
            }

            return child;
        }
    }

    return p;
}

private BSNode<Contact> findMin(BSNode<Contact> p) {
    if (p == null) {
        return null;
    }

    while(p.left != null){
        p = p.left;
        }
        return p;
}


}



