//package pl.sdacademy.domain.entity;
//
//
//import javax.persistence.Embeddable;
//import javax.persistence.ManyToOne;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class StudentTeacherId implements Serializable {
//
//    @ManyToOne
//    private Student student;
//
//    @ManyToOne
//    private Teacher teacher;
//
//    public StudentTeacherId(Student student, Teacher teacher) {
//        this.student = student;
//        this.teacher = teacher;
//    }
//
//    public StudentTeacherId() {
//    }
//
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//
//
//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//
//
//}
