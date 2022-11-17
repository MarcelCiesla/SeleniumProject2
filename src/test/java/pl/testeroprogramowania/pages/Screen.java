package pl.testeroprogramowania.pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import static pl.testeroprogramowania.tests.BaseTest.extentReports;

public class Screen {

    private WebDriver driver;

    ExtentTest test = extentReports.createTest("Check out Test");


}
