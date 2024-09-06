package models.lombok;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static test.GroovyTest.cfg;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class DemoQaSteps {

  @Step("Открываем сайт DemoQA")
  public void openFirstPage() {
    Selenide.open(cfg.startpage());
  }

  @Step("Кликаем по карточке Elements")
  public void clickElements() {
    $x("//div[@class='category-cards']/div[position()=1]").click();
  }

  @Step("Кликаем по элементу списка Text Box")
  public void clickListElementTextBox() {
    $x("//li[@id='item-0']").click();
  }

  @Step("Заполняем поле Name")
  public void fillFieldName() {
    $x("//input[@id='userName']").sendKeys(cfg.name());
  }

  @Step("Заполняем поле Email")
  public void fillFieldEmail() {
    $x("//input[@id='userEmail']").sendKeys(cfg.email());
  }

  @Step("Заполняем поле Current Address")
  public void fillFieldCurAddress() {
    $x("//textarea[@id='currentAddress']").sendKeys(cfg.curaddress());
  }

  @Step("Заполняем поле Permanent Address")
  public void fillFieldPerAddress() {
    $x("//textarea[@id='permanentAddress']").sendKeys(cfg.peraddress());
  }

  @Step("Скролим страницу до элемента  Submit")
  public void scrollToTheElementButtonSubmit() {
    $x("//button[@id='submit']").scrollIntoView(true).click();
  }

  @Step("Кликаем по кнопки Submit")
  public void clickButtonSubmit() {
    $x("//button[@id='submit']").click();
  }

  @Step("Проверяем, заполнено ли поле Name")
  public void checkName() {
    $x("//p[@id='name']").shouldHave(text(cfg.name()));
  }

  @Step("Проверяем, заполнено ли поле Email")
  public void checkEmail() {
    $x("//p[@id='email']").shouldHave(text(cfg.email()));
  }

  @Step("Закрываем браузер")
  public void closeBrowser() {
    Selenide.closeWebDriver();
  }
}
