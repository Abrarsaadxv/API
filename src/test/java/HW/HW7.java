package HW;

import baseurls.HWBaseurl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

public class HW7 extends HWBaseurl {

    /*
     Given
            https://reqres.in/api/unknown/
     When
          I send GET Request to the URL
     Then
          1)Status code is 200
          2)Print all pantone_values
          3)Print all ids greater than 3 on the console
            Assert that there are 3 ids greater than 3
          4)Print all names whose ids are less than 3 on the console
            Assert that the number of names whose ids are less than 3 is 2
  */
    @Test
    public void test1() {
        spec.pathParams("first", "unknown");
        Response response = given(spec).when().get("{first}");
        //           HTTP Status Code should be 200

        response.prettyPrint();

        given().then().statusCode(200);
        JsonPath json = response.jsonPath();
//            3)Print all ids greater than 3 on the console
        List<Integer> Idgraterthen3 = json.getList("data.findAll{it.id>3}.id");
        System.out.println("Idgraterthen3 = " + Idgraterthen3);

        assertTrue(Idgraterthen3.size() == 3);

        //            4)Print all names whose ids are less than 3 on the console
        //              Assert that the number of names whose ids are less than 3 is 2
        List<Integer> Idlessthen3 = json.getList("data.findAll{it.id<3}.name");
        System.out.println("Idlessthen3 = " + Idlessthen3);
        assertTrue(Idlessthen3.size() == 2);


    }

}

