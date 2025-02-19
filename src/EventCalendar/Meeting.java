//Author: Miles Glover

package EventCalendar;

//import
import java.time.Duration;
import java.time.LocalDateTime;

//class handles all data and functions concerning meetings
class Meeting extends Event implements Completable {

    //class variables
    private LocalDateTime endTime;
    private String location;
    private boolean complete;

    //constructor
    public Meeting(String name, LocalDateTime start, LocalDateTime end, String location) {
        super(name, start);
        this.endTime = end;
        this.location = location;
        this.complete = false;
    }

    //implementing getName method
    @Override
    public String getName() {
        return name;
    }

    //getter for endTime
    public LocalDateTime getEndTime() {
        return endTime;
    }

    //setter for endTime
    public void setEndTime(LocalDateTime end) {
        this.endTime = end;
    }

    //calculate duration
    public Duration getDuration() {
        return Duration.between(dateTime, endTime);
    }

    //getter for location
    public String getLocation() {
        return location;
    }

    //setter for location
    public void setLocation(String location) {
        this.location = location;
    }

    //marking as complete
    @Override
    public void complete() {
        this.complete = true;
    }

    //checking if complete
    @Override
    public boolean isComplete() {
        return complete;
    }
}
