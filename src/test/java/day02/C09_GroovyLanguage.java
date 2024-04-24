package day02;

import baseurls.JosnBaseurl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class C09_GroovyLanguage extends JosnBaseurl {
        /*
    Given
        https://jsonplaceholder.typicode.com/todos
    When
         I send GET Request to the URL
    Then
         1)Status code is 200

         2)Print all ids greater than 190 on the console
           Assert that there are 10 ids greater than 190

         3)Print all 'completeds' whose ids are less than 5 on the console
           Assert that the number of userIds whose ids are less than 5 is 4

         4)Print all titles whose ids are greater than 195
           Assert that "quis eius est sint explicabo" is one of the titles whose id is less than 5

         5)Print id whose title is "quo adipisci enim quam ut ab"
           Assert that id is 8
*/


    @Test
    public void groovyTest() {

        //Set the Url
        spec.pathParam("first","todos");

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).when().get("{first}");
        //response.prettyPrint();
        //Do assertion

//        1)Status code is 200
        response.then().statusCode(200);
//        2)Print all ids greater than 190 on the console
//        Assert that there are 10 ids greater than 190

        JsonPath json = response.jsonPath();
        List<Integer> idList = json.getList("id");
        System.out.println("idList = " + idList);
        int idGreaterThan190 = 0;

        for (Integer w:idList){
            if (w>190){
                System.out.println(w);
                idGreaterThan190++;
            }
        }
        assertTrue(idGreaterThan190==10);

//        3)Print all 'completeds' whose ids are less than 5 on the console
//        Assert that the number of 'completeds' whose ids are less than 5 is 4

         List<Boolean> itemslessthen5 =  json.getList("findAll{it.id<5}.completeds");// it stand ffor items
        System.out.println("itemslessthen5 = " + itemslessthen5);
        assertTrue(itemslessthen5.size()==4);



//        4)Print all titles whose ids are greater than 195
//        Assert that "quis eius est sint explicabo" is one of the titles whose id is less than 5

        List<String> itemslgraterthen195 = json.getList("findAll{it.id>195}.title");
        System.out.println("itemslgraterthen195 = " + itemslgraterthen195);
assertTrue(itemslgraterthen195.contains("quis eius est sint explicabo"));


//        5)Print id whose title is "quo adipisci enim quam ut ab"
        Object id = json.getList("findAll{it.title=='quo adipisci enim quam ut ab'}.id").get(0);
        List<Integer> idList2 = json.getList("findAll{it.title=='quo adipisci enim quam ut ab'}.id");

        int id2 = idList2.get(0);
        System.out.println("id = " + id);
        assertEquals(8,id);



    }

}