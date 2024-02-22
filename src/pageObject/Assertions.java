package pageObject;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Assertions  extends Actions {
	public void checkCheckoutSuccess(String message) {
		Assert.assertEquals(driver.findElement(By.className("base")).getText(),message);

	
	}
}
