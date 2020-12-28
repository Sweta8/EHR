package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassWordPage {
	
	public WebDriver driver;
	
	public ForgotPassWordPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By emailAddress=By.id("user_email");
	By sendMeInstructions=By.cssSelector("input[type='Send Me Instruction']");
	
	public WebElement getEmailAddress()
	{
		return driver.findElement(emailAddress);
	}

	public WebElement sendMeInstructions()
	{
		return driver.findElement(sendMeInstructions);
	}
}
