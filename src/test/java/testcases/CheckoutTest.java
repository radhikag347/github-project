package testcases;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.io.File;
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
import pages.PdtAddCart;

public class CheckoutTest {

	WebDriver driver;
	PdtAddCart pdt;	
	Checkout chckout;
	
	private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;
    @BeforeSuite
    public void setUpReport()
    {
        //create the HtmlReporter in that path by the name of  SearchReport.html
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
                + "/test-output/CheckoutPageTest.html");
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
	
	@Test(priority = 1, testName = "TC - 0010", enabled = false)
    public void creditdebit() throws IOException, InterruptedException {
		test = extent.createTest("verify_creditdebit", "Test Passed");
        pdt = new PdtAddCart(driver);
        Actions action = new Actions(driver);
 		action.sendKeys(Keys.PAGE_DOWN).build().perform();
 		
 		//Thread.sleep(3000);
 		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00010A-image1.jpg");
 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20, 1));
		WebElement elementAbout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Smartphone 6S 32GB LTE']")));
 		
		pdt.phone1Click();
		
 		Actions action2 = new Actions(driver);
 		action2.sendKeys(Keys.PAGE_DOWN).build().perform();
 		pdt.Entquantdisp();
 		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00010A-image2.jpg");
 		pdt.addtocart();
 		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00010A-image3.jpg");
 		pdt.Viewcartcl();   
	
 		 		
 		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20, 1));
		WebElement elementAbout1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='checkout-button button alt wc-forward']")));
		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00010A-image4.jpg");
		chckout = new Checkout(driver);
 		chckout.protocheck();
 		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00010A-image5.jpg");
 		chckout.chkout();
 		
 		System.out.println(chckout.ccc());
 		String actual = chckout.ccc();
   		String expected = "Credit card / debit card";
   		
   	    AssertJUnit.assertEquals(expected, actual);
        Thread.sleep(3000);  
	
	}
	
	
	 @Test(priority = 2, testName = "TC - 00011", enabled = true)
	    public void placeorder() throws IOException, InterruptedException {
		 test = extent.createTest("verify_placeorder", "Test Passed");    
		 pdt = new PdtAddCart(driver);
	        chckout = new Checkout(driver);
	        Actions action = new Actions(driver);
	 		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	 		
	 		 Thread.sleep(3000);
	 		
	 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20, 1));
			WebElement elementAbout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Smartphone 6S 32GB LTE']")));
	 		
	 		//add product1
	 		pdt.phone1Click();
	 		pdt.Entquantdisp();
	 		pdt.addtocart();
	 		
	 		//add product2 
	 		
	 		pdt.smartphones();
	 		
	  		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	 		pdt.phone2Click();
	 		 Thread.sleep(3000);
	 		
	  		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20, 1));
			WebElement elementAbout1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='pa_brands']")));
	 		pdt.selectbrand();
	 		
	  		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	 		pdt.selectcolor();
	 		pdt.selectsize();
	 		pdt.Entquantdisp2();
	 		pdt.Viewcartcl();   
	 		
	 		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	 		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20, 1));
			WebElement elementAbout2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='checkout-button button alt wc-forward']")));
	 		
		
			RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00011A-image7.jpg");
		
	 		chckout.protocheck();
	 		
	 		chckout.bilfname("Firstname");
	 		chckout.billname("lastname");
	 		chckout.bilstname("Lascollinas");
	 		chckout.bilcity("Irving");
	 		//chckout.bilstate("New York");
	 		chckout.zipcode("75063");
	 		chckout.phone("1234566789");
	 		
	 		action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(5000);
			RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00011A-image8.jpg");
	 		chckout.emailid("radhikag347@gmail.com");
	 			 
			Thread.sleep(5000);
			driver.switchTo().frame(0);
			
			chckout.ccinfo();
		    Thread.sleep(5000);
		    
			chckout.exp();
			chckout.cvc();
			
			driver.switchTo().parentFrame();
		    
	 		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	 		//WebElement checkbox = driver.findElement(By.xpath("//input[@id='terms']"));
			WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(60, 1));
			WebElement checkbox = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='terms']")));
			
			chckout.checkbox();
		    Thread.sleep(5000);
		    RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00011A-image9.jpg");
		    int attempts = 0;
	        while (attempts < 2) {
	            try {
	            	chckout.placeorder();
	                break;
	            } catch (StaleElementReferenceException e) {
	                // Handle the exception or log it
	            }
	            attempts++;
	        }
	        
	        
	        String actual = chckout.ordrec();
	        String expected = "Order received";
	        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC00011A-image10.jpg");
	        AssertJUnit.assertEquals(expected, actual);
	        Thread.sleep(3000);
	 }	
}
