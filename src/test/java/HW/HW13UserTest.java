package HW;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import pojos.createUserHW;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class HW13UserTest {

    private RequestSpecification spec;

    @Test
    public void testUserLifecycle() {
        // Base URL
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        spec = RestAssured.given();

        // User data
        createUserHW user = new createUserHW(441, "Aramxxoz", "Aram", "Saad", "aram@gmail.com", "aa@112232", "0556075532");

        // Create User
        Response createUserResponse = given(spec)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/user");
        assertEquals(200, createUserResponse.getStatusCode());

        // Read User - You need to implement this part

        // Update User - You need to implement this part

        // Delete User - You need to implement this part
    }
}
