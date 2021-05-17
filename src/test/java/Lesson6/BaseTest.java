package Lesson6;


import Lesson6.pages.ButtonDatePickerPage;
import Lesson6.pages.LogOutForKudaGoPage;
import Lesson6.pages.LoginForKudaGoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    WebDriver driver;
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
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 15);
        loginForKudaGoPage = new LoginForKudaGoPage(driver);
        logOutForKudaGoPage = new LogOutForKudaGoPage(driver);
        buttonDatePickerPage = new ButtonDatePickerPage(driver);

    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}








