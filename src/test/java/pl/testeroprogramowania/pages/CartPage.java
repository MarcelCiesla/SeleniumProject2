package pl.testeroprogramowania.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.tests.SeleniumHelper;

import java.io.IOException;

public class CartPage extends Screen{

    @FindBy(partialLinkText = "Proceed to checkout")
    private WebElement proceedToCheckoutButton;

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public AddressDetailsPage openAddressDetails() throws IOException {
        proceedToCheckoutButton.click();
        test.log(Status.PASS, "Open address Details", SeleniumHelper.getScreenshot(driver));
        return new AddressDetailsPage(driver);

    }
}
