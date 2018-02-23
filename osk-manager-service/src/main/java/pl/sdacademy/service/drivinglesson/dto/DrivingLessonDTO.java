package pl.sdacademy.service.drivinglesson.dto;

import java.util.Date;

public class DrivingLessonDTO {

    private String teacherFirstAndLastName;
    private String studentFirstAndLastName;
    private Date lessonDay;
    private Date lessonStartTime;
    private Date lessonStopTime;

    public DrivingLessonDTO() {
    }

    public DrivingLessonDTO(String teacherFirstAndLastName, String studentFirstAndLastName, Date lessonDay, Date lessonStartTime, Date lessonStopTime) {
        this.teacherFirstAndLastName = teacherFirstAndLastName;
        this.studentFirstAndLastName = studentFirstAndLastName;
        this.lessonDay = lessonDay;
        this.lessonStartTime = lessonStartTime;
        this.lessonStopTime = lessonStopTime;
    }

    public String getTeacherFirstAndLastName() {
        return teacherFirstAndLastName;
    }

    public void setTeacherFirstAndLastName(String teacherFirstAndLastName) {
        this.teacherFirstAndLastName = teacherFirstAndLastName;
    }

    public String getStudentFirstAndLastName() {
        return studentFirstAndLastName;
    }

    public void setStudentFirstAndLastName(String studentFirstAndLastName) {
        this.studentFirstAndLastName = studentFirstAndLastName;
    }

    public Date getLessonDay() {
        return lessonDay;
    }

    public void setLessonDay(Date lessonDay) {
        this.lessonDay = lessonDay;
    }

    public Date getLessonStartTime() {
        return lessonStartTime;
    }

    public void setLessonStartTime(Date lessonStartTime) {
        this.lessonStartTime = lessonStartTime;
    }

    public Date getLessonStopTime() {
        return lessonStopTime;
    }

    public void setLessonStopTime(Date lessonStopTime) {
        this.lessonStopTime = lessonStopTime;
    }
}
