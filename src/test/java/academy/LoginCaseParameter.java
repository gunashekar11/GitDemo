package academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginCaseParameter extends Base
{

	public WebDriver driver;
	@BeforeTest
	public void initializeBrowser() throws IOException
	{

		driver=openBrowser();
		
	}	
	
@Test(dataProvider = "getData")
public void Navigate(String Username,String Password)
{
	// We called the Url here itself, due to socket connection issue
	// Because we are using multiple parameters but we the invoking the browser only once which 
	// is intialized in BeforeTest
	driver.get(prop.getProperty("url"));
	HomePage hop = new HomePage(driver);
	hop.Login().click();
	LoginPage lop = new LoginPage(driver);
	lop.Username().sendKeys(Username);
	lop.Password().sendKeys(Password);
	lop.Submit().click();
	
}

@DataProvider
public Object[][] getData()
{
	// java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
	// To avoid this, alter the size of array
	Object[][] data = new Object[2][2];
	// Declare the first set of data
	data[0][0]="Validuser@gmail.com";
	data[0][1]="ValidPassword";
	// Declare the Second set of data
	data[1][0]="InValiduser@gmail.com";
	data[1][1]="InValidPassword";
	
	return data;
	
}

@AfterTest
public void tearDown()
{
	driver.quit();
}
}


