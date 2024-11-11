package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Utils {

    public static void setupBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }
}
