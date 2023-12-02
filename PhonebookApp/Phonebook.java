package PhonebookApp;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Phonebook {
    
    static ContactBST contactBST;
    static LinkedList<Event> events;
    static LinkedList<Contact> contacts;

    public Phonebook() {
        contactBST = new ContactBST();
        events = new LinkedList<Event>();
        contacts = new LinkedList<>();
        
        
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
                if(phonebook.AddContact(newContact)) 
                System.out.println("Contact added successfully!");
                else
                System.out.println("Contact couldn't be added ");

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

                   if(  phonebook.searchContact(searchCriteria, searchTerm))

                break;
                case 3: //still
                System.out.print("Enter the contact's name to delete: ");
                String nameToDelete = scanner.nextLine();
                    deleteContact(nameToDelete);
                    break;
                case 4:
                // Schedule an event/appointment
                System.out.println("Enter type:");
                System.out.println("1. event");
                System.out.println("2. appointment");
                System.out.print("Enter your choice: ");
                int eventType = scanner.nextInt();
                scanner.nextLine();
                if (eventType == 1) {
                    System.out.print("Enter event title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter contacts name separated by a comma: ");
                    String contactNames = scanner.nextLine();
                    String[] names = contactNames.split(",");
                       for (String Cname : names) {
                    // Search for the contact in the BST and add to the event
                    boolean contactFound = Phonebook.contactBST.findKey(Cname.trim());
                    if (!contactFound)
                    System.out.println("Error: Contact '" + name.trim() + "' not found. Event not created.");
                }

                    System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
                    String dateTimeString = scanner.nextLine();
                     // Validate date/time format 
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
                    Date dateTime;
                    try {
                        dateTime = dateFormat.parse(dateTimeString);
                    } catch (ParseException e) {
                        System.out.println("Error: Invalid date/time format. Please use MM/DD/YYYY HH:MM.");
                        continue;  // Restart the loop
                    }

                    System.out.print("Enter event location: ");
                    String location = scanner.nextLine();

                  
                

                    // Create and schedule the event
                    phonebook.scheduleEvent(title, contactNames, dateTime, location);
                    System.out.println("Event scheduled successfully!");
                } else if (eventType == 2) {
                    // Schedule an appointment
                    // Implement this part based on your requirements
                } else {
                    System.out.println("Invalid choice.");
                }
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
    

public boolean AddContact(Contact contact){
    
    boolean nameInserted= false ;
    boolean phoneExist=contactBST.checkPhoneExist(contact.getPhoneNumber());
    if(phoneExist)
        System.out.println("cannot add , has phone exist before " + contact.getName());
    else {
        boolean nameExists = contactBST.findKey(contact.getName());
        if (nameExists) {
            System.out.println("Cannot add, contact with the same name already exists: " + contact.getName());
        } else {
         contactBST.insert(contact.getName(), contact);
           nameInserted = true;
    }
}   return nameInserted;
  }      
    
public void searchContact(int searchCriteria, String searchTerm) {
    boolean contactFound = false;
    switch (searchCriteria) {
        case 1:
            // Search by Name
            contactFound = contactBST.searchContactByName(searchTerm);
            break;
        case 2:
            // Search by Phone Number
           contactFound =  contactBST.searchByPhoneNumber(contactBST.getRoot(), searchTerm);
            break;
        case 3:
            // Search by Email Address
           contactFound =  contactBST.searchByEmailAddress(contactBST.getRoot(), searchTerm);
            break;
        case 4:
            // Search by Address
            contactFound = contactBST.searchByAddress(contactBST.getRoot(), searchTerm);
            break;
        case 5:
            // Search by Birthday
           contactFound =  contactBST.searchByBirthday(contactBST.getRoot(), searchTerm);
            break;
        default:
            System.out.println("Invalid search criteria.");
    }
    if (!contactFound) {
        System.out.println("Contact not found.");
    }
    }

    public void deleteContact(String nameToDelete) {
        // Check if the contact exists before deleting
        if (contactBST.findKey(nameToDelete)) {
        // Retrieve the contact from the contact BST
        Contact deletedContact = contactBST.retrieve();
        // Remove contact from the contact BST
        boolean contactRemoved = contactBST.removeKey(nameToDelete);

       if (contactRemoved) {
        // Remove the contact from any scheduled events
        removeContactFromEvents(deletedContact);
        System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Failed to delete contact.");
        }
    }
    else {
        System.out.println("Contact not found.");
    }
    }

    public void scheduleEvent(String title, String contactNames, Date dateTime, String location) {
        // Split the contact names and link the event with contacts
        linkEventWithContacts(contactNames);
        // Check if all contacts exist in the contact BST
        if (!validateContactsExist()) {
            System.out.println("Error: One or more contacts do not exist in the contact BST. Event not scheduled.");
            return;
        }
        // Check for conflicts with existing events for each contact
        if (!validateNoConflicts(dateTime)) {
            System.out.println("Error: Conflicts found with existing events. Event not scheduled.");
            return;
        }

private void removeContactFromEvents(Contact deletedContact) {
        // Iterate through all events and remove the contact
        Node<Event> currentEvent = events.findFirst ();
        while (currentEvent != null) {
            Event event = currentEvent.getData();
            if (event.isEvent()) {
                // For events, remove the contact from the list of contacts
                if (event.getContacts().search(deletedContact)) {
                    event.getContacts().remove(deletedContact);
                    System.out.println("Contact removed from event: " + event.getTitle());
                }
            } else {
                // For appointments, check if the contact matches and remove the appointment
                if (event.getContact().equals(deletedContact)) {
                    events.remove(currentEvent.getData());
                    System.out.println("Appointment removed: " + event.getTitle());
                    break;  // Assuming each contact has only one appointment
                }
            }
            currentEvent = currentEvent.getNext();
        }
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
