package PhonebookApp;

public class ContactBST {
    
private BSTNode root,current;

 public ContactBST(){
    root = current = null;
 }
 
 public boolean empty(){
 return root == null;
 }
 public BSTNode getRoot() {
    return root;
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
        if (empty()) {
            current = root = new BSTNode(k, val);
            return true;
        }
    
        BSTNode parent = null;
        BSTNode current = root;
        while (current != null) {
            parent = current;
            int comparison = k.compareToIgnoreCase(current.key);
            if (comparison < 0) {
                current = current.left;
            } else if (comparison > 0) {
                current = current.right;
            } else {
                // Key already exists
                return false;
            }
        }
    
        // Insert the new node
        BSTNode newNode = new BSTNode(k, val);
        if (k.compareToIgnoreCase(parent.key) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    
        current = newNode; // Update current to the newly inserted node
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
        
        
      //public void preOrder(){
        
       // if(root==null)
          //  System.out.println("empty tree");
       // else 
           // inOrder(root );
  //  }
    
     //*private void preOrder(BSTNode p ){
            
        //    if(p==null ) 
        //        return;
           // System.out.println("key = "+ p.key);
          //  System.out.println(p.data.toString());
           // inOrder(p.left);      
           // inOrder(p.right);     
       // } 
        
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
public boolean searchContactByName(String name) {
            return searchByName(root, name);
        }
private boolean searchByName(BSTNode node, String name) {
            if (node == null) {
                return false;
            }
    
            int comparison = node.data.compareTo(new Contact(name, "", "", "", "", ""));
            if (comparison == 0) {
                {
                node.data.printContact();}
                return true;
            } else if (comparison < 0) {
                return searchByName(node.left, name);
            } else {
                return searchByName(node.right, name);
            }
        }

public boolean searchByPhoneNumber(BSTNode node, String phoneNumber) {
            if (node == null) {
                return false;
            }
    
            int comparison = node.data.compareToPhone(phoneNumber);
            if (comparison == 0) {
                System.out.println(node.data);
                return true;
            } else if (comparison < 0) {
                return searchByPhoneNumber(node.left, phoneNumber);
            } else {
                return searchByPhoneNumber(node.right, phoneNumber);
            }
        }
public boolean searchByEmailAddress(BSTNode node, String emailAddress) {
            if (node == null) {
                return false;
            }
        
            int comparison = node.data.compareToEmail(emailAddress);
            boolean found = false;
        
            if (comparison == 0) {
                node.data.printContact();
                found = true;
            }
        
            // Continue searching in both subtrees
            boolean leftFound = searchByEmailAddress(node.left, emailAddress);
            boolean rightFound = searchByEmailAddress(node.right, emailAddress);
        
            return found || leftFound || rightFound;
        }

public boolean searchByAddress(BSTNode node, String address) {
            if (node == null) {
                return false;
            }
        
            int comparison = node.data.compareToAddress(address);
            boolean found = false;
        
            if (comparison == 0) {
                node.data.printContact();
                found = true;
            }
        
            //Continue searching in both subtrees
            boolean leftFound = searchByAddress(node.left, address);
            boolean rightFound = searchByAddress(node.right, address);
        
            return found || leftFound || rightFound;
        }       
 
public boolean searchByBirthday(BSTNode node, String birthday) {
            if (node == null) {
                return false;
            }
        
            int comparison = node.data.compareToBirthday(birthday);
            boolean found = false;
        
            if (comparison == 0) {
                node.data.printContact();
                found = true;
            }
        
            // Continue searching in both subtrees
            boolean leftFound = searchByBirthday(node.left, birthday);
            boolean rightFound = searchByBirthday(node.right, birthday);
        
            return found || leftFound || rightFound;
        }      

        public Contact retrieveByName(String name) {
            return retrieveByName(root, name);
        }
        
        private Contact retrieveByName(BSTNode node, String name) {
            if (node == null) {
                return null;
            }
        
            int comparison = node.data.getName().compareTo(name);
            if (comparison == 0) {
                return node.data;
            } else if (comparison < 0) {
                return retrieveByName(node.right, name);
            } else {
                return retrieveByName(node.left, name);
            }
        }
        

 //public Contact searchByFirstName(String n){
        
    public void searchFirstName(String fn){

        searchFirstName(root, fn);

    }
    private void searchFirstName(BSTNode p, String fn) {
        if (p == null) {
            return;
        }
    
        // Traverse left subtree
        searchFirstName(p.left, fn);
        
        // Check if the current node's data (contact) has the matching first name
        if (( p.data).getFirstName().equals(fn)) {
            System.out.println(p.data);
        }
    
        // Traverse right subtree
        searchFirstName(p.right, fn);
    
        
    }
       
        
        
        
        
        
   
}

