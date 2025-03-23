
package Patrol.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Patrol.utilities.BrowserUtility;
import Patrol.utilities.WaitUtility;

public class CasesDetailPage extends BasePage {

	public CasesDetailPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Cases Detail']")
	WebElement caseDetailTab;

	@FindBy(xpath = "//nav[@role='tablist']//a[normalize-space(text())='Matter']")
	WebElement matterTab;

	@FindBy(xpath = "//nav[@role='tablist']//a[normalize-space(text())='Task']")
	WebElement taskTab;

	@FindBy(xpath = "//nav[@role='tablist']//a[normalize-space(text())='Document']")
	WebElement documentTab;

	@FindBy(xpath = "//nav[@role='tablist']//a[normalize-space(text())='Notes']")
	WebElement notesTab;

	@FindBy(xpath = "//nav[@role='tablist']//a[normalize-space(text())='Contact']")
	WebElement contactTab;

	@FindBy(xpath = "//nav[@role='tablist']//a[normalize-space(text())='Calender']")
	WebElement calenderTab;

	@FindBy(xpath = "//nav[@role='tablist']//a[normalize-space(text())='Invoice']")
	WebElement invoiceTab;

	@FindBy(xpath = "//nav[@role='tablist']//a[normalize-space(text())='Related Matters']")
	WebElement relatedMattersTab;

	@FindBy(xpath = "//div[@id='add-matter' and contains(@class,'show')]")
	WebElement matterModal;

	@FindBy(xpath = "//div[@id='add-task' and contains(@class,'show')]")
	WebElement taskModal;

	@FindBy(xpath = "//div[@id='add-document' and contains(@class,'show')]")
	WebElement documentModal;

	@FindBy(xpath = "//div[@id='add-notes' and contains(@class,'show')]")
	WebElement notesModal;

	@FindBy(xpath = "//div[@id='add-contact' and contains(@class,'show')]")
	WebElement contactModal;
	
	@FindBy(xpath = "//div[@id='add-existing-contact' and contains(@class,'show')]")
	WebElement ExistingcontactModal;
	
	
	
//	@FindBy(xpath="//div[@id='add-matter']")
//	WebElement calenderModal;
//	
//	@FindBy(xpath="//div[@id='add-matter']")
//	WebElement invoiceModal;
//	
//	@FindBy(xpath="//div[@id='add-matter']")
//	WebElement relatedMattersModal;
//	
	@FindBy(xpath = "//a[text()='Create Matter']")
	WebElement createMatterBtn;

	@FindBy(xpath = "//button[text()='Save Changes']")
	WebElement matterModalSaveChangesBtn;

	@FindBy(xpath = "//button[text()='Create Task']")
	WebElement createTaskBtn;

	@FindBy(xpath = "//div[@id='add-task' and contains(@class,'show')]//input[@name='task_name']")
	WebElement task_name;

	@FindBy(xpath = "//div[@id='add-task' and contains(@class,'show')]//input[@name='task_description']")
	WebElement task_description;

	@FindBy(xpath = "//div[@id='add-task' and contains(@class,'show')]//textarea[@class='select2-search__field']")
	WebElement assigned_user;

	@FindBy(xpath = "//span[@class='select2-results']")
	WebElement assigned_user_search_result;

	@FindBy(xpath = "//ul[@class='select2-results__options']//li[text()='Krishna Jaiswal']")
	WebElement assigned_user_option_2;

	@FindBy(xpath = "//div[@id='add-task' and contains(@class,'show')]//button[text()='Save changes']")
	WebElement taskModalSaveChangesBtn;

	@FindBy(xpath = "//a[text()='Create Document']")
	WebElement createDocumentBtn;
	@FindBy(xpath = "//div[@id='add-document' and contains(@class,'show')]//input[@name='name']")
	WebElement documentName;
	@FindBy(xpath = "//div[@id='add-document' and contains(@class,'show')]//input[@name='document_date']")
	WebElement documentDate;
	@FindBy(xpath = "//div[@id='add-document' and contains(@class,'show')]//input[@name='description']")
	WebElement documentDescription;
	@FindBy(xpath = "//div[@id='add-document' and contains(@class,'show')]//button[text()='Save changes']")
	WebElement documentModalSaveChangesBtn;

	// Notes

	@FindBy(xpath = "//button[normalize-space()='Create Note']")
	WebElement createNoteBtn;

//	@FindBy(xpath="//div[@class='mb-3 has-error']//input[@name='name']")
//	WebElement note_name;

