package smokeTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import support.extentReportClass;
import pageObject.Actions;
import pageObject.Assertions;
@Listeners
public class checkoutFunctionality extends extentReportClass   {
	Assertions assertion=new Assertions();
	String productName= "shirt";
	 int number = (int)(Math.random()*100);
	String email = "Ayajamal"+number+"@gmail.com";
	String firstName = "Aya ";
	String lastName = "Jamal ";
	String companyName = "IT";
	String add1 = "street 1";
	String add2 = "street 2";
	String add3 = "street 3";
	String cityName = "NewYork";
	String postCode = "12345";
	String phoneNumber = "1234435";

	
	@BeforeSuite
	public void beforeTest() {
	selectBrowser();
	maximizeBrowser();
	openWebsite();
	}
	
	@Test (description = "Checkout functionality")
	public void checkoutFunctionality () throws InterruptedException {
		extentTest =extentReport.createTest("Checkout functionalit");
		extentTest.log(Status.INFO, "Checkout Functionality Test Start");
		extentTest.log(Status.INFO, "Search for product ");
		typeSearchInputField( productName );
		clickOnRandomProduct();
		Thread.sleep(300);
		extentTest.log(Status.INFO, "Select the product options");
		selectProductSize();
		selectProductColor();
		enterProductQuantity("2");
		clickOnAddToCartButton();
		Thread.sleep(300);
        clickOnShoppingcCartIcon();
        clickOnProceedToCheckoutButton();
        Thread.sleep(3000);
        extentTest.log(Status.INFO, "Fill shipping address in fields");
        enterEmailAddress(email);
        Thread.sleep(400);
        enterFirstName(firstName);
        enterLastName(lastName);
        enterCompanyName(companyName);
        enterAddress1(add1);
        enterAddress2(add2);
        enterAddress3(add3);
        enterCity(cityName);
        selectState();
        enterPostCode(postCode);
        selectCountry();
        enterPhoneNumber(phoneNumber);
        selectShippingMethods();
        Thread.sleep(5000);
        clickOnNextButton();
        Thread.sleep(3000);
		clickOnPlaceOrderButton();
		Thread.sleep(3000);
		printOrderNumber();
		assertion.checkCheckoutSuccess("Thank you for your purchase!");
		extentTest.log(Status.INFO, "Checkout Functionality Test End");
		
	}
	
	@AfterSuite
	public void afterTest() {
		closeBrowser();

	}
	

}
