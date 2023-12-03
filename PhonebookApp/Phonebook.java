package PhonebookApp;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Phonebook {
    
    static ContactBST contactBST;
    static LinkedList<Event> events;
   

    public Phonebook() {
        contactBST = new ContactBST();
        events = new LinkedList<Event>();
          
    }
    public ContactBST getContactBST() {
        return contactBST;
    }
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            do{
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

                      phonebook.searchContact(searchCriteria, searchTerm) ;
                    break;
                    case 3: //still
                    System.out.print("Enter the contact's name to delete: ");
                    String nameToDelete = scanner.nextLine();
                        phonebook.deleteContact(nameToDelete);
                        break;
                    case 4:
                    // Schedule an event/appointment
                    System.out.println("Enter type:");
                    System.out.println("1. event");
                    System.out.println("2. appointment");
                    System.out.print("Enter your choice: ");
                    int eventType = scanner.nextInt();
                    scanner.nextLine();
                    
                        System.out.print("Enter event title: ");
                        String title = scanner.nextLine();
                        String[] names = null;

                         if (eventType == 1) {
                        do {
            System.out.print("Enter contacts name separated by a comma: ");
            String contactNames = scanner.nextLine();

            // Check if contacts exist in the BST 
            names = contactNames.split(",");

            if (names == null || names.length == 0) {
                // Handle the case where names is null or empty
                System.out.println("Error: Please enter at least one contact name.");
            }

   } while (names == null || names.length == 0);

                        // Check if contacts exist in the BST 
                           for (String Cname : names) {
                        boolean contactFound = Phonebook.contactBST.findKey(Cname.trim());
                        if (!contactFound){ 
                        System.out.println("Error: Contact '" + Cname.trim() + "' not found. Event not created.");
                        return;
                    }} }
                        if(eventType == 2){
                            System.out.print("Enter contact name: ");
                            String contactName = scanner.nextLine();
                        
                            // Check if the contact exists in the BST before scheduling the appointment
                            boolean contactFound =Phonebook.contactBST.findKey(contactName.trim());
                            if (!contactFound) {
                                System.out.println("Error: Contact '" + contactName.trim() + "' not found. Appointment not created.");
                                continue; } }
                            
                    

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
                    
                        phonebook.scheduleEvent(eventType, title, dateTime, location, names);
                        
                        

                        System.out.println("Event scheduled successfully!");
                      
                        break;
                    case 5:
                    System.out.println("Enter search criteria:");
                    System.out.println("1. Contact Name");
                    System.out.println("2. Event Title");
                    int printCriteria = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                if (printCriteria == 1) {
                   System.out.println("Enter the contact name: ");
                 String searchContact = scanner.nextLine();
                 phonebook.printEventDetails(printCriteria, searchContact);
}                else if (printCriteria == 2) {
                System.out.println("Enter the event title: ");
                String searchEvent = scanner.nextLine();
                 phonebook.printEventDetails(printCriteria, searchEvent);
}                else {
                System.out.println("Invalid search criteria.");
}

                        break;
                    case 6:
                    System.out.print("Enter first name to search: ");
                    String firstNameToSearch = scanner.nextLine();
                    ContactBST contactBST = phonebook.getContactBST();
                    contactBST.searchFirstName(firstNameToSearch);
                        break;
                    case 7:
                        phonebook.displayAllEventsAlphabetically();
                        break;
                    case 8:
                        System.out.println("Exiting Phonebook. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 8);
        }
    

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
    
public boolean searchContact(int searchCriteria, String searchTerm) {
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
    return contactFound;
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

public void scheduleEvent(int eventType,String title, Date dateTime, String location, String [ ] names) {
    Event event = null;

    if (eventType == 1) {
        // Schedule an event
        if (names.length == 1) {
            // Single-contact event
            String contactName = names[0];
            Contact appContactName = Phonebook.contactBST.retrieveByName(contactName.trim());
            if (appContactName != null) {
                event = new Event(true, title, dateTime, location, new String[]{contactName});
            } else {
                System.out.println("Error: Contact not found. Event not created.");
                return;
            }
        } else {
            // Multi-contact event
            event = new Event(true, title, dateTime, location, names);
        }
    } else if (eventType == 2) {
        // Schedule an appointment
        if (names.length != 1) {
            System.out.println("Error: Please enter only one contact name for an appointment.");
            return;
        }

        String contactName = names[0];
        Contact appContactName = Phonebook.contactBST.retrieveByName(contactName.trim());
        if (appContactName != null) {
            event = new Event(false, title, dateTime, location, appContactName);
        } else {
            System.out.println("Error: Contact not found. Appointment not created.");
            return;
        }
    }

    if (event == null) {
        System.out.println("Error: Unable to create event/appointment.");
        return;
    }

    if (hasConflict(event)) {
        System.out.println("Error: Conflict detected. Event/Appointment not scheduled.");
        return;
    }

    events.insert(event);
    System.out.println("Event/Appointment scheduled successfully!");
       
}        

    

    public boolean hasConflict(Event event) {
        if (events.empty()) {
            return false; // No events in the list, no conflict
        }
    
        events.findFirst();
        Event currentEvent;
    
        do {
            currentEvent = events.retrieve();
    
            if (currentEvent.hasonflict(event)) {
                return true; // Conflict detected
            }
    
        } while (!events.last() &&events.findnext());
    
        return false; // No conflict found
    }

            
      
    
     
    private void removeContactFromEvents(Contact deletedContact) {
        events.findFirst();
        while (true) {
            Event currentEvent = events.retrieve();
            currentEvent.removeContactFromEvent(deletedContact);
    
            if (events.last()) {
                break; // Break the loop if it's the last event
            }
            events.findNext();
        }
    }
    
    
    public void displayAllEventsAlphabetically() {
        events.findFirst(); 
    
        while (true) {
            Event currentEvent = events.retrieve();
            currentEvent.displayEvent(); 
    
            if (events.last()) {
                break; // Break the loop if it's the last event
            }
            events.findNext();
        }
    }
    public void printEventDetails(String eventTitle){
        events.findFirst();
        Event currentEvent = null;
        boolean found = false;
    
        while (true) {
            currentEvent = events.retrieve();
    
            if (currentEvent.getTitle().equalsIgnoreCase(eventTitle)) {
                currentEvent.displayEvent();
                found = true;
                break;
            }
    
            if (events.last()) {
                break; // Break the loop if it's the last event
            }
            events.findNext();
        }
    
        // Check if the event was found before attempting to display
        if (!found) {
            System.out.println("Event with title '" + eventTitle + "' not found.");
        }

    }
    public void printEventDetails(int searchCriteria, String searchTerm) {
        switch (searchCriteria) {
            case 1: // Search by Contact Name
                boolean contactFound = Phonebook.contactBST.searchContactByName(searchTerm);
                if (!contactFound) {
                    System.out.println("Contact not found.");
                }
                break;
            case 2: // Search by Event Title
                // Call a method to search for events by title
                printEventDetails(searchTerm);
                break;
            // Add more cases for other search criteria if needed
            default:
                System.out.println("Invalid search criteria.");
        }
    }
    

    
    
}
