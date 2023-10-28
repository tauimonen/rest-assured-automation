/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.annotations.Test;
/**
 *
 * @author uimon
 */
public class GetAndPostTestExamples {
    
    @Test
    public void testGetIds(){
        baseURI = "https://jsonplaceholder.typicode.com";
        given()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("id", hasItems(1, 50, 100));
    }
    
    @Test
    public void testGetBody(){
        baseURI = "https://jsonplaceholder.typicode.com";
        given()
                .get("/posts/4")
                .then()
                .statusCode(200)
                .body("body", equalTo("ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit"));
    }
    
    @Test
    public void testPost() {
        
        baseURI = "https://jsonplaceholder.typicode.com";
        
        JSONObject request = new JSONObject(); 
        request.put("userId", 1000);
        request.put("id", "1000");
        request.put("title", "Hello test title");
        request.put("body", "Hello test body");
              
        System.out.println(request);
        
        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);
    }
    
}
