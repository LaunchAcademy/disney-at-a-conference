import java.util.ArrayList;

public class Conference {
  private String name;
  private int maxRegistrants;
  private ArrayList<Person> attendees;
  private ArrayList sessions;

  public Conference(String name, int maxRegistrants) {
    this.name = name;
    this.maxRegistrants = maxRegistrants;
    this.attendees = new ArrayList<>();
    this.sessions = new ArrayList();
  }

  public String getName() {
    return this.name;
  }

  public int getMaxRegistrants() {
    return this.maxRegistrants;
  }

  public ArrayList getAttendees() {
    return this.attendees;
  }

  public ArrayList getSessions() {
    return this.sessions;
  }

  public boolean register(Person newAttendee) {
    // get a list of all attendee emails

    // make an empty array to store the emails
    ArrayList<String> attendeeEmails = new ArrayList<>();

    // iterate through all attendees
    for (Person attendee : this.attendees) {
      // add their email to our list
      attendeeEmails.add(attendee.getEmail());
    }

    // make sure the newAttendee's email is not in that list
    if(
        attendeeEmails.contains(newAttendee.getEmail()) ||
            // if we're already at max registration
        this.attendees.size() == this.maxRegistrants
    ) {
      return false;
    } else {
      this.attendees.add(newAttendee);
      return true;
    }
//    if (attendeeEmails.contains(newAttendee.getEmail())) {
//      return false;
//    } else if(this.attendees.size() == this.maxRegistrants) {
//      return false;
//    } else {
//      this.attendees.add(newAttendee);
//      return true;
//    }
  }

  public boolean addSession(Session newSession) {
    this.sessions.add(newSession);
    return true;
  }
}
