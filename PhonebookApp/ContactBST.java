package PhonebookApp;

public class ContactBST {
    
private BSTNode root,current;

 public ContactBST(){
    root = current = null;
 }
 
 public boolean empty(){
 return root == null;
 }
 
 public Contact retrieve() { 
    if (current != null) {
        return current.data;
    } else {
        return null;
    }
}
 
public void clear(){
    current=root=null;
}
    public boolean full(){
        return false;
    }
    
    public boolean findKey(String k ){
        
        BSTNode p=root;

        if(empty()){  //checks if the tree is empty before starting the search
            return false;}

        while (p!= null){
            current=p;
            if(k.compareToIgnoreCase(p.key)==0){
                return true;
            }
            else if (k.compareToIgnoreCase(p.key)<0){
                p=p.left;
            }
            else {
                p=p.right;
            }
        }   
            
          return false;      
        }
        
    public boolean insert(String k ,Contact val){
        if(empty()){
            current = root = new BSTNode (k,val);
            return true;
        }
        
        BSTNode p = current;
        if (findKey(k)){ // the key to be inserted already exists
            current=p;
            return false;   
        }
        
        BSTNode tmp = new BSTNode (k, val); 
        if (k.compareToIgnoreCase(current.key)<0){
            current.left=tmp;  
        }
        else 
        {
            current.right=tmp;
        }
        current=tmp;
        return true;      
    }
    
    public boolean removeKey(String name ){
        
        //search for k
        String nameSearch = name ;
        BSTNode current =root; 
        BSTNode parent = null; // parent of current
        while(current != null){
            int comparison = nameSearch.compareToIgnoreCase(current.key);
            if(comparison<0){
                parent=current;
                current=current.left;
            }   
            else if (comparison>0){
                parent=current;
                current=current.right;
                
            }
            else { 
                  break;   // Node to be removed is found
            }
        }
        if (current == null) {
            // Node not found
            return false;
        }
             // Case 1: Node to be removed has no children
    if (current.left == null && current.right == null) {
        if (parent == null) {
            // Node is the root
            root = null;
        } else if (current == parent.left) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    }
    // Case 2: Node to be removed has one child
    else if (current.left == null || current.right == null) {
        BSTNode child = (current.left != null) ? current.left : current.right;

        if (parent == null) {
            // Node is the root
            root = child;
        } else if (current == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }
    // Case 3: Node to be removed has two children
    else {
        // Find the minimum node in the right subtree
        BSTNode min = current.right;
        parent = current;
        while (min.left != null) {
            parent = min;
            min = min.left;} 

        // Replace the current node's key and data with the min node's key and data
        current.key = min.key;
        current.data = min.data;
        // Remove the min node (which has at most one right child)
        if (parent.left == min) {
            parent.left = min.right;
        } else {
            parent.right = min.right;
        }
        }
        return true ;
    }
    
        
     
     
    public void inOrder(){
        
        if(empty())
            System.out.println("empty tree");
        else 
            inOrder( root );
    }
        
        private void inOrder(BSTNode p ){
            
            if(p==null ) //Base Case
                return;
            inOrder(p.left); // Traverse the left subtree
            System.out.println("key = "+ p.key); // Print the current 
            System.out.println(p.data.toString()); //node's key and data
         inOrder(p.right);     // Traverse the right subtree
        }
        
        
      public void preOrder(){
        
        if(root==null)
            System.out.println("empty tree");
        else 
            inOrder(root );
    }
    
     private void preOrder(BSTNode p ){
            
            if(p==null ) 
                return;
            System.out.println("key = "+ p.key);
            System.out.println(p.data.toString());
            inOrder(p.left);      
            inOrder(p.right);     
        }
        
    public boolean checkPhoneExist(String phoneNumber ){
       
        if (root == null) 
            return false;
        else 
            return checkPhoneinOrder(root,phoneNumber);      
        
    }
    
    private boolean checkPhoneinOrder(BSTNode p, String phoneNumber){
        
        if (p==null)return false; // Base case

        if (checkPhoneinOrder(p.left, phoneNumber)){ 
            return true;}

        if (p.data.getPhoneNumber().equals(phoneNumber)){//Check the current node
            return true; }

            return checkPhoneinOrder(p.right, phoneNumber);  //check the right subtree
           
        }
    
    public Contact searchByFirstName(String n){
        
        LinkedList<Contact> matchingContacts = new LinkedList<>();
        if(root==null) 
            return matchingContacts;
        rSearchByFirstName(root,matchingContacts,n);
        return matchingContacts;
        
         
    }
    
    private void rSearchByFirstName(BSTNode p , LinkedList<Contact> matchingContacts,String n ){
        
        if(p==null) return ; 
        rSearchByFirstName(p.left,matchingContacts,n);
        String CurFullName=p.key;
        String FirstName = CurFullName.substring(0, CurFullName.indexOf(" "));
        
        if (FirstName.equals(n)){
            matchingContacts.insert(p.data);
        }
        
        
        
        
        
        
        
    }
}

