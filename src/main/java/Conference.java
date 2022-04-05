import java.util.ArrayList;

public class Conference {

  private String name;
  private int maxRegistrants;
  private ArrayList<Person> attendees;
  private ArrayList<Session> sessions;

  public Conference(String name, int maxRegistrants) {
    this.name = name;
    this.maxRegistrants = maxRegistrants;
    this.attendees = new ArrayList<>();
    this.sessions = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public int getMaxRegistrants() {
    return maxRegistrants;
  }

  public ArrayList<Person> getAttendees() {
    return attendees;
  }

  public ArrayList<Session> getSessions() {
    return sessions;
  }


  public boolean register(Person attendee) {
    if (attendees.size() >= maxRegistrants) {
      return false;
    }

    for (Person person : attendees) {
      if (person.getEmail().equals(attendee.getEmail())) {
        return false;
      }
    }

    attendees.add(attendee);
    return true;
  }

  public boolean addSession(Session session) {
    sessions.add(session);
    return true;
  }

  public String getSummary() {
    StringBuilder sb = new StringBuilder();

    sb.append(this.name);
    sb.append("Number of Attendees: " + attendees.size());

    for (Person attendee : attendees) {
      sb.append(attendee.getFirstName() + " " + attendee.getLastName());
    }

    sb.append("Number of Sessions: " + this.sessions.size());

    for (Session session : sessions) {
      sb.append(
          session.getName() + ", facilitated by " + session.getFacilitator().getFirstName() + " "
              + session.getFacilitator().getLastName());
    }

    if (maxRegistrants == attendees.size()) {
      sb.append("Registration is now closed");
    } else {
      sb.append("Registration is still open");
    }

    return sb.toString();
  }
}
