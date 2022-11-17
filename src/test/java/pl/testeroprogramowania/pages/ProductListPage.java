package pl.testeroprogramowania.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.tests.SeleniumHelper;

import java.io.IOException;

public class ProductListPage extends Screen {

    private WebDriver driver;

    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage openProduct(String title) throws IOException {
        driver.findElement(By.xpath("//h2[text()='" + title + "']")).click();
        test.log(Status.PASS, "Open Product", SeleniumHelper.getScreenshot(driver));
        return new ProductPage(driver);
    }


}
