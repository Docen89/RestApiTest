package test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static test.GroovyTest.cfg;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import models.lombok.DemoQaSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LambdaTest {

  private static final String POLE = "Заполняем поле ";
  private static final String POLECHECK = "Проверяем, заполнено ли поле ";

  @Test
  @DisplayName("Tестируем DemoQA с помощью лямбды")
  public void testSteplambda() {
    SelenideLogger.addListener("allure", new AllureSelenide());
    step("Открываем сайт DemoQA" + cfg.startpage(), () -> {
      Selenide.open(cfg.startpage());
    });
    step("Кликаем по карточке Elements", () -> {
      $x("//div[@class='category-cards']/div[position()=1]").click();
    });
    step("Кликаем по элементу списка Text Box", () -> {
      $x("//li[@id='item-0']").click();
    });
    step(POLE + "Name " + cfg.name(), () -> {
      $x("//input[@id='userName']").sendKeys(cfg.name());
    });
    step(POLE + "Email " + cfg.email(), () -> {
      $x("//input[@id='userEmail']").sendKeys(cfg.email());
    });
    step(POLE + "Current Address " + cfg.curaddress(), () -> {
      $x("//textarea[@id='currentAddress']").sendKeys(cfg.curaddress());
    });
    step(POLE + "Permanent Address " + cfg.peraddress(), () -> {
      $x("//textarea[@id='permanentAddress']").sendKeys(cfg.peraddress());
    });
    step("Скролим страницу до элемента  Submit", () -> {
      $x("//button[@id='submit']").scrollIntoView(true).click();
    });
    step("Кликаем по кнопки Submit", () -> {
      $x("//button[@id='submit']").click();
    });
    step(POLECHECK + "Name " + cfg.name(), () -> {
      $x("//p[@id='name']").shouldHave(text(cfg.name()));
    });
    step(POLECHECK + "Email " + cfg.email(), () -> {
      $x("//p[@id='email']").shouldHave(text(cfg.email()));
    });
    step("Закрываем браузер", () -> {
      Selenide.closeWebDriver();
    });
  }

  @Test
  @DisplayName("Тестируем DemoQA   с AllureSteps")
  public void stepsAllureDemoQa() {
    DemoQaSteps step = new DemoQaSteps();

    step.openFirstPage();
    step.clickElements();
    step.clickListElementTextBox();
    step.fillFieldName();
    step.fillFieldEmail();
    step.fillFieldCurAddress();
    step.fillFieldPerAddress();
    step.scrollToTheElementButtonSubmit();
    step.clickButtonSubmit();
    step.checkName();
    step.checkEmail();
    step.closeBrowser();
  }
}
