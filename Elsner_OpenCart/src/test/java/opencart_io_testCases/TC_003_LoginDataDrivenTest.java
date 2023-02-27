package opencart_io_testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart_io_Utilities.DataProviders;
import opencart_io_pageObject.HomePage;
import opencart_io_pageObject.LoginPage;
import opencart_io_pageObject.MyAccountPage;

public class TC_003_LoginDataDrivenTest extends BaseClass{

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class) // if dataProviderClass is at different package.
	public void test_LoginDDT(String email, String pwd, String exp) {
		logger.info(" Starting TC_003_LoginDataDrivenTest ");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickRegister();
			hp.ClickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExists();// this method is created MyAccountPage

			if (exp.equals("Valid")) {
				if (targetpage == true) {
					macc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equals("Invalid")) {
				if (targetpage == true) {
					MyAccountPage myaccpage = new MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_003_LoginDataDrivenTest");

	}


	
	
}
