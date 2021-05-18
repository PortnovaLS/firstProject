package Lesson6and7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonDatePickerPage extends BasePage {

    public ButtonDatePickerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='DayPicker-choosenDate navbar-item-link']")
    public WebElement dayPickerItem;

    @FindBy(xpath = "//div[@aria-label='пт 21 мая 2021 г.']")
    public WebElement chosenDate;

    @FindBy(xpath = "//button[@class='button']")
    public WebElement buttonChosenDate;

    @FindBy(xpath = "//div[@id='react-date-picker']")
    public WebElement successChosenDate;

    @Step("Нажать кнопку Выбор даты")
    public ButtonDatePickerPage clickDayPickerItem() {
        dayPickerItem.click();
        return this;
    }

    @Step("Выбрать дату")
    public ButtonDatePickerPage clickChosenDate() {
        chosenDate.click();
        return this;
    }

    @Step("Нажать кнопку Применить")
    public ButtonDatePickerPage clickButtonChosenDate() {
        buttonChosenDate.click();
        return this;
    }
}
