import java.util.ArrayList;
import java.util.List;

public class Conference {

  private List<Person> attendees;
  private String name;
  private int maxRegistrants;
  private List<Session> sessions;

  public Conference(String name, int maxRegistrants) {
    this.name = name;
    this.maxRegistrants = maxRegistrants;
    this.attendees = new ArrayList<Person>();
    this.sessions = new ArrayList<Session>();
  }

  public String getName() {
    return this.name;
  }

  public List<Person> getAttendees() {
    return attendees;
  }

  public int getMaxRegistrants() {
    return this.maxRegistrants;
  }

  public List<Session> getSessions() {
    return this.sessions;
  }

  public boolean register(Person registrant) {
    if (this.attendees.size() >= this.maxRegistrants) {
      return false;
    }

    for (Person attendee : this.attendees) {
      if (attendee.getEmail().equals(registrant.getEmail())) {
        return false;
      }
    }

    this.attendees.add(registrant);
    return true;
  }

  public boolean addSession(Session session) {
    this.sessions.add(session);
    return true;
  }
}
