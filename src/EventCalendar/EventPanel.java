//Author: Miles Glover

package EventCalendar;

//imports
import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;

//displays event details of a single event and allows you to complete completable events
public class EventPanel extends JPanel {

    //class variables
    private Event event;
    private JButton completeButton;

    //constructs an EventPanel for the given event.
    public EventPanel(Event event) {

        this.event = event;
        setLayout(new BorderLayout());

        //display event details
        JLabel nameLabel = new JLabel("Event: " + event.getName());

        //display the date in the correct format
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDate = event.getDateTime().format(dateFormatter);
        JLabel dateLabel = new JLabel("Date: " + formattedDate);

        //create info panels for name/date
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0, 1));
        infoPanel.add(nameLabel);
        infoPanel.add(dateLabel);

        //if event is a Meeting, add location and duration
        if (event instanceof Meeting) {

            Meeting meeting = (Meeting) event;

            //format the duration ahead of time to get rid of java.time string artefacts
            String formattedDuration = meeting.getDuration().toHours()+" hours";

            JLabel durationLabel = new JLabel("Duration: " + formattedDuration);
            JLabel locationLabel = new JLabel("Location: " + meeting.getLocation());
            infoPanel.add(durationLabel);
            infoPanel.add(locationLabel);

        }

        add(infoPanel, BorderLayout.CENTER);

        //if event is Completable, add a "Complete" button
        if (event instanceof Completable) {

            completeButton = new JButton("Complete");
            completeButton.addActionListener(e -> {

                ((Completable) event).complete();
                completeButton.setEnabled(false);

            });

            add(completeButton, BorderLayout.SOUTH);

        }

    }


}

