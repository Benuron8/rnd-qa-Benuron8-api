package tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import model.Vet;
import utils.Utils;

public class VetsApiTest {
	@BeforeClass
	public void setup() {
		Utils.setupBaseURI("http://localhost:8080");
	}

	@Test
	public void testListVeterinarians() {
		
		List<Vet> vets =
		RestAssured
		.given()
			.contentType(ContentType.JSON)
		.when()
			.get("/vets")
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.extract().jsonPath().getList("", Vet.class);

        assertEquals(vets.size(), 6, "Number of vets in the list should be 6");		
	}

}
