package org.example.models;

public class CreateCourierWithoutLogin {
    private String password;
    private String firstName;

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }
    public CreateCourierWithoutLogin withPassword(String password)
    {
        this.password = password;
        return this;
    }
    public CreateCourierWithoutLogin withFirstName(String firstName)
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
