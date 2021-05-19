package Lesson6and7;

import Lesson6and7.pages.ButtonDatePickerPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Lesson6and7.pages.ConfigurationForKudaGo.EVENTS_URL;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@Feature("Тестирование элемента Выбор даты")
public class ButtonDatePickerTest extends BaseTest{

    @BeforeEach
    public void goToPage() {
        driver.get(EVENTS_URL);
    }

    @Test
    void CheckButtonDatePicker() {
        new ButtonDatePickerPage(driver)
                .clickDayPickerItem()
                .clickChosenDate()
                .clickButtonChosenDate();
        assertThat(new ButtonDatePickerPage(driver).successChosenDate.getText(), containsString("21 мая"));
    }
}
