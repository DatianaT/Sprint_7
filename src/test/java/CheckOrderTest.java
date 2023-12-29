import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.example.constant.ConstCourier.BASE_URL;
import static org.example.constant.ConstCourier.MESSAGE;
import static org.example.constant.ConstOrder.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class CheckOrderTest extends BeforeAndAfter{


        @Test
        @DisplayName("Проверка не существующего заказа с передачей пустого номера")
        @Description("Проверка не существующего заказа с передачей пустого номера")
        public void checkEmptyTackOrder()
        {
            Response result = given()
                    .header("Content-type", "application/json")
                    .and()
                    .get(ORDER_TRACK);
            result.then().assertThat().body(MESSAGE, equalTo(NOT_ENOUGH_DATA));
            assertEquals("Неверный статус код",SC_BAD_REQUEST, result.statusCode());
        }
}
