package pl.testeroprogramowania.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.tests.SeleniumHelper;

import java.io.IOException;

public class HomePage extends Screen{


    @FindBy(xpath = "//span[text()='My account']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//span[text()='Shop']")
    private WebElement shopLink;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public MyAccountPage openMyAccountPage() {
        myAccountLink.click();
        return new MyAccountPage(driver);
    }

    public ProductListPage openShopPage() {
        shopLink.click();
        try {
            test.log(Status.PASS, "Opening shop page", SeleniumHelper.getScreenshot(driver));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ProductListPage(driver);
    }

}
