package HW;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojos.createUserHW;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class HW15UpdateUser {

    private RequestSpecification spec;
    private createUserHW user;


    @Test
    public void testUserLifecycle() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        spec = given();
        // Initialize user object
        user = new createUserHW(441, "Aramxxoz", "Aram", "Saad", "aram@gmail.com", "aa@112232", "0556075532");

        // Read User
        Response readUserResponse = given(spec)
                .pathParam("username", user.getUsername())
                .when()
                .get("/user/{username}");
readUserResponse.prettyPrint();
        //  do Asserting
        assertEquals(200, readUserResponse.getStatusCode());
//        assertEquals(user.getId(), );


        // uodate
        user.setEmail("Abbey@gmail.com");
        Response updateUserResponse = given(spec)
                .contentType("application/json")
                .pathParam("username", user.getUsername())
                .body(user)
                .when()
                .put("/user/{username}");


    }
}
