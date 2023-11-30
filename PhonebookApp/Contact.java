package PhonebookApp;



class Contact implements Comparable<Contact> {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String birthday;
    private String notes;
    LinkedList<Event>events;

    public Contact() {
        this.name = "";
        this.phoneNumber = "";
        this.email = "";
        this.address = "";
        this.birthday = "";
        this.notes = "";
        events = new LinkedList<Events>();
    }
    

    public Contact(String name, String phoneNumber, String email, String address, String birthday, String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
    }
//public boolean addEvent(Event e){}
    
    public boolean removeEvent(String T){
        if (events.empty()) return false ;
        
        Event tempEvent= new Event();
        tempEvent.title = T;
        if(events.search(tempEvent)){
        events.remove(tempEvent);
        return true;
        }
        return false;
           
    
    }
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return  "name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address + ", birthday=" + birthday + ", notes=" + notes + ", events=" + events.toString() + '}';
    }

 
    
     @Override
     
    public int compareTo(Contact o) {
        
            return (this.name.compareToIgnoreCase(o.name));
    }

    
    public int compareToPhone(String Phone) {
       
            return (this.phoneNumber.compareToIgnoreCase(Phone));
       
    }

    public int compareToEmail(String emailaddress) {
       
            return (this.email.compareToIgnoreCase(emailaddress));
        
    }

    public int compareToAddress(String address) {
       
       return ( this.address.compareToIgnoreCase(address));
    }

    public int compareToBirthday(String birthday) {
       
          return( this.birthday.compareTo(birthday) ) ;
       
    }
    
    public int compareFirstName(String name) {
        
            String [] all = this.name.split(" ");
            return (all[0].compareToIgnoreCase(name) ) ;
        
        
    }
}