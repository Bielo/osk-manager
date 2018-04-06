package pl.sdacademy.domain.entity;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "DRIVING_LESSON")
@Audited

public class DrivingLesson implements Serializable{

    private static final long serialVersionUID = 2836665682991196971L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LESSON_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    @NotNull
    @Column(name = "LESSON_START_DAY")
    @Temporal(TemporalType.DATE)
    @Future
    private Date lessonDay;

    @NotNull
    @Column(name = "LESSON_START_TIME")
    @Temporal(TemporalType.TIME)
    private Date lessonStartTime;

    @NotNull
    @Column(name = "LESSON_STOP_TIME")
    @Temporal(TemporalType.TIME)
    private Date lessonStopTime;

    @Column(name = "IS_CONFIRMED")
    private boolean isConfirmed;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "drivingLesson")
    private DrivingLessonUnconfirmed drivingLessonUnconfirmed;

    public DrivingLesson() {
    }

    public DrivingLesson(Student student, Teacher teacher, Date lessonDay, Date lessonStartTime, Date lessonStopTime, boolean isConfirmed) {
        this.student = student;
        this.teacher = teacher;
        this.lessonDay = lessonDay;
        this.lessonStartTime = lessonStartTime;
        this.lessonStopTime = lessonStopTime;
        this.isConfirmed = false;
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

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public DrivingLessonUnconfirmed getDrivingLessonUnconfirmed() {
        return drivingLessonUnconfirmed;
    }

    public void setDrivingLessonUnconfirmed(DrivingLessonUnconfirmed drivingLessonUnconfirmed) {
        this.drivingLessonUnconfirmed = drivingLessonUnconfirmed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrivingLesson that = (DrivingLesson) o;
        return Objects.equals(teacher, that.teacher) &&
                Objects.equals(lessonDay.getDay(), that.lessonDay.getDay()) &&
                Objects.equals(lessonStartTime.getHours(), that.lessonStartTime.getHours()) &&
                Objects.equals(lessonStopTime.getHours(), that.lessonStopTime.getHours());
    }

    @Override
    public int hashCode() {

        return Objects.hash(teacher, lessonDay, lessonStartTime, lessonStopTime);
    }
}
