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
import org.openqa.selenium.ElementClickInterceptedException;
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

import pages.Registration;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

	public class Logintest {

	  
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
	                + "/test-output/LoginTest.html");
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
	        driver.get("https://demo.perscholastraining.com/my-account-2/");
	    }

	

	    @Test(priority = 1, testName = "TC - 0004", enabled = true)
	    // test if it is used a valid email in order to create an account
	    
	    public void Loginintoaccount() throws IOException, InterruptedException {
	        //test = extent.createTest("createAccountValidEmail_test","Test Passed");
	        //test.addScreenCaptureFromPath("createAccountValidEmail.png");
	    	test = extent.createTest("verify_Loginaccount", "Test Passed");
	        reglogin = new Registration(driver);
	     /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100, 1));
	  		WebElement elementAbout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='My Account']")));
	  		Thread.sleep(5000);
	        reglogin.ClickOnMyAccountButn();
	        //ecomLogInPage = new EcomLogInPage(driver);
	       // Thread.sleep(3000);
	       // driver.findElement(By.id("reg_password")).clear();
	       // reglogin.EnterUserNameReg("Admin");*/
	        reglogin.entLoginusrnm("Stu4@gmail.com");
	        System.out.println("Entered emailid");
	        reglogin.entLoginusrpwd("Psssw0rd@#$123452345sfsff");
	        System.out.println("Entered password");

	        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0004A-image1.jpg");
	        Actions action = new Actions(driver);
	 		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	 		try {
	 		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(100, 1));
	  		WebElement elementAbout1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("login")));
	  		elementAbout1.click();}
	 		catch(ElementClickInterceptedException e){
	 			System.out.println("login not clickable");
	 		}
	  		//reglogin.ClickOnLoginBtn();
	        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0004A-image2.jpg");
	        Thread.sleep(3000);
	        //System.out.println(reglogin.RegisterPageMess());
	        String expected = "Hello testcase0004 (not testcase0004? Log out)" ;
	        System.out.println(expected);

	        String actual = reglogin.LoginPageMess();
	        AssertJUnit.assertEquals(expected, actual);
	        
	        Thread.sleep(3000);
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

	
