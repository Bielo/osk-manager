package pl.sdacademy.domain.entity;

public class Teacher {

    private Long id;
    private Long version;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Teacher(){
    }

    public Teacher(String firstName, String lastName, String mobileNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = mobileNumber;
        this.email = email;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
