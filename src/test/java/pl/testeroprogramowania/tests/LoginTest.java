package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .logInValidData("test@test.pl", "test@test.pl")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

  /*  @Test
    public void loginWithInvalidPasswordTest() {

        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .logInInvalidData("test@test.pl", "lelel")
                .getError();

        Assert.assertTrue(error.getText().contains("Incorrect username or password"));
    }*/
}

