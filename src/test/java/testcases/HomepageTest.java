package testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import lib.RunReports;
import lib.SelectBrowser;
import pages.Checkout;
import pages.Homepage;
import pages.PdtAddCart;


public class HomepageTest {
	
	WebDriver driver;
	PdtAddCart pdt;	
	Checkout chckout;
	Homepage hompg;
	
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;
    @BeforeSuite
    public void setUpReport()
    {
        //create the HtmlReporter in that path by the name of  SearchReport.html
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
                + "/test-output/HomePageTest.html");
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
	    }

	 @Test(priority = 1, testName = "TC - 0012", enabled = false)
	    public void Homepagepdt() throws IOException, InterruptedException {
		 test = extent.createTest("verify_Homepageprdt", "Test Passed");    
		 hompg = new Homepage(driver);
		 hompg.home(); 
		 
	        Actions action = new Actions(driver);
	 		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	 		
	 		hompg.featured();
	 		
	 		List <WebElement> list = driver.findElements(By.cssSelector("div[id='tab-products-1']>div[class='woocommerce columns-3 ']>ul[class*='products products list-unstyled']>li[class*='product type-product post']"));
	 		System.out.println(list.size()+ " products are displayed");
	 		String test=hompg.featuredisplay();
	 		
	 		
	 		int actual = list.size();
	   		int expected = 8;
	   		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00012A-image1.jpg");
	   	    AssertJUnit.assertEquals(expected, actual);
	        Thread.sleep(3000);
	 }
	 
	 @Test(priority = 2, testName = "TC - 0013", enabled = false)
		    public void Homemainmenu() throws IOException, InterruptedException {
		 test = extent.createTest("verify_Homemainmennu", "Test Passed");       
			 hompg = new Homepage(driver);
			 hompg.home();
			 RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00013A-image1.jpg");		 
					 
		 		String actual = hompg.menudisplay();
		   		String expected = " Home About Shop Trending Styles Compare Contact Us FAQ Terms and Conditions Wishlist";
		   		
		   	    AssertJUnit.assertEquals(expected, actual);
		        Thread.sleep(3000);
		   		
		   	   
	 } 
	 
	 @Test(priority = 3, testName = "TC - 0014", enabled = false)
	    public void searchpdthome() throws IOException, InterruptedException {
		 test = extent.createTest("verify_searchpdthome", "Test Passed");       
		 hompg = new Homepage(driver);
		 hompg.home();
		 RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00014A-image1.jpg");		 
		 hompg.searchclear();
		 hompg.searchphone("Smartphone 6S 64GB LTE");
		 RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00014A-image2.jpg");
		 Thread.sleep(5000);
		 
		 hompg.searchbutton();
		 RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00014A-image3.jpg");
		 String actual = hompg.phonelink();
	   	 String expected = "Smartphone 6S 64GB LTE";
	   		
	   	    AssertJUnit.assertEquals(expected, actual);
	        Thread.sleep(3000);
}
	 
	 @Test(priority = 4, testName = "TC - 0015", enabled = true)
	    public void justsearch() throws IOException, InterruptedException {
		 test = extent.createTest("verify_justsearch", "Test Passed");        
		 hompg = new Homepage(driver);
		 hompg.home();
		 RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00015A-image1.jpg");	 
		 hompg.searchclear();
		 		 
		 hompg.searchbutton();
		 RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00015A-image2.jpg");
		 hompg.recprdt();
		 String actual = hompg.recprdt();
	   	 String expected = "Recommended Products";
	   		
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
