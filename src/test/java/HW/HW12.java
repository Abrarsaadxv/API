package HW;


import baseurls.JsonBaseurl;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojos.BookingPojo;
import pojos.HWPetPojos;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class HW12  extends JsonBaseurl {
    //Write an automation test that will
    // create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document
//(All actions must be done on same pet)
    //      (Use Pojo)

    @Test
    public void test() {
        spec.pathParam("first", "todos");
//CREATE A PET
        HWPetPojos pet = new HWPetPojos(221, "Monky", "available");
        Response response = given(spec)
                .body(pet)
                .when()
                .post("{first}");
        response.prettyPrint();
        HWPetPojos actualData = response.as(HWPetPojos.class);

        // read
        Response readResponse = given(spec)
                .pathParam("petId", pet.getPetId())
                .when()
                .get("{first}/{petId}");
        readResponse.prettyPrint();

        //// UPDATE THE PET
         pet.setStatus("available"); // Update the pet status
            Response updateResponse = given(spec)
                    .pathParam("petId", pet.getPetId())
                    .body(pet)
                    .when()
                    .put("{first}/{petId}");
            updateResponse.prettyPrint();


        //    // DELETE THE PET
            Response deleteResponse = given(spec)
                    .pathParam("petId", pet.getPetId())
                    .when()
                    .delete("{first}/{petId}");
            assertEquals(200, deleteResponse.statusCode()); // Assert delete successful
        //
        //    // VERIFY PET DELETION
            Response verifyDeletedResponse = given(spec)
                    .pathParam("petId", pet.getPetId())
                    .when()
                    .get("{first}/{petId}");
            assertEquals(404, verifyDeletedResponse.statusCode()); // Assert pet not found after deletion



        // DO Assertion
        assertEquals(201,response.statusCode());
        assertEquals(pet.getPetId(), actualData.getPetId());
        assertEquals(pet.getName(), actualData.getName());
        assertEquals(pet.getStatus(), actualData.getStatus());
    }



}