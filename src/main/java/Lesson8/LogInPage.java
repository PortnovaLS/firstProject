package Lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Lesson6and7.pages.ConfigurationForKudaGo.BASE_URL;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LogInPage {

    public SelenideElement buttonUserZone = $(By.xpath("//div[@id='userzone']//a[contains(@class, 'login')]"));

    public SelenideElement inputLogin = $(By.xpath("//form[@class='authPopup-form tokenized' and @id='auth-form-login']/input[@placeholder='Email']"));

    public SelenideElement inputPassword = $(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='password']"));

    public SelenideElement buttonAuth = $(By.xpath("//form[@class='authPopup-form tokenized']/button[@class='authPopup-button button']"));

    public SelenideElement loginSuccess = $(By.xpath("//span[@class='user-zone-underline']"));

    @Step("Нажать кнопку Вход для авторизации")
    public LogInPage submitUserZone(){
        open(BASE_URL);
        buttonUserZone.click();
        return this;
    }

    @Step("Заполнить поле логина")
    public LogInPage fillInputLogin (String login){
        inputLogin.sendKeys(login);
        return this;
    }
    @Step("Заполнить поле пароля")
    public LogInPage fillInputPassword (String password){
        inputPassword.sendKeys(password);
        return this;
    }
    @Step("Нажать кнопку войти")
    public void submitLogin(){
        buttonAuth.click();
    }
}
