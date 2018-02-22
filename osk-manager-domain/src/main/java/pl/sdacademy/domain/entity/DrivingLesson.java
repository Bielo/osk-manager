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
        @AssociationOverride(name = "pk.student", joinColumns = @JoinColumn(name = "STUDENT_ID")),
        @AssociationOverride(name = "pk.teacher", joinColumns = @JoinColumn(name = "TEACHER_ID"))
})
@Audited

public class DrivingLesson {

    @EmbeddedId
    private StudentTeacherId pk = new StudentTeacherId();

    @NotNull
    @Column(name = "LESSON_START")
    private Date lessonStart;

    @NotNull
    @Column(name = "LESSON_STOP")
    private Date lessonStop;

    public DrivingLesson() {
    }

    public DrivingLesson(StudentTeacherId pk, Date lessonStart, Date lessonStop) {
        this.pk = pk;
        this.lessonStart = lessonStart;
        this.lessonStop = lessonStop;
    }

    public StudentTeacherId getPk() {
        return pk;
    }

    public void setPk(StudentTeacherId pk) {
        this.pk = pk;
    }


    public Date getLessonStart() {
        return lessonStart;
    }

    public void setLessonStart(Date lessonStart) {
        this.lessonStart = lessonStart;
    }


    public Date getLessonStop() {
        return lessonStop;
    }

    public void setLessonStop(Date lessonStop) {
        this.lessonStop = lessonStop;
    }
}
