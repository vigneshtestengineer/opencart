package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TestBase.BaseClass;

public class MyAccountPage extends BaseClass{
	
	public MyAccountPage(WebDriver driver) {
		super();
	}
	
	@FindBy(xpath ="//*[@id=\'content\']/div/div[1]/div/div/h2")
	WebElement headermyaccount;
	
	public boolean isMyAccountPageExist()
	{
		try {
			return(headermyaccount.isDisplayed());
		}catch(Exception e) {
			return(false);
		}
	}

}
