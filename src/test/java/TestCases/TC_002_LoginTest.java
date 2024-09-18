package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import TestBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void login_test()
	
	{
		try
		{
		logger.info("_____________Starting TC_002_LoginTest____________ ");
		
		HomePage hp=new HomePage(driver);
		
		hp.clickaccount();
		logger.info("Account menu is clicked");
		hp.clicklogin();
		logger.info("Login menu is clicked");
		
		LoginPage lp=new LoginPage(driver);
		logger.info("Providing login details");
		lp.setEmail(rb.getString("email"));
		lp.setPwd(rb.getString("password"));
		lp.clickloginbtn();
		
		logger.info("Login button is clicked");
		
		MyAccountPage afterlogin=new MyAccountPage(driver);
		boolean jumptoaccountpage=afterlogin.isMyAccountPageExist();
		Assert.assertEquals(jumptoaccountpage, true);
		}catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("______________TC_002_LoginTest ended________________");
		
	}
	

	
	

}
