package pageObject;

import java.util.List;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import support.extentReportClass;



public class Actions  {
	
	static public WebDriver driver; 
	public void selectBrowser() {
		System.out.println("Enter the number of the browser you want to run the code on");
		System.out.println( "1 Chrome");
		System.out.println( "2 Firefox");
		System.out.println( "3 Edge");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		switch(number) {
		case 1:
		    driver= new ChromeDriver(); 
		    break;
		case 2:
			 driver= new FirefoxDriver(); 
			 break;
	    case 3:
		    driver= new EdgeDriver(); 
		    break; 
	}
		}
	
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void openWebsite() {
		driver.get("https://magento.softwaretestingboard.com/");
	}
	public void typeSearchInputField(String product) {
		driver.findElement(By.id("search")).sendKeys(product + Keys.ENTER);
	}
	public void clickOnRandomProduct() {
		
		List<WebElement> items=driver.findElements(By.cssSelector(".product-items .item "));
        int rnd = (int)(Math.random()*items.size());
        items.get(rnd).click();}

        public void selectProductSize() {
    		
        	driver.findElements(By.cssSelector(".swatch-option.text")).get(1).click();
    		}
    		
 
        public void selectProductColor() {
    		driver.findElements(By.cssSelector(".swatch-option.color")).get(0).click();
    		}
           	
    	public void enterProductQuantity(String qty) {
    	WebElement item	=driver.findElement(By.id("qty"));
    	item.clear();
    	item.sendKeys(qty);
    	}
    	public void clickOnAddToCartButton() {
   		 driver.findElement(By.id("product-addtocart-button")).click();
   	}
      	public void clickOnShoppingcCartIcon() {
      		driver.findElement(By.className("showcart")).click();
      	}
     	public void clickOnProceedToCheckoutButton() {
      		 driver.findElement(By.id("top-cart-btn-checkout")).click();
      		
      	}
    	public void enterEmailAddress(String email) {
     		 driver.findElement(By.id("customer-email")).sendKeys(email);
     		
     	}
    	public void enterFirstName(String firstName) {
    		 driver.findElement(By.name("firstname")).sendKeys(firstName);
    		
    	}
    	public void enterLastName(String lastName) {
   		 driver.findElement(By.name("lastname")).sendKeys(lastName);
   		
   	}
    	public void enterCompanyName(String companyName) {
      		 driver.findElement(By.name("company")).sendKeys(companyName);
      		
      	}
   
    	public void enterAddress1(String add1) {
    		 driver.findElement(By.name("street[0]")).sendKeys(add1);
    		
    	}
     	public void enterAddress2(String add2) {
    		 driver.findElement(By.name("street[1]")).sendKeys(add2);
    		
    	}
    	public void enterAddress3(String add3) {
   		 driver.findElement(By.name("street[2]")).sendKeys(add3);
   		
   	}
    	public void enterCity(String cityName) {
      		 driver.findElement(By.name("city")).sendKeys(cityName);
      		
      	}
    	public void selectState() {
     		WebElement element= driver.findElement(By.name("region_id"));
    		Select dropdown = new Select(element);
    		dropdown.selectByIndex(2);    
    		}
    	
    	public void enterPostCode(String postCode) {
     		 driver.findElement(By.name("postcode")).sendKeys(postCode);
     		
    	}
	public void selectCountry() {
 		WebElement element= driver.findElement(By.name("country_id"));
		Select dropdown = new Select(element);
		dropdown.selectByIndex(1);    
		}
	public void enterPhoneNumber(String telephone) {
		 driver.findElement(By.name("telephone")).sendKeys(telephone);
		
	}
	public void selectShippingMethods() {
	
		driver.findElement(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[2]/td[1]/input")).click();
		
	}
	public void clickOnNextButton() {
  		driver.findElement(By.className("continue")).click();
  	}
	public void clickOnPlaceOrderButton() {
		driver.findElement(By.className("checkout")).click();
  	}
	public void printOrderNumber() {
  	System.out.print(driver.findElement(By.cssSelector(" .checkout-success p>span")).getText());	
	
}
	public void closeBrowser() {
		driver.close();
	}
	
}
 
