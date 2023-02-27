package opencart_io_testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import opencart_io_pageObject.HomePage;
import opencart_io_pageObject.LoginPage;
import opencart_io_pageObject.MyAccountPage;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups= {"Sanity","Master"})
	public void test_Login()
	{
		logger.info("*****Starting TC_002_LoginTest********");
		
		try
		{				
			HomePage hp=new HomePage(driver);
								
			hp.ClickLogin();
			logger.info("Cliked on the Login Link");
			
			LoginPage lp=new LoginPage(driver);
			logger.info("Providing Login Details");
			
			lp.setEmail(rb.getString("email")); // valid email, get it from properties file
			lp.setPassword(rb.getString("password")); // valid password, get it from properties file
			
			lp.clickLogin();
			logger.info("Cliked on Login Button");
			
			lp.clickMyAccount();
			logger.info("Cliked on My Account Button");
			
			MyAccountPage macc=new MyAccountPage(driver);
			
			boolean targetpage=macc.isMyAccountPageExists();
						
			Assert.assertEquals(targetpage, true,"Invalid Credentials");
			
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("******Finished TC_002_LoginTest****");
		
	}
	
	
}