package day04;

import baseurls.RestFullBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C20_PostRequest extends RestFullBaseUrl {

    //   Given
    //       1) https://restful-booker.herokuapp.com/booking
    //       2) {
    //               "firstname": "Jane",
    //               "lastname": "Doe",
    //               "totalprice": 111,
    //               "depositpaid": true,
    //               "bookingdates": {
    //                   "checkin": "2018-01-01",
    //                   "checkout": "2019-01-01"
    //               },
    //               "additionalneeds": "Extra pillows please"
    //           }
    //   When
    //       I send POST Request to the Url
    //   Then
    //       Status code is 200
    //       And response body should be like {
    //                            "bookingid": 2243,
    //                            "booking":{
    //                                       "firstname": "Jane",
    //                                       "lastname": "Doe",
    //                                       "totalprice": 111,
    //                                       "depositpaid": true,
    //                                       "bookingdates": {
    //                                              "checkin": "2018-01-01",
    //                                              "checkout": "2019-01-01"
    //                                                       },
    //                                                       "additionalneeds": "Extra pillows please"
    //                                                   }
    //
    //
    //                                            }


    @Test
    public void test(){

        // Set Url
        spec.pathParam("first","booking");

        // Set Expected data
        BookingDatesPojo bookingDates = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo payload = new BookingPojo( "Jane","Doe",111,true,bookingDates,"Extra pillows please");

        // Send request and get respnse
        Response response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();

        // Do Assertions
        BookingResponsePojo actualData = response.as(BookingResponsePojo.class);




    }



}
