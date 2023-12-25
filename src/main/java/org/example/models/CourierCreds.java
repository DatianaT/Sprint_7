package org.example.models;

public class CourierCreds {

    private final String login;
    private final String password;

    public CourierCreds(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static CourierCreds fromCourier(Courier courier) {
        return new CourierCreds(courier.getLogin(), courier.getPassword());
    }
    public static CourierCreds fromCourierWithWrongLogin(Courier courier) {
        return new CourierCreds("1111111", courier.getPassword());
    }
    public static CourierCreds fromCourierWithWrongPassword(Courier courier) {
        return new CourierCreds(courier.getLogin(), "1111111111");
    }
    public static CourierCreds fromCourierWithWrongPasswordAndLogin(Courier courier) {
        return new CourierCreds("1111111", "1111111111");
    }
    public static CourierCreds fromCourierWithEmptyLogin(Courier courier) {
        return new CourierCreds("", courier.getPassword());
    }

    @Override
    public String toString() {
        return "CourierCreds{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}