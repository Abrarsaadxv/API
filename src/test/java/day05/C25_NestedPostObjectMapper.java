package day05;

import baseurls.RestFullBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C25_NestedPostObjectMapper extends RestFullBaseUrl {
    /*
Given
    1) https://restful-booker.herokuapp.com/booking
    2) {
            "firstname": "Jane",
            "lastname": "Doe",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
            },
            "additionalneeds": "Extra pillows please"
        }
When
    I send POST Request to the Url
Then
    Status code is 200
    And response body should be like
    {
        "bookingid": 2243,
        "booking":{
                    "firstname": "Jane",
                    "lastname": "Doe",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2018-01-01",
                        "checkout": "2019-01-01"
                    },
                    "additionalneeds": "Extra pillows please"
                }
         }
*/
    @Test
    public void test() throws JsonProcessingException {
        spec.pathParam("first","booking");

        String expectedStr = """
                {
                     "firstname": "Jane",
                     "lastname": "Doe",
                     "totalprice": 111,
                     "depositpaid": true,
                     "bookingdates": {
                         "checkin": "2018-01-01",
                         "checkout": "2019-01-01"
                     },
                     "additionalneeds": "Extra pillows please"
                 }""";

        ObjectMapper objectMapper = new ObjectMapper();
        BookingPojo payLoad = objectMapper.readValue(expectedStr, BookingPojo.class);

        Response response = given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();

        BookingResponsePojo actualData = objectMapper.readValue(response.asString(), BookingResponsePojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(payLoad.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(payLoad.getLastname(), actualData.getBooking().getLastname());
        assertEquals(payLoad.getDepositpaid(), actualData.getBooking().getDepositpaid());
        assertEquals(payLoad.getTotalprice(), actualData.getBooking().getTotalprice());
        assertEquals(payLoad.getBookingdates().getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(payLoad.getBookingdates().getCheckout(), actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(payLoad.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());
    }

}



