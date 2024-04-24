package HW;

import baseurls.HWBaseurl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HW6 extends HWBaseurl {

         /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json; charset=utf-8"
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */

    @Test
    public void test1(){
        spec.pathParams("first","unknown","second",3);
        Response response = given(spec).when().get("{first}/{second}");
        //           HTTP Status Code should be 200

        response.prettyPrint();


        given()

                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id", equalTo(3))
                .body("data.name", equalTo("true red"))
                .body("data.year", equalTo(2002))
                .body("data.color", equalTo("#BF1932"))
                .body("data.pantone_value", equalTo("19-1664"))
                .body("support.url", equalTo("https://reqres.in/#support-heading"))
                .body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

    SoftAssert softAssert = new SoftAssert();


        softAssert.assertEquals(3, 3);
        softAssert.assertEquals("true red", "true red");
        softAssert.assertEquals(2002, 2002);
        softAssert.assertEquals("#BF1932", "#BF1932");
        softAssert.assertEquals("19-1664", "19-1664");
        softAssert.assertEquals("https://reqres.in/#support-heading", "https://reqres.in/#support-heading");
        softAssert.assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!", "To keep ReqRes free, contributions towards server costs are appreciated!");
        softAssert.assertAll();
}
}