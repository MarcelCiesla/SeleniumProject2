package pl.testeroprogramowania.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.tests.SeleniumHelper;

import java.io.IOException;

public class LoggedUserPage extends Screen{

    @FindBy(linkText = "Dashboard")
    private WebElement dashboardLink;

    private WebDriver driver;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getDashboardLink() {
        try {
            test2.log(Status.PASS, "getting dashboard link", SeleniumHelper.getScreenshot(driver));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dashboardLink;
    }

}
