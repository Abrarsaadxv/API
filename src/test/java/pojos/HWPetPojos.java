package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
@JsonIgnoreProperties(ignoreUnknown = true)

public class HWPetPojos {
    private Integer petId;
    private String name;
    private String status;

    // create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document


    public HWPetPojos() {
    }

    public HWPetPojos(Integer petId, String name, String status) {
        this.petId = petId;
        this.name = name;
        this.status = status;
    }


    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HWPetPojos{" +
                "petId=" + petId +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }


}