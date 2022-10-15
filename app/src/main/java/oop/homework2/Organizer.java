package oop.homework2;

public class Organizer extends User {
  private String unit;

  public Organizer(
    String initId,
    String initName,
    String initPhoneNo,
    String initEmail,
    String initUnit
  ) {
    super(initId, initName, initPhoneNo, initEmail);
    this.unit = initUnit;
  }

  public String getUnit() {
    return unit;
  }

  public String toString() {
    return new StringBuilder()
      .append("- Organizer\n")
      .append("  id: ")     .append(getId())     .append('\n')
      .append("  name: ")   .append(getName())   .append('\n')
      .append("  phoneNo: ").append(getPhoneNo()).append('\n')
      .append("  email: ")  .append(getEmail())  .append('\n')
      .append("  unit: ")   .append(unit)        .append('\n')
      .toString();
  }
}
