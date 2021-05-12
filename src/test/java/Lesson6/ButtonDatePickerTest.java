package Lesson6;

import Lesson6.pages.ButtonDatePickerPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Lesson6.pages.ConfigurationForKudaGo.EVENTS_URL;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

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
        assertThat(new ButtonDatePickerPage(driver).successChosenDate.getText(), containsString("15 мая"));
    }
}
