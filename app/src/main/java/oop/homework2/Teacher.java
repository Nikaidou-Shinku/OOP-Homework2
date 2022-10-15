package oop.homework2;

public class Teacher extends User {
  private String teacherNo;
  private String department;

  public Teacher(
    String initId,
    String initName,
    String initPhoneNo,
    String initEmail,
    String initTeacherNo,
    String initDepartment
  ) {
    super(initId, initName, initPhoneNo, initEmail);
    this.teacherNo = initTeacherNo;
    this.department = initDepartment;
  }

  public String getTeacherNo() {
    return teacherNo;
  }

  public String getDepartment() {
    return department;
  }
  public void setDepartment(String department) {
    this.department = department;
  }

  public String toString() {
    return new StringBuilder()
      .append("- Teacher\n")
      .append("  id: ")        .append(getId())     .append('\n')
      .append("  name: ")      .append(getName())   .append('\n')
      .append("  phoneNo: ")   .append(getPhoneNo()).append('\n')
      .append("  email: ")     .append(getEmail())  .append('\n')
      .append("  teacherNo: ") .append(teacherNo)   .append('\n')
      .append("  department: ").append(department)  .append('\n')
      .toString();
  }
}
