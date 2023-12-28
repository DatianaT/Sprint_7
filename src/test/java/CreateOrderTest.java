import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.order.Order;
import org.example.order.OrderGenerator;
import org.example.orderModels.OrderCreate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.example.constant.ConstCourier.BASE_URL;
import static org.example.constant.ConstOrder.*;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class CreateOrderTest {
    private final String firstName;
    private final String lastName;
    private final String adress;
    private final int metroStation;
    private final String phone;
    private final int rentTime;
    private final String deliveryDate;
    private final String comment;
    public String[] color;
    private int track;

    public CreateOrderTest(String firstName, String lastName, String adress, int metroStation, String phone,
                           int rentTime, String deliveryDate, String comment, String[] color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }
    @Parameterized.Parameters()
    public static Object[][] getParameters(){
        return new Object[][]{
                {"Naruto", "Uchiha", "Konoha, 142 apt.", 4, "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", new String[]{BLACK}},
                {"Оля", "Ли", "ул. Мира", 2, "88002000600", 7, "2020-06-29", "hello", new String[]{GREY}},
                {"Ержан", "Ку", "ул. Свободы", 5, "88002353535", 6, "2020-07-27", "Вставай", new String[]{BLACK, GREY}},
                {"Датьяна", "Тутник", "Бали", 1, "2660066", 9, "2020-04-25", "Спасибо", null}
        };

    }
    @Before
    public void setUp(){
        RestAssured.baseURI = BASE_URL;
    }
    @Test
    @DisplayName("Создание заказа")
    @Description("Создание заказа")
    public void createOrder(){
        OrderGenerator orderGenerator = new OrderGenerator();
        Order order = orderGenerator.paramOrder(firstName, lastName, adress, metroStation, phone, rentTime,
                deliveryDate, comment, color);
        OrderCreate orderCreate = new OrderCreate();
        Response response = orderCreate.create(order);
        response.then().assertThat().statusCode(SC_CREATED).and().body(TRACK, notNullValue());
    }

}