	@FindBy(xpath = "//div[@id='add-notes' and contains(@class,'show')]//input[@name='name']")
	WebElement note_name;

	@FindBy(xpath = "//div[@id='add-notes' and contains(@class,'show')]//input[@name='note_date']")
	WebElement note_date;

	@FindBy(xpath = "//div[@id='add-notes' and contains(@class,'show')]//input[@name='description']")
	WebElement note_description;

	@FindBy(xpath = "//div[@id='add-notes' and contains(@class,'show')]//button[text()='Save changes']")
	WebElement noteModalSaveChangesBtn;

	// Contacts

	@FindBy(xpath = "//button[@id='contactDropdown']")
	WebElement contactOptions;

	@FindBy(xpath = "//a[normalize-space()='Create Contact']")
	WebElement createContact;

	@FindBy(xpath = "//a[normalize-space()='Existing Contact']")
	WebElement existingContact;
	
	@FindBy(xpath="//select[@id='existingContact']")
	WebElement preExistContact;

	@FindBy(xpath = "//select[@name='client_category']")
	WebElement clientCategory;

	@FindBy(xpath = "//input[@id='name']")
	WebElement contactlName;

	@FindBy(xpath = "//input[@id='email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneNumber;

	@FindBy(xpath = "//input[@id='other_info']")
	WebElement otherInfo;

	@FindBy(xpath = "//input[@id='address']")
	WebElement address;

	@FindBy(xpath = "//form[@id='addContactForm']//button[@type='submit'][normalize-space()='Save changes']")
	WebElement ContactModalSaveChangesBtn;

	public boolean isCaseDetailTabVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, caseDetailTab);
	}

	public void clickOnMatterTab() {
		matterTab.click();
	}

	public void clickOnTaskTab() {
		taskTab.click();
	}

	public void clickOnDocumentTab() {
		documentTab.click();
	}

	public void clickOnNotesTab() {
		notesTab.click();
	}

	public void clickOnContactTab() {
		contactTab.click();
	}

	public void clickOnCalenderTab() {
		calenderTab.click();
	}

	public void clickOnInvoiceTab() {
		invoiceTab.click();
	}

	public void clickOnRelatedMattersTab() {
		relatedMattersTab.click();
	}

	// matter methods
	public void clickOnCreateMatterBtn() {
		BrowserUtility.scrollIntoView(driver, createMatterBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, createMatterBtn);
		createMatterBtn.click();
	}

	public boolean isMatterModalVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, matterModal);
	}

	public boolean isMatterModalHide() {
		return WaitUtility.waitForElementToBeInvisible(driver, matterModal);
	}

	public void clickOnMatterModalSaveChangesBtn() {
		BrowserUtility.scrollIntoView(driver, matterModalSaveChangesBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, matterModalSaveChangesBtn);
		matterModalSaveChangesBtn.click();
	}

	// task methods
	public void clickOnCreateTaskBtn() {
		BrowserUtility.scrollIntoView(driver, createTaskBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, createTaskBtn);
		createTaskBtn.click();
	}

	public boolean isTaskModalVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, taskModal);
	}

	public boolean isTaskModalHide() {
		return WaitUtility.waitForElementToBeInvisible(driver, taskModal);
	}

	public void enterTaskName(String value) {
		BrowserUtility.scrollIntoView(driver, task_name, true);
		task_name.clear();
		task_name.sendKeys(value);
	}

	public void enterTaskDescription(String value) {
		BrowserUtility.scrollIntoView(driver, task_description, true);
		task_description.clear();
		task_description.sendKeys(value);
	}

	public void clickOnAssignedUser() {
		BrowserUtility.scrollIntoView(driver, assigned_user, true);
		WaitUtility.waitForElementToBeClickable(driver, assigned_user);
		assigned_user.click();
	}

	public void clickOn2ndOption() {
		WaitUtility.waitForElementToBeVisible(driver, assigned_user_search_result);
		assigned_user_option_2.click();
	}

	public void clickOnTaskModalSaveChangesBtn() {
		BrowserUtility.scrollIntoView(driver, taskModalSaveChangesBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, taskModalSaveChangesBtn);
		taskModalSaveChangesBtn.click();
	}

	// document methods
	public void clickOnCreateDocumentBtn() {
		BrowserUtility.scrollIntoView(driver, createDocumentBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, createDocumentBtn);
		createDocumentBtn.click();
	}

	public boolean isDocumentModalVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, documentModal);
	}

	public boolean isDocumentModalHide() {
		return WaitUtility.waitForElementToBeInvisible(driver, documentModal);
	}

	public void enterDocumentName(String value) {
		BrowserUtility.scrollIntoView(driver, documentName, true);
		documentName.clear();
		documentName.sendKeys(value);
	}

	public void enterDocumentDate() {
		BrowserUtility.scrollIntoView(driver, documentDate, true);
		documentDate.clear();
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = currentDate.format(formatter);
		documentDate.sendKeys(formattedDate);
	}

	public void enterDocumentDescription(String value) {
		BrowserUtility.scrollIntoView(driver, documentDescription, true);
		documentDescription.clear();
		documentDescription.sendKeys(value);
	}

	public void clickOnDocumentSaveBtn() {
		BrowserUtility.scrollIntoView(driver, documentModalSaveChangesBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, documentModalSaveChangesBtn);
		documentModalSaveChangesBtn.click();
	}

	// Notes Method

	public void clickOncreateNotesBtn() {
		BrowserUtility.scrollIntoView(driver, createNoteBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, createNoteBtn);
		createNoteBtn.click();
	}

	public boolean isNoteModalVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, notesModal);
	}

	public boolean isNoteModalHide() {
		return WaitUtility.waitForElementToBeInvisible(driver, notesModal);
	}

	public void enterNoteName(String value) {
		BrowserUtility.scrollIntoView(driver, note_name, true);
		note_name.clear();
		note_name.sendKeys(value);
	}

	public void enterNoteDate() {
		BrowserUtility.scrollIntoView(driver, note_date, true);
		note_date.clear();
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = currentDate.format(formatter);
		note_date.sendKeys(formattedDate);
	}

	public void enterNoteDescription(String value) {
		BrowserUtility.scrollIntoView(driver, note_description, true);
		note_description.clear();
		note_description.sendKeys(value);
	}

	public void clickOnNoteSaveBtn() {
		BrowserUtility.scrollIntoView(driver, noteModalSaveChangesBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, noteModalSaveChangesBtn);
		noteModalSaveChangesBtn.click();
	}

	// Contacts Method

	public void clickOnContactOptionBtn() {
		BrowserUtility.scrollIntoView(driver, contactOptions, true);
		WaitUtility.waitForElementToBeClickable(driver, contactOptions);
		contactOptions.click();

	}

	public void clickOnCreateContact() {
		BrowserUtility.scrollIntoView(driver, createContact, true);
		WaitUtility.waitForElementToBeClickable(driver, createContact);
		createContact.click();

	}

	public void clickOnExistingContact() {
		BrowserUtility.scrollIntoView(driver, existingContact, true);
		WaitUtility.waitForElementToBeClickable(driver, existingContact);
		existingContact.click();

	}

	public boolean isContactModalVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, contactModal);
	}

	public boolean isContactModalHide() {
		return WaitUtility.waitForElementToBeInvisible(driver, contactModal);
	}

	public void enterClientCategory(String value) {
		BrowserUtility.scrollIntoView(driver, clientCategory, true);
		clientCategory.clear();
		clientCategory.sendKeys(value);
	}

	public void enterContactName(String value) {
		BrowserUtility.scrollIntoView(driver, contactlName, true);
		contactlName.clear();
		contactlName.sendKeys(value);
	}

	public void enterEmail(String value) {
		BrowserUtility.scrollIntoView(driver, email, true);
		email.clear();
		email.sendKeys(value);
	}

	public void enterPhoneNo(String value) {
		BrowserUtility.scrollIntoView(driver, phoneNumber, true);
		phoneNumber.clear();
		phoneNumber.sendKeys(value);
	}

	public void enterOtherInfo(String value) {
		BrowserUtility.scrollIntoView(driver, otherInfo, true);
		otherInfo.clear();
		otherInfo.sendKeys(value);
	}

	public void enterAddress(String value) {
		BrowserUtility.scrollIntoView(driver, address, true);
		address.clear();
	    address.sendKeys(value);
	}

	public void clickOnContactSaveBtn() {
		BrowserUtility.scrollIntoView(driver, ContactModalSaveChangesBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, ContactModalSaveChangesBtn);
		ContactModalSaveChangesBtn.click();
	}
}
