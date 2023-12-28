import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.courier.CourierClient;
import org.example.models.Courier;
import org.example.models.CreateCourierWithoutLogin;
import org.example.models.CreateCourierWithoutPassword;
import org.junit.Before;
import org.junit.Test;
import static org.apache.http.HttpStatus.*;
import static org.example.constant.ConstCourier.*;
import static org.example.courier.CourierGenerator.*;
import static org.example.models.CourierCreds.fromCourier;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;


public class CourierTest {
    private int id;

    @Before
    public void setUp(){
        RestAssured.baseURI = BASE_URL;
   }


    @Test
    @DisplayName("Создание курьера")
    @Description("Создание курьера со случайными данными")
    public void createCourier(){
        Courier courier = randomCourier();
        CourierClient courierClient = new CourierClient();

        Response response = courierClient.create(courier);

        assertEquals("Неверный статус код", SC_CREATED, response.statusCode());

        Response loginResponse = courierClient.login(fromCourier(courier));
        id = loginResponse.path(ID);

        assertEquals("Неверный статус код", SC_OK, loginResponse.statusCode());
    }

    @Test
    @DisplayName("Создание одинаковых курьеров")
    @Description("Создание курьера с идентичным логином и паролем")
    public void creatingTheSameCourier(){
        Courier courier = randomCourier();
        CourierClient courierClient = new CourierClient();

        Response response = courierClient.create(courier);
        response.then().assertThat().statusCode(SC_CREATED)
                .and().body(OK, equalTo(true));

        Response loginResponse = courierClient.login(fromCourier(courier));
        id = loginResponse.path("id");
        loginResponse.then().assertThat().statusCode(SC_OK)
                .and().body(ID, notNullValue());

        CourierClient secondCourier = new CourierClient();
        Response secondResponse = secondCourier.create(courier);
        secondResponse.then().assertThat().statusCode(SC_CONFLICT)
                .and().body(MESSAGE, equalTo(MESSAGE_ABOUT_SAME_COURIER));
    }

    @Test
    @DisplayName("Создание курьера без логина")
    @Description("Создание курьера без логина")
    public void courierWithoutLogin(){
        CreateCourierWithoutLogin createCourierWithoutLogin = randomCourierWitoutLigin();
        CourierClient courierClient = new CourierClient();
        Response response = courierClient.createWithoutLogin(createCourierWithoutLogin);
        response.then().assertThat().statusCode(SC_BAD_REQUEST)
                .and().body(MESSAGE, equalTo(MASSAGE_BAD_REQUEST));
    }
    @Test
    @DisplayName("Создание курьера без пароля")
    @Description("Создание курьера без пароля")
    public void courierWithoutPassword(){
        CreateCourierWithoutPassword createCourierWithoutPassword = randomCourierWithoutPassword();
        CourierClient courierClient = new CourierClient();
        Response response = courierClient.createWithoutPassword(createCourierWithoutPassword);
        response.then().assertThat().statusCode(SC_BAD_REQUEST)
                .and().body(MESSAGE, equalTo(MASSAGE_BAD_REQUEST));
    }
}