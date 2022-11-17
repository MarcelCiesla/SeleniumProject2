package pl.testeroprogramowania.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pl.testeroprogramowania.utils.DriverFactory;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    protected static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extentReports;

    @BeforeSuite
    public void beforeSuite() {
        htmlReporter = new ExtentHtmlReporter("index.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @AfterSuite
    public void afterSuite() {
        htmlReporter.flush();
        extentReports.flush();
    }


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10l));
        driver.manage().window().maximize();
        driver.get("http://seleniumdemo.com/");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
