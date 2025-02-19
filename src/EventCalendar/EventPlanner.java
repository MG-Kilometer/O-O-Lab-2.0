//Author: Miles Glover

package EventCalendar;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

//main class for the Event Planner GUI.
//creates a JFrame and adds the EventListPanel.
public class EventPlanner {

    //main that creates the GUI
    public static void main(String[] args) {

        //constant values
        final int windowWidth = 800;
        final int windowHeight = 800;

        //creates a Jframe
        JFrame frame = new JFrame("Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(windowWidth, windowHeight);

        //create a eventListPanel
        EventListPanel eventListPanel = new EventListPanel();
        addDefaultEvents(eventListPanel);

        //adds the eventListPanel to the Jframe
        frame.add(eventListPanel);
        frame.setVisible(true);

    }

    ///adds some default events to the EventListPanel. rounds to minutes to remove long decimal
    private static void addDefaultEvents(EventListPanel eventListPanel) {

        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES); // Truncate to minutes
        eventListPanel.addEvent(new Deadline("Default Deadline", now.plusDays(1)));
        eventListPanel.addEvent(new Meeting("Default Meeting", now.plusDays(1), now.plusDays(2).plusHours(1).truncatedTo(ChronoUnit.MINUTES), "Room 101"));

    }
}



