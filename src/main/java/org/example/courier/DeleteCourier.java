package org.example.courier;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static org.example.constant.ConstCourier.COURIER_URL;
import static io.restassured.RestAssured.given;

public class DeleteCourier {
        @Step("Удаление курьера")
        public Response deleteCourier(Integer id)
        {
            return given()
                    .delete(COURIER_URL + String.format("/%d", id));
        }
}
