//Author: Miles Glover

package EventCalendar;

//import
import java.time.LocalDateTime;

//class handles all data and functions concerning deadlines
class Deadline extends Event implements Completable {

    //class variable
    private boolean complete;

    //constructor
    public Deadline(String name, LocalDateTime deadline) {
        super(name, deadline);
        this.complete = false;
    }

    //implementing getName method
    @Override
    public String getName() {

        return name;

    }

    //getter for deadline
    public LocalDateTime getDeadline() {

        return dateTime;

    }

    //setter for deadline
    public void setDeadline(LocalDateTime deadline) {

        this.dateTime = deadline;

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
