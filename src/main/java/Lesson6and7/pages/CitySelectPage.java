package Lesson6and7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CitySelectPage extends BasePage{

    public CitySelectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='city-select']")
    public WebElement iconCitySelect;

    @FindBy(xpath = "//ul[@id='locations-dropdown']//a[@href='/spb/']")
    public WebElement citySelect;

    @FindBy(xpath = "//div[@class='location-switcher']/span")
    public WebElement successCitySelect;

    @Step("Выпадающее меню для выбора города")
    public CitySelectPage dropDownCitySelect(){
        Actions actions = new Actions(driver);
        actions.moveToElement(iconCitySelect).perform();
        return this;
    }
    @Step("Нажать кнопку для выбора города")
    public CitySelectPage clickCitySelect(){
        iconCitySelect.click();
        return this;
    }

    @Step("Выбрать город Санкт-Петербург")
    public void citySelectStPetersburg(){
        citySelect.click();
    }
}
