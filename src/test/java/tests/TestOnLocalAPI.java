package tests;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

/**
 *
 * @author uimon
 */
public class TestOnLocalAPI {
    
    @Test
    public void testGet() {
        
        baseURI = "http://localhost:3000";
        given().get("/users")
                .then()
                .statusCode(200)
                .log().all();
    }
    
    // @Test
    public void testPost() {
        baseURI = "http://localhost:3000";
        
        JSONObject request = new JSONObject();
        
        request.put("firstName", "Ken");
        request.put("lastName", "Client");
        request.put("subjectId", 1);
        
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toString())
                .when()
                .post("/users")
                .then()
                .statusCode(201);
    }
    
    //@Test
    public void testPut() {
        baseURI = "http://localhost:3000";
        JSONObject request = new JSONObject();
        
        request.put("firstName", "Matti");
        request.put("lastName", "Masa");
        request.put("subjectId", 1);
        
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toString())
                .when()
                .put("/users/3")
                .then()
                .statusCode(200);
    }
    
    //@Test
    public void testPatch() {
        baseURI = "http://localhost:3000";
        JSONObject request = new JSONObject();
        
        request.put("lastName", "Meikäläinen");

        
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toString())
                .when()
                .patch("/users/3")
                .then()
                .statusCode(200);
    }
    
    @Test
    public void testDelete() {
        baseURI = "http://localhost:3000";
        given()
            .when()
            .delete("/users/4")
            .then()
            .statusCode(200);
    }    
}
