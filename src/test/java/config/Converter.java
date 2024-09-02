package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import models.lombok.LogopassModel;

public class Converter {

  ObjectMapper objectMapper = new ObjectMapper();

  void pojoToJsonString() throws IOException {
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    LogopassModel logpass = new LogopassModel("Taras", "123");
    objectMapper.writeValue(new File("src/test/resources/Logopass.json"), logpass);
  }
}