package oop.homework2;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
  private String studentNo;
  private boolean gender;
  private String grade;
  private String department;
  private List<Team> teamList;

  public Student(
    String initId,
    String initName,
    String initPhoneNo,
    String initEmail,
    String initStudentNo,
    boolean initGender,
    String initGrade,
    String initDepartment
  ) {
    super(initId, initName, initPhoneNo, initEmail);
    this.studentNo = initStudentNo;
    this.gender = initGender;
    this.grade = initGrade;
    this.department = initDepartment;
    this.teamList = new ArrayList<Team>();
  }

  public String getStudentNo() {
    return studentNo;
  }

  public boolean getGender() {
    return gender;
  }

  public String getGrade() {
    return grade;
  }

  public String getDepartment() {
    return department;
  }

  public List<Team> getTeamList() {
    return teamList;
  }

  public String toString() {
    return new StringBuilder()
      .append("- Student\n")
      .append("  id: ")        .append(getId())                   .append('\n')
      .append("  name: ")      .append(getName())                 .append('\n')
      .append("  phoneNo: ")   .append(getPhoneNo())              .append('\n')
      .append("  email: ")     .append(getEmail())                .append('\n')
      .append("  studentNo: ") .append(studentNo)                 .append('\n')
      .append("  gender: ")    .append(gender ? "Female" : "Male").append('\n')
      .append("  grade: ")     .append(grade)                     .append('\n')
      .append("  department: ").append(department)                .append('\n')
      .toString();
  }
}
