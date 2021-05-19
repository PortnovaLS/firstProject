package Lesson6and7;

import Lesson6and7.pages.CitySelectPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Lesson6and7.pages.ConfigurationForKudaGo.BASE_URL;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@Feature("Тестирование элемента Выбор города")
public class ButtonCitySelectTest extends BaseTest{

    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL);
    }

    @Test
    void CheckButtonCitySelect() {
        new CitySelectPage(driver)
                .dropDownCitySelect()
                .clickCitySelect()
                .citySelectStPetersburg();
        assertThat(new CitySelectPage(driver).successCitySelect.getText(), containsString("в Санкт-Петербурге"));
    }
}
