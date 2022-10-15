package oop.homework2;

public class User {
  private String id;
  private String name;
  private String phoneNo;
  private String email;

  public User(
    String initId,
    String initName,
    String initPhoneNo,
    String initEmail
  ) {
    this.id = initId;
    this.name = initName;
    this.phoneNo = initPhoneNo;
    this.email = initEmail;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNo() {
    return phoneNo;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String toString() {
    return new StringBuilder()
      .append("- User\n")
      .append("  id: ")     .append(id)     .append('\n')
      .append("  name: ")   .append(name)   .append('\n')
      .append("  phoneNo: ").append(phoneNo).append('\n')
      .append("  email: ")  .append(email)  .append('\n')
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
    User user = (User)o;
    return id.equals(user.getId());
  }
}
