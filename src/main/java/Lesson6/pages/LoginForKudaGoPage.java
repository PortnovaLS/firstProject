package Lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginForKudaGoPage extends BasePage {

    @FindBy (xpath = "//div[@id='userzone']//a[contains(@class, 'login')]")
    public WebElement buttonUserZone;

    public By inputLoginLocator = By.xpath("//form[@class='authPopup-form tokenized' and @id='auth-form-login']/input[@placeholder='Email']");

    @FindBy(xpath = "//form[@class='authPopup-form tokenized' and @id='auth-form-login']/input[@placeholder='Email']")
    public WebElement inputLogin;

    @FindBy(xpath = "//form[@class='authPopup-form tokenized']/input[@name='password']")
    public WebElement inputPassword;

    @FindBy (xpath = "//form[@class='authPopup-form tokenized']/button[@class='authPopup-button button']")
    public WebElement buttonAuth;

    @FindBy(xpath = "//span[@class='user-zone-underline']")
    public WebElement loginSuccess;

    public LoginForKudaGoPage(WebDriver driver) {
        super(driver);
    }

    public LoginForKudaGoPage submitUserZone(){
        buttonUserZone.click();
        return this;
    }
    public LoginForKudaGoPage inputLoginLocator() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new LoginForKudaGoPage(driver)
                .inputLoginLocator));
        return this;
    }
    public LoginForKudaGoPage fillInputLogin (String login){
        inputLogin.sendKeys(login);
        return this;
    }
    public LoginForKudaGoPage fillInputPassword (String password){
        inputPassword.sendKeys(password);
        return this;
    }
    public void submitLogin(){
        buttonAuth.click();
    }
}
