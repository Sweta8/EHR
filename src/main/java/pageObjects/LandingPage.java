package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By signIn=By.xpath("//span[text()='Login']");
	By fetauredCourses=By.xpath("//h2[text()='Featured Courses']");
	
	public LoginPage getSignIn()
	{
		 driver.findElement(signIn).click();
		 return new LoginPage(driver);
	}

	public WebElement getFeaturedCoursesTitle()
	{
		return driver.findElement(fetauredCourses);
	}
}
