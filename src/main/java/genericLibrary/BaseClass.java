package genericLibrary;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {

	public PropertyFileLibrary pLib = new PropertyFileLibrary();
	public ExcelFileLibrary eLib = new ExcelFileLibrary();
	public JavaLibrary jLib = new JavaLibrary();
	public WebDriverLibrary wLib = new WebDriverLibrary();
	public WebDriver driver = null;

	@BeforeSuite
	public void bsConfig() {

		System.out.println("database connected sucessfully");
	}

	@BeforeClass
	public void bcConfig() throws IOException {
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");

		if (BROWSER.equalsIgnoreCase("chrome")) {

	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Browser launched sucessfully ->" + BROWSER);
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Browser launched sucessfully ->" + BROWSER);
		} else {
			System.out.println("invalid browser name");
		}

		wLib.maximiseWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
	}

	@BeforeMethod
	public void bmConfig() throws IOException {
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("--- login is sucessfull ---");

	}

	@SuppressWarnings("unused")
	@AfterMethod
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		System.out.println("--- Logout sucessfull ---");
	}

	@AfterClass
	public void acConfing() throws Exception {
		Thread.sleep(10000);
		// driver.quit();
		System.out.println("browser closed successfully");
	}

	@AfterSuite
	public void asConfig() {
		System.out.println("database closed sucessfully");
	}

}
