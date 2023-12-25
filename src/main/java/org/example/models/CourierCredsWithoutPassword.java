package org.example.models;

public class CourierCredsWithoutPassword {
        private final String login;

        public CourierCredsWithoutPassword(String login){
            this.login = login;
        }
        public static CourierCredsWithoutPassword forCourierCredsWithoutPassword(Courier courier){
            return new CourierCredsWithoutPassword(courier.getLogin());
        }

    @Override
    public String toString() {
        return "CourierCredsWithoutPassword{" +
                "login='" + login + '\'' +
                '}';
    }
}
