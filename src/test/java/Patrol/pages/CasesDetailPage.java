package Patrol.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Patrol.utilities.BrowserUtility;
import Patrol.utilities.WaitUtility;

public class CasesDetailPage extends BasePage {

	public CasesDetailPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='tab1-task']//table[contains(@class,'table')]//tbody//tr")
	List<WebElement> task_table_rows;
	
	@FindBy(xpath = "//div[@id='tab1-document']//table[contains(@class,'table')]//tbody//tr")
	List<WebElement> document_table_rows;
	
	@FindBy(xpath = "//div[@id='tab1-notes']//table[contains(@class,'table')]//tbody//tr")
	List<WebElement> notes_table_rows;
	
	@FindBy(xpath = "//div[@id='tab1-contact']//table[contains(@class,'table')]//tbody//tr")
	List<WebElement> contact_table_rows;
	
	@FindBy(xpath = "//div[@id='tab1-relatedMatters']//table[contains(@class,'table')]//tbody//tr")
	List<WebElement> related_matters_table_rows;
	
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
	WebElement createContactMadal;

	@FindBy(xpath = "//div[@id='add-existing-contact' and contains(@class,'show')]")
	WebElement existingContactMadal;

//	@FindBy(xpath="//div[@id='add-matter']")
//	WebElement calenderModal;
//	
	@FindBy(xpath = "//div[@id='add-tabinvoice' and contains(@class,'show')]")
	WebElement invoiceModal;

	@FindBy(xpath = "//div[@id='add-relatedMatters' and contains(@class,'show')]")
	WebElement relatedMattersModal;

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
	
	// Matter
	
	@FindBy(xpath="//select[@id='state']") 
	WebElement state;
	
	@FindBy(xpath="//select[@id='district']")  
	WebElement district;

	// document
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

	// contact
	@FindBy(xpath = "//button[@id='contactDropdown']")
	WebElement contactDropdown;
	

	@FindBy(xpath = "//ul[@aria-labelledby='contactDropdown']")
	WebElement contactDropdownOptions;

	@FindBy(xpath = "//ul[@aria-labelledby='contactDropdown']//li//a[text()='Create Contact']")
	WebElement createContactOption;

	@FindBy(xpath = "//ul[@aria-labelledby='contactDropdown']//li//a[text()='Existing Contact']")
	WebElement createExistingOption;
	
	//Notes
	
	@FindBy(xpath="//button[normalize-space()='Create Note']")
	WebElement createNoteBtn;
	
