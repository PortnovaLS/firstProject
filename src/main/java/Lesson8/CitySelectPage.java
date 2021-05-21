package Lesson8;

import Lesson6and7.pages.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static Lesson6and7.pages.ConfigurationForKudaGo.BASE_URL;
import static com.codeborne.selenide.Selenide.*;

public class CitySelectPage {

    public SelenideElement iconCitySelect = $(By.xpath("//span[@class='city-select']"));

    public SelenideElement citySelect = $(By.xpath("//div[@class='tip-inner']//a[@id='location-spb']"));

    public SelenideElement successCitySelectStPetersburg = $(By.xpath("//div[@class='location-switcher']/span"));

    @Step("Выпадающее меню для выбора города")
    public CitySelectPage dropDownCitySelect(){
        open(BASE_URL);
      actions().moveToElement(iconCitySelect).click(iconCitySelect).perform();
        return this;
    }

    @Step("Выбрать город ")
    public void citySelect(){
        citySelect.shouldBe(Condition.visible);
    }
}
