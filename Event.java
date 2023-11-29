/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phaes2;

import java.sql.Time;

/**
 *
 * @author sara
 */
public class Event {
    
    private String title;
    private String date;
    private String time;
    private String location;
    private String ContactName;
    private String start,end;
    private Time st,ed;
    public boolean isEvent=true;
    public LinkedList<Contact>contactWithEvent=new LinkedList<Contact>();

    public Event(String title, String date, String time, String location, String ContactName) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.ContactName = ContactName;
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
    
    
    
    
    
    
}
