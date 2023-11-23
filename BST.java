/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phaes2;

/**
 *
 * @author sara
 */
public class BST<T> {
    
     public Node<T> root,current;

 public BST(){
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
        
        Node<T> p=root;
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
        if(root == null){
            current = root = new Node<T>(k,val);
            return true;
        }
        
        Node<T> p = current;
        if (findKey(k)){
            current=p;
            return false;   
        }
        
        Node<T> tmp = new Node<>(k, val);
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
        Node<T> p =root; // parent of p
        Node<T> q = null;
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
                
                if ((p.left!=null)&&(p.right!=null)){ // case 3 two
                    
                    // search for the min in the right subtree
                    Node<T> min = p.right;
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
        
        if(root==null)
            System.out.println("empty tree");
        else 
            inOrder((Node<Contact>) root );
    }
        
        private void inOrder(Node<Contact> p ){
            
            if(p==null ) 
                return;
            inOrder(p.left);
            System.out.println("key = "+ p.key);
            System.out.println(p.data.toString());
         inOrder(p.right);     
        }
        
        
      public void preOrder(){
        
        if(root==null)
            System.out.println("empty tree");
        else 
            inOrder((Node<Contact>) root );
    }
    
     private void preOrder(Node<Contact> p ){
            
            if(p==null ) 
                return;
            System.out.println("key = "+ p.key);
            System.out.println(p.data.toString());
            inOrder(p.left);      
            inOrder(p.right);     
        }
        
    public boolean checkPhoneExist(String phone ){
       
        if (root==null)
            return false;
        else 
            return checkPhoneinOrder((Node<Contact>)root,phone);      
        
    }
    
    private boolean checkPhoneinOrder(Node<Contact> p , String phone){
        
        if (p==null)return false;
        boolean exist=checkPhoneinOrder(p.left,phone);
        if(exist)
            return true;
        if (p.data.getPhoneNumber().equals(phone))
            return true;  
        return checkPhoneinOrder(p.right,phone);
    }
    
    public LinkedList<Contact> SearchByFirstName(String n){
        
        LinkedList<Contact> res = new LinkedList<Contact>();
        if(root==null)
            RSearchByFirstName(root,res,n);
        return res;
        
         
    }
    
    private void RSearchByFirstName(Node<T> p , LinkedList<Contact> res,String n ){
        
        if(p==null) return ;
        RSearchByFirstName(p.left,res,n);
        String CurFullName=p.key;
        String FirstName = CurFullName.substring(0, CurFullName.indexOf(" "));
        if (FirstName.equals(n)){
            res.insert((Contact)p.data);
        }
        
        
        
        
        
        
        
    }
}

