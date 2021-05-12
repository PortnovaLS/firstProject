package Lesson6;

import Lesson6.pages.ButtonCitySelectPage;
import Lesson6.pages.ButtonDatePickerPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Lesson6.pages.ConfigurationForKudaGo.BASE_URL;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ButtonCitySelectTest extends BaseTest{

    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL);
    }

    @Test
    void CheckButtonCitySelect() {
        new ButtonCitySelectPage(driver)
                .dropDownCitySelect()
                .clickCitySelect()
                .citySelect();
        assertThat(new ButtonCitySelectPage(driver).successCitySelect.getText(), containsString("в Санкт-Петербурге"));


    }
}
