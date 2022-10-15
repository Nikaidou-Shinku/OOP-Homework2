package oop.homework2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Activity {
  private String id;
  private String name;
  private Date startTime;
  private Date endTime;
  private String description;
  private String site;

  private List<Team> teams;
  private List<Teacher> teachers;
  private List<Organizer> organizers;

  public Activity(
    String initId,
    String initName,
    Date initStartTime,
    Date initEndTime,
    String initDescription,
    String initSite
  ) {
    this.id = initId;
    this.name = initName;
    this.startTime = initStartTime;
    this.endTime = initEndTime;
    this.description = initDescription;
    this.site = initSite;

    this.teams = new ArrayList<Team>();
    this.teachers = new ArrayList<Teacher>();
    this.organizers = new ArrayList<Organizer>();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Date getStartTime() {
    return startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public String getSite() {
    return site;
  }

  public void addTeamToActivity(Team team) {
    teams.add(team);
  }
  public void removeTeamFromActivity(String id) {
    teams.removeIf(team -> team.getTeamId().equals(id));
  }

  public void addTeacherToActivity(Teacher teacher) {
    teachers.add(teacher);
  }
  public void removeTeacherFromActivity(String id) {
    teachers.removeIf(teacher -> teacher.getId().equals(id));
  }

  public void addOrganizerToActivity(Organizer organizer) {
    organizers.add(organizer);
  }
  public void removeOrganizerFromActivity(String id) {
    organizers.removeIf(organizer -> organizer.getId().equals(id));
  }

  public String toString() {
    return new StringBuilder()
      .append("- Activity\n")
      .append("  id: ")         .append(id)         .append('\n')
      .append("  name: ")       .append(name)       .append('\n')
      .append("  startTime: ")  .append(startTime)  .append('\n')
      .append("  endTime: ")    .append(endTime)    .append('\n')
      .append("  description: ").append(description).append('\n')
      .append("  site: ")       .append(site)       .append('\n')
      .toString();
  }

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (getClass() != o.getClass()) {
      return false;
    }
    Activity activity = (Activity)o;
    return id.equals(activity.getId());
  }

  public Iterator<Team> getTeamsIterator() {
    return teams.iterator();
  }
  public Iterator<Teacher> getTeachersIterator() {
    return teachers.iterator();
  }
  public Iterator<Organizer> getOrganizersIterator() {
    return organizers.iterator();
  }
}
