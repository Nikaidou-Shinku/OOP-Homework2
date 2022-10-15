package oop.homework2;

import java.util.ArrayList;
import java.util.List;

public class Team {
  private String teamId;
  private String teamName;
  private String department;
  private Student creator;

  private List<Student> students;
  private List<Teacher> teachers;

  public Team(
    String initTeamId,
    String initTeamName,
    String initDepartment,
    Student initCreator
  ) {
    this.teamId = initTeamId;
    this.teamName = initTeamName;
    this.department = initDepartment;
    this.creator = initCreator;

    this.students = new ArrayList<Student>();
    this.teachers = new ArrayList<Teacher>();
  }

  public String getTeamId() {
    return teamId;
  }

  public String getTeamName() {
    return teamName;
  }

  public String getDepartment() {
    return department;
  }

  public Student getCreator() {
    return creator;
  }

  public String toString() {
    return new StringBuilder()
      .append("- Team\n")
      .append("  teamId: ")    .append(teamId)           .append('\n')
      .append("  teamName: ")  .append(teamName)         .append('\n')
      .append("  department: ").append(department)       .append('\n')
      .append("  creator: ")   .append(creator.getName()).append('\n')
      .toString();
  }

  public List<Student> getStudentList() {
    return students;
  }

  public List<Teacher> getTeacherList() {
    return teachers;
  }

  public void addStudent(Student student) {
    students.add(student);
  }

  public void addTeacher(Teacher teacher) {
    teachers.add(teacher);
  }
}
