package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import genericLibrary.WebDriverLibrary;

public class HomePage extends WebDriverLibrary {

	// Declaration
	@FindBys({ @FindBy(xpath = "//a[@class='main-menu-icon']/i"),
			@FindBy(xpath = "//*[@id=\"header\"]/div/header/div[1]/ul/li[1]/a/i") })
	private WebElement menuIconBtn;

	@FindBy(linkText = "Workflow")
	private WebElement workflowBtn;

	@FindBy(partialLinkText = "Client")
	private WebElement clientBtn;

	@FindBy(xpath = "//li[@class='user-profile dropdown open']")
	private WebElement profileImg;

	@FindBy(linkText = "Logout")
	private WebElement logoutBtn;

	// Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getMenuIconBtn() {
		return menuIconBtn;
	}

	public WebElement getWorkflowBtn() {
		return workflowBtn;
	}

	public WebElement getClientBtn() {
		return clientBtn;
	}

	public void setClientBtn(WebElement clientBtn) {
		this.clientBtn = clientBtn;
	}

	public WebElement getProfileImg() {
		return profileImg;

	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	// Business Library
	/**
	 * This Method will Navigate to WorkFlow Cursors.
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public void clickWorkFlowLnk(WebDriver driver) throws InterruptedException {
		menuIconBtn.click();
		mouseHoverOn(driver, workflowBtn);
		workflowBtn.click();
	}

	/**
	 * This Method will Navigate to Client Cursors.
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public void clickClent(WebDriver driver) throws InterruptedException {
		mouseHoverOn(driver, menuIconBtn);
		clientBtn.click();
	}
}