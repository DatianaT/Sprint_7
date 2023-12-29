package org.example.models;

public class CreateCourierWithoutFirstname {
        private String login;
        private String password;

        public String getLogin()
        {
            return login;
        }

        public String getPassword()
        {
            return password;
        }

        public CreateCourierWithoutFirstname withLogin(String login)
        {
            this.login = login;
            return this;
        }

        public CreateCourierWithoutFirstname withPassword(String password)
        {
            this.password = password;
            return this;
        }

    @Override
    public String toString() {
        return "CreateCourierWithoutFerstname{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

