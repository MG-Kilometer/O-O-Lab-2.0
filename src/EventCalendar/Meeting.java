//Author: Miles Glover
//Purpose of File:

package EventCalendar;

import java.time.Duration;
import java.time.LocalDateTime;

public class Meeting implements Completable {

    //class variables
    private String name;
    private LocalDateTime start;
    private LocalDateTime endDateTime;
    private String location;
    private boolean complete;

    //constructor for meeting
    public Meeting(String name, LocalDateTime start, LocalDateTime end, String location) {

        this.name = name;
        this.start = start;
        this.endDateTime = end;
        this.location = location;
        this.complete = false;

    }

    //marks the meeting as complete
    @Override
    public void complete() {

        this.complete = true;

    }

    //returns true if the meeting is complete
    @Override
    public boolean isComplete() {

        return complete;

    }

    //returns when meeting will end
    public LocalDateTime getEndTime() {

        return endDateTime;

    }

    //returns how long the meeting is duration-wise
    public Duration getDuration() {

        return Duration.between(start, endDateTime);

    }

    //returns the location of the meeting
    public String getLocation() {

        return location;

    }

    //sets when the meeting will end
    public void setEndTime(LocalDateTime end) {

        this.endDateTime = end;

    }

    //sets the location of the meeting
    public void setLocation(String location) {

        this.location = location;

    }

}

