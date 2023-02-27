package opencart_io_pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[normalize-space()='My account - Customer info']") // MyAccount Page heading
	WebElement msgHeading;

	@FindBy (xpath = "//a[normalize-space()='Log out']")
	WebElement linkLogout;
	
	
	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickLogout()
	{
		linkLogout.click();
	}
	
}