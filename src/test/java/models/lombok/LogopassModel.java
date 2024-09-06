package models.lombok;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.switchTo;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogopassModel {

  public String userName;
  public String password;

  public static class DemoqaPage1 {


    /**
     * метод для клика по карточка elements
     */
    public SelenideElement clickElements() {
      return $x("//div[@class='category-cards']/div[position()=1]");
    }

    /**
     * метод для клика по карточка elements
     */
    public void clickTextbox() {
      $x("//li[@id='item-0']").click();
    }

    /**
     * метод для ввода имени пользователя
     */
    public void inputUserName(String Name) {
      SelenideElement userName = $x("//input[@id='userName']");
      userName.sendKeys(Name);
    }

    /**
     * метод для ввода email
     */
    public void inputUserEmail(String Email) {
      SelenideElement userEmail = $x("//input[@id='userEmail']");
      userEmail.sendKeys(Email);
    }

    /**
     * метод для ввода текущего адреса
     */
    public void inputCurrentAddress(String curAddress) {
      SelenideElement currentAddress = $x("//textarea[@id='currentAddress']");
      currentAddress.sendKeys(curAddress);
    }

    /**
     * определение поля ввода постоянного адреса
     */
    public void inputPermanentAddress(String perAddress) {
      SelenideElement permanentAddress = $x("//textarea[@id='permanentAddress']");
      permanentAddress.sendKeys(perAddress);
    }

    /**
     * метод для осуществления нажатия кнопки
     */
    public void clickSubmitBtn() {
      SelenideElement buttonSubmit = $x("//button[@id='submit']");
      buttonSubmit.click();
    }

    /**
     * метод для осуществления скоролла до кнопки
     */
    public void ScrollSubmitBtn() {
      SelenideElement buttonSubmit = $x("//button[@id='submit']");
      buttonSubmit.scrollIntoView(true).click();
    }

    /**
     * метод для осуществления клика по карточке alertsFrameWindows
     */
    public void clickAlertsFrameWindows() {
      SelenideElement alertsFrameWindows = $x("//div[@class='category-cards']/div[position()=3]");
      alertsFrameWindows.click();
    }

    /**
     * метод для осуществления клика  BrowserWindows
     */
    public void clickBrowserWindows() {
      SelenideElement browserWindows = $x("//span[text()='Browser Windows']");
      browserWindows.click();
    }

    /**
     * метод для осуществления клика по кнопке NewTab
     */
    public void clickButtonNewTab() {
      SelenideElement buttonNewTab = $x("//button[text()='New Tab']");
      buttonNewTab.click();
      switchTo().window(1);
    }

    /**
     * проверка по тексту
     */
    public void checkOpenSampleHeading() {
      $x("//h1[@id='sampleHeading']").shouldHave(text("This is a sample page"));
    }

    /**
     * проверка имени
     */
    public void checkName() {
      $x("//p[@id='name']").shouldHave(text("Name:Taras"));
    }

    /**
     * проверка почты
     */
    public void checkEmail() {
      $x("//p[@id='email']").shouldHave(text("Email:test@bk.ru"));
    }

    /**
     * закрытие браузера
     */
    public void closeBrowser() {
      closeWebDriver();
    }

    /**
     * открытие новой вкладки
     */
    public void openNewPage() {
      switchTo().window(1);
    }

    /**
     * проверка текста на второй вкладке
     */
    public void openSampleHeading() {
      $x("//h1[@id='sampleHeading']").shouldHave(text("This is a sample page"));
    }

  }
}
