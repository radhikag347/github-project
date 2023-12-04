package testcases;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lib.RunReports;
import lib.SelectBrowser;
import pages.PdtAddCart;
//import pages.Registration;

public class PdtAddCarttest {

	WebDriver driver;
	PdtAddCart pdt;

	private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;
    @BeforeSuite
    public void setUpReport()
    {
        //create the HtmlReporter in that path by the name of  SearchReport.html
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
                + "/test-output/pdtaddcartTest.html");
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

    @Test(priority = 1, testName = "TC - 0005", enabled = false)
    public void productpriceview() throws IOException, InterruptedException {
    	test = extent.createTest("verify_productprice", "Test Passed");
        pdt = new PdtAddCart(driver);
        Actions action = new Actions(driver);
 		action.sendKeys(Keys.PAGE_DOWN).build().perform();
 		
 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20, 1));
		WebElement elementAbout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Smartphone 6S 32GB LTE']")));
		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0005A-image1.jpg");
 		pdt.phone1Click();
 		action.sendKeys(Keys.PAGE_DOWN).build().perform(); 
      //  Thread.sleep(3000);
 		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0005A-image2.jpg");
        String actual = pdt.phone1pricetext();
        String expected = "$1,215.00";
        System.out.println(actual);

        AssertJUnit.assertEquals(expected, actual);
        Thread.sleep(3000);
    }
		
    @Test(priority = 2, testName = "TC - 0006", enabled = false)
    public void productquntadd() throws IOException, InterruptedException {
    	test = extent.createTest("verify_productquantityadded", "Test Passed");
        pdt = new PdtAddCart(driver);
        Actions action = new Actions(driver);
 		action.sendKeys(Keys.PAGE_DOWN).build().perform();
 		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0006A-image1.jpg");
 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20, 1));
		WebElement elementAbout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Smartphone 6S 32GB LTE']")));
		pdt.phone1Click();
 		pdt.Entquantdisp();
 		
 		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0006A-image2.jpg");
 		  
      //  Thread.sleep(3000);
 		
        String actual = pdt.Entquantdisp();
        String expected = "2";
        System.out.println(actual);

        AssertJUnit.assertEquals(expected, actual);
        Thread.sleep(3000);
    }
		
    @Test(priority = 3, testName = "TC - 0007", enabled = false)
    public void productquntadddble() throws IOException, InterruptedException {
    	test = extent.createTest("verify_2productsadded", "Test Passed");
        pdt = new PdtAddCart(driver);
        Actions action = new Actions(driver);
 		action.sendKeys(Keys.PAGE_DOWN).build().perform();
 		
 		 Thread.sleep(3000);
 		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0007A-image1.jpg");
 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20, 1));
		WebElement elementAbout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Smartphone 6S 32GB LTE']")));
 		
 		//add product1
 		pdt.phone1Click();
 		pdt.Entquantdisp();
 		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0007A-image2.jpg");
 		pdt.addtocart();
 		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0007A-image3.jpg");
 		//add product2 
 		
 		pdt.smartphones();
 		 Actions action1 = new Actions(driver);
  		action1.sendKeys(Keys.PAGE_DOWN).build().perform();
  		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0007A-image4.jpg");
 		pdt.phone2Click();
 		
  		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20, 1));
		WebElement elementAbout1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='pa_brands']")));
 		pdt.selectbrand();
 		Actions action2 = new Actions(driver);
  		action2.sendKeys(Keys.PAGE_DOWN).build().perform();
 		pdt.selectcolor();
 		pdt.selectsize();
 		pdt.Entquantdisp2();
 		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0007A-image5.jpg");
 		
 		String p = pdt.cartmsgdisp();
 		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0007A-image6.jpg");
 		String[] z = p.split("View cart");
 		//String m = z.toString();
 		String n =z[1].trim();
       System.out.println(n);
       String[] y = {n,pdt.Viewcart2()};
       String[] x = {"2 × “Smartphone 6S 64GB LTE” have been added to your cart.","View cart"};
               
       for(int i=0;i<=1;i++) {
       AssertJUnit.assertEquals(x[i],y[i]);}
      
        //AssertJUnit.assertEquals(expected, actual);
        Thread.sleep(3000);
    }
    
    @Test(priority = 4, testName = "TC - 0008", enabled = false)
    public void cartprdt() throws IOException, InterruptedException {
    	test = extent.createTest("verify_pdtaddcart", "Test Passed");
        pdt = new PdtAddCart(driver);
        Actions action = new Actions(driver);
 		action.sendKeys(Keys.PAGE_DOWN).build().perform();
 		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0008A-image1.jpg");
 		//Thread.sleep(3000);
 		
 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20, 1));
		WebElement elementAbout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Smartphone 6S 32GB LTE']")));
 		
		pdt.phone1Click();
		
 		Actions action2 = new Actions(driver);
 		action2.sendKeys(Keys.PAGE_DOWN).build().perform();
 		pdt.Entquantdisp();
 		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0008A-image2.jpg");
 		pdt.addtocart();
 		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0008A-image3.jpg");
 		pdt.Viewcartcl();   
 		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0008A-image4.jpg");
        Actions action3 = new Actions(driver);
 		action3.sendKeys(Keys.PAGE_DOWN).build().perform();
 		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0008A-image5.jpg");
 		String[] y = {pdt.prdtname(),pdt.quantity(),pdt.subtotal(),pdt.total()};
        String[] x = {"Smartphone 6S 32GB LTE","2","$2,430.00","$2,430.00"};
                
        for(int i=0;i<=3;i++) {
        AssertJUnit.assertEquals(x[i],y[i]);}
       
        Thread.sleep(3000);
    }
		
	    @Test(priority = 5, testName = "TC - 0009", enabled = true)
	    // test if it is used a valid email in order to create an account
	    public void removeitem() throws IOException, InterruptedException {
	    	test = extent.createTest("verify_removepdt", "Test Passed");
	    	pdt = new PdtAddCart(driver);
	    	Actions action = new Actions(driver);
	   		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	   		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0009A-image1.jpg");
	   		 Thread.sleep(3000);
	   		
	   		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20, 1));
	  		WebElement elementAbout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Smartphone 6S 32GB LTE']")));
	   		
	   		//add product1
	   		pdt.phone1Click();
	   		pdt.Entquantdisp();
	   		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0009A-image2.jpg");
	   		pdt.addtocart();
	   		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0009A-image3.jpg");
	   		pdt.Viewcartcl();  
	   		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0009A-image4.jpg");
	   		pdt.deleteitem();
	   		
	   		String actual = pdt.cartempty();
	   		String expected = "Your cart is currently empty.";
	   		RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC0009A-image5.jpg");
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
