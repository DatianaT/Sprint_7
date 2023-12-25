package org.example.models;

public class CreateCourierWithoutPassword {
    private String login;
    private  String firstName;
    public String getLogin() {
        return login;
    }
    public String getFirstName() {
        return firstName;
    }
    public CreateCourierWithoutPassword withLogin(String login)
    {
        this.login = login;
        return this;
    }
    public CreateCourierWithoutPassword withFirstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }

    @Override
    public String toString() {
        return "CreateCourierWithoutPassword{" +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
