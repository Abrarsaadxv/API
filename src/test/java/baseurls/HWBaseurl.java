package baseurls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class HWBaseurl {

    protected RequestSpecification spec;
    @BeforeMethod
    public void setUp(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api")
                .build();
    }
}

