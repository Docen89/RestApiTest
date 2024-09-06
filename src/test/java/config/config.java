package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:config.properties"})
public interface config extends Config {

  @Key("base.uri")
  String baseuri();

  @Key("base.path")
  String basepath();

  @Key("start.page")
  String startpage();

  @Key("name")
  String name();

  @Key("email")
  String email();

  @Key("cur.address")
  String curaddress();

  @Key("per.address")
  String peraddress();

  @Key("browser.size")
  String browsersize();

  @Key("page.load.strategy")
  String pageloadstrategy();
}