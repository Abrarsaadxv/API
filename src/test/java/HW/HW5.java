package HW;

import baseurls.HWBaseurl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HW5  extends HWBaseurl {
    /*
       Given
           https://reqres.in/api/users/2
       When


           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be "application/json"
       And
           "email" is "janet.weaver@reqres.in",
       And
           "first_name" is "Janet"
       And
           "last_name" is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */


    @Test
    public void test(){

        spec.pathParams("first","users","second",2);
        Response response = given(spec).when().get("{first}/{second}");
        //           HTTP Status Code should be 200

        response.prettyPrint();

//           "email" is "janet.weaver@reqres.in",
        response
                .then()
                .statusCode(200)
        .contentType("application/json")
                .body("data.email",equalTo("janet.weaver@reqres.in"))
                .body("data.first_name",equalTo("Janet"))
                .body("data.last_name",equalTo("Weaver"))
                .body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }
}
