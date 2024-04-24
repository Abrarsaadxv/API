package Day01;

import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class C01_RequstAndResponse {

    public static void main(String[] args) {

            /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET Request to the url
    Then
        Print Status Code (should be 200)
    And
        Print Content Type (should be JSON)
    And
        Print Status Line (should be HTTP/1.1 200 OK)
    And
        Print Connection and Date headers on console
    And
        Print all headers on console

*/

        String url = " https://restful-booker.herokuapp.com/booking";

        Response response = given().get(url); // all data I need is in response
//        System.out.println(response); this print the reference of the response
        response.prettyPrint();
        // how to print status code
        int statsusCode = response.statusCode();
        System.out.println(" statuse code is : " + statsusCode);


        //How to print statusLine
        String statusline = response.statusLine();
        System.out.println("statuse Line  is : " + statusline);

        // how to print contentType
        String contentType = response.contentType();
        System.out.println("contentType = " + contentType);

        // how to get connection value from headers
        String conn = response.header("Connection");
        System.out.println("conn = " + conn);

        String data = response.header("Date");
        System.out.println("date is  = " + data);
        Headers headers = response.headers();
        System.out.println("headers = " + headers);

        // How to get response Time
        long time = response.time();
        System.out.println("time = " + time);


    }

}
