package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),\"Login\")]")
	WebElement loginbutton;
	@FindBy(xpath="//h2[contains(text(),'Featured Courses')]")
	WebElement courses;
	@FindBy(xpath="//nav[@class='navbar-collapse collapse']")
	WebElement navigationbar;
	

	
	public WebElement Login()
	{
		return loginbutton;
	}
	
	public void clickLogin()
	{
		 loginbutton.click();
	}
	public WebElement courses()
	{
		return courses;
	}
	public WebElement navigationBar()
	{
		return navigationbar;
	}
	
	
}