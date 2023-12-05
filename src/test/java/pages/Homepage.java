package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lib.SelectBrowser;

public class Homepage {
	
	WebDriver driver;
    
    @FindBy (linkText = "Home")
	//@FindBy(xpath = ("//*[@id=\"menu-item-5472\"]/a"))
    WebElement home;
    
    @FindBy (xpath = ("//div[@id='content']/div/nav/a"))
    WebElement home2;
    
    @FindBy (linkText = "Featured")
    WebElement featured;
    
    @FindBy(css = "div[id='tab-products-1']>div[class='woocommerce columns-3 ']>ul[class*='products products list-unstyled']>li[class*='product type-product post']")
    WebElement featuredisplay;
    
    @FindBy (css = "ul[id='menu-secondary-nav']")
    WebElement menudisplay;
    
    @FindBy (id = "search")
    WebElement searchinput;
    
    @FindBy (xpath = ("//button[@class='btn btn-secondary']/i[@class='ec ec-search']"))
    WebElement searchbutton;
    
    @FindBy(linkText = ("Smartphone 6S 64GB LTE"))
    WebElement phonelink;
    
    @FindBy(className ="h1")
    WebElement recprdt;
		
		
    
    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
		
		
  public void home()
  {
	  home.click();
  }
  
  public void home2()
  {
	  home2.click();
  }
  
  public void featured()
  {
	  featured.click();
  } 
  public String featuredisplay()
  {
	  return featuredisplay.getText();
  } 	
		
  public String menudisplay()
  {
	  List <WebElement> list = driver.findElements(By.cssSelector("ul[id='menu-secondary-nav']"));
		for (WebElement showlist :list)
      {
           System.out.println(showlist.getText());
           
      }
	  return menudisplay.getText();
  } 	
		
  public void searchclear()
  {
  	searchinput.clear();
  }
  public void searchphone(String args)
  {
  	searchinput.sendKeys(args);
  }
			
  public void searchbutton()
  {
  	searchbutton.click();
  }
  
  public String phonelink()
  {
  	return phonelink.getText();
  }	
	
  public String recprdt()
  {
  	return recprdt.getText();
  }	
  
}
