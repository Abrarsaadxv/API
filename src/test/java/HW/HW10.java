package HW;

import baseurls.HWBaseurl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class HW10  extends HWBaseurl {
   // Using the https://petstore.swagger.io/ document,
    // write an automation test that finds the number of "pets" with the status "available"
    // and asserts that there are more than 100.

@Test
    public void test(){
    String  url="https://petstore.swagger.io/v2";
    Response response = given()
            .baseUri(url)
            .get("/pet/findByStatus?status=available");
    response.prettyPrint();

    JsonPath jsonPath = response.jsonPath();
    int NumOfAvailablePets = jsonPath.getList("findAll { it.status == 'available' }").size();

    // Assert that there are more than 100 available pets
    assertTrue(NumOfAvailablePets > 100);


}






}
