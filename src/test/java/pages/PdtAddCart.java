package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import lib.SelectBrowser;

public class PdtAddCart {
    WebDriver driver;

    // @FindBy(linkText = "My Account");
    //WebElement MyAccountButton;

   // By MyAccountButton = By.linkText("My Account");
   // By RegisterpageHeading = By.className("entry-title");

    @FindBy (xpath = "//h2[text()='Smartphone 6S 32GB LTE']")
    WebElement phone1;
    
    @FindBy (xpath = "//h2[text()='Smartphone 6S 64GB LTE']")
    WebElement phone2;
    
    @FindBy(linkText = "Smartphones")
    WebElement smartphones;
    
    @FindBy (xpath = "//select[@id='pa_brands']/option[@value='apple']")
    WebElement se;
    
    @FindBy (xpath = "//select[@id='pa_color']/option[@value='gold']")
    WebElement se1;	
    
    @FindBy (xpath = "//select[@id='pa_size']/option[@value='large']")
    WebElement se2;	
        
    @FindBy (xpath = "//span[@class='electro-price']")
    WebElement phone1price;
    
    @FindBy (xpath = "//input[@title='Qty']")
    WebElement dvalue;

    @FindBy(name = "add-to-cart")
    WebElement addtocart;
    
    @FindBy(xpath = "//button[@class='single_add_to_cart_button button alt disabled wc-variation-selection-needed' or type='submit']")
    WebElement subaddtocart;
    
    
    @FindBy(xpath = "//div[@class='woocommerce-message']")
    WebElement cartmsg;
    
     
    @FindBy(linkText = "View cart")
     WebElement viewcartlink;
    
    @FindBy(xpath = "//div[@class='woocommerce-message']/a[@class='button wc-forward']")
    WebElement viewcart2link;

    
    @FindBy(xpath = "//td[@class='product-thumbnail']//img[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail']")
    WebElement prdtimg;
    
    @FindBy (linkText="Smartphone 6S 32GB LTE")
     WebElement prdtname;
    
    @FindBy (xpath = "//input[@title='Qty']")
    WebElement quantity;
    
    @FindBy (xpath="//td[@data-title='Subtotal']/span[@class='woocommerce-Price-amount amount']")
    WebElement subtotal;
    
    @FindBy (xpath="//tr[@class='order-total']/td[@data-title='Total']//span[@class='woocommerce-Price-amount amount']")
    WebElement total;
    
    @FindBy (linkText = "×")
    WebElement deleteitem; 	
    
	@FindBy (xpath = "//div[@class='cart-empty woocommerce-info']")
	 WebElement cartempty;
		
	
    
    
    public PdtAddCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void phone1Click()
    {
        phone1.click();
    }
    
    public void phone2Click()
    {
        phone2.click();
    }
    
    public void smartphones()
    {
    	smartphones.click();
    }
    
    public String phone1pricetext()
    {
    	return phone1price.getText();
    }    
    
    public String Entquantdisp() throws InterruptedException
    {
    	dvalue.clear();
 		Thread.sleep(5000);
 		//dvalue.sendKeys(Keys.NUMPAD2);
 		for(int i=0;i<=2;i++) {
 		dvalue.sendKeys(Keys.ARROW_UP);}
 		Thread.sleep(2000);
 		dvalue.sendKeys(Keys.ARROW_DOWN);
 		return dvalue.getAttribute("value");
    }
    public void Entquantdisp2() throws InterruptedException
    {
    	dvalue.clear();
 		Thread.sleep(5000);
 		//dvalue.sendKeys(Keys.NUMPAD2);
 		for(int i=0;i<=1;i++) {
 		dvalue.sendKeys(Keys.ARROW_UP);}
 		Thread.sleep(2000);
 		dvalue.sendKeys(Keys.ARROW_DOWN);
 		dvalue.sendKeys(Keys.ENTER);
 		//return dvalue.getAttribute("value");
    }
    
    public void addtocart() 
    {
    	addtocart.click();
    }
    
    public void subaddtocart() 
    {
    	subaddtocart.click();
    }
    public String cartmsgdisp() 
    {
    	return cartmsg.getText();
    	 
     }
    public String Viewcart2() 
    {
    	return viewcart2link.getText();
    	 
     }
    
    
    public void Viewcartcl() 
    {
    	viewcartlink.click();
    	 
     }
    public void Viewcartcl2() 
    {
    	viewcart2link.click();
    	 
     }
    
    
    public void selectbrand()
    {
    	se.click();
    	
    }
    public void selectcolor()
    {
    	se1.click();
    	
    }
    public void selectsize()
    {
    	se2.click();
    	
    }
    public String prdtname()
    {
    	return prdtname.getText();
    	
    }
    
    public String quantity()
    {
    	return quantity.getAttribute("value");
    	
    }
    public String subtotal()
    {
    	return subtotal.getText();
    	
    }
    public String total()
    {
    	return total.getText();
    	
    }
    
    public void deleteitem()
    {
    	 deleteitem.click();
    	
    }
    public String cartempty()
    {
    	return cartempty.getText();
    	
    }
}