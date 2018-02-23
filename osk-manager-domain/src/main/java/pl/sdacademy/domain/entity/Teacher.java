package pl.sdacademy.domain.entity;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TEACHER")
@Audited
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEACHER_ID")
    private Long id;

    @Version
    @Column(name = "LATEST_VERSION")
    private Long version;

    @NotEmpty
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotEmpty
    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @NotNull
    @Email
    @Column(name = "EMAIL")
    private String email;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<DrivingLesson> drivingLessons = new ArrayList<DrivingLesson>();

    public Teacher(){
    }

    public Teacher(String firstName, String lastName, String mobileNumber, String email, List<DrivingLesson> drivingLesson) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = mobileNumber;
        this.email = email;
        this.drivingLessons = drivingLesson;
    }


    public List<DrivingLesson> getDrivingLessons() {
        return drivingLessons;
    }

    public void setDrivingLessons(List<DrivingLesson> drivingLessons) {
        this.drivingLessons = drivingLessons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
