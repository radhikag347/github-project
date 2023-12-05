package lib;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class SelectBrowser {
    static WebDriver driver;
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    public static WebDriver StartBrowser(String browsername) throws InterruptedException {
        // ---If the browser is Firefox----
        if (browsername.equalsIgnoreCase("Firefox")) {
            // Set the path for geckodriver.exe
        	System.setProperty("webdriver.gecko.driver", "C:\\driver\\firefoxdriver\\geckodriver.exe");	
    		
            // Instantiate a driver
        	 FirefoxOptions options = new FirefoxOptions();
             driver = new FirefoxDriver(options);

             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     		//2) open url on the browser
     		//driver.get("https://demo.perscholastraining.com/my-account-2/");
     		
        }
        //---- If the browser is Chrome--
        else if (browsername.equalsIgnoreCase("Chrome")) {
          System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver\\chromedriver-win64\\chromedriver.exe");
       	  
       	  ChromeOptions options = new ChromeOptions();
       	  options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
          options.addArguments("--remote-allow-origins=*");
         
       		driver=new ChromeDriver(options);
       		
       		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       	   // driver.get("https://demo.perscholastraining.com/my-account-2/");
       	 

        }
        // ----If the browser is  EdgeIE----
        else if (browsername.equalsIgnoreCase("EdgeExplore")) {
            // Set the path for IEdriver

        	System.setProperty("webdriver.edge.driver", "C:\\driver\\edgedriver\\msedgedriver.exe");
        	//Instantiate a EdgeDriverclass:    
        	  EdgeOptions options = new EdgeOptions();
        	  options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        	  options.addArguments("--remote-allow-origins=*");
        	           		 
        	  driver = new EdgeDriver(options);        				 
        	  //2) open url on the browser
        	 // driver.get("https://demo.perscholastraining.com/my-account-2/");
        	  
          }
        
             driver.manage().window().maximize();
             Thread.sleep(5000);
             return driver;
             
    }


}

