package tests;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author uimon
 */
public class TestExamples {
    
    @Test
    public void test1(){
        
        Response response = get("https://jsonplaceholder.typicode.com/todos/1");        
        int statusCode = response.getStatusCode();
        
        Assert.assertEquals(statusCode, 200);
    }
    
    @Test
    public void test2() {
        
        baseURI = "https://jsonplaceholder.typicode.com";
        given()
                .get("/todos/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("delectus aut autem"));
                
    }
    
    @Test
    public void test3() {
        baseURI = "https://jsonplaceholder.typicode.com";
        given()
                .get("/todos/54")
                .then()
                .statusCode(200)
                .body("title", equalTo("quis et est ut voluptate quam dolor"))
                .body("userId", equalTo(3))
                .body("completed", equalTo(true))
                .log().all();
    }
}
