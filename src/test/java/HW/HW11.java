package HW;

import baseurls.HWBaseurl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class HW11 extends HWBaseurl {
    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12
    Note: Print using JsonPath: response.jsonPath().prettyPrint();
*/

    @Test
    public void getrequastTest() {

        spec.pathParam("first", "productsList");
       Response response = given(spec)
                .header("Content-Type","application/json")
                .get("{first}");


        JsonPath jsonPath = response.jsonPath();
        jsonPath.prettyPrint();


        List<Object> womenList = jsonPath.getList("findAll {it.userType == 'Women'}");
        int numberofWomen = 0;

if (womenList!= null){
     numberofWomen = womenList.size();
}
        //    //assertion
      //  assertEquals(numberofWomen, 12);




    }

}
