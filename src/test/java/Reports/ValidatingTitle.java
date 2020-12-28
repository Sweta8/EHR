package Reports;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidatingTitle extends Base {
	
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initaize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@Test
	public void BaseNavigation() throws IOException
	{
		
		LandingPage lp=new LandingPage(driver);
		Assert.assertEquals(lp.getFeaturedCoursesTitle().getText(), "FetauredCourses");
		log.error("Vaildate Corses");
	}
	
	

}
