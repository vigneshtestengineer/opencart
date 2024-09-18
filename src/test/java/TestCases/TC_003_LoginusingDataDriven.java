package TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import TestBase.BaseClass;

public class TC_003_LoginusingDataDriven extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProvider.class)
	public void test_logindatadriver(String email, String password, String status, String expected) {
		
		logger.info("****Starting TC_003_LoginusingDataDriven*****");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickaccount();
		hp.clicklogin();
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(email);
		lp.setPwd(password);
		lp.clickloginbtn();
		
		MyAccountPage afterlogin=new MyAccountPage(driver);
		boolean jumptoaccountpage=afterlogin.isMyAccountPageExist();
		
		if(expected.equals(("Valid"))) {
			
			if(jumptoaccountpage==true) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
	if(expected.equals(("Invalid"))) {
			
			if(jumptoaccountpage==true) {
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e){
			Assert.fail();
		}
	
	}

}
