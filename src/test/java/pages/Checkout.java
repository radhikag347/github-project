package pages;

import java.time.Duration;

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


public class Checkout {

    WebDriver driver;
    
     @FindBy (xpath = "//a[@class='checkout-button button alt wc-forward']")
     WebElement protocheck;
		
     @FindBy (className="entry-title")
     WebElement chkout;
			
     @FindBy (xpath = "//label[normalize-space()='Credit card / debit card']")	
	 WebElement ccc; 
     
     @FindBy (id = "billing_first_name")
     WebElement bilfname;
     
     @FindBy (id = "billing_last_name")
     WebElement billname;
     
     @FindBy (id = "billing_address_1")
     WebElement bilstname;
     
     @FindBy (id = "billing_city")
     WebElement bilcity;
     
     @FindBy (id = "billing_state")
     WebElement bilstate;
     
     @FindBy (id = "billing_postcode")
     WebElement zipcode;
     
     @FindBy (id = "billing_phone")
     WebElement phone;
     
     @FindBy (id = "billing_email")
     WebElement emailid;
     
     @FindBy (xpath = "//div[@class='p-Input']/input[@id='Field-numberInput']")
     WebElement ccinfo;	
		
     @FindBy (id = "Field-expiryInput")
     WebElement exp;	
		
     @FindBy (id = "Field-cvcInput")
     WebElement cvc;	
	
     @FindBy (xpath = "//input[@id='terms']")
     WebElement checkbox;	
	
     @FindBy (id = "place_order")
     WebElement placeorder;
	
     @FindBy (xpath = "//h1[contains(text(),'Order received')]")
     WebElement ordrec; 
	    
		
     
     public Checkout(WebDriver driver) {
         this.driver = driver;
         PageFactory.initElements(driver, this);
     }
		
    
    public void protocheck()
    {
    	protocheck.click();
    }
    
    public String chkout()
    {
    	return chkout.getText();
    }
    
    public String ccc()
    {
    	return ccc.getText();
    }
    

    public void bilfname(String args)
    {
		bilfname.sendKeys(args);
    }	
    
    public void billname(String args)
    {
    	billname.sendKeys(args);
    }
    
    public void bilstname(String args)
    {
   	 bilstname.sendKeys(args);
    }
	
    public void bilcity(String args)
    {
   	 bilcity.sendKeys(args);
    }
    
    public void bilstate(String args)
    {
   	 bilstate.sendKeys(args);
   	bilstate.sendKeys(Keys.RETURN);
    }
	
    public void zipcode(String args)
    {
   	 zipcode.sendKeys(args);
    }
		
    public void phone(String args)
    {
   	 phone.sendKeys(args);
    }
	
    public void emailid(String args)
    {
   	 emailid.sendKeys(args);
   	 emailid.sendKeys(Keys.RETURN);
    }
	
    public void ccinfo()
    {
    	ccinfo.sendKeys("4242424242424242");
    }
    
    public void exp()
    {
    	exp.sendKeys("05/26");
    }
    
    public void cvc()
    {
    	cvc.sendKeys("222");
    }
    public void checkbox()
    {
    	checkbox.click();
    }
   
    public void placeorder()
    {
    	placeorder.click();
    }
    public String ordrec()
    {
    	return ordrec.getText();
    }
    
}


   