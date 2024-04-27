package day03;

import baseurls.JsonBaseurl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C15_PostRequestPojo extends JsonBaseurl {
    /*
     Given
        https://jsonplaceholder.typicode.com/todos
        {
        "userId": 55,
        "title": "Tidy your room",
        "completed": false
        }
    When
        I send POST Request to the Url
    Then
        Status code is 201
    And
        response body is like {
                                "userId": 55,
                                "title": "Tidy your room",
                                "completed": false,
                                "id": 201
                                }
*/
    @Test
    public void PostRequastPojoTest() {


        spec.pathParams("first", "todos");


        // SET EQPECTED DATA
        JsonPlaceHolderPojo payload = new JsonPlaceHolderPojo(55, "Tidy your room", false);
        System.out.println(payload);

        //sent a requast and get response
        Response response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();

        // do assertions
        assertEquals(201,response.statusCode());
        JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class);
        assertEquals(payload.getUserId(), actualData.getUserId());
        assertEquals(payload.getTitle(), actualData.getTitle());
        assertEquals(payload.getCompleted(), actualData.getCompleted());
    }
}
