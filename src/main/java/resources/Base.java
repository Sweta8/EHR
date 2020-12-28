package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
	    prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\swetas\\Documents\\Java_Selenium\\Eclispe_Workspace\\EHR\\data.properties");
		prop.load(fis);
		String value=prop.getProperty("browser");
		if(value.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\swetas\\Documents\\Java_Selenium\\chromedriver_win32 (2)\\chromedriver.exe");
		    driver=new ChromeDriver();
			
		}
		if(value.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\swetas\\Documents\\Java_Selenium\\geckodriver-v0.27.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		if(value.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\swetas\\Documents\\Java_Selenium\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	org.apache.commons.io.FileUtils.copyFile(src, new File(destinationFile));
	return destinationFile;
	
}

}
