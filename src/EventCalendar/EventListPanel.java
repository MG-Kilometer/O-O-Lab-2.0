//Author: Miles Glover

package EventCalendar;

//imports
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

//manages and displays a list of events.
//allows for sorting, filtering, and adding new events
public class EventListPanel extends JPanel {

    //class variables that hold events/buttons for the GUI
    private ArrayList<Event> events;
    private JPanel displayPanel;
    private JComboBox<String> sortDropDown;
    private JCheckBox filterCompleted, filterDeadlines, filterMeetings;
    private JButton addEventButton;

    //constructs the event list panel and initializes components.
    public EventListPanel() {

        //makes the array list of events and sets the layout
        this.events = new ArrayList<>();
        setLayout(new BorderLayout());

        //control panel with sorting and filtering
        JPanel controlPanel = new JPanel();
        String[] sortOptions = {"Name (A-Z)", "Name (Z-A)", "Date (Earliest First)", "Date (Latest First)"};
        sortDropDown = new JComboBox<>(sortOptions);
        sortDropDown.addActionListener(e -> sortEvents());
        controlPanel.add(sortDropDown);

        //hide completed checkbox
        filterCompleted = new JCheckBox("Hide Completed");
        filterCompleted.addActionListener(e -> updateDisplay());
        controlPanel.add(filterCompleted);

        //hide deadlines checkbox
        filterDeadlines = new JCheckBox("Hide Deadlines");
        filterDeadlines.addActionListener(e -> updateDisplay());
        controlPanel.add(filterDeadlines);

        //hide meetings checkbox
        filterMeetings = new JCheckBox("Hide Meetings");
        filterMeetings.addActionListener(e -> updateDisplay());
        controlPanel.add(filterMeetings);

        //add event button
        addEventButton = new JButton("Add Event");
        addEventButton.addActionListener(e -> new AddEventModal(this));
        controlPanel.add(addEventButton);

        add(controlPanel, BorderLayout.NORTH);

        // Display panel for events
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(displayPanel), BorderLayout.CENTER);

    }

    //adds an event to the list and refreshes the display.
    public void addEvent(Event event) {

        events.add(event);
        updateDisplay();

    }


    //updates the event display based on sorting and filtering
    private void updateDisplay() {

        displayPanel.removeAll();
        for (Event event : events) {

            //if filter attribute true, dont render
            if (filterCompleted.isSelected() && event instanceof Completable && ((Completable) event).isComplete()) {
                continue;
            }
            if (filterDeadlines.isSelected() && event instanceof Deadline) {
                continue;
            }
            if (filterMeetings.isSelected() && event instanceof Meeting) {
                continue;
            }

            displayPanel.add(new EventPanel(event));

        }

        displayPanel.revalidate();
        displayPanel.repaint();

    }


    //sorts events based on the selected option and updates display
    private void sortEvents() {

        Comparator<Event> comparator;

        //sorts based on name, reversed name order, date, and reverse date order respectfully
        switch (sortDropDown.getSelectedIndex()) {

            case 0: comparator = Comparator.comparing(Event::getName); break;
            case 1: comparator = Comparator.comparing(Event::getName).reversed(); break;
            case 2: comparator = Comparator.comparing(Event::getDateTime); break;
            case 3: comparator = Comparator.comparing(Event::getDateTime).reversed(); break;
            default: return;

        }

        events.sort(comparator);
        updateDisplay();

    }

}