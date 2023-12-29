import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.courier.DeleteCourier;
import org.junit.After;
import org.junit.Before;
import static org.apache.http.HttpStatus.SC_OK;
import static org.example.constant.ConstCourier.BASE_URL;
import static org.junit.Assert.assertEquals;

public class BeforeAndAfter {
    protected int id;
    @Before
    public void setUp()
    {
        RestAssured.baseURI = BASE_URL;
    }

    @After
    public void tearDown()
    {
        if(id != 0)
        {
            DeleteCourier courierClient = new DeleteCourier();
            Response responseDelete = courierClient.deleteCourier(id);
            assertEquals("Неверный статус код при удалении курьера", SC_OK, responseDelete.statusCode());
        }
    }
}
