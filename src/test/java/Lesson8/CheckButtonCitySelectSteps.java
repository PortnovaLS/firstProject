package Lesson8;

import Lesson8.CitySelectPage;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static Lesson6and7.pages.ConfigurationForKudaGo.BASE_URL;
import static com.codeborne.selenide.Selenide.open;

public class CheckButtonCitySelectSteps {
    @Given("I am on home page")
    public void iAmOnHomePage() {
       open(BASE_URL);
    }

    @When("I select dropdown menu")
    public void iSelectDropdownMenu() {
        new CitySelectPage().dropDownCitySelect();
    }

    @And("I select city St Petersburg")
    public void iSelectCityStPetersburg() {
        new CitySelectPage().citySelect();
    }

    @Then("I see selected city St Petersburg")
    public void iSeeSelectedCityStPetersburg() {
        new CitySelectPage().successCitySelectStPetersburg.shouldBe(Condition.visible);
    }
}



