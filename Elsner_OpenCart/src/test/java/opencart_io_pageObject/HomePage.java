package opencart_io_pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
// Under Page Object Class - create a constructor
	public HomePage(WebDriver driver) {
        // Inheritance super recall the parent class method or constructor  
		super(driver); // call Parent Class(BasePage)constructor
// Or we have write the Following constructor 
//		public BasePage(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}
	}
//Create Elements
	
	@FindBy(xpath ="//a[normalize-space()='Register']")
	WebElement linkRegister ;
	
	@FindBy(xpath="//a[normalize-space()='Log in']")
	WebElement LinkLogin ;
	
//Action Methods
	
	public void clickRegister() {
		linkRegister.click();
	}
	
	public void ClickLogin() {
		LinkLogin.click();
	}
}
