package PhonebookApp;

import java.sql.Time;

public class Event implements Comparable<Event> {
    
    private String title;
    private String date;
    private String time;
    private String location;
    private boolean isEvent;
    private LinkedList<Contact> contacts;

    public Event(boolean isEvent,String title, String date, String time, String location) {
        this.isEvent = isEvent;
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.contacts = new LinkedList<>();
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String ContactName) {
        this.ContactName = ContactName;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Time getSt() {
        return st;
    }

    public void setSt(Time st) {
        this.st = st;
    }

    public Time getEd() {
        return ed;
    }

    public void setEd(Time ed) {
        this.ed = ed;
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
