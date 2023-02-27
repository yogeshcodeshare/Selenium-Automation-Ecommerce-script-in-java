package opencart_io_testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;

	public Logger logger; // for logging log import the apache.log4j2

	public ResourceBundle rb; // import with java.util

	// Reuseable methode
	// Setup method
	@BeforeClass(groups = {"Regression","Sanity","Master"})
	@Parameters("browser")
	public void setup(String br) {

		rb = ResourceBundle.getBundle("config"); // this load the Config.properties file

		// logging
		logger = LogManager.getLogger(this.getClass()); // this give the current class

		// disable the message - chrome is run by some external software.
		// ChromeOptions options = new ChromeOptions();
		// options.setExperimentalOption("excludeSwitches",new String[]
		// {"enable-automation"});

		// WebDriverManager.chromedriver().setup();
		if (br.equals("chrome")) {
			driver = new ChromeDriver();
		} 
		else if (br.equals("edge")) 
		{
			driver = new EdgeDriver();
		} 
		else {
			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(rb.getString("webURL"));
		driver.manage().window().maximize();
	}

	// Window closed.
	@AfterClass (groups = {"Regression","Sanity","Master"})
	public void closedBrowser() {
		driver.quit();
	}

	// Genrate the randome string,Data
	public String randomString() {
		// RandomStringUtils is class form come throught lang3 dependency
		String genratedString = RandomStringUtils.randomAlphabetic(5);
		return (genratedString);
	}

	// randomAlphabetic / randomNumeric method in the RandomStringUtils class
	// randomAlphabetic genrate the random string of 5 character
	public String randomNumber() {
		String genratedString2 = RandomStringUtils.randomNumeric(10);
		return (genratedString2);
	}

	// randomNumeric genrate a unique 10 digits number. but this number in string
	// Format
	public String randomAplhaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(5);
		String num = RandomStringUtils.randomNumeric(10);
		return (str +"@"+ num);
	}
	
	// Capture the screen shot
	public String captureScreen(String tname) throws IOException {

		/* // Import the SimpleDateFormat from java.txt
		SimpleDateFormat df = new SimpleDateFormat(); // create Object
		// import the DAte From java.Util package
		Date dt = new Date();
		String timeStamp = df.format(dt);
		*/
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			// import FileUtils appache.common.io
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
	
	
	
}
