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

  public ArrayList<Person> getAttendees(){
    return this.attendees;
  }

  public String getName() {
    return this.name;
  }

  public int getMaxRegistrants() {
    return this.maxRegistrants;
  }

  public ArrayList<Session> getSessions() {
    return this.sessions;
  }

  public Boolean register(Person newPerson) {
    // if the # of current attendees is already at maxRegistrants
    if(this.attendees.size() == this.maxRegistrants) {
      return false;
    }

    // loop through the current attendees
    for(Person attendee : this.attendees) {
      // if any of the current attendees has a matching email
      if(attendee.getEmail().equals(newPerson.getEmail())) {
        // don't add them to the array
        return false;
      }
    }

    //else
    // add a person to the attendees
    this.attendees.add(newPerson);
    return true;
  }

  public Boolean addSession(Session newSession) {
    this.sessions.add(newSession);
    return true;
  }

  public String getSummary() {
    StringBuilder sb = new StringBuilder();

    sb.append(this.name);
    sb.append("Number of Attendees: " + this.attendees.size());

    for(Person attendee : this.attendees) {
      sb.append(attendee.getFirstName() + " " + attendee.getLastName());
    }

    sb.append("Number of Sessions: " + this.sessions.size());

    for(Session session : this.sessions) {
      sb.append(session.getName() + ", facilitated by " + session.getFacilitator().getFirstName() + " " + session.getFacilitator().getLastName());
    }

    if(this.attendees.size() == this.maxRegistrants) {
      sb.append("Registration is now closed");
    } else {
      sb.append("Registration is still open");
    }

    return sb.toString();
  }
}
