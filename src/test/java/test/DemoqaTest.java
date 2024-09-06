package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import models.lombok.LogopassModel.DemoqaPage1;
import config.config;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DemoqaTest {


  DemoqaPage1 page1 = new DemoqaPage1();
  private config cfg = ConfigFactory.create(config.class);

  @BeforeEach

  public void setup() {
    Selenide.open(cfg.startpage());
    Configuration.pageLoadStrategy = cfg.pageloadstrategy();
    Configuration.browserSize = cfg.browsersize();

  }


  @Test
  @DisplayName("Проверка заполнения полей userName,userEmail,currentAddress,permanentAddress")
  public void DemoqaTest_1() {

    SelenideLogger.addListener("allure", new AllureSelenide());

    page1.clickElements().click();
    //кликаем по карточке elements
    page1.clickTextbox();
    //кликаем по карточке Textbox
    page1.inputUserName(cfg.name());
    page1.inputUserEmail(cfg.email());
    page1.inputCurrentAddress(cfg.curaddress());
    page1.inputPermanentAddress(cfg.peraddress());
    page1.ScrollSubmitBtn();
    page1.clickSubmitBtn();
    page1.checkEmail();
    page1.checkName();
  }

  @Test
  @DisplayName("Открытие новой вкладки")
  public void DemoqaTest_2() {
    page1.clickAlertsFrameWindows();
    page1.clickBrowserWindows();
    page1.clickBrowserWindows();
    page1.clickButtonNewTab();
    page1.openNewPage();
    page1.openSampleHeading();
  }

}
