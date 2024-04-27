package HW;

import baseurls.HWBaseurl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotNull;
  /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

public class HW8 extends HWBaseurl {

    @Test
    public void createUserTest() {

        spec.pathParam("first","users");
        Map<String, Object> payload = new HashMap<>();
        payload.put("name","morpheus");
        payload.put( "job","leader");
        System.out.println("payload = " + payload);

      Response response=  given(spec)
              .body(payload)
              .header("Content-Type", "application/json")
              .post("{first}");

       JsonPath json =response.jsonPath();
       assertEquals(201,response.statusCode());
//       assertEquals(payload.get("name"),json.getString("name"));


        Map<String,Object> actualData = response.as(Map.class);
        assertEquals(201,response.statusCode());
        assertEquals(payload.get("name"),actualData.get("name"));
        assertEquals(payload.get("job"),actualData.get("job"));




    }

}