//	@FindBy(xpath="//input[@placeholder='individual name']") 
//	WebElement Notename;
	
	@FindBy(xpath="//div[@id='add-notes' and contains(@class,'show')]//input[@name='name']") 
	WebElement Notename;
	
	@FindBy(xpath="//input[@name='note_date']") 
    WebElement NoteDate;
	
	@FindBy(xpath="//div[@id='add-notes']//input[@name='description']")
	WebElement notesDescription;
	
	@FindBy(xpath="//div[@id='add-notes']//button[@type='submit'][normalize-space()='Save changes']")  
	WebElement notesModalsaveChangesBtn;

	// create contact

	@FindBy(xpath = "//div[@id='add-contact' and contains(@class,'show')]//select[@name='client_category']")
	WebElement companyDropdown;

	@FindBy(xpath = "//div[@id='add-contact' and contains(@class,'show')]//input[@id='name']")
	WebElement individualName;

	@FindBy(xpath = "//div[@id='add-contact' and contains(@class,'show')]//input[@placeholder='Company Name']")
	WebElement companyName;

	@FindBy(xpath = "//div[@id='add-contact' and contains(@class,'show')]//input[@id='email']")
	WebElement companyEmail;

	@FindBy(xpath = "//div[@id='add-contact' and contains(@class,'show')]//input[@id='phone']")
	WebElement companyPhoneNo;

	@FindBy(xpath = "//div[@id='add-contact' and contains(@class,'show')]//input[@id='other_info']")
	WebElement companyOtherInfo;

	@FindBy(xpath = "//div[@id='add-contact' and contains(@class,'show')]//input[@id='address']")
	WebElement companyAddress;

	@FindBy(xpath = "//div[@id='add-contact' and contains(@class,'show')]//button[text()='Save changes']")
	WebElement createContactModalSaveBtn;

	// existing contact
	@FindBy(xpath = "//div[@id='add-existing-contact' and contains(@class,'show')]//select[@id='existingContact']")
	WebElement existingContactDropdown;

	@FindBy(xpath = "//div[@id='add-existing-contact' and contains(@class,'show')]//button[text()='Save changes']")
	WebElement existingContactModalSaveBtn;

	// invoice

	@FindBy(xpath = "//button[@id='addInvoiceBtn']")
	WebElement postInvoiceBtn;

	@FindBy(xpath = "//div[@id='add-tabinvoice' and contains(@class,'show')]//select[@id='category_name']")
	WebElement activityCategoryDropdown;

	@FindBy(xpath = "//div[@id='add-tabinvoice' and contains(@class,'show')]//input[@id='date']")
	WebElement categoryDate;

	@FindBy(xpath = "//div[@id='add-tabinvoice' and contains(@class,'show')]//span[@class='select2-search select2-search--inline']")
	WebElement peopleClient;

	@FindBy(xpath = "//ul[@id='select2-firm_user-results']")
	WebElement peopleClientDropdown;

	@FindBy(xpath = "//ul[@id='select2-firm_user-results']//li")
	List<WebElement> peopleClientOptions;

	@FindBy(xpath = "//div[@id='add-tabinvoice' and contains(@class,'show')]//select[@id='rate']")
	WebElement feeType;

	@FindBy(xpath = "//div[@id='add-tabinvoice' and contains(@class,'show')]//input[@id='amount']")
	WebElement amount;

	@FindBy(xpath = "//div[@id='add-tabinvoice' and contains(@class,'show')]//input[@id='contract_file']")
	WebElement contractFile;

	@FindBy(xpath = "//div[@id='add-tabinvoice' and contains(@class,'show')]//input[@id='invoice_files']")
	WebElement invoiceFile;

	@FindBy(xpath = "//div[@id='add-tabinvoice' and contains(@class,'show')]//div[contains(@class,'uploaded-file')]")
	WebElement uploadInvoiceOutput;

	@FindBy(xpath = "//div[@id='add-tabinvoice' and contains(@class,'show')]//input[@id='term_date']")
	WebElement termDate;

	@FindBy(xpath = "//div[@id='add-tabinvoice' and contains(@class,'show')]//input[@id='invoice_date']")
	WebElement invoiceDate;

	@FindBy(xpath = "//div[@id='add-tabinvoice' and contains(@class,'show')]//select[@id='due_days']")
	WebElement dueDate;

	@FindBy(xpath = "//div[@id='add-tabinvoice' and contains(@class,'show')]//textarea[@id='description']")
	WebElement invoiceDescription;

	@FindBy(xpath = "//div[@id='add-tabinvoice' and contains(@class,'show')]//button[text()='Save Invoice']")
	WebElement invoiceModalSaveBtn;

	// related matters

	@FindBy(xpath = "//button[@data-bs-target='#add-relatedMatters']")
	WebElement relatedMattersBtn;

	@FindBy(xpath = "//div[@id='add-relatedMatters' and contains(@class,'show')]//select[@name='court']")
	WebElement court;

	@FindBy(xpath = "//div[@id='add-relatedMatters' and contains(@class,'show')]//select[@name='subcourt']")
	WebElement subCourt;

	@FindBy(xpath = "//div[@id='add-relatedMatters' and contains(@class,'show')]//span[@id='select2-search_case_filter-container']")
	WebElement searchCase;

	@FindBy(xpath = "//ul[@id='select2-search_case_filter-results']")
	WebElement searchCaseDropdown;

	@FindBy(xpath = "//ul[@id='select2-search_case_filter-results']//li")
	List<WebElement> searchCaseOptions;

	@FindBy(xpath = "//div[@id='add-relatedMatters' and contains(@class,'show')]//button[text()='Save changes']")
	WebElement relatedMattersModalSaveBtn;

	@FindBy(xpath = "//div[@aria-labelledby='swal2-title']")
	WebElement areYouSurePopUp;

	@FindBy(xpath = "//button[text()='Yes, Change!']")
	WebElement yesChagenBtn;
	
	@FindBy(xpath="//div[@id='add-relatedMatters' and contains(@class,'show')]//button[@aria-label='Close']")  
	WebElement relatedMAtterModalclosebtn;
	// --------------

	public void clickOnMatterTab() {
		matterTab.click();
	}

	public void clickOnTaskTab() {
		BrowserUtility.click(driver, taskTab);
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
		BrowserUtility.click(driver, relatedMattersTab);
	}

	// detail methods

	public boolean isCaseDetailTabVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, caseDetailTab, 10);
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
	
	public void selectState(String value) {
		BrowserUtility.selectByVisibleText(state, value);
	}
	
	public void selectState() {
		BrowserUtility.selectRandomOption(state);
	}

	public void selectDistrict() {
		BrowserUtility.selectRandomOption(district);
	}
	
	public void selectDistrict(String value) {
		BrowserUtility.selectByVisibleText(district, value);
	}

	public void clickOnMatterModalSaveChangesBtn() {
		BrowserUtility.scrollIntoView(driver, matterModalSaveChangesBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, matterModalSaveChangesBtn);
		matterModalSaveChangesBtn.click();
	}
	
	public void clickOnRelatedMatterModalCloseButton() {
		BrowserUtility.click(driver, relatedMAtterModalclosebtn);
	}

	// task methods
	public void clickOnCreateTaskBtn() {
		BrowserUtility.scrollIntoView(driver, createTaskBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, createTaskBtn);
		BrowserUtility.click(driver, createTaskBtn);
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
		BrowserUtility.click(driver, createDocumentBtn);
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
	
	//Notes method
	
	public void clickOnCreateNoteBtn() {
		BrowserUtility.scrollIntoView(driver, createNoteBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, createNoteBtn);
		BrowserUtility.click(driver, createNoteBtn);
	}

	public boolean isNoteModalVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, notesModal);
	}

	public boolean isNoteModalHide() {
		return WaitUtility.waitForElementToBeInvisible(driver, notesModal);
	}

	public void enterNoteName(String value) {
		BrowserUtility.scrollIntoView(driver, Notename, true);
		Notename.clear();
		Notename.sendKeys(value);
	}

	public void enterNoteDate() {
		BrowserUtility.scrollIntoView(driver, NoteDate, true);
		NoteDate.clear();
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = currentDate.format(formatter);
		NoteDate.sendKeys(formattedDate);
	}

	public void enterNotesDescription(String value) {
		BrowserUtility.scrollIntoView(driver, notesDescription, true);
		notesDescription.clear();
		notesDescription.sendKeys(value);
	}

	public void clickOnNotesSaveBtn() {
		BrowserUtility.scrollIntoView(driver, notesModalsaveChangesBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, notesModalsaveChangesBtn);
		notesModalsaveChangesBtn.click();
	}

	// contact method
	public void clickOnContactOptions() {
		BrowserUtility.scrollIntoView(driver, contactDropdown, true);
		WaitUtility.waitForElementToBeClickable(driver, contactDropdown);
		contactDropdown.click();
	}

	public void clickOnCreateContact() {
		BrowserUtility.scrollIntoView(driver, createContactOption, true);
		WaitUtility.waitForElementToBeClickable(driver, createContactOption);
		createContactOption.click();
	}

	public void clickOnExistingContact() {
		BrowserUtility.scrollIntoView(driver, createExistingOption, true);
		WaitUtility.waitForElementToBeClickable(driver, createExistingOption);
		createExistingOption.click();
	}

	// create contact
	public boolean isCreateContactModalVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, createContactMadal);
	}

	public boolean isCreateContactModalHide() {
		return WaitUtility.waitForElementToBeInvisible(driver, createContactMadal);
	}

	public void selectCategory(String value) {
		BrowserUtility.scrollIntoView(driver, companyDropdown, true);
		BrowserUtility.selectByVisibleText(companyDropdown, value);
	}

	public void enterIndividualName(String value) {
		BrowserUtility.scrollIntoView(driver, individualName, true);
		individualName.clear();
		individualName.sendKeys(value);
	}

	public void enterCompanyName(String value) {
		BrowserUtility.scrollIntoView(driver, companyName, true);
		companyName.clear();
		companyName.sendKeys(value);
	}

	public void enterEmail(String value) {
		BrowserUtility.scrollIntoView(driver, companyEmail, true);
		companyEmail.clear();
		companyEmail.sendKeys(value);
	}

	public void enterPhoneNo(String value) {
		BrowserUtility.scrollIntoView(driver, companyPhoneNo, true);
		companyPhoneNo.clear();
		companyPhoneNo.sendKeys(value);
	}

	public void enterOtherInfo(String value) {
		BrowserUtility.scrollIntoView(driver, companyOtherInfo, true);
		companyOtherInfo.clear();
		companyOtherInfo.sendKeys(value);
	}

	public void enterAddres(String value) {
		BrowserUtility.scrollIntoView(driver, companyAddress, true);
		companyAddress.clear();
		companyAddress.sendKeys(value);
	}

	public void clickOnCreateContactSaveBtn() {
		BrowserUtility.scrollIntoView(driver, createContactModalSaveBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, createContactModalSaveBtn);
		createContactModalSaveBtn.click();
	}

	// existing contact method

	public boolean isExistingContactModalVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, existingContactMadal);
	}

	public boolean isExistingContactModalHide() {
		return WaitUtility.waitForElementToBeInvisible(driver, existingContactMadal);
	}

	public void selectContact(String value) {
		BrowserUtility.scrollIntoView(driver, existingContactDropdown, true);
		BrowserUtility.selectByVisibleText(existingContactDropdown, value);
	}

	public void clickOnExistingContactSaveBtn() {
		BrowserUtility.scrollIntoView(driver, existingContactModalSaveBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, existingContactModalSaveBtn);
		existingContactModalSaveBtn.click();
	}

	// invoice method

	public void clickOnPostInvoiceBtn() {
		BrowserUtility.scrollIntoView(driver, postInvoiceBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, postInvoiceBtn);
		postInvoiceBtn.click();
	}

	public boolean isInvoiceModalVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, invoiceModal);
	}

	public boolean isInvoiceModalHide() {
		return WaitUtility.waitForElementToBeInvisible(driver, invoiceModal);
	}

	public void selectActivityCategory(String value) {
		BrowserUtility.scrollIntoView(driver, activityCategoryDropdown, true);
		BrowserUtility.selectByVisibleText(activityCategoryDropdown, value);
	}

	public void enterCategoryDate(String value) {
		BrowserUtility.scrollIntoView(driver, categoryDate, true);
		categoryDate.clear();
		categoryDate.sendKeys(value);
	}

	public void selectPeopleClient(String value) {
		BrowserUtility.scrollIntoView(driver, peopleClient, true);
		WaitUtility.waitForElementToBeClickable(driver, peopleClient);
		BrowserUtility.click(driver, peopleClient);

		WaitUtility.waitForElementToBeVisible(driver, peopleClientDropdown);

		for (int i = 0; i < peopleClientOptions.size(); i++) {
			WebElement option = peopleClientOptions.get(i);
			if (option.getText().trim().equals(value)) {
				BrowserUtility.scrollIntoView(driver, option, true);
				WaitUtility.waitForElementToBeClickable(driver, option);
				option.click();
				return; // Stop execution after clicking
			}
		}
		throw new NoSuchElementException("Option '" + value + "' not found in the dropdown.");
	}

	public void selectFeeType(String value) {
		BrowserUtility.scrollIntoView(driver, feeType, true);
		BrowserUtility.selectByVisibleText(feeType, value);
	}

	public void enterAmount(String value) {
		BrowserUtility.scrollIntoView(driver, amount, true);
		amount.clear();
		amount.sendKeys(value);
	}

	public void uploadContract(String value) {
		BrowserUtility.scrollIntoView(driver, contractFile, true);
		contractFile.clear();
		contractFile.sendKeys(value);
	}

	public boolean isContractUploaded(String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String fileValue = (String) js.executeScript("arguments[0].value;", contractFile);
		if (fileValue.contains(value)) {
			return true;
		} else {
			return false;
		}
	}

	public void uploadInvoice(String filepath) {
		BrowserUtility.click(driver, invoiceFile);
		try {
			StringSelection filePathSelection = new StringSelection(filepath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection,null);
			
			WaitUtility.waitForSeconds(3);
			
			Robot rb = new Robot();
			
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			
			WaitUtility.waitForSeconds(3);
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			
			WaitUtility.waitForSeconds(3);
			
			
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public boolean isInvoiceUploaded(String value) {
		WaitUtility.waitForElementToBeVisible(driver, uploadInvoiceOutput);
		if (uploadInvoiceOutput.getText().equals(value)) {
			return true;
		} else {
			return false;
		}
	}

	public void enterTermDate(String value) {
		BrowserUtility.scrollIntoView(driver, termDate, true);
		termDate.clear();
		termDate.sendKeys(value);
	}

	public void enterInvoiceDate(String value) {
		BrowserUtility.scrollIntoView(driver, invoiceDate, true);
		invoiceDate.clear();
		invoiceDate.sendKeys(value);
	}

	public void selectDueDate(String value) {
		BrowserUtility.scrollIntoView(driver, dueDate, true);
		BrowserUtility.selectByVisibleText(dueDate, value);
	}

	public void enterInvoiceDescription(String value) {
		BrowserUtility.scrollIntoView(driver, invoiceDescription, true);
		invoiceDescription.clear();
		invoiceDescription.sendKeys(value);
	}

	public void clickOnInvoiceModalSaveBtn() {
		BrowserUtility.scrollIntoView(driver, invoiceModalSaveBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, invoiceModalSaveBtn);
		invoiceModalSaveBtn.click();
	}

	// related matter methods

	public void clickOnRelatedMattersBtn() {
		BrowserUtility.scrollIntoView(driver, relatedMattersBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, relatedMattersBtn);
		relatedMattersBtn.click();
	}

	public boolean isRelatedMattersModalVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, relatedMattersModal);
	}

	public boolean isRelatedMattersModalHide() {
		return WaitUtility.waitForElementToBeInvisible(driver, relatedMattersModal);
	}

	public void selectCourt(String value) {
		BrowserUtility.selectByVisibleText(court, value);
	}
	
	public void selectCourt() {
		BrowserUtility.selectRandomOption(court);
	}

	public void selectSubCourt() {
		BrowserUtility.selectRandomOption(subCourt);
	}
	
	public void selectSubCourt(String value) {
		BrowserUtility.selectByVisibleText(subCourt, value);
	}	

