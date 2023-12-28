package org.example.orderModels;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.order.Order;
import static io.restassured.RestAssured.given;
import static org.example.constant.ConstOrder.CREATE_ORDER;

public class OrderCreate {
    @Step("Создание заказа {order}")
    public Response create(Order order) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(order)
                .when()
                .post(CREATE_ORDER);
    }
}
