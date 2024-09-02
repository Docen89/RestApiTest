package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.javafaker.Faker;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import models.lombok.LogopassModel;
import org.junit.jupiter.api.Test;


public class Converter {
  Faker faker = new Faker(new Locale("EN"));
  String firstName=faker.name().firstName();
  String password=faker.internet().password();

  ObjectMapper objectMapper = new ObjectMapper();
@Test
  void pojoToJsonString() throws IOException {
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    LogopassModel logpass = new LogopassModel(firstName, password);
    objectMapper.writeValue(new File("src/test/resources/Logopass.json"), logpass);
  }
}