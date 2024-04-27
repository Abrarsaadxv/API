package day03;

import TestData.JsonPlaceholderTestData;
import baseurls.JsonBaseurl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C12_PostRequastTestData extends JsonBaseurl {

    /*
     Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
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
    public void postRequestTest() {

        //Set the Url

        //Set the expected data(Payload) --> Prepare it as Map
        spec.pathParam("first", "todos");

        Map<String, Object> payload = JsonPlaceholderTestData
                .jsonPlaceHolderMapper(55, "Tidy your room", false);

        //Send the request and get the response
        Response response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();

        //Do assertion

        JsonPath json = response.jsonPath();
        assertEquals(201, response.statusCode());
        assertEquals(payload.get("userId"), json.getInt("userId"));


        // changing response to string object Deserialization
        Map<String, Object> actualData = response.as(Map.class);
        assertEquals(201, response.statusCode());
        assertEquals(payload.get("userId"), actualData.get("userId"));
        assertEquals(payload.get("title"), actualData.get("title"));
        assertEquals(payload.get("completed"), actualData.get("completed"));


    }

}
