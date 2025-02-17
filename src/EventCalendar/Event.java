//Author: Miles Glover
//Purpose of File:

package EventCalendar;

import java.time.LocalDateTime;

public class Event implements Comparable<Event> {

    //class variables
    private String name;
    private LocalDateTime dateTime;

    //constructor
    public Event(String name, LocalDateTime dateTime) {

        this.name = name;
        this.dateTime = dateTime;

    }

    //getter for name
    public String getName() {

        return name;

    }

    //setter for name
    public void setName(String name) {

        this.name = name;

    }

    //getter for dateTime
    public LocalDateTime getDateTime() {

        return dateTime;

    }

    //setter for dateTime
    public void setDateTime(LocalDateTime dateTime) {

        this.dateTime = dateTime;

    }

    //compareTo method for sorting events by dateTime
    @Override
    public int compareTo(Event e) {

        return this.dateTime.compareTo(e.dateTime);

    }

    //toString method for debugging/display purposes
    @Override
    public String toString() {

        return "Event{name='" + name + "', dateTime=" + dateTime + "}";

    }

}
