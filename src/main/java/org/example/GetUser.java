package org.example;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static io.restassured.RestAssured.given;

public class GetUser {

    String errorMessage = "Internal Server Error";
  GetUserPOJO.User user15 = new GetUserPOJO.User(15, "Gogol", "male", 210, "Mirgorod", "1809-04-01T00:00:00");
  GetUserPOJO getUserPOJO = new GetUserPOJO(true,0, null, user15);

    @Test
    public void getUserById() {
        GetUserPOJO response = given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .get("https://hr-challenge.dev.tapyou.com/api/test/user/" +  user15.id)
                .then()
                .statusCode(200)
                .extract().body().as(GetUserPOJO.class);

        Assert.assertEquals(getUserPOJO.isSuccess, response.isSuccess);
        Assert.assertEquals(getUserPOJO.errorCode, response.errorCode);
        Assert.assertEquals(getUserPOJO.errorMessage, response.errorMessage);

        Assert.assertEquals(user15.getId(), response.user.getId());
        Assert.assertEquals(user15.getName(), response.user.getName());
        Assert.assertEquals(user15.getGender(), response.user.getGender());
        Assert.assertEquals(user15.getAge(), response.user.getAge());
        Assert.assertEquals(user15.getCity(), response.user.getCity());
        Assert.assertEquals(user15.getRegistrationDate(), response.user.getRegistrationDate());
    }

    @Test
    public void getEmptyUserById() {
        GetUserPOJO emptyUser = new GetUserPOJO(true,0, null, null);
        int emptyUserId = 7;

        GetUserPOJO response = given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .get("https://hr-challenge.dev.tapyou.com/api/test/user/" + emptyUserId)
                .then()
                .statusCode(200)
                .extract().body().as(GetUserPOJO.class);

        Assert.assertEquals(emptyUser.isSuccess, response.isSuccess);
        Assert.assertEquals(emptyUser.getErrorCode(), response.getErrorCode());
        Assert.assertEquals(emptyUser.getErrorMessage(), response.getErrorMessage());
        Assert.assertEquals(emptyUser.user, response.getUser());
    }

    @Test
    public void getUserByInvalidId() {
        int invalidId = 0;
        String response = given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .get("https://hr-challenge.dev.tapyou.com/api/test/user/" + invalidId)
                .then()
                .statusCode(500)
                .extract().body().jsonPath().getString("error");
        Assert.assertEquals(errorMessage, response);
    }
}
