package oop.homework2;

import java.util.Date;

public class LectureActivity extends Activity {
  private String keySpeaker;

  public LectureActivity(
    String initId,
    String initName,
    Date initStartTime,
    Date initEndTime,
    String initDescription,
    String initSite,
    String initKeySpeaker
  ) {
    super(initId, initName, initStartTime, initEndTime, initDescription, initSite);
    this.keySpeaker = initKeySpeaker;
  }

  public String getKeySpeaker() {
    return keySpeaker;
  }

  public String toString() {
    return new StringBuilder()
      .append("- LectureActivity\n")
      .append("  id: ")         .append(getId())         .append('\n')
      .append("  name: ")       .append(getName())       .append('\n')
      .append("  startTime: ")  .append(getStartTime())  .append('\n')
      .append("  endTime: ")    .append(getEndTime())    .append('\n')
      .append("  description: ").append(getDescription()).append('\n')
      .append("  site: ")       .append(getSite())       .append('\n')
      .append("  keySpeaker: ") .append(keySpeaker)      .append('\n')
      .toString();
  }
}
