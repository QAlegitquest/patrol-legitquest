package Patrol.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Patrol.utilities.WaitUtility;

public class DashBoardPage extends BasePage {

	public DashBoardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@id='ajaxStatusDiv']//img")
	private WebElement loadder;
	
	@FindBy(xpath="//span[normalize-space()='Dashboard']") 
	WebElement dashboard;

	@FindBy(xpath = "//span[text()='Manage Cases']")
	private WebElement manageCases;
	
	@FindBy(xpath = "//span[text()='Cases']")
	private WebElement casesLink;
	
	@FindBy(xpath = "//span[text()='Notification']")
	private WebElement notificationLink;

	@FindBy(xpath = "//span[text()='Alerts']")
	private WebElement alertsLink;
	
	@FindBy(xpath = "//button[text()='Graphical View']")
	private WebElement graphicalViewTab;
	
	@FindBy(xpath = "//button[text()='Personal dashboard']")
	private WebElement personalDashboardTab;
	
	@FindBy(xpath = "//button[text()='Fisrm Feed']")
	private WebElement firmFeedTab;
	
	@FindBy(xpath="//a[@href='https://patrol.legitquest.com/cases']//span[@class='me-2'][normalize-space()='View All']")  
	WebElement viewAllCases;
	
	@FindBy(xpath="//a[@href='https://patrol.legitquest.com/clients']//span[@class='me-2'][normalize-space()='View All']")  
	WebElement viewAllContacts;
	
	@FindBy(xpath="//a[@href='https://patrol.legitquest.com/documents']//span[@class='me-2'][normalize-space()='View All']")  
	WebElement viewAllDocuments;
	
	@FindBy(xpath="//a[@href='https://patrol.legitquest.com/matters']//span[@class='me-2'][normalize-space()='View All']")  
	WebElement viewAllMatters;
	
	@FindBy(xpath="//a[@href='https://patrol.legitquest.com/tasks']//span[@class='me-2'][normalize-space()='View All']")  
	WebElement viewAllTasks;
	
	@FindBy(xpath="//a[@href='https://patrol.legitquest.com/invoice']//span[@class='me-2'][normalize-space()='View All']")  
	WebElement viewAllInvoice;
	
	@FindBy(xpath="//h1[normalize-space()='Cases']")  
	WebElement cases;
	
	@FindBy(xpath="//h1[normalize-space()='Contacts']")  
	WebElement contacts;
	
	@FindBy(xpath="//h1[normalize-space()='Document']")  
	WebElement document;
	
	@FindBy(xpath="//h1[normalize-space()='Matter']") 
	WebElement matter;
	
	@FindBy(xpath="//h1[normalize-space()='Tasks']")  
	WebElement tasks;
	
	@FindBy(xpath="//h1[normalize-space()='Invoice']")  
	WebElement invoice;

	
	public boolean isGraphicalViewTabVisible(){
		return WaitUtility.waitForElementToBeVisible(driver, graphicalViewTab);
	}
	
	public boolean isPersonalDashboardTabVisible(){
		return WaitUtility.waitForElementToBeVisible(driver, personalDashboardTab);
	}
	
	public boolean isFirmFeedTabVisible(){
		return WaitUtility.waitForElementToBeVisible(driver, firmFeedTab);
	}
	
	public void clickOndashboard() {
		WaitUtility.waitForElementToBeInvisible(driver,loadder);
		WaitUtility.waitForElementToBeClickable(driver, dashboard);
		dashboard.click();
	}

	public void clickOnManageCases() {
		WaitUtility.waitForElementToBeInvisible(driver,loadder);
		WaitUtility.waitForElementToBeClickable(driver, manageCases);
		manageCases.click();
	}

	public void clickAlertsLink() {
		WaitUtility.waitForElementToBeClickable(driver, alertsLink);
		alertsLink.click();
	}

	public void clickCasesLink() {
		WaitUtility.waitForElementToBeClickable(driver, casesLink);
		casesLink.click();
	}
	
	public void clickNotificationCasesLink() {
		WaitUtility.waitForElementToBeClickable(driver, casesLink);
		notificationLink.click();
	}
	
	public void clickOnviewAllCases() {
		WaitUtility.waitForElementToBeClickable(driver, viewAllCases);
		viewAllCases.click();
	}
	
	public void clickOnviewAllMatters() {
		WaitUtility.waitForElementToBeClickable(driver, viewAllMatters);
		viewAllMatters.click();
	}
	
	public void clickOnviewAllContacts() {
		WaitUtility.waitForElementToBeClickable(driver, viewAllContacts);
		viewAllContacts.click();
	}
	
	public void clickOnviewAllDocuments() {
		WaitUtility.waitForElementToBeClickable(driver, viewAllDocuments);
		viewAllDocuments.click();
	}
	
	public void clickOnviewAllTasks() {
		WaitUtility.waitForElementToBeClickable(driver, viewAllTasks);
		viewAllTasks.click();
	}
	
	public void clickOnviewAllInvoice() {
		WaitUtility.waitForElementToBeClickable(driver, viewAllInvoice);
		viewAllInvoice.click();
	}
	
	public boolean isAllCasesVisible(){
		return WaitUtility.waitForElementToBeVisible(driver, cases);
	}
	
	public boolean isAllMattersVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, matter);
	}
	
	public boolean isAllDocumentsVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, document);
	}
	
	public boolean isAllTasksVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, tasks);
	}
	
	public boolean isAllContactsVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, contacts);
	}
	
	public boolean isAllInvoicesVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, invoice);
	}
}
