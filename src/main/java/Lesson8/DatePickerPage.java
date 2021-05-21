package Lesson8;

import Lesson6and7.pages.BasePage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static Lesson6and7.pages.ConfigurationForKudaGo.EVENTS_URL;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DatePickerPage {

    public SelenideElement dayPickerItem = $(By.xpath("//div[@class='DayPicker-choosenDate navbar-item-link']"));

    public SelenideElement chosenDate = $(By.xpath("//div[@aria-label='ср 26 мая 2021 г.']"));

    public SelenideElement buttonChosenDate = $(By.xpath("//button[@class='button']"));

    public SelenideElement successChosenDate = $(By.xpath("//div[@id='react-date-picker']"));

    @Step("Нажать кнопку Выбор даты")
    public DatePickerPage clickDayPickerItem() {
        open(EVENTS_URL);
        dayPickerItem.click();
        return this;
    }

    @Step("Выбрать дату")
    public DatePickerPage clickChosenDate() {
        chosenDate.click();
        return this;
    }

    @Step("Нажать кнопку Применить")
    public DatePickerPage clickButtonChosenDate() {
        buttonChosenDate.click();
        return this;
    }
}
