

public class ContactBST<T> {
    
 public BSTNode<T> root,current;

 public ContactBST(){
    root = current = null;
 }
 
 public boolean empty(){
 return root == null;
 }
 
 public T retrieve() { 
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
        
        BSTNode<T> p=root;

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
        
    public boolean insert(String k ,T val){
        if(empty()){
            current = root = new BSTNode<T>(k,val);
            return true;
        }
        
        BSTNode<T> p = current;
        if (findKey(k)){ // the key to be inserted already exists
            current=p;
            return false;   
        }
        
        BSTNode<T> tmp = new BSTNode<>(k, val); 
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
    
    public boolean removeKey(String k ){
        
        //search for k
        String k1 = k ;
        BSTNode<T> p =root; 
        BSTNode<T> q = null; // parent of p
        while(p!= null){
            if(k1.compareToIgnoreCase(p.key)<0){
                q=p;
                p=p.left;
            }   
            else if (k1.compareToIgnoreCase(p.key)>0){
                q=p;
                p=p.right;
                
            }
            else 
            {      //found the key
                
                if ((p.left!=null)&&(p.right!=null)){ // case 3: two children
                    
                    // search for the min in the right subtree
                    BSTNode<T> min = p.right;
                    q=p;
                    while(min.left!=null){
                        q=min;
                        min=min.left;
                    }
                    p.key=min.key;
                    p.data=min.data;
                    k1=min.key;
                    p=min;
                    // now fall back to either case 1 or 2
                            
                 }
              
                
             // the subtree rooted at p will change here
             if(p.left!= null){ // one child
                 p=p.left;                    
             }
             else { // one or no childern
                 p=p.right;
             }
             
             if(q==null){ // no parent for p , root must change
                 root=p;
             }
             else{
                 if(k1.compareToIgnoreCase(q.key)<0){
                     q.left=p;
                 }
                 else{
                     q.right=p;
                 }
             }
             current=root;
             return true;
             
            }    
            
         }
        
    return false; // not found 
        
}      
     
    public void inOrder(){
        
        if(empty())
            System.out.println("empty tree");
        else 
            inOrder((BSTNode<Contact>) root );
    }
        
        private void inOrder(BSTNode<Contact> p ){
            
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
            inOrder((BSTNode<Contact>) root );
    }
    
     private void preOrder(BSTNode<Contact> p ){
            
            if(p==null ) 
                return;
            System.out.println("key = "+ p.key);
            System.out.println(p.data.toString());
            inOrder(p.left);      
            inOrder(p.right);     
        }
        
    public boolean checkPhoneExist(String phone ){
       
        if (empty()) 
            return false;
        else 
            return checkPhoneinOrder((BSTNode<Contact>)root,phone);      
        
    }
    
    private boolean checkPhoneinOrder(BSTNode<Contact> p , String phone){
        
        if (p==null)return false; // Base case

        if (checkPhoneinOrder(p.left, phone))
            return true;

        if (p.data.getPhoneNumber().equals(phone))//Check the current node
            return true; 

        if (checkPhoneinOrder(p.right, phone))  //check the right subtree
          return true; 
        }
    
    public LinkedList<Contact> searchByFirstName(String n){
        
        LinkedList<Contact> matchingContacts = new LinkedList<Contact>();
        if(root==null) 
            return matchingContacts;
        rSearchByFirstName(root,matchingContacts,n);
        return matchingContacts;
        
         
    }
    
    private void rSearchByFirstName(BSTNode<T> p , LinkedList<Contact> matchingContacts,String n ){
        
        if(p==null) return ; 
        rSearchByFirstName(p.left,matchingContacts,n);
        String CurFullName=p.key;
        String FirstName = CurFullName.substring(0, CurFullName.indexOf(" "));
        
        if (FirstName.equals(n)){
            matchingContacts.insert((Contact)p.data);
        }
        
        
        
        
        
        
        
    }
}

