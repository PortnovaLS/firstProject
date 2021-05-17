package Lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogOutForKudaGoPage extends BasePage{

    public LogOutForKudaGoPage(WebDriver driver) {
        super(driver);
    }

    public By loginLocator = By.xpath("//span[@class='user-zone-underline']");

    @FindBy(xpath = "//div[@class='user-zone-above']/i")
    public WebElement iconSelectForLogOut;

    @FindBy(xpath = "//a[@href='/account/logout/?next=https://kudago.com/msk/']")
    public WebElement clickLogOut;

    @FindBy(xpath = "//a[@href='/account/login/'][1]//span[1]")
    public WebElement successLogOut;

    public LogOutForKudaGoPage getCookie(){
        Cookie sessionCookie = driver.manage().getCookieNamed("sessionid");
        driver.manage().deleteCookie(sessionCookie);
        Cookie cookie = new Cookie("sessionid", "jyg4nhuqxpwpm7v80aj5q59w4hlcfkao");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        return this;
    }

    public LogOutForKudaGoPage waitLoginLocator() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(new LogOutForKudaGoPage(driver)
                .loginLocator));
        return this;
    }

    public LogOutForKudaGoPage iconDropDownForLogOut() {
        Actions actions = new Actions(driver);
        actions.moveToElement(iconSelectForLogOut).perform();
        return this;
    }

    public void clickForLogOut() {
        clickLogOut.click();
    }
}
