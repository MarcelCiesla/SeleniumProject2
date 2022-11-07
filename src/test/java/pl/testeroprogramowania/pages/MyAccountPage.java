package pl.testeroprogramowania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.dom.model.ShadowRootType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.utils.SeleniumHelper;

public class MyAccountPage {


    @FindBy(id = "reg_email")
    private WebElement regEmailInput;

    @FindBy(id = "reg_password")
    private WebElement regPasswordInput;

    @FindBy(name = "register")
    private WebElement regButton;

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private WebElement error;

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void registerUser(String email, String password) {
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);
        By productName = By.name("register");
        SeleniumHelper.waitForClickable(productName, driver);
        driver.findElement(productName).click();
        /*regButton.click();*/
    }

    public LoggedUserPage registerUserValidData(String email, String password) {
        registerUser(email, password);
        By productName = By.name("register");
        SeleniumHelper.waitForClickable(productName, driver);
        driver.findElement(productName).click();
        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerUserInvalidData(String email, String password) {
        registerUser(email, password);
        By productName = By.name("register");
        SeleniumHelper.waitForClickable(productName, driver);
        driver.findElement(productName).click();
        return this;
    }

    private void logIn(String username, String password) {
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public LoggedUserPage logInValidData(String username, String password) {
        logIn(username, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage logInInvalidData(String username, String password) {
        logIn(username, password);
        return this;
    }

    public WebElement getError() {
        return error;
    }
}
