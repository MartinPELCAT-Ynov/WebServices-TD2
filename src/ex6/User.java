package ex6;

import java.util.Date;

public class User {
    private String name;
    private String firstName;
    private String email;
    private Date birthDate;


    private boolean isAtRisk = false;

    public User(String name, String firstName, String email, Date birthDate) {
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public boolean isAtRisk() {
        return isAtRisk;
    }

    public void setAtRisk(boolean atRisk) {
        isAtRisk = atRisk;
    }
}
