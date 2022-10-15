package oop.homework2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
  private ActivityManagementSystem amSystem = new ActivityManagementSystem();
  private UserSubSystem usSystem = amSystem.getUserSubSystem();
  private ActivitySubSystem asSystem = amSystem.getActivitySubSystem();

  private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  // 初始化系统
  private void initSystem() throws ParseException {
    // 添加学生信息
    usSystem.addStudent(new Student(
      "stu_001",
      "小明",
      "13139149931",
      "22352@qq.com",
      "2021223111",
      false,
      "本科二年级",
      "软件学院"
    ));

    usSystem.addStudent(new Student(
      "stu_002",
      "小红",
      "13139149932",
      "22152@qq.com",
      "2021223112",
      true,
      "本科二年级",
      "软件学院"
    ));

    usSystem.addTeacher(new Teacher(
      "tea_001",
      "肖老师",
      "15304114352",
      "xiao@nwpu.edu.cn",
      "01342",
      "软件学院"
    ));

    usSystem.addOrganizer(new Organizer(
      "org_001",
      "软件学院官方",
      "010-03901234",
      "software@nwpu.edu.cn",
      "软件学院"
    ));


    // 添加活动信息
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    asSystem.addActivity(new ArtisticActivity(
      "act_001",
      "校园歌唱大赛",
      format.parse("2022-10-01 14:45:00"),
      format.parse("2022-10-04 17:00:00"),
      "一年一度校园歌唱大赛",
      "http://www.singasong.nwpu.edu.cn",
      "唱歌"
    ));

    asSystem.addActivity(new LectureActivity(
      "act_002",
      "翱翔讲座",
      format.parse("2022-10-09 14:00:00"),
      format.parse("2022-10-09 17:00:00"),
      "人工智能主题专讲",
      "http://www.lecture.nwpu.edu.cn",
      "陈晶"
    ));

    asSystem.addActivity(new PartyActivity(
      "act_003",
      "党日活动",
      format.parse("2022-10-11 14:00:00"),
      format.parse("2022-10-11 17:00:00"),
      "人人讲党课",
      "http://www.dangri.nwpu.edu.cn",
      "喜迎二十大",
      "党课"
    ));


    // 添加团队信息
    usSystem.createTeam("stu_001", "team_001", "科技与狠活队", "软件学院");
    usSystem.addStudentToTeam("stu_001", "stu_002", "team_001");
    usSystem.addTeacherToTeam("stu_001", "tea_001", "team_001");
  }

  @Test void test00() {
    System.out.println("Test 0: 测试系统初始化功能\n");
    assertDoesNotThrow(() -> { initSystem(); });
  }

  @Test void test01() {
    System.out.println("Test 1: 查看所有的用户（学生、教师、主办方）信息\n");
    assertDoesNotThrow(() -> {
      initSystem();
      amSystem.displayUserSubSystem();
    });
  }

  @Test void test02() {
    System.out.println("Test 2: 查看所有的活动信息\n");
    assertDoesNotThrow(() -> {
      initSystem();
      amSystem.displayActivitySubSystem();
    });
  }

  @Test void test03() {
    System.out.println("Test 3: 增、删、改、查学生/教师/主办方信息\n");
    assertDoesNotThrow(() -> {
      initSystem();

      // 学生的增删改查
      usSystem.addStudent(new Student(
        "stu_003",
        "小红",
        "13139149932",
        "22152@qq.com",
        "2021223112",
        true,
        "本科二年级",
        "软件学院"
      ));
      Student stu2 = usSystem.getStudentById("stu_003");

      stu2.setEmail("235462@qq.com");
      assertEquals(stu2.getEmail(), "235462@qq.com"); // check

      usSystem.removeStudentById("stu_003");
      assertNull(usSystem.getStudentById("stu_003")); // check

      // 教师的增删改查
      usSystem.addTeacher(new Teacher(
        "tea_002",
        "马老师",
        "15334114352",
        "ma@nwpu.edu.cn",
        "01242",
        "软件学院"
      ));
      Teacher tea2 = usSystem.getTeacherById("tea_002");

      tea2.setDepartment("计算机学院");
      assertEquals(tea2.getDepartment(), "计算机学院"); // check

      usSystem.removeTeacherById("tea_002");
      assertNull(usSystem.getTeacherById("tea_002")); // check

      // 主办方的增删改查
      usSystem.addOrganizer(new Organizer(
        "org_002",
        "计算机学院官方",
        "010-03904534",
        "compute@nwpu.edu.cn",
        "计算机学院"
      ));
      Organizer org2 = usSystem.getOrganizerById("org_002");

      org2.setName("计算机学院院办");
      assertEquals(org2.getName(), "计算机学院院办"); // check

      usSystem.removeOrganizerById("org_002");
      assertNull(usSystem.getOrganizerById("org_002")); // check
    });
  }

  @Test void test04() {
    System.out.println("Test 4: 增、删、改、查活动信息\n");
    assertDoesNotThrow(() -> {
      initSystem();

      asSystem.addActivity(new ArtisticActivity(
        "act_004",
        "街舞艺术节",
        format.parse("2022-10-01 14:45:00"),
        format.parse("2022-10-04 17:00:00"),
        "翱翔会议厅，等你来共舞",
        "http://www.dance.nwpu.edu.cn",
        "跳舞"
      ));
      Activity act = asSystem.getActivityById("act_004");

      act.setDescription("翱翔大厅，街舞专场，与你共舞");
      assertEquals(act.getDescription(), "翱翔大厅，街舞专场，与你共舞"); // check

      asSystem.removeActivityById("act_004");
      assertNull(asSystem.getActivityById("act_004")); // check
    });
  }

  @Test void test05() {
    System.out.println("Test 5: 根据时间筛选活动\n");
    assertDoesNotThrow(() -> {
      initSystem();

      List<Activity> acts = asSystem.getActivitiesByDate(format.parse("2022-10-02 14:00:00"));

      assertEquals(acts.size(), 1);
      assertEquals(acts.get(0).getId(), "act_001");
    });
  }

  @Test void test06() {
    System.out.println("Test 6: 将团队添加到某项活动中（报名）、从某项活动中删除团队（撤销报名）\n");
    assertDoesNotThrow(() -> {
      initSystem();

      // 将 team1 添加到 act1
      Activity act = asSystem.getActivityById("act_001");
      Student stu = usSystem.getStudentById("stu_001");
      Team team = stu.getTeamList().get(0);

      act.addTeamToActivity(team);
      assertEquals(act.getTeamsIterator().next(), team); // check

      act.removeTeamFromActivity("team_001");
      assertFalse(act.getTeamsIterator().hasNext()); // check
    });
  }

  @Test void test07() {
    System.out.println("Test 7: 将教师添加到某项活动中、从某项活动中删除教师\n");
    assertDoesNotThrow(() -> {
      initSystem();

      // 将 tea1 添加到 act1
      Activity act = asSystem.getActivityById("act_001");
      Teacher teacher = new Teacher(
        "tea_003",
        "吕老师",
        "153666888",
        "lv@nwpu.edu.cn",
        "01145",
        "软件学院"
      );

      act.addTeacherToActivity(teacher);
      assertEquals(act.getTeachersIterator().next(), teacher); // check

      act.removeTeacherFromActivity("tea_003");
      assertFalse(act.getTeachersIterator().hasNext()); // check
    });
  }

  @Test void test08() {
    System.out.println("Test 8: 将主办方添加到某项活动中、从某项活动中删除主办方\n");
    assertDoesNotThrow(() -> {
      initSystem();

      Activity act = asSystem.getActivityById("act_001");
      Organizer organizer = new Organizer(
        "org_003",
        "软件学院官方",
        "010-03901234",
        "software@nwpu.edu.cn",
        "软件学院"
      );

      act.addOrganizerToActivity(organizer);
      assertEquals(act.getOrganizersIterator().next(), organizer); // check

      act.removeOrganizerFromActivity("org_003");
      assertFalse(act.getOrganizersIterator().hasNext()); // check
    });
  }

  @Test void test09() {
    System.out.println("Test 9: 检查某个团队是否参加了多项活动\n");
    assertDoesNotThrow(() -> {
      initSystem();

      // 让 team1 参加三个活动
      Activity act1 = asSystem.getActivityById("act_001");
      Activity act2 = asSystem.getActivityById("act_002");
      Activity act3 = asSystem.getActivityById("act_003");

      Student stu = usSystem.getStudentById("stu_001");
      Team team = stu.getTeamList().get(0);

      act1.addTeamToActivity(team);

      assertTrue(asSystem.checkTeamValidity("team_001")); // check

      act2.addTeamToActivity(team);
      act3.addTeamToActivity(team);

      assertFalse(asSystem.checkTeamValidity("team_001")); // check
    });
  }

  @Test void test10() {
    System.out.println("Test 10: 创建团队，将学生/老师加入团队\n");
    assertDoesNotThrow(() -> {
      initSystem();

      usSystem.createTeam("stu_001", "team_002", "啥也不是队", "计算机学院");
      
      Student stu = usSystem.getStudentById("stu_001");
      Team team = stu.getTeamList().get(1);
      assertEquals(team.getTeamId(), "team_002"); // check

      usSystem.addStudentToTeam("stu_001", "stu_002", "team_002");
      assertEquals( // check
        team.getStudentList().get(1), // The first student is creator
        usSystem.getStudentById("stu_002")
      );

      usSystem.addTeacherToTeam("stu_001", "tea_001", "team_002");
      assertEquals( // check
        team.getTeacherList().get(0),
        usSystem.getTeacherById("tea_001")
      );
    });
  }
}
