package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// ELEMENTS	
	
	@FindBy(xpath="//*[@id=\'top\']/div[2]/div[2]/ul/li[2]/div/a/span")
	WebElement myaccount;
	
	@FindBy(xpath="//*[@id=\'top\']/div[2]/div[2]/ul/li[2]/div/ul/li[1]/a")
	WebElement register;
	
	@FindBy(xpath="//*[@id=\'top\']/div[2]/div[2]/ul/li[2]/div/ul/li[2]/a")
	WebElement clicklogin;
	
	// Action method
	
	public void clickaccount()
	{
		myaccount.click();
	}
	
	public void clickregister()
	{
		register.click();
	}
	
	public void clicklogin()
	{
		clicklogin.click();
	}


}
