package opencart_io_pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

// WebElements
//gender radio button
	@FindBy(id = "gender-male")
	WebElement maleRadioButton;

	@FindBy(id = "gender-female")
	WebElement femaleRadioButton;

// registration form

	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement txtfirstname;

	@FindBy(xpath = "//input[@id='LastName']")
	WebElement txtlastname;

	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	WebElement dayDropdown;

	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	WebElement monthDropdown;

	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	WebElement yearDropdown;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement txtemail;

	@FindBy(xpath = "//input[@id='Company']")
	WebElement txtcompanyname;

// neswletter check box code remain
	@FindBy(id = "Newsletter")
	WebElement newsletterCheckbox;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//button[@id='register-button']")
	WebElement btnRegister;

	@FindBy(xpath = "//div[@class='result']")
	WebElement msgRegistrationCompleted;

	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement btnContinue;

// Action Method
// gender radio button Action method

	public void selectGender(String gender) {
		if (gender.equalsIgnoreCase("male")) {
			maleRadioButton.click();
		} else if (gender.equalsIgnoreCase("female")) {
			femaleRadioButton.click();
		} else {
			throw new IllegalArgumentException("Invalid gender: " + gender);
		}
	}

// registration form Action method	
	public void setFirstName(String fname) {
		txtfirstname.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtlastname.sendKeys(lname);
	}

// date of brith dropdown selection Action method
	public void selectDateOfBirth(int day, int month, int year) {
		Select daySelect = new Select(dayDropdown);
		daySelect.selectByValue(String.valueOf(day));

		Select monthSelect = new Select(monthDropdown);
		monthSelect.selectByValue(String.valueOf(month));

		Select yearSelect = new Select(yearDropdown);
		yearSelect.selectByValue(String.valueOf(year));
	}

	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}

	public void setCompanyName(String CompanyName) {
		txtcompanyname.sendKeys(CompanyName);
	}

// newsletter checkbox action method
	 public void setNewsletter(boolean subscribe) {
		    if (newsletterCheckbox.isSelected() != subscribe) {
		      newsletterCheckbox.click();
		    }  
	 }
	
	
	public void setPassword(String psw) {
		txtPassword.sendKeys(psw);
	}

	public void setConfirmPassword(String Confpsw) {
		txtConfirmPassword.sendKeys(Confpsw);
	}

	public void ClickRegistration() {
		btnRegister.click();
	}

	public String getRegistrationCompletedMsg() {
		try {
			return (msgRegistrationCompleted.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public void ClickContinue() {
		btnContinue.click();
	}

}
