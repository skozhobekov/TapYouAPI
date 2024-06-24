package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class GetList {

    String errorMessage = "Internal Server Error";
    GetListPOJO getListOfIDs = new GetListPOJO(true, 0, null, new ArrayList<>(5));

    @Test
    public void getListOfFemale() throws JsonProcessingException {

        GetListPOJO response = given()
                .log()
                .all()
                .when()
                .contentType(ContentType.JSON)
                .param("gender", "female")
                .get("https://hr-challenge.dev.tapyou.com/api/test/users")
                .then()
                .statusCode(200)
                .extract().body().as(GetListPOJO.class);

        Assert.assertEquals(getListOfIDs.isSuccess, response.isSuccess);
        Assert.assertEquals(getListOfIDs.errorCode, response.errorCode);
        Assert.assertEquals(getListOfIDs.errorMessage, response.errorMessage);
        Assert.assertNotNull(getListOfIDs.idList);
    }
    @Test
    public void getListOfMale()  {
        GetListPOJO response = given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .param("gender" ,"male")
                .get("https://hr-challenge.dev.tapyou.com/api/test/users")
                .then()
                .statusCode(200)
                .extract().body().as(GetListPOJO.class);

        Assert.assertEquals(getListOfIDs.isSuccess, response.isSuccess);
        Assert.assertEquals(getListOfIDs.errorCode, response.errorCode);
        Assert.assertEquals(getListOfIDs.errorMessage, response.errorMessage);
        Assert.assertNotNull(getListOfIDs.idList);
    }

    @Test
    public void getListmaleAndfemale() {

        String response = given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .param("gender", "male")
                .param("gender", "female")
                .get("https://hr-challenge.dev.tapyou.com/api/test/users")
                .then()
                .statusCode(500)
                .extract().body().jsonPath().getString("error");
        Assert.assertEquals(errorMessage, response);
    }

    @Test
    public void getListInvalidGender() {
        String response = given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .param("gender", "123")
                .get("https://hr-challenge.dev.tapyou.com/api/test/users")
                .then()
                .statusCode(500)
                .extract().body().jsonPath().getString("error");
        Assert.assertEquals(errorMessage, response);
    }
}
