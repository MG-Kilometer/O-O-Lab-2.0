//Author: Miles Glover
//Purpose of File:

package EventCalendar;

import java.time.LocalDateTime;

public class Deadline implements Completable {

    //class variables
    private String name;
    private LocalDateTime deadline;
    private boolean complete;

    //constructor
    public Deadline(String name, LocalDateTime deadline) {

        this.name = name;
        this.deadline = deadline;
        this.complete = false;

    }

    //marks the deadline as complete
    @Override
    public void complete() {

        this.complete = true;

    }

    //checks if the deadline is complete
    @Override
    public boolean isComplete() {

        return complete;

    }

    //getter for name
    public String getName() {

        return name;

    }

    //getter for deadline
    public LocalDateTime getDeadline() {

        return deadline;

    }

    //setter for deadline
    public void setDeadline(LocalDateTime deadline) {

        this.deadline = deadline;

    }

}

