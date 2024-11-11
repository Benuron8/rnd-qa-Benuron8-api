package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import model.Pet;
import utils.Utils;

public class PetsApiTest {

	@BeforeClass
	public void setup() {
		Utils.setupBaseURI("http://localhost:8080");
	}
	
	@Test
    public void testAddPet() {
        Pet newPet = new Pet("1", "Brownie", "2024-11-08T23:00:00.000Z", "2");
       
        RestAssured
        .given()
        	.contentType(ContentType.JSON)
            .body(newPet)
        .when()
            .post("/owners/3/pets")
        .then()
            .statusCode(204);
    }
}
