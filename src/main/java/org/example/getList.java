package org.example;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class getList {


@Test
    public void getListOfId() {
        String listOfIDs = given()
                .log()
                .all()
                .when()
                .contentType(ContentType.JSON)
                .param("gender", "female")
                .get("https://hr-challenge.dev.tapyou.com/api/test/users?gender=female")
                .then()
                .statusCode(200)
                .extract().body().asPrettyString();
    System.out.println(listOfIDs);
    }
}
