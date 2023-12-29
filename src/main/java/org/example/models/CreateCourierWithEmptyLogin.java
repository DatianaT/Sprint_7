package org.example.models;

public class CreateCourierWithEmptyLogin {
    private String password;
    private String firstName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }
    public CreateCourierWithEmptyLogin withPassword(String password)
    {
        this.password = password;
        return this;
    }
    public CreateCourierWithEmptyLogin withFirstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }

    @Override
    public String toString() {
        return "CreateCourierWithoutLogin{" +
                "password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

}
