package Patrol.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Patrol.utilities.BrowserUtility;
import Patrol.utilities.WaitUtility;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement Login;

	@FindBy(xpath = "//div[contains(@class,'page-header')]//h1")
	private WebElement header;
	
	@FindBy(xpath = "//a[@id='userDropdown']")
	private WebElement userDropdown;
	
	@FindBy(xpath = "//div[@aria-labelledby='userDropdown']")
	private WebElement userDropdownMenu;
	
    @FindBy(xpath = "//div[@aria-labelledby='userDropdown']//a[contains(normalize-space(.), 'Profile')]")
    private WebElement profileLink;

    @FindBy(xpath = "//div[@aria-labelledby='userDropdown']//a[contains(normalize-space(.), 'Switch Company')]")
    private WebElement switchCompanyLink;

    @FindBy(xpath = "//div[@aria-labelledby='userDropdown']//a[contains(normalize-space(.), 'Settings')]")
    private WebElement settingsLink;

    @FindBy(xpath = "//div[@aria-labelledby='userDropdown']//a[contains(normalize-space(.), 'Logout')]")
    private WebElement logoutLink;

    public void clickOnProfile() {
    	BrowserUtility.click(driver, userDropdown);
    	WaitUtility.waitForElementToBeVisible(driver, userDropdownMenu);
        BrowserUtility.click(driver, profileLink);
    }

    public void clickOnSwitchCompany() {
    	BrowserUtility.click(driver, userDropdown);
    	WaitUtility.waitForElementToBeVisible(driver, userDropdownMenu);
        BrowserUtility.click(driver, switchCompanyLink);
    }

    public void clickOnSettings() {
    	BrowserUtility.click(driver, userDropdown);
    	WaitUtility.waitForElementToBeVisible(driver, userDropdownMenu);
        BrowserUtility.click(driver, settingsLink);
    }

    public void clickOnLogout() {
    	BrowserUtility.click(driver, userDropdown);
    	WaitUtility.waitForElementToBeVisible(driver, userDropdownMenu);
        BrowserUtility.click(driver, logoutLink);
    }
	
	public boolean isEmailFieldVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, email);
	}
	
	public boolean isPasswordFieldVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, password);
	}
	
	public void setEmail(String EmailID) {
		BrowserUtility.sendKeys(driver, email, EmailID, "setEmail");
	}

	public void setPassword(String usrPass) {
		BrowserUtility.sendKeys(driver, password, usrPass, "setPass");
	}

	public void performAction() {
		BrowserUtility.click(driver, Login, "ClickedOnLoginBtn");
	}

	public void login(String EmailId, String usrPass) {
		setEmail(EmailId);
		setPassword(usrPass);
		performAction();
	}
	
	public void logout() {}

	public boolean isLoggedSuccessFull() {
		return WaitUtility.waitForElementToBeVisible(driver, header);
	}
	
	public boolean isLoggedOutSuccessFully() {
		if(driver.getCurrentUrl().equals("https://patrol.legitquest.com/")) {
			return true;
		}else {
			return false;
		}
	}
}