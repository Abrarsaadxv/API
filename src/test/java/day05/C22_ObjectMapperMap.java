package day05;

import TestData.JsonPlaceholderTestData;
import TestData.RestulTestData;
import baseurls.JsonBaseurl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C22_ObjectMapperMap extends JsonBaseurl {

    /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
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

Note: Use map and POJO seperately
*/

    @Test
    public void test() throws JsonProcessingException {

        // set url
        spec.pathParam("first", "todos");

        // set Expexted Data
//    JsonPlaceholderTestData.jsonPlaceHolderMapper(55,"Tidy your room",false);

        String expectedStr = """
                {"userId": 55,
                "title": "Tidy your room",
                "completed": false,
                 "id": 201
                  }
                """;


        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> payload = objectMapper.readValue(expectedStr, Map.class);

        //send request and get response

         Response response = given(spec).body(payload).when().post("{first}");
         response.prettyPrint();

         //do assertion
       Map<String, Object> actualData =  objectMapper.readValue(response.asString(),Map.class);


       assertEquals(201,response.statusCode());
       assertEquals(payload.get("userId"),actualData.get("userId"));
       assertEquals(payload.get("title"),actualData.get("title"));
       assertEquals(payload.get("completed"),actualData.get("completed"));


    }


}
