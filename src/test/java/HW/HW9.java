package HW;

import baseurls.HWBaseurl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class HW9 extends HWBaseurl {
    /*
Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
*/
    @Test
    public void createUserTest() {
        spec.pathParam("first", "user");
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", 225);
        payload.put("username", "Abrarxx");
        payload.put("firstName", "Abbey");
        payload.put("lastName", "Althiabi");
        payload.put("email", "Abbey@gmail.com");

        // Send POST request to create a user
        Response response = given(spec)
                .header("Content-Type", "application/json")
                .body(payload)
                .post("{first}");

        response.prettyPrint();

        assertEquals(response.getStatusCode(), 201);

    }


}
