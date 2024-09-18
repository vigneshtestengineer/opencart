package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TestBase.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage (WebDriver driver) {
		
		super();
	}
	
	@FindBy(xpath = "//*[@id='input-email\']")
	WebElement loginemail;
	
	@FindBy(xpath = "//*[@id=\'input-password\']")
	WebElement loginpassword;
	
	@FindBy(xpath ="//*[@id=\'form-login\']/button")
	WebElement loginbtn;
	
	public void setEmail(String emailid) {
		loginemail.sendKeys(emailid);
		
	}
	
	public void setPwd(String pwdid) {
		loginpassword.sendKeys(pwdid);	
	}
	
	public void clickloginbtn() {
		loginbtn.click();	
	}

}
