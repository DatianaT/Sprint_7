package org.example.courier;
import org.example.models.Courier;
import org.example.models.CreateCourierWithEmptyLogin;
import org.example.models.CreateCourierWithoutLogin;
import org.example.models.CreateCourierWithoutPassword;
import static utils.Utils.randomString;

public class CourierGenerator {
    public static Courier randomCourier(){
        return new Courier()
                .withLogin(randomString(8))
                .withPassword(randomString(16))
                .withFirstName(randomString(10));
    }
    public static CreateCourierWithoutLogin randomCourierWitoutLigin(){
        return new CreateCourierWithoutLogin()
                .withPassword(randomString(16))
                .withFirstName(randomString(10));
    }
    public static CreateCourierWithoutPassword randomCourierWithoutPassword(){
        return new CreateCourierWithoutPassword()
                .withLogin(randomString(8))
                .withFirstName(randomString(10));
    }


}