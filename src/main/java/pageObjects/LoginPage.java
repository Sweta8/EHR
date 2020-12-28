package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By emailAddress=By.xpath("//input[@type='email']");
	By password=By.id("user_password");
	By loginButton=By.cssSelector("input[value='Log In']");
	By forgotPassWord=By.linkText("Forgot Password?");
	
	public WebElement getEmailAddress()
	{
		return driver.findElement(emailAddress);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElement(loginButton);
	}
	
	
	public ForgotPassWordPage getForgotPassword()
	{
		 driver.findElement(forgotPassWord).click();
		 return new ForgotPassWordPage(driver);
	}

}
