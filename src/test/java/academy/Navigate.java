package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobjects.HomePage;
import resources.Base;

public class Navigate extends Base
{
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Navigate.class.getName());  
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
	HomePage hp = new HomePage(driver);
//	hp.clickLogin();
//	hp.Login().click();
    Assert.assertEquals("FEATURED COURSES123",hp.courses().getText());
    Assert.assertTrue(hp.navigationBar().isDisplayed());
    log.info("Navigation Bar is ddisplayed");
    System.out.println("Navigation Bar is ddisplayed--syso");
}

@AfterTest
public void tearDown()
{
	driver.quit();
}
}
