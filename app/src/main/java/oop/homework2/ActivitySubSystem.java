package oop.homework2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ActivitySubSystem {
  private List<Activity> activities;

  public ActivitySubSystem() {
    this.activities = new ArrayList<Activity>();
  }

  public void addActivity(Activity activity) {
    activities.add(activity);
  }

  public void removeActivityById(String id) {
    activities.removeIf(activity -> activity.getId().equals(id));
  }

  public Activity getActivityById(String id) {
    return activities.stream()
      .filter(activity -> activity.getId().equals(id))
      .findFirst()
      .orElse(null);
  }

  public List<Activity> getActivitiesByDate(Date date) {
    return activities.stream()
      .filter(activity -> (
        activity.getStartTime().before(date) &&
        activity.getEndTime().after(date)
      ))
      .collect(Collectors.toList());
  }

  public List<Activity> getActivityList() {
    return activities;
  }

  public boolean checkTeamValidity(String teamId) {
    long count = activities.stream()
      .filter(activity -> {
        Spliterator<Team> spliterator = Spliterators.spliteratorUnknownSize(activity.getTeamsIterator(), 0);
        return StreamSupport.stream(spliterator, false)
          .anyMatch(team -> team.getTeamId().equals(teamId));
      })
      .count();

    return count == 1;
  }
}
