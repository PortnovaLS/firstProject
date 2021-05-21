package Lesson8;

import Lesson8.DatePickerPage;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Lesson6and7.pages.ConfigurationForKudaGo.BASE_URL;
import static Lesson6and7.pages.ConfigurationForKudaGo.EVENTS_URL;
import static com.codeborne.selenide.Selenide.open;

public class CheckButtonDatePickerSteps {

    @Given("I am on Events page")
    public void iAmOnEventsPage() {
        open(EVENTS_URL);
    }

    @When("I press button DatePicker")
    public void iPressButtonDatePicker() {
        new DatePickerPage().clickDayPickerItem();
    }

    @And("I choose date")
    public void iChooseDate() {
        new DatePickerPage().clickChosenDate();
    }

    @And("I press button Apply")
    public void iPressButtonApply() {
        new DatePickerPage().clickButtonChosenDate();
    }

    @Then("I see chosen Date")
    public void iSeeChosenDate() {
        new DatePickerPage().successChosenDate.shouldBe(Condition.visible);
    }
}
