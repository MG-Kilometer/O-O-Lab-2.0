//Author: Miles Glover

package EventCalendar;

//import
import java.time.LocalDateTime;

//class holds most general information of an event
public abstract class Event implements Comparable<Event> {

    //class variables
    protected String name;
    protected LocalDateTime dateTime;

    public Event(String name, LocalDateTime dateTime) {

        this.name = name;
        this.dateTime = dateTime;

    }

    //abstract method
    public abstract String getName();

    //getter for dateTime
    public LocalDateTime getDateTime() {

        return dateTime;

    }

    //setter for dateTime
    public void setDateTime(LocalDateTime dateTime) {

        this.dateTime = dateTime;

    }

    //setter for name
    public void setName(String name) {

        this.name = name;

    }

    //compareTo method for sorting events by dateTime
    @Override
    public int compareTo(Event other) {

        return this.dateTime.compareTo(other.dateTime);

    }

}
