package pl.sdacademy.domain.entity;


import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "DRIVING_LESSON")
@AssociationOverrides({
        @AssociationOverride(name = "STUDENT_ID", joinColumns = @JoinColumn(name = "STUDENT_ID")),
        @AssociationOverride(name = "TEACHER_ID", joinColumns = @JoinColumn(name = "TEACHER_ID"))
})
@Audited

public class DrivingLesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LESSON_ID")
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Teacher teacher;

    @NotNull
    @Column(name = "LESSON_START_DAY")
    @Temporal(TemporalType.DATE)
    private Date lessonDay;

    @NotNull
    @Column(name = "LESSON_START_TIME")
    @Temporal(TemporalType.TIME)
    private Date lessonStartTime;

    @NotNull
    @Column(name = "LESSON_STOP_TIME")
    @Temporal(TemporalType.TIME)
    private Date lessonStopTime;

    public DrivingLesson() {
    }

    public DrivingLesson(Student student, Teacher teacher, Date lessonDay, Date lessonStartTime, Date lessonStopTime) {
        this.student = student;
        this.teacher = teacher;
        this.lessonDay = lessonDay;
        this.lessonStartTime = lessonStartTime;
        this.lessonStopTime = lessonStopTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
