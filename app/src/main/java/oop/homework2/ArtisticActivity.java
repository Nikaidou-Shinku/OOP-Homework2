package oop.homework2;

import java.util.Date;

public class ArtisticActivity extends Activity {
  private String type;

  public ArtisticActivity(
    String initId,
    String initName,
    Date initStartTime,
    Date initEndTime,
    String initDescription,
    String initSite,
    String initType
  ) {
    super(initId, initName, initStartTime, initEndTime, initDescription, initSite);
    this.type = initType;
  }

  public String getType() {
    return type;
  }

  public String toString() {
    return new StringBuilder()
      .append("- ArtisticActivity\n")
      .append("  id: ")         .append(getId())         .append('\n')
      .append("  name: ")       .append(getName())       .append('\n')
      .append("  startTime: ")  .append(getStartTime())  .append('\n')
      .append("  endTime: ")    .append(getEndTime())    .append('\n')
      .append("  description: ").append(getDescription()).append('\n')
      .append("  site: ")       .append(getSite())       .append('\n')
      .append("  type: ")       .append(type)            .append('\n')
      .toString();
  }
}
