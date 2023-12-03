package PhonebookApp;
import java.util.Date;


public class Event implements Comparable<Event> {
    
    private String title;
    private Date  DateTime;
    private String location;
    private boolean isEvent;
    private LinkedList<Contact> contacts;

    public Event(boolean isEvent, String title,Date dateTime, String location, String[] contactNames) {
        this.isEvent = isEvent;
        this.title = title;
        this.DateTime = dateTime;
        this.location = location;
        this.contacts = new LinkedList<>();
        
        for (String name : contactNames) {
            // Search for the contact in the BST and add to the event
            
                Contact contact = Phonebook.contactBST.retrieveByName(name);
                addContact(contact); //insert in the contacts linked list
        }
    }

    public Event(boolean isEvent, String title, Date DateTime, String location, Contact contactNames) {
        this.isEvent = isEvent;
        this.title = title;
        this.DateTime = DateTime;
        this.location = location;
        this.contacts = new LinkedList<>();
        this.addContact(contactNames); //insert in the contacts linked list
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateTime() {
        return DateTime;
    }

    public void setDateTime(Date DateTime) {
        this.DateTime = DateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public boolean isEvent() {
        return isEvent;
    }

    public void setIsEvent(boolean isEvent) {
        this.isEvent = isEvent;
    }
    public void addContact(Contact contact) {
        contacts.insert(contact);
    }
    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public boolean hasContact(String contactName){
        return contacts.search(contactName);
    }
    public LinkedList<Contact> getContacts() {
        return contacts;
    }
    public boolean hasonflict(Event otherEvent) {
        return this.compareTo(otherEvent) == 0;
    }

    
    @Override
public int compareTo(Event otherEvent) {
    return this.DateTime.compareTo(otherEvent.getDateTime());
}

    public void removeContactFromEvent(Contact deletedContact) {
        if (isEvent()) {
            // For events, remove the contact from the list of contacts
            if (contacts.search(deletedContact)) {
                contacts.remove(deletedContact);
                System.out.println("Contact removed from event: " + getTitle());
            }
        } else {
            // For appointments, check if the contact matches and remove the appointment
            if (hasContact(deletedContact.getName())) {
                System.out.println("Appointment removed: " + getTitle());
            }
        }
    }
    public void displayEvent() {
        System.out.println("Event Name: " + title);
        System.out.println("Date and Time: " + DateTime);
        System.out.println("Location: " + location);
        
        System.out.println(); 
    }

}
  
    
