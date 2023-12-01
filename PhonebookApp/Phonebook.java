package PhonebookApp;

import java.util.List;
import java.util.Scanner;

public class Phonebook {
    
    static ContactBST contactBST;
    static LinkedList<Event> events;

    public Phonebook() {
        contactBST = new ContactBST();
        events = new LinkedList<Event>();
        
    }
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to the BST Phonebook! Please choose an option:");
            System.out.println("1. Add a contact");
            System.out.println("2. Search for a contact");
            System.out.println("3. Delete a contact");
            System.out.println("4. Schedule an event/appointment");
            System.out.println("5. Print event details");
            System.out.println("6. Print contacts by first name");
            System.out.println("7. Print all events alphabetically");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                System.out.print("Enter the contact's name: ");
                String name = scanner.nextLine();
        
                System.out.print("Enter the contact's phone number: ");
                String phoneNumber = scanner.nextLine();
        
                System.out.print("Enter the contact's email address: ");
                String email = scanner.nextLine();
        
                System.out.print("Enter the contact's address: ");
                String address = scanner.nextLine();
        
                System.out.print("Enter the contact's birthday: ");
                String birthday = scanner.nextLine();
        
                System.out.print("Enter any notes for the contact: ");
                String notes = scanner.nextLine();
        
                Contact newContact = new Contact(name, phoneNumber, email, address, birthday, notes);
                phonebook.AddContact(newContact);
                break;
                case 2:
                System.out.println("Enter search criteria:");
                System.out.println("1. Name");
                System.out.println("2. Phone Number");
                System.out.println("3. Email Address");
                System.out.println("4. Address");
                System.out.println("5. Birthday");

                int searchCriteria = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                String prompt = "";
                switch (searchCriteria) {
                    case 1:
                        prompt = "Name";
                        break;
                    case 2:
                        prompt = "Phone Number";
                        break;
                    case 3:
                        prompt = "Email Address";
                        break;
                    case 4:
                        prompt = "Address";
                        break;
                    case 5:
                        prompt = "Birthday";
                        break;
                    default:
                        System.out.println("Invalid search criteria.");
                        continue; // Skip to the next iteration of the loop
                }
                System.out.print("Enter search term for " + prompt + ": ");
                    String searchTerm = scanner.nextLine();

                    phonebook.searchContact(searchCriteria, searchTerm);
                

