package Lesson6and7;


import Lesson6and7.Listeners.CustomLogger;
import Lesson6and7.pages.ButtonDatePickerPage;
import Lesson6and7.pages.LogOutForKudaGoPage;
import Lesson6and7.pages.LoginForKudaGoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;
    LoginForKudaGoPage loginForKudaGoPage;
    LogOutForKudaGoPage logOutForKudaGoPage;
    ButtonDatePickerPage buttonDatePickerPage;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupBrowser() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new CustomLogger());
        webDriverWait = new WebDriverWait(driver, 15);
        loginForKudaGoPage = new LoginForKudaGoPage(driver);
        logOutForKudaGoPage = new LogOutForKudaGoPage(driver);
        buttonDatePickerPage = new ButtonDatePickerPage(driver);

    }

    @AfterEach
    void tearDown(){
        driver.manage().logs().get(LogType.BROWSER).getAll().forEach(System.out::println);
        driver.quit();
    }
}








