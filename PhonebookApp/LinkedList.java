package PhonebookApp;

public class LinkedList<T extends Comparable<T>> {
    
    public static class Node<T>{
        public T data;
        public Node<T> next;
        public Node () {
            data = null;
            next = null;
        }
        public Node (T val) {
            data = val;
            next = null;
        }
        

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

    }    


    private Node<T> head;
    private Node<T> current;
    int size;
    
    public LinkedList () {
        size = 0;
        head = current = null;
    }
    public boolean empty () {
        return head == null;
    }
    public boolean last () {
        return current.next == null;
    }
    public boolean full () {
            return false;
    }
    public void findFirst () {
            current = head;
    }
    public void findNext () {
            current = current.next;
    }
    public T retrieve () {
            return current.data;
    }
    public void update (T val) {
            current.data = val;
    }
    
    public boolean insert (T val) {
           
            Node<T> tmp;
            Node<T> prev = null;
            current = head;
            while (current != null && current.getData().compareTo(val) <= 0) {
                prev = current;
                current = current.getNext();
            }
    
            tmp = new Node<>(val);
    
            if (prev == null) {
                // Insert at the beginning
                tmp.setNext(head);
                head = tmp;
            } else {
                // Insert somewhere in the middle or at the end
                tmp.setNext(current);
                prev.setNext(tmp);
            }
    
            size++;
            return true;
    }

    public boolean search (T contactName)
    {
        if (head == null)
            return false;
        
        Node<T> node  = head;
        while ((node != null) && (node.getData().compareTo(contactName) != 0))
            node = node.getNext();
        if ((node != null) && (node.getData().compareTo(contactName) == 0))
        {
            current = node;
            return true;
        }
        return false;
    }
    public boolean search(String val) {
        Node<T> node = head;
        while (node != null) {
            if (node.getData().toString().equals(val)) {
                current = node;
                return true;
            }
            node = node.getNext();
        }
        return false;
    }
            
    public T remove (T val) {
            
        if (search (val) == false)
         return null;

        T data = current.getData();
        
        if (current == head) {
                head = head.next;
        }
        else {
            Node<T> tmp = head;

                while (tmp.next != current)
                        tmp = tmp.next;
               tmp.next = current.next;
        }
        if (current.next == null)
                current = head;
        else
                current = current.next;
        size -- ;
        return data;    
    }

     @Override
    public String toString() 
    {
           Node<T>  p = head;
            String str = "" ;
            
            while ( p != null)
            {
                str += p.getData().toString();
                str +=  "\n";
                p = p .next;
            }
            return str;
        }
}