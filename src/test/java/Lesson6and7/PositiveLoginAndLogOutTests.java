package Lesson6and7;

import Lesson6and7.pages.LogOutForKudaGoPage;
import Lesson6and7.pages.LoginForKudaGoPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;
import static Lesson6and7.pages.ConfigurationForKudaGo.BASE_URL;
import static org.hamcrest.CoreMatchers.containsString;

@Feature("Тестирование позитивного сценария LogIn и LogOut")
public class PositiveLoginAndLogOutTests extends BaseTest {

    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL);
    }

    @Test
    void positiveLogin() {
        new LoginForKudaGoPage(driver)
                .submitUserZone()
                .inputLoginLocator()
                .fillInputLogin("lyubovportnovapottnova@yandex.ru")
                .fillInputPassword("qq9147[[")
                .submitLogin();
        assertThat(new LoginForKudaGoPage(driver).loginSuccess,isDisplayed());
    }
    @Test
    void positiveLogOut() {
        new LogOutForKudaGoPage(driver)
                .getCookie()
                .waitLoginLocator()
                .iconDropDownForLogOut()
                .clickForLogOut();
        assertThat(new LogOutForKudaGoPage(driver).successLogOut.getText(), containsString("Вход"));
    }
}

