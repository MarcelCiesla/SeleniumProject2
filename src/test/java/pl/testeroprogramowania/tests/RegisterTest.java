package pl.testeroprogramowania.tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {
        WebElement entryTitle = new HomePage(driver).openMyAccountPage()
                .registerUser("test@test.pl", "test@test.pl").getEntryTitle();

        Assert.assertTrue(entryTitle.isDisplayed());
        Assert.assertEquals(entryTitle.getText(),"My Account");
    }
}
