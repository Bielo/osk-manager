package pl.sdacademy.domain.entity;


import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "DRIVING_LESSON_UNCONFIRMED")
@Audited
public class DrivingLessonUnconfirmed implements Serializable{


    private static final long serialVersionUID = -8403930256542164310L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UNCONFIRMED_LESSON_ID")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LESSON_ID", nullable = false)
    private DrivingLesson drivingLesson;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    public DrivingLessonUnconfirmed() {
    }

    public DrivingLessonUnconfirmed(DrivingLesson drivingLesson, Student students) {
        this.drivingLesson = drivingLesson;
        this.student = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DrivingLesson getDrivingLesson() {
        return drivingLesson;
    }

    public void setDrivingLesson(DrivingLesson drivingLesson) {
        this.drivingLesson = drivingLesson;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
