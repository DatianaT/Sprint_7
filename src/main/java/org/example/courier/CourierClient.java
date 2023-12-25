package org.example.courier;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.models.*;

import static io.restassured.RestAssured.given;
import static org.example.constant.ConstCourier.COURIER_LOGIN_URL;
import static org.example.constant.ConstCourier.COURIER_URL;

public class CourierClient {
    @Step("Создание курьера {courier}")
    public Response create(Courier courier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(COURIER_URL);
    }

    @Step("Авторизация курьера с кредами {courierCreds}")
    public Response login(CourierCreds courierCred) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courierCred)
                .when()
                .post(COURIER_LOGIN_URL);
    }

    @Step("Регистрация курьера без логина {createCourierWithoutLogin}")
    public Response createWithoutLogin(CreateCourierWithoutLogin createCourierWithoutLogin) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(createCourierWithoutLogin)
                .when()
                .post(COURIER_URL);
    }

    @Step("Регистрация курьера без пароля {createCourierWithoutPassword}")
    public Response createWithoutPassword(CreateCourierWithoutPassword createCourierWithoutPassword) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(createCourierWithoutPassword)
                .when()
                .post(COURIER_URL);
    }

    @Step("Регистрация курьера с пустым логином {createCourierWithEmptyLogin}")
    public Response createWithEmptyLogin(CreateCourierWithEmptyLogin createCourierWithEmptyLogin) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(createCourierWithEmptyLogin)
                .when()
                .post(COURIER_URL);
    }
}