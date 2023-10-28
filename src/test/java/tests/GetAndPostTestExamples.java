/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
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
    
}
