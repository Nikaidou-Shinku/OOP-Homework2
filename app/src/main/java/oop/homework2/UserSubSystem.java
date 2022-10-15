package oop.homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserSubSystem {
  private List<User> users;

  public UserSubSystem() {
    this.users = new ArrayList<User>();
  }

  public void addStudent(Student student) {
    users.add(student);
  }
  public void removeStudentById(String id) {
    users.removeIf(student -> student.getId().equals(id));
  }
  public Student getStudentById(String id) {
    return (Student)users.stream()
      .filter(student -> student.getId().equals(id))
      .findFirst()
      .orElse(null);
  }
  public List<Student> getStudentList() {
    return users.stream()
      .filter(user -> user instanceof Student)
      .map(user -> (Student)user)
      .collect(Collectors.toList());
  }

  public void addOrganizer(Organizer organizer) {
    users.add(organizer);
  }
  public void removeOrganizerById(String id) {
    users.removeIf(organizer -> organizer.getId().equals(id));
  }
  public Organizer getOrganizerById(String id) {
    return (Organizer)users.stream()
      .filter(organizer -> organizer.getId().equals(id))
      .findFirst()
      .orElse(null);
  }
  public List<Organizer> getOrganizerList() {
    return users.stream()
      .filter(user -> user instanceof Organizer)
      .map(user -> (Organizer)user)
      .collect(Collectors.toList());
  }

  public void addTeacher(Teacher teacher) {
    users.add(teacher);
  }
  public void removeTeacherById(String id) {
    users.removeIf(teacher -> teacher.getId().equals(id));
  }
  public Teacher getTeacherById(String id) {
    return (Teacher)users.stream()
      .filter(teacher -> teacher.getId().equals(id))
      .findFirst()
      .orElse(null);
  }
  public List<Teacher> getTeacherList() {
    return users.stream()
      .filter(user -> user instanceof Teacher)
      .map(user -> (Teacher)user)
      .collect(Collectors.toList());
  }

  public void createTeam(
    String creatorId,
    String teamId,
    String teamName,
    String department
  ) {
    Student creator = getStudentById(creatorId);

    Team newTeam = new Team(teamId, teamName, department, creator);
    newTeam.addStudent(creator);

    creator.getTeamList().add(newTeam);
  }
  public void addStudentToTeam(String creatorId, String studentId, String teamId) {
    Student creator = getStudentById(creatorId);

    Team team = creator.getTeamList().stream()
      .filter(t -> t.getTeamId().equals(teamId))
      .findFirst()
      .orElse(null);

    if (team != null) {
      Student student = getStudentById(studentId);
      team.addStudent(student);
    }
  }
  public void addTeacherToTeam(String creatorId, String teacherId, String teamId) {
    Student creator = getStudentById(creatorId);

    Team team = creator.getTeamList().stream()
      .filter(t -> t.getTeamId().equals(teamId))
      .findFirst()
      .orElse(null);

    if (team != null) {
      Teacher teacher = getTeacherById(teacherId);
      team.addTeacher(teacher);
    }
  }
}
