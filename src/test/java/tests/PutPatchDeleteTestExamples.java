package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PutPatchDeleteTestExamples {
    
    private JSONObject request;

    @BeforeMethod
    public void setUp() {
        request = new JSONObject();
        request.put("userId", 1000);
        request.put("id", "1000");
        request.put("title", "Hello test title");
        request.put("body", "Hello test body");
        
        System.out.println(request);
    }
    
    @Test
    public void testPut() {
        baseURI = "https://jsonplaceholder.typicode.com";

        given()
            .header("Content-Type", "application/json")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(request.toString())  // Convert JSONObject to a string
            .when()
            .put("/posts/1")
            .then()
            .statusCode(200);
    }
    
    @Test
    public void testPatch() {
        baseURI = "https://jsonplaceholder.typicode.com";
        
        given()
            .header("Content-Type", "application/json")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(request.toString())  // Convert JSONObject to a string
            .when()
            .patch("/posts/1")
            .then()
            .statusCode(200);
    }
    
    @Test
    public void testDelete() {
        baseURI = "https://jsonplaceholder.typicode.com";
        
        given()
            .when()
            .delete("/posts/1")
            .then()
            .statusCode(200);
    }
}
