package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:config.properties"})
public interface config extends Config {

  @Key("base.uri")
  String baseuri();

  @Key("base.path")
  String basepath();
}