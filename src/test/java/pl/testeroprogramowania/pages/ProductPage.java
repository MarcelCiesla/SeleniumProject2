package pl.testeroprogramowania.pages;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.tests.SeleniumHelper;

import java.io.IOException;

public class ProductPage extends Screen {

    @FindBy(name = "add-to-cart")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='woocommerce-message']//a[text()='View cart']")
    private WebElement viewCartButton;

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public ProductPage addProductToCart() throws IOException {
        addToCartButton.click();
        test.log(Status.PASS, "adding product to cart", SeleniumHelper.getScreenshot(driver));
        return this;
    }

    public CartPage viewCart() throws IOException {
        viewCartButton.click();
        test.log(Status.PASS, "View Cart", SeleniumHelper.getScreenshot(driver));
        return new CartPage(driver);
    }
}
