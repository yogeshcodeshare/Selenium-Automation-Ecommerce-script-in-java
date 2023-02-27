package opencart_io_testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart_io_pageObject.AccountRegistrationPage;
import opencart_io_pageObject.HomePage;
//import opencart_io_testCases.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

// Actual Method
	@Test(groups= {"Regression","Master"})
	public void test_account_Registration()throws InterruptedException {
	
		logger.debug("application logs....");
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		try {
            
			// create a object class
			HomePage hp = new HomePage(driver);
			hp.clickRegister(); // using this it will click on the registrion tab
			logger.info("Click on the Registration");
			// use account registration page action method
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			
			// gender radio button
			regpage.selectGender("male");
			// registration Action method
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			logger.info("Providing Customer Data");
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			// Date Of brith dropdown
			regpage.selectDateOfBirth(22, 12, 1986);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			regpage.setEmail(randomString() + "@gmail.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			regpage.setCompanyName("Elsner pvt. Ltd., Ahmedabad");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			regpage.setNewsletter(true);
			
			regpage.setPassword("Test@123");
			regpage.setConfirmPassword("Test@123");
			// Another Method generate random PAssword
			/*
			 * String password = randomAplhaNumeric(); store random psw in password variable
			 * regpage.setPassword(password); regpage.setConfirmPassword(password);
			 */
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			regpage.ClickRegistration();
			logger.info("Click on the Registration");
			
			// this method return the confirmation message. so we have compare the message
			// using assertion.
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			String confmsg = regpage.getRegistrationCompletedMsg();
			logger.info("Validating Expected Message");
			Assert.assertEquals(confmsg, "Your registration completed", "Test Failed"); // this is validation
			
			regpage.ClickContinue();
			logger.info("Click on the Continue");
		    } 
		   catch (Exception e) 
		    {
			   logger.error("Test fail");
			Assert.fail();
		    }
		logger.info("*** Finish TC_001_AccountRegistrationTest ***");
	}
}