//	public void selectCase() {
//		WaitUtility.waitForElementToBeVisible(driver, searchCase);
//		BrowserUtility.scrollIntoView(driver, searchCase, true);
//		WaitUtility.waitForElementToBeClickable(driver, searchCase);
//		searchCase.click();
//		WaitUtility.waitForElementToBeVisible(driver, searchCaseDropdown);
//		BrowserUtility.scrollIntoView(driver, searchCaseOptions.get(2), true);
//		WaitUtility.waitForElementToBeClickable(driver, searchCaseOptions.get(2));
//		searchCaseOptions.get(2).click();
//	}

	public void selectCase() {
		// Wait for the searchCase element to be visible and clickable
		WaitUtility.waitForElementToBeVisible(driver, searchCase);
		BrowserUtility.scrollIntoView(driver, searchCase, true);
		WaitUtility.waitForElementToBeClickable(driver, searchCase);
		searchCase.click();

		// Wait for the dropdown options to be visible
		try {
			WaitUtility.waitForElementToBeVisible(driver, searchCaseDropdown);
		} catch (Exception e) {
			WaitUtility.waitForElementToBeVisible(driver, searchCaseDropdown);
		}

		// Generate a random index starting from 1 to exclude the first option
		Random random = new Random();
		int randomIndex = 1 + random.nextInt(searchCaseOptions.size() - 1);

		// Scroll to and click the randomly selected option
		WebElement randomOption = searchCaseOptions.get(randomIndex);
		BrowserUtility.scrollIntoView(driver, randomOption, true);
		WaitUtility.waitForElementToBeClickable(driver, randomOption);
		randomOption.click();
	}
	
	
	public boolean isAreYouSurePopUpVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, areYouSurePopUp);
	}

	public void clickOnYesChangeBtn() {
		BrowserUtility.scrollIntoView(driver, yesChagenBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, yesChagenBtn);
		yesChagenBtn.click();
	}

	public void clickOnRelatedMattersSaveBtn() {
		BrowserUtility.scrollIntoView(driver, relatedMattersModalSaveBtn, true);
		WaitUtility.waitForElementToBeClickable(driver, relatedMattersModalSaveBtn);
		relatedMattersModalSaveBtn.click();
	}

	// task validation method
	public void isTaskTableContains() {
		System.out.println("task_table_rows size => " + task_table_rows.size());

		for (WebElement row : task_table_rows) {
			WaitUtility.waitForElementToBeVisible(driver, row);
			List<WebElement> cells = row.findElements(By.xpath(".//td"));
			WaitUtility.waitForElementToBeVisible(driver, cells.get(0));
			WaitUtility.waitForElementToBeVisible(driver, cells.get(1));
			WaitUtility.waitForElementToBeVisible(driver, cells.get(2));
			WaitUtility.waitForElementToBeVisible(driver, cells.get(3));
			WaitUtility.waitForElementToBeVisible(driver, cells.get(4));
			WaitUtility.waitForElementToBeVisible(driver, cells.get(5));
			WaitUtility.waitForElementToBeVisible(driver, cells.get(6));
			String sno = cells.get(0).getText();
			String name = cells.get(1).getText();
			String assigned = cells.get(2).getText();
			String user = cells.get(3).getText();
			String description = cells.get(4).getText();
			String duedate = cells.get(5).getText();
			String priority = cells.get(6).getText();
			System.out.println(sno + " " + name + " " + assigned + " " + user + " " + description + " " + duedate + " "
					+ priority + " cells size =>" + cells.size());
		}
		System.out.println("----------------------------------------------------------------------");
	}
	
	// document validatin method 
	public void isDocumentTableContains() {
	    System.out.println("document_table_rows size => " + document_table_rows.size());  
	    
	    for (WebElement row : document_table_rows) { 
	        WaitUtility.waitForElementToBeVisible(driver, row);
	        List<WebElement> cells = row.findElements(By.xpath(".//td")); 
	        
	        WaitUtility.waitForElementToBeVisible(driver, cells.get(0));
	        WaitUtility.waitForElementToBeVisible(driver, cells.get(1));
	        WaitUtility.waitForElementToBeVisible(driver, cells.get(2));
	        WaitUtility.waitForElementToBeVisible(driver, cells.get(3));
	        
	        String name = cells.get(0).getText();
	        String caseName = cells.get(1).getText();
	        String documentDate = cells.get(2).getText();
	        String documentDescription = cells.get(3).getText();
	        
	        System.out.println(name + " " + caseName + " " + documentDate + " " + documentDescription + " cells size =>" + cells.size());  
	    }
	    System.out.println("----------------------------------------------------------------------");
	}


	// notes validation method 
	public void isNotesTableContains() {
		System.out.println("notes_table_rows size => " + notes_table_rows.size());
		for (WebElement row : notes_table_rows) {
			WaitUtility.waitForElementToBeVisible(driver, row);
			List<WebElement> cells = row.findElements(By.xpath(".//td"));
			String sno, name, description, date_created;
			WaitUtility.waitForElementToBeVisible(driver, cells.get(0));
			WaitUtility.waitForElementToBeVisible(driver, cells.get(1));
			WaitUtility.waitForElementToBeVisible(driver, cells.get(2));
			WaitUtility.waitForElementToBeVisible(driver, cells.get(3));
			sno = cells.get(0).getText();
			name = cells.get(1).getText();
			description = cells.get(2).getText();
			date_created = cells.get(3).getText();
			System.out.println(
					sno + " " + name + " " + description + " " + date_created + " cells size =>" + cells.size());
		}
		System.out.println("----------------------------------------------------------------------");
	}
	
	// contact validation method 
	public void isContactTableContains() {
	    System.out.println("contact_table_rows size => " + contact_table_rows.size());  
	    
	    for (WebElement row : contact_table_rows) { 
	        WaitUtility.waitForElementToBeVisible(driver, row);
	        List<WebElement> cells = row.findElements(By.xpath(".//td")); 
	        
	        WaitUtility.waitForElementToBeVisible(driver, cells.get(0));
	        WaitUtility.waitForElementToBeVisible(driver, cells.get(1));
	        WaitUtility.waitForElementToBeVisible(driver, cells.get(2));
	        WaitUtility.waitForElementToBeVisible(driver, cells.get(3));
	        WaitUtility.waitForElementToBeVisible(driver, cells.get(4));
	        WaitUtility.waitForElementToBeVisible(driver, cells.get(5));
	        
	        String sno = cells.get(0).getText();
	        String name = cells.get(1).getText();
	        String contactType = cells.get(2).getText();
	        String email = cells.get(3).getText();
	        String phoneNumber = cells.get(4).getText();
	        String dateCreated = cells.get(5).getText();
	        
	        System.out.println(sno + " " + name + " " + contactType + " " + email + " " + phoneNumber + " " + dateCreated + " cells size =>" + cells.size());  
	    }
	    System.out.println("----------------------------------------------------------------------");
	}
	
	// related matter validation method 
	public void isRelatedMattersTableContains() {
	    System.out.println("related_matters_table_rows size => " + related_matters_table_rows.size());  
	    
	    for (WebElement row : related_matters_table_rows) { 
	        WaitUtility.waitForElementToBeVisible(driver, row);
	        List<WebElement> cells = row.findElements(By.xpath(".//td")); 
	        
	        WaitUtility.waitForElementToBeVisible(driver, cells.get(0));
	        WaitUtility.waitForElementToBeVisible(driver, cells.get(1));
	        WaitUtility.waitForElementToBeVisible(driver, cells.get(2));
	        
	        String caseName = cells.get(0).getText();
	        String relatedCase = cells.get(1).getText();
	        String dateCreated = cells.get(2).getText();
	        
	        System.out.println(caseName + " " + relatedCase + " " + dateCreated + " cells size =>" + cells.size());  
	    }
	    System.out.println("----------------------------------------------------------------------");
	}


}