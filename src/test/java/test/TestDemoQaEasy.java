package test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import models.lombok.AuthResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestDemoQaEasy {

  @Test
  @DisplayName("Авторизация с незарегистрированым пользователем")
  void enterBadElements() {
    AuthResponseModel respMod = given()
        .body(new File("src/test/resources/Logopass.json"))
        .contentType(JSON)
        .log().uri()

        .when()
        .post("https://demoqa.com/Account/v1/GenerateToken")

        .then()
        .log().status()
        .log().body()
        .statusCode(200)
        .extract().as(AuthResponseModel.class);
    assertEquals("User authorization failed.", respMod.getResult());
  }
}



