package day03;

import baseurls.HWBaseurl;
import baseurls.JsonBaseurl;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C15_PostRequestPojo extends JsonBaseurl {


    @Test
    public void PostRequestPojoTest(){
        // Set Url
        spec.pathParam("first","todos");

        // Set Expected Data

        JsonPlaceHolderPojo payLoad = new JsonPlaceHolderPojo(55,"Tidy your room",false);
        System.out.println(payLoad);

        // Sent request and get response
        Response response = given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();

        // Do Assertions
        JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class);

        assertEquals(201,response.statusCode());
        assertEquals(payLoad.getUserId(),actualData.getUserId());
        assertEquals(payLoad.getTitle(),actualData.getTitle());
        assertEquals(payLoad.getCompleted(),actualData.getCompleted());

    }










}



