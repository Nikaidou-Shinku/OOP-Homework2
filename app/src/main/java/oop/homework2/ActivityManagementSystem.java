package oop.homework2;

import java.util.List;

public class ActivityManagementSystem {
  private ActivitySubSystem activitySubSystem;
  private UserSubSystem userSubSystem;

  public ActivityManagementSystem() {
    this.activitySubSystem = new ActivitySubSystem();
    this.userSubSystem = new UserSubSystem();
  }

  public void displayUserSubSystem() {
    System.out.println("Students:\n");
    List<Student> students = userSubSystem.getStudentList();
    students.forEach(student -> System.out.println(student));

    System.out.println("Organizers:\n");
    List<Organizer> organizers = userSubSystem.getOrganizerList();
    organizers.forEach(organizer -> System.out.println(organizer));

    System.out.println("Teachers:\n");
    List<Teacher> teachers = userSubSystem.getTeacherList();
    teachers.forEach(teacher -> System.out.println(teacher));
  }
  public void displayActivitySubSystem() {
    System.out.println("Activities:\n");
    List<Activity> activities = activitySubSystem.getActivityList();
    activities.forEach(activity -> System.out.println(activity));
  }
  public UserSubSystem getUserSubSystem() {
    return userSubSystem;
  }
  public ActivitySubSystem getActivitySubSystem() {
    return activitySubSystem;
  }
}
