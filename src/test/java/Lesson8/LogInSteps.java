package Lesson8;

import Lesson8.LogInPage;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInSteps {
    @When("I click button Enter for authorization")
    public void iClickButtonEnterForAuthorization() {
        new LogInPage().submitUserZone();
    }

    @And("I fill field Login")
    public void iFillFieldLogin() {
        new LogInPage().fillInputLogin("lyubovportnovapottnova@yandex.ru");
    }

    @And("I fil field Password")
    public void iFilFieldPassword() {
        new LogInPage().fillInputPassword("qq9147[[");
    }

    @And("I click button Enter")
    public void iClickButtonEnter() {
        new LogInPage().submitLogin();
    }

    @Then("I see success authorization")
    public void iSeeSuccessAuthorization() {
        new LogInPage().loginSuccess.shouldHave(Condition.text("Lyubov"));
    }
}
