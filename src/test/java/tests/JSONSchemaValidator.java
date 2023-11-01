package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.testng.annotations.Test;


public class JSONSchemaValidator {
    
    @Test
    public void testGetIds(){
        baseURI = "https://jsonplaceholder.typicode.com";
        given()
                .get("/posts")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema.json"))
                .statusCode(200);
    }
}
