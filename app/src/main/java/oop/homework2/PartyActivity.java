package oop.homework2;

import java.util.Date;

public class PartyActivity extends Activity {
  private String theme;
  private String classification;

  public PartyActivity(
    String initId,
    String initName,
    Date initStartTime,
    Date initEndTime,
    String initDescription,
    String initSite,
    String initTheme,
    String initClassification
  ) {
    super(initId, initName, initStartTime, initEndTime, initDescription, initSite);
    this.theme = initTheme;
    this.classification = initClassification;
  }

  public String getTheme() {
    return theme;
  }

  public String getClassification() {
    return classification;
  }

  public String toString() {
    return new StringBuilder()
      .append("- PartyActivity\n")
      .append("  id: ")            .append(getId())         .append('\n')
      .append("  name: ")          .append(getName())       .append('\n')
      .append("  startTime: ")     .append(getStartTime())  .append('\n')
      .append("  endTime: ")       .append(getEndTime())    .append('\n')
      .append("  description: ")   .append(getDescription()).append('\n')
      .append("  site: ")          .append(getSite())       .append('\n')
      .append("  theme: ")         .append(theme)           .append('\n')
      .append("  classification: ").append(classification)  .append('\n')
      .toString();
  }
}
