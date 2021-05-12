package Lesson6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonCitySelectPage extends BasePage{

    public ButtonCitySelectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='city-select']")
    public WebElement iconCitySelect;

    @FindBy(xpath = "//ul[@id='locations-dropdown']//a[@href='/spb/']")
    public WebElement citySelect;

    @FindBy(xpath = "//div[@class='location-switcher']/span")
    public WebElement successCitySelect;

    public ButtonCitySelectPage dropDownCitySelect(){
        Actions actions = new Actions(driver);
        actions.moveToElement(iconCitySelect).perform();
        return this;
    }
    public ButtonCitySelectPage clickCitySelect(){
        iconCitySelect.click();
        return this;
    }

    public void citySelect(){
        citySelect.click();
    }
}
