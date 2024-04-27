package day03;

import TestData.JsonPlaceholderTestData;
import baseurls.JsonBaseurl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static TestData.JsonPlaceholderTestData.jsonPlaceHolderMapper;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C13_PutRequast extends JsonBaseurl {


    /*
    Given
        1) https://jsonplaceholder.typicode.com/todos/198
        2) {
             "userId": 21,
             "title": "Read Books",
             "completed": false
           }
    When
        I send a PUT request to the URL
    Then
       the status code should be 200
       And the response body should be like:
       {
          "completed": false,
          "title": "Read Books",
          "userId": 21,
          "id": 198
       }
     */
    @Test
    public void putRequstTest() {
        spec.pathParams("first", "todos",
                "second", 198);

        Map<String, Object> payload = jsonPlaceHolderMapper(21, "Read Books", false);
        Response response =  given(spec)
                        .body(payload)
                        .when()
                        .put("{first}/{second}");
        response.prettyPrint();
        payload.put("id", 198);

         Map<String, Object> actualData=response.as(Map.class);
         assertEquals(200,response.statusCode());
        assertEquals(payload.get("userId"), actualData.get("userId"));
        assertEquals(payload.get("title"), actualData.get("title"));
        assertEquals(payload.get("completed"), actualData.get("completed"));
        assertEquals(payload.get("id"), actualData.get("id"));


    }
}
