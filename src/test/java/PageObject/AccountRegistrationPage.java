package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	// ELEMENTS
	
	@FindBy(xpath="//*[@id=\'input-firstname\']")
	WebElement firstname;
	
	@FindBy(xpath ="//*[@id=\'input-lastname\']")
	WebElement lastname;
	
	@FindBy(xpath ="//*[@id=\'input-email\']")
	WebElement mailinput;
	
	@FindBy(xpath ="//*[@id=\'input-password\']")
	WebElement Regsiterpwd;
	
	@FindBy(xpath ="//*[@id=\'form-register\']/div/div/div/input")
	WebElement policybtn;
	
	@FindBy(xpath = "//*[@id=\'form-register\']/div/div/button")
	WebElement continuebtn;
	
	// Action
	
	public void enterfname(String rfname)
	{
		firstname.sendKeys(rfname);
	}
	
	public void enterlname(String rlname)
	{
		lastname.sendKeys(rlname);
	}
	
	public void entermail(String remailid)
	{
		mailinput.sendKeys(remailid);
	}
	
	public void enterregpwd(String rpwd)
	{
		Regsiterpwd.sendKeys(rpwd);
	}
	
	public void selecttandc()
	{
		policybtn.click();
	}
	
	public void clikcontinue()
	{
		continuebtn.click();
	}

}
