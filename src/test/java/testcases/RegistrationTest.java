package testcases;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lib.RunReports;
import org.testng.AssertJUnit;
import lib.SelectBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Registration;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class RegistrationTest{

  
	WebDriver driver;
    Registration reglogin;
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;
    @BeforeSuite
    public void setUpReport()
    {
        //create the HtmlReporter in that path by the name of  SearchReport.html
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
                + "/test-output/RegistrationPageTest.html");
        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Suryadevara");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Radhika");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting ProductDetails report");
        htmlReporter.config().setReportName("Ecom product details and Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }
    
    @BeforeTest(enabled = true)
    public void launchBrowser() throws InterruptedException {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(5000);
        driver.get("https://demo.perscholastraining.com/");
         Reporter.log("The browser is open for Registration");
    }


    @Test(priority = 1, testName = "TC - 0002", enabled = false)
    // test if it is used a valid email in order to create an account
    public void createAccountWeekPassword() throws IOException, InterruptedException {
        //test = extent.createTest("createAccountValidEmail_test","Test Passed");
        //test.addScreenCaptureFromPath("createAccountValidEmail.png");
       test = extent.createTest("verify_createAccountWeekPassword_0002", "Test Passed");
       reglogin = new Registration(driver);
        reglogin.ClickOnMyAccountButn();
        //ecomLogInPage = new EcomLogInPage(driver);
        Thread.sleep(2000);

        reglogin.EnterPassReg("P@ssper");
        reglogin.EnterEMailReg("radhikag347@gmail.com");
RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0002A-image1.jpg");
        //RunReports.extent.createTest("functionality1Test1");
        //RunReports.test.addScreenCaptureFromPath("TC0002-image1.jpg");
         Thread.sleep(4000);
       String ErrorMsg = driver.findElement(By.className("bad")).getText();
       Actions action = new Actions(driver);
       action.sendKeys(Keys.PAGE_DOWN).build().perform();
        System.out.println(ErrorMsg);
        String actual = "Weak - Please enter a stronger password.";
       RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0002A-image2.jpg");
        //RunReports.test.addScreenCaptureFromPath("TC0002B-image2.jpg");
       
       AssertJUnit.assertEquals(actual, ErrorMsg);
    }

    @Test(priority = 3, testName = "TC - 0001", enabled = false)
    // test if it is used a valid email in order to create an account
    public void createAccounWithValidPass() throws IOException, InterruptedException {
        //test = extent.createTest("createAccountValidEmail_test","Test Passed");
        //test.addScreenCaptureFromPath("createAccountValidEmail.png");
        test = extent.createTest("createAccounWithValidPass_0001", "Test Passed");
       reglogin = new Registration(driver);
        reglogin.ClickOnMyAccountButn();
        //ecomLogInPage = new EcomLogInPage(driver);
       // Thread.sleep(3000);
        driver.findElement(By.id("reg_password")).clear();
        reglogin.EnterUserNameReg("Admin12345678");
        reglogin.EnterEMailReg("pertest613@gmail.com");
        reglogin.EnterPassReg("PERscholas$123");
 RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0001A-image1.jpg");
        Actions action = new Actions(driver);
 		action.sendKeys(Keys.PAGE_DOWN).build().perform();
 		
        reglogin.ClickOnRegBtn();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0001A-image2.jpg");
        Thread.sleep(3000);
        //System.out.println(reglogin.RegisterPageMess());
        String expected = "My Account" ;
        System.out.println(expected);

        String actual = reglogin.RegisterPageMess();
        AssertJUnit.assertEquals(expected, actual);
        Thread.sleep(3000);
    }

    @Test(priority = 2, testName = "TC - 0003" , enabled = true)
    // test if it is used a valid email in order to create an account
    public void createAccounWithExistingUserNAme() throws IOException, InterruptedException {
        test = extent.createTest("createAccountValidExisting_username","Test Passed");
        //test.addScreenCaptureFromPath("createAccountValidEmail.png");
        reglogin = new Registration(driver);
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0003A-image1.jpg");
        reglogin.ClickOnMyAccountButn();
        //ecomLogInPage = new EcomLogInPage(driver);
        // Thread.sleep(3000);
        driver.findElement(By.id("reg_password")).clear();
        reglogin.EnterUserNameReg("Admin");
        reglogin.EnterEMailReg("pertest611@gmail.com");
        reglogin.EnterPassReg("PERscholas$123");
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0003A-image2.jpg");
        Actions action = new Actions(driver);
 		action.sendKeys(Keys.PAGE_DOWN).build().perform();

   		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20, 1));
  		WebElement elementAbout1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("register")));
        reglogin.ClickOnRegBtn();
        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0003A-image3.jpg");
        Thread.sleep(5000);
        String expected = reglogin.ErrorMsgUser();
        //System.out.println(reglogin.RegisterPageMess());
        //String expected = driver.getCurrentUrl();
        System.out.println(expected);

        String actual = "Error: An account is already registered with that username. Please choose another.";
        AssertJUnit.assertEquals(expected, actual);
        
        

    }
       
       @AfterMethod
    public void getResult(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));

           test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }

    @AfterSuite
    public void tearDown()
    {
        extent.flush();
    }


}

