package pl.sdacademy.domain.entity;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(name = "STUDENT")
@Audited
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
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

    @NotEmpty
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @NotNull
    @Past
    @Column(name = "BIRTHDATE")
    private LocalDate birthdate;


    public Student() {

    }

    public Student(String firstName, String lastName, String email, String phoneNumber, LocalDate birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
