package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Owner;
import utils.Utils;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OwnersApiTest {

	@BeforeClass
	public void setup() {
		Utils.setupBaseURI("http://localhost:8080");
	}

	@Test
    public void testAddOwner() {
        Owner newOwner = new Owner("Andre", "Oliveira", "Street 1", "Amsterdam", "1234567890");
       
        RestAssured
        .given()
        	.contentType(ContentType.JSON)
            .body(newOwner)
        .when()
            .post("/owners")
        .then()
            .statusCode(201);
    }
	
	@Test
	public void testGetOwner() {
	    Response owner = RestAssured
	        .given()
	        .contentType(ContentType.JSON)
	        .when()
	        .get("/owners/1")
	        .then()
	        .statusCode(200) 
	        .contentType(ContentType.JSON)
	        .extract()
	        .response();

	    assertNotNull(owner.jsonPath().get("id"), "Owner Id should not be null");
	    assertNotNull(owner.jsonPath().get("firstName"), "First Name should not be null");
	    assertNotNull(owner.jsonPath().get("lastName"), "Last Name should not be null");
	    
	    List<Map<String, Object>> pets = owner.jsonPath().getList("pets");
	    
	    assertTrue(pets.size() > 0, "Owner 1 should have at least one pet");
	}

	@Test
	public void testListOwners() {
		RestAssured
		.given()
			.contentType(ContentType.JSON)
		.when()
			.get("/owners/list")
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON);
	}
}
