package Lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.BufferedReader;

public class ButtonDatePickerPage extends BasePage {

    public ButtonDatePickerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='DayPicker-choosenDate navbar-item-link']")
    public WebElement dayPickerItem;

    @FindBy(xpath = "//div[@aria-label='сб 15 мая 2021 г.']")
    public WebElement chosenDate;

    @FindBy(xpath = "//button[@class='button']")
    public WebElement buttonChosenDate;

    @FindBy(xpath = "//div[@id='react-date-picker']")
    public WebElement successChosenDate;

    public ButtonDatePickerPage clickDayPickerItem() {
        dayPickerItem.click();
        return this;
    }

    public ButtonDatePickerPage clickChosenDate() {
        chosenDate.click();
        return this;
    }

    public ButtonDatePickerPage clickButtonChosenDate() {
        buttonChosenDate.click();
        return this;
    }
}
