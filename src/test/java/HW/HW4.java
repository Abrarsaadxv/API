package HW;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.emptyString;

public class HW4 {
       /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

@Test
public void  testhw4(){

        String url ="https://reqres.in/api/users/23";
        Response response =  get(url);

        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server", equalTo("cloudflare"))
                .body(equalTo("{}"));
//                .body(is(emptyString()));




    }
}
