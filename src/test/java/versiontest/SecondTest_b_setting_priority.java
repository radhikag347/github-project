package versiontest;

	import org.testng.annotations.Test;
	import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class SecondTest_b_setting_priority 
	{
		
	 WebDriver driver;
	 
	 //s2
	 @BeforeClass
	  public void openApp()
	 
	  {
		 System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver\\chromedriver-win64\\chromedriver.exe");
		  ChromeOptions options = new ChromeOptions();

		  options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		  options.addArguments("--remote-allow-origins=*");
			 
			 
			driver=new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		    driver.manage().window().maximize();	  }
	  
	  //s1
	  @Test(priority=50)
	  public void login()
	  
		{
			driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");
			driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		}
	  
	  
	  //s3
	  @AfterClass
	  public void close()
	  
		{
		  driver.quit();
		}
		
	

}
