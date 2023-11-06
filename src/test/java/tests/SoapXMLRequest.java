package tests;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.Test;

public class SoapXMLRequest {

    @Test
    public void validateSoapXML() {

        baseURI = "http://www.dneonline.com";

        File file = new File("./SoapRequest/add.xml");

        if (file.exists()) {
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                given()
                        .contentType("text/xml")
                        .accept(ContentType.XML)
                        .body(fileInputStream)
                        .when()
                        .post("/calculator.asmx")
                        .then()
                        .statusCode(200)
                        .log()
                        .all();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The file does not exist.");
        }
    }
}
