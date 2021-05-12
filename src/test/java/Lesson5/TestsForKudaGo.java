package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.yandex.qatools.htmlelements.matchers.WebElementMatchers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestsForKudaGo {
    WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String PAGE_URL = "https://kudago.com/msk/";

    @BeforeSuite
    void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeSuite
    void setUpBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test(description = "Positive logIn", enabled = true)
    void positiveLogIn() {
        driver.get(PAGE_URL);
        driver.findElement(By.xpath("//div[@id='userzone']//a[contains(@class, 'login')]")).click();
        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='username']"))
                .sendKeys("lyubovportnovapottnova@yandex.ru");
        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='password']"))
                .sendKeys("qq9147[[");
        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/button[@class='authPopup-button button']"))
                .click();
        List<WebElement> userZone = driver.findElements(
                By.xpath("//span[@class='user-zone-underline']"));
        assertThat(userZone.get(0), hasText("Lyubov"));
        Assert.assertTrue(userZone.get(0).isDisplayed());
    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }

    @Test
    void positiveLogOut() {
        driver.get(PAGE_URL);
        Cookie sessionCookie = driver.manage().getCookieNamed("sessionid");
        driver.manage().deleteCookie(sessionCookie);
        Cookie cookie = new Cookie("sessionid", "otee4e0ux77c9gln1n03wdkz9toyjwon");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        Actions actions = new Actions(driver);
        WebElement iconDropdown = driver.findElement(By.xpath("//div[@class='user-zone-above']/i"));
        actions.moveToElement(iconDropdown).perform();
        driver.findElement(By.xpath("//a[@href='/account/logout/?next=https://kudago.com/msk/']")).click();
        List<WebElement> accountLogin = driver.findElements(
                By.xpath("//div[@id='userzone']//a[@href='/account/login/'][1]//span[1]"));
        Assert.assertTrue(accountLogin.get(0).isDisplayed());
        assertThat(accountLogin.get(0).getText(), containsString("Вход"));

    }

    @Test
    void CheckButtonAddEvent() {
        driver.get("https://kudago.com/msk/events/");
        driver.findElement(By.xpath("//a[@href='https://kudago.com/pages/about/adv/']")).click();
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//a[@href='#popup:price3']")), "Получить прайс и презентацию"));
        driver.findElement(By.xpath("//a[@href='#popup:price3']")).click();
        driver.findElement(By.xpath("//div[@class='t-popup t-popup_show']//input[@placeholder='Ваша компания']"))
                .sendKeys("test");
        List<WebElement> event = driver.findElements(
                By.xpath("//form[@id='form167455775']//div[@class='t-input-block']"));
        assertThat(event.get(0), hasText(""));
    }

    @Test
    void CheckButtonDatePicker() {
        driver.get("https://kudago.com/msk/events/");
        driver.findElement(By.xpath("//div[@class='DayPicker-choosenDate navbar-item-link']")).click();
        driver.findElement(By.xpath("//div[@aria-label='ср 12 мая 2021 г.']")).click();
        driver.findElement(By.xpath("//button[@class='button']")).click();
        List<WebElement> datePicker = driver.findElements(
                By.xpath("//div[@id='react-date-picker']"));
        Assert.assertTrue(datePicker.get(0).isDisplayed());
        assertThat(datePicker.get(0).getText(), containsString("12 мая"));
    }
    @Test
    void CheckButtonCitySelect() {
        driver.get(PAGE_URL);
        Actions actions = new Actions(driver);
        WebElement cityDropdown = driver.findElement(By.xpath("//span[@class='city-select']"));
        actions.moveToElement(cityDropdown).perform();
        driver.findElement(By.xpath("//span[@class='city-select']")).click();
        driver.findElement(By.xpath("//ul[@id='locations-dropdown']//a[@href='/online/']")).click();
        List<WebElement> citySelect = driver.findElements(
                By.xpath("//span[@class='city-select']"));
        Assert.assertTrue(citySelect.get(0).isDisplayed());
        assertThat(citySelect.get(0).getText(), containsString("Выберите город"));
    }
    @Test
    void CheckCenteredContainer() {
        driver.get(PAGE_URL);
        List <WebElement> centeredContainer = driver.findElements(
                By.xpath("//div[@id='lower-nav']//div[@class='centered-container']"));
        assertThat(centeredContainer.get(0).findElement(By.xpath("//a[@href='/msk/city-food/']//span")),
                hasText("ЕДА"));
        assertThat(centeredContainer.get(0).findElement(By.xpath("//a[@href='/msk/attractions/']//span")),
                hasText("ИНТЕРЕСНЫЕ МЕСТА"));
    }
}
