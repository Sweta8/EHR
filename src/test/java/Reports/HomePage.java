package Reports;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassWordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@Test(dataProvider="getData")
	public void baseNavigation(String email,String password) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		LandingPage lp=new LandingPage(driver);
		LoginPage l=lp.getSignIn();
		l.getEmailAddress().sendKeys(email);
		l.getPassword().sendKeys(password);
		ForgotPassWordPage fp=l.getForgotPassword();
		fp.getEmailAddress().sendKeys(email);
	}
	
	@DataProvider
	public Object[][] getData(){
		
		return new Object[][]{{"swetacjc@gmail.com","8603189299"},{"ankitamishra","90"}};
	}

}
