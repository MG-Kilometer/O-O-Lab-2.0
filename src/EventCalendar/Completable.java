//Author: Miles Glover

package EventCalendar;

//interface for complete and isComplete
public interface Completable {

    //sets completness
    void complete();

    //returns true if complete, false otherwise
    boolean isComplete();

}
