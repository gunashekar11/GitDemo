package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginCase extends Base
{
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(LoginCase.class.getName());  
	@BeforeTest
	public void initializeBrowser() throws IOException
	{

		driver=openBrowser();
		driver.get(prop.getProperty("url"));
		log.info("Browser Opened!!");
	}	
	
@Test
public void Navigate() 
{

	HomePage hop = new HomePage(driver);
	hop.Login().click();
	LoginPage lop = new LoginPage(driver);
	lop.Username().sendKeys("Testing123@gmail.com");
	lop.Password().sendKeys("Tester@123");
	lop.Submit().click();
	log.info("Page is navigated!!");
	
}

@AfterTest
public void tearDown()
{
	driver.quit();
}
}
