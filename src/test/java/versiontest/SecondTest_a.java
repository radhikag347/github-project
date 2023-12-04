package versiontest;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondTest_a 
{
	
 WebDriver driver;
 
  @BeforeTest
  public void openApp()
 
  {
	 // WebDriverManager.chromedriver().setup();
	  System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver\\chromedriver-win64\\chromedriver.exe");
	  //driver=new ChromeDriver();
	  ChromeOptions options = new ChromeOptions();

	  options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		 options.addArguments("--remote-allow-origins=*");
		 
		 
		 driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().window().maximize();
  }
  
  
  @Test
  public void login() throws InterruptedException
  
	{
	  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	  Thread.sleep(5000);
	
	 /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));*/
	   // driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
	}
  
  @AfterTest
  public void close()
  
	{
	  	  driver.close();
	}
	
}

