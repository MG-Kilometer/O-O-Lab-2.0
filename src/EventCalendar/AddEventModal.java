//Author: Miles Glover

package EventCalendar;

//imports
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//a modal dialog for adding a new event to the planner.
public class AddEventModal extends JDialog {

    //class variables for text labels/buttons
    private JTextField nameField, dateTimeField, locationField, durationField;
    private JComboBox<String> eventTypeDropdown;
    private JButton addButton;
    private EventListPanel eventListPanel;

    //constructs an event-adding modal
    public AddEventModal(EventListPanel eventListPanel) {

        //constant values
        final int windowWidth = 600;
        final int windowHeight = 400;
        final int gridX = 6;
        final int gridY = 2;

        //creates eventListPanel and sets window size
        this.eventListPanel = eventListPanel;
        setTitle("Add Event");
        setSize(windowWidth, windowHeight);
        setLayout(new GridLayout(gridX, gridY));

        //name text field
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        //date/time text field
        add(new JLabel("Date & Time (yyyy-MM-dd HH:mm):"));
        dateTimeField = new JTextField();
        add(dateTimeField);

        //type text field
        add(new JLabel("Type:"));
        eventTypeDropdown = new JComboBox<>(new String[]{"Deadline", "Meeting"});
        add(eventTypeDropdown);

        //duration text field
        add(new JLabel("Duration (Meetings only) (in hrs):"));
        durationField = new JTextField();
        durationField.setEnabled(false);
        add(durationField);

        //location text field
        add(new JLabel("Location (Meetings only):"));
        locationField = new JTextField();
        locationField.setEnabled(false);
        add(locationField);

        //makes the duration and location typable if it is a meeting
        eventTypeDropdown.addActionListener(e -> {

            boolean isMeeting = eventTypeDropdown.getSelectedItem().equals("Meeting");
            durationField.setEnabled(isMeeting);
            locationField.setEnabled(isMeeting);

        });

        //add event button with some exception handling
        addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            try {
                addEvent();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: Invalid input. Please check your input and try again.", "Event Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(addButton);

        setVisible(true);

    }


    //adds an event based on user input
    private void addEvent() {

        String name = nameField.getText();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        //add the deadline information if it is one, otherwise add the meeting information
        if (eventTypeDropdown.getSelectedItem().equals("Deadline")) {

            eventListPanel.addEvent(new Deadline(name, dateTime));

        } else {

            String location = locationField.getText();
            double duration = Double.parseDouble(durationField.getText());
            eventListPanel.addEvent(new Meeting(name, dateTime, dateTime.plusHours((long) duration), location));

        }

        //close modal
        dispose();

    }

}
