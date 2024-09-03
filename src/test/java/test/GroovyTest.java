package test;


import static io.restassured.RestAssured.get;

import config.config;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import java.util.List;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GroovyTest {

  public static config cfg = ConfigFactory.create(config.class);

  @BeforeAll
  public static void setUp() {
    RestAssured.baseURI = cfg.baseuri();
    RestAssured.basePath = cfg.basepath();
    RestAssured.requestSpecification = new RequestSpecBuilder()
        .log(LogDetail.ALL)
        .build();
    RestAssured.responseSpecification = new ResponseSpecBuilder()
        .log(LogDetail.BODY)
        .build();
  }

  @Test
  @DisplayName("Выдача полного списка книг")
  public void extractBooks() {
    Response response = get();
    List<String> allAuthor = response.path("books.author");
    System.out.println(allAuthor);
  }
}
