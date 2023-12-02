package PhonebookApp;

import java.sql.Time;

public class Event implements Comparable<Event> {
    
    private String title;
    private String DateTime;
    private String location;
    private boolean isEvent;
    private LinkedList<Contact> contacts;

    public Event(boolean isEvent, String title, String DateTime, String location, String contactNames) {
        this.isEvent = isEvent;
        this.title = title;
        this.DateTime = DateTime;
        this.location = location;
        this.contacts = new LinkedList<>();
        
        // Link event with contacts using the provided contact names
        linkEventWithContacts(contactNames);
    }
    private void linkEventWithContacts(String contactNames) {
        String[] names = contactNames.split(",");
        for (String name : names) {
            // Search for the contact in the BST and add to the event
            boolean contactFound = Phonebook.contactBST.findKey(name.trim());
            if (contactFound) {
                Contact contact = Phonebook.contactBST.retrieve();
                addContact(contact); //insert in the contacts linked list
            } else {
                System.out.println("Error: Contact '" + name.trim() + "' not found. Event not created.");
               
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String DateTime) {
        this.DateTime = DateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public boolean IsEvent() {
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
    
    @Override
public int compareTo(Event otherEvent) {
    return this.title.compareTo(otherEvent.getTitle());
}

    
    
    
}
