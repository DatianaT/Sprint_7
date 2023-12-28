import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.courier.CourierClient;
import org.example.models.Courier;
import org.junit.Before;
import org.junit.Test;
import static org.apache.http.HttpStatus.*;
import static org.apache.http.HttpStatus.SC_OK;
import static org.example.courier.CourierGenerator.*;
import static org.example.models.CourierCreds.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.example.constant.ConstCourier.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;

public class LoginTest {
        private int id;

        @Before
        public void setUp(){
            RestAssured.baseURI = BASE_URL;
        }
        @Test
        @DisplayName("Авторизация курьера")
        @Description("Успешная авторизация")
        public void loginInSystem(){
        Courier courier = randomCourier();
        CourierClient courierClient = new CourierClient();
        Response response = courierClient.create(courier);

        assertEquals("Неверный статус код", SC_CREATED, response.statusCode());

        Response loginResponse = courierClient.login(fromCourier(courier));
        id = loginResponse.path(ID);

        loginResponse.then().assertThat().statusCode(SC_OK)
                    .and().body(ID, notNullValue());
    }

    @Test
    @DisplayName("Авторизация курьера с неправильно указанными логином")
    @Description("Система вернёт ошибку, если неправильно указать логин")
    public void authorizationWithWringLogin(){
        Courier courier = randomCourier();
        CourierClient courierClient = new CourierClient();
        Response response = courierClient.login(fromCourierWithWrongLogin(courier));
        response.then().assertThat().statusCode(SC_NOT_FOUND)
                .and().body(MESSAGE, equalTo(MESSAGE_NOT_FOUND));
    }
    @Test
    @DisplayName("Авторизация курьера с неправильно указанными паролем")
    @Description("Система вернёт ошибку, если неправильно указать пароль")
    public void authorizationWithWringPassword(){
        Courier courier = randomCourier();
        CourierClient courierClient = new CourierClient();
        Response response = courierClient.login(fromCourierWithWrongPassword(courier));
        response.then().assertThat().statusCode(SC_NOT_FOUND)
                .and().body(MESSAGE, equalTo(MESSAGE_NOT_FOUND));
    }
    @Test
    @DisplayName("Авторизация курьера в системе без логина")
    @Description("Запрос без логина")
    public void authorizationWithEmptyLogin(){
        Courier courier = randomCourier();
        CourierClient courierClient = new CourierClient();
        Response response = courierClient.login(fromCourierWithEmptyLogin(courier));
        response.then().assertThat().statusCode(SC_BAD_REQUEST)
                .and().body(MESSAGE, equalTo(MASSAGE_NOT_ENOUGH_DATA_FOR_AUTHORIZ));
    }

    @Test
    @DisplayName("Авторизация курьера с несуществующими логином и паролем")
    @Description("Если авторизоваться под несуществующим пользователем, запрос возвращает ошибку")
    public void authorizationWithWringPasswordAndLogin(){
        Courier courier = randomCourier();
        CourierClient courierClient = new CourierClient();
        Response response = courierClient.login(fromCourierWithWrongPasswordAndLogin(courier));
        response.then().assertThat().statusCode(SC_NOT_FOUND)
                .and().body(MESSAGE, equalTo(MESSAGE_NOT_FOUND));
    }

        @Test
        @DisplayName("Авторизация под несуществующим пользователем")
        @Description("Авторизация под несуществующим пользователем")
        public void loginWithNonexistentCourier(){
            Courier courier = randomCourier();
            CourierClient courierClient = new CourierClient();

            Response loginResponse = courierClient.login(fromCourier(courier));

            loginResponse.then().assertThat().statusCode(SC_NOT_FOUND)
                    .and().body(MESSAGE, equalTo(MESSAGE_NOT_FOUND));
        }
}