                phonebook.searchContact(searchCriteria, searchTerm);
                break;
                case 3:
                    deleteContact(scanner);
                    break;
                case 4:
                    scheduleEvent(scanner);
                    break;
                case 5:
                    printEventDetails(scanner);
                    break;
                case 6:
                    printContactsByFirstName(scanner);
                    break;
                case 7:
                    printAllEventsAlphabetically();
                    break;
                case 8:
                    System.out.println("Exiting Phonebook. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
    

}
    

public void AddContact(Contact contact){
    
    boolean nameInserted=false;
    boolean phoneExist=contactBST.checkPhoneExist(contact.getPhoneNumber());
    if(phoneExist)
        System.out.println("cannot add , has phone exist before " + contact.getName());
    else {
        boolean nameExists = contactBST.findKey(contact.getName());
        if (nameExists) {
            System.out.println("Cannot add, contact with the same name already exists: " + contact.getName());
        } else {
        nameInserted = contactBST.insert(contact.getName(), contact);
    }
}     }      
    
public void searchContact(int searchCriteria, String searchTerm) {
    if (contactBST.findKey(searchTerm)) {
    switch (searchCriteria) {
        case 1:
            // Search by Name
            contactBST.searchByName(contactBST.getRoot(), searchTerm);
            break;
        case 2:
            // Search by Phone Number
            contactBST.searchByPhoneNumber(contactBST.getRoot(), searchTerm);
            break;
        case 3:
            // Search by Email Address
            contactBST.searchByEmailAddress(contactBST.getRoot(), searchTerm);
            break;
        case 4:
            // Search by Address
            contactBST.searchByAddress(contactBST.getRoot(), searchTerm);
            break;
        case 5:
            // Search by Birthday
            contactBST.searchByBirthday(contactBST.getRoot(), searchTerm);
            break;
        default:
            System.out.println("Invalid search criteria.");
    }


    
    public LinkedList<Contact> SearchByFirstName(String s) {
        //not sure
        return Contacts.SearchByFirstName(s);
        
      
    }
    
    public static void printAllcontact(){
        
        Contacts.inOrder();
        
    }
    
    
    public LinkedList<Event> getEventsinContact(String s){
        
        Contact thisContact = searchByName (s);
        if(thisContact!=null)
            return thisContact.getContactEvents();
        
        
        
    }
public boolean isConflict(Event e , Contact c){
    
    LinkedList<Event>contactEvents=c.contactEvents;
    
    if(contactEvents.empty()){
        return false;
    }   
    
    contactEvents.findFirst();
    while(!contactEvents.last()){
        if(e.getDate().equals(contactEvents.retrieve().getDate()))
            return false;
        if(e.getDate().equals(contactEvents.retrieve().getDate()){
                
              if(
                      
                (isgreater(e.getEnd(),contactEvents.retrieve().getStart())>=0
                 && isgreater(e.getEnd(),contactEvents.retrieve().getEnd())<=0)   
                      
                 !!(isgreater(e.getStart(),contactEvents.retrieve().getStart())>=0
                 && isgreater(e.getStart(),contactEvents.retrieve().getEnd())<=0)
                      
                 !!( isgreater(contactEvents.retrieve().getStart(),e.getStart())>=0)
                 && isgreater(contactEvents.retrieve().getEnd(),e.getEnd())>=0    
                         )
                 return true  ;      
}
   contactEvents.findFirst();
 }
    if(!e.getDate().equals(contactEvents.retrieve().getDate()))
        return false;
    if(
             (isgreater(e.getEnd(),contactEvents.retrieve().getStart())>=0
                 && isgreater(e.getEnd(),contactEvents.retrieve().getEnd())<=0)   
                      
                 !!(isgreater(e.getStart(),contactEvents.retrieve().getStart())>=0
                 && isgreater(e.getStart(),contactEvents.retrieve().getEnd())<=0)
                      
                 !!( isgreater(contactEvents.retrieve().getStart(),e.getStart())>=0)
                 && isgreater(contactEvents.retrieve().getEnd(),e.getEnd())>=0    
            )
    
        return true;
        else 
        
        return false;

            
    
    
     
    
}

public int isgreater(String t1, String t2){
    
    String a1[]=t1.split(":");
    String a2[]=t2.split(":");
    if(Integer.parseInt(a1[0])>Integer.parseInt(a2[0]))
    return 1;
    else if(Integer.parseInt(a1[0])<Integer.parseInt(a2[0]))
    return-1;
    else{
     if(Integer.parseInt(a1[1])>Integer.parseInt(a2[1]))
         return 1;
     else if(Integer.parseInt(a1[1])>Integer.parseInt(a2[1]))
        return -1;
     else 
         return 0;
         
         
}

}


public void scheduleEvent(Event e, String ContactName){
    
     Contact thisContact = searchByName (ContactName);
    if(thisContact==null)
    {
        System.out.println("cannot scheduls this event"+ContactName);
        return;
        
    }
    if(!e.IsEvent()){
            if(!e.contactWithEvent.empty())
                System.out.println("");
            return;
    }
    
    boolean isConflict=isConflict(e,thisContact);
    if(thisContact!=null&&!isConflict){
        System.out.println("schdulling contact :"+thisContact.getName()+"'"+e.getTitle());
        
        //for contact
        thisContact.contactEvents.AddSortedEvent(e)
                //for Event
                e.contactWithEvent.AddSorted(thisContact);
                //for All
                addEvent(e);
    }
    else{
        if(thisContact==null)
            System.out.println("dose not exist event title"+e.getTitle()+"contact="+thisContact.getName());
        if(isConflict)
            System.out.println("there is conflict event title = "+e.getTitle()+"contact="+thisContact.getName());
        
    }      
            
      
    public Event searchEventByTitle(String n){
        
        if(Events.empty())
        return null;
        Events.findFirst();
        while(!Events.last()){
            if(Events.retrieve().getTitle().equals(n))
            return Events.retrieve();  
            Events.findFirst();      
        }
        if(Events.retrieve().getTitle().equals(n))
            return Events.retrieve();
        return null;      
    }
    
    
    
    
    
    
    
    
    
}










}
