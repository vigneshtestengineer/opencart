package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AccountRegistrationPage;
import PageObject.HomePage;
import TestBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {
	
	
	
	@Test(groups={"Regression","Master"})
	void test_account_Registration()
	
	{
		logger.debug("*** Log Info ***");
		
		logger.info("****  Started Testing TC_001_AccountRegistration  ****");
		
		try {
		
		HomePage hp=new HomePage(driver);
		
		hp.clickaccount();
		logger.info("****  Clicked Account  ****");
		
		hp.clickregister();
		logger.info("****  Clicked Regsiter  ****");
		
		AccountRegistrationPage AR=new AccountRegistrationPage(driver);
		
		AR.enterfname(randomString());
		
		AR.enterlname(randomString());
		
		String gamil=randomGmail();
		AR.entermail(gamil);
		
		String password=randomAlphaNumeric();
		AR.enterregpwd(password);
		
		AR.selecttandc();
		
		logger.info("****  All values entered in Registration page  ****");
		
		AR.clikcontinue();
		
		logger.info("****  Login has been created  ****");
		
	}
		
		catch(Exception e) {
			
			logger.error("**** Test Case TC_001_AccountRegistration FAILED   ****");
			
			Assert.fail();
		}
	
	
		logger.info("**** Finished Test Case TC_001_AccountRegistration   ****");
		
	}
	
	
	
}
		
	
