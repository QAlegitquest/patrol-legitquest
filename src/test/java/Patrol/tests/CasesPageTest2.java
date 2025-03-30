package Patrol.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.CasesDetailPage;
import Patrol.pages.CasesPage2;
import Patrol.pages.DashBoardPage;
import Patrol.pages.LoginPage;
import Patrol.utilities.BaseTest;
import Patrol.utilities.BrowserUtility;
import Patrol.utilities.CommonUtility;
import Patrol.utilities.ConfingDataProvider;
import Patrol.utilities.ScreenShotsUtility;
import Patrol.utilities.WaitUtility;

public class CasesPageTest2 extends BaseTest {

	@Test(priority = 1, enabled = true)
	public void verifyAllLinks() {
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquest();
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickCasesLink();
		CasesPage2 casePage = new CasesPage2(driver);
		int page = 1;
		while (true) {
			System.out.println("Current Page Before Loop: " + page);
			for (int i = 0; i < casePage.getTableRowsCount(); i++) {
				casePage.clickOnLink(String.valueOf((i + 1)));
				CasesDetailPage caseDetailPage = new CasesDetailPage(driver);
				String msg = "Page => pNO, Row => rNo, CaseLink => cLink";
				if (!caseDetailPage.isCaseDetailTabVisible()) {
					msg = msg.replace("pNO", String.valueOf(page));
					msg = msg.replace("rNo", String.valueOf((i + 1)));
					msg = msg.replace("cLink", driver.getCurrentUrl());
				}
				softAssert.assertEquals(caseDetailPage.isCaseDetailTabVisible(), true, msg);
				casePage.goToPreviousPage();
			}
			BrowserUtility.scrollToDown(driver);
			WaitUtility.waitForSeconds(0.5);
			if (!casePage.isNextButtonDisabled()) {
				casePage.clickOnNextButton();
			} else {
				break;
			}
			page++;
		}
		softAssert.assertAll();
	}
	
	@Test(priority = 2, enabled = false)
	public void verifyAllLinks2() {
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLQTest();
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickCasesLink();
		CasesPage2 casePage = new CasesPage2(driver);
		int page = 1;
		while (true) {
			System.out.println("Current Page Before Loop: " + page);
			for (int i = 0; i < casePage.getTableRowsCount(); i++) {
				casePage.clickOnLink(String.valueOf((i + 1)));
				CasesDetailPage caseDetailPage = new CasesDetailPage(driver);
				String msg = "Page => pNO, Row => rNo, CaseLink => cLink";
				if (!caseDetailPage.isCaseDetailTabVisible()) {
					msg = msg.replace("pNO", String.valueOf(page));
					msg = msg.replace("rNo", String.valueOf((i + 1)));
					msg = msg.replace("cLink", driver.getCurrentUrl());
				}
				softAssert.assertEquals(caseDetailPage.isCaseDetailTabVisible(), true, msg);
				casePage.goToPreviousPage();
			}
			BrowserUtility.scrollToDown(driver);
			WaitUtility.waitForSeconds(0.5);
			if (!casePage.isNextButtonDisabled()) {
				casePage.clickOnNextButton();
			} else {
				break;
			}
			page++;
		}
		softAssert.assertAll();
	}

	@Test(priority = 3, enabled = false)
	public void verifyPagination() {
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquest();
		//activeFirmpage.clickOnLQTest();
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickCasesLink();
		CasesPage2 casePage = new CasesPage2(driver);
		int lastPageNumber = casePage.getSecondLastPageNumber();
		for (int page = 2; page <= lastPageNumber; page++) {
			if (casePage.isLogoDisplayed()) {
				BrowserUtility.scrollToDown(driver);
				WaitUtility.waitForSeconds(2);
				casePage.clickOnPage(String.valueOf(page));
				WaitUtility.waitForSeconds(5);
			} else {
				String screenshotName = "Skip Page = " + page;
				softAssert.assertEquals(casePage.isLogoDisplayed(), true, screenshotName);
				ScreenShotsUtility.addScreenshotToReport(driver, screenshotName);
				casePage.goToPreviousPage();
				page++;
				BrowserUtility.scrollToDown(driver);
				WaitUtility.waitForSeconds(2);
				casePage.clickOnPage(String.valueOf(page));
				WaitUtility.waitForSeconds(5);
			}
		}
		softAssert.assertAll();
	}

	// matter tab test
	@Test(priority = 3, enabled = false)
	public void matterTab() {
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquestTest();
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickCasesLink();
		CasesPage2 casePage = new CasesPage2(driver);
		int page = 1;
		while (true) {
			System.out.println("Current Page Before Loop: " + page);
			for (int i = 0; i < casePage.getTableRowsCount(); i++) {
				casePage.clickOnLink(String.valueOf((i + 1)));
				CasesDetailPage caseDetailPage = new CasesDetailPage(driver);
				softAssert.assertEquals(caseDetailPage.isCaseDetailTabVisible(), true);
				caseDetailPage.clickOnMatterTab();
				caseDetailPage.clickOnCreateMatterBtn();
				softAssert.assertEquals(caseDetailPage.isMatterModalVisible(), true, "matter modal is not visible");
				caseDetailPage.clickOnMatterModalSaveChangesBtn();
				softAssert.assertEquals(caseDetailPage.isMatterModalHide(), true, "matter modal is not hide");
				caseDetailPage.clickOnMatterTab();
				casePage.goToPreviousPage();
				casePage.goToPreviousPage();
			}
			BrowserUtility.scrollToDown(driver);
			WaitUtility.waitForSeconds(0.5);
			if (!casePage.isNextButtonDisabled()) {
				casePage.clickOnNextButton();
			} else {
				break;
			}
			page++;
		}
		softAssert.assertAll();
	}

	// task tab test
	@Test(priority = 4, enabled = false)
	public void taskTab() {
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquestTest();
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickCasesLink();
		CasesPage2 casePage = new CasesPage2(driver);
		int page = 1;
		while (true) {
			System.out.println("Current Page Before Loop: " + page);
			for (int i = 0; i < casePage.getTableRowsCount(); i++) {
				casePage.clickOnLink(String.valueOf((i + 1)));
				CasesDetailPage caseDetailPage = new CasesDetailPage(driver);
				softAssert.assertEquals(caseDetailPage.isCaseDetailTabVisible(), true);
				caseDetailPage.clickOnTaskTab();
				caseDetailPage.clickOnCreateTaskBtn();
				softAssert.assertEquals(caseDetailPage.isTaskModalVisible(), true, "task modal is not visible");
				caseDetailPage.enterTaskName("Task 1");
				caseDetailPage.enterTaskDescription("Task 1 Description");
				caseDetailPage.clickOnAssignedUser();
				caseDetailPage.clickOn2ndOption();
				caseDetailPage.clickOnTaskModalSaveChangesBtn();
				softAssert.assertEquals(caseDetailPage.isTaskModalHide(), true, "task modal is not hide");
				caseDetailPage.clickOnTaskTab();
				casePage.goToPreviousPage();
				casePage.goToPreviousPage();
			}
			BrowserUtility.scrollToDown(driver);
			WaitUtility.waitForSeconds(0.5);
			if (!casePage.isNextButtonDisabled()) {
				casePage.clickOnNextButton();
			} else {
				break;
			}
			page++;
		}
		softAssert.assertAll();
	}

	// document tab test
	@Test(priority = 5, enabled = false)
	public void documentTab() {
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquestTest();
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickCasesLink();
		CasesPage2 casePage = new CasesPage2(driver);
		int page = 1;
		while (true) {
			System.out.println("Current Page Before Loop: " + page);
			for (int i = 0; i < casePage.getTableRowsCount(); i++) {
				casePage.clickOnLink(String.valueOf((i + 1)));
				CasesDetailPage caseDetailPage = new CasesDetailPage(driver);
				softAssert.assertEquals(caseDetailPage.isCaseDetailTabVisible(), true);
				caseDetailPage.clickOnDocumentTab();
				caseDetailPage.clickOnCreateDocumentBtn();
				softAssert.assertEquals(caseDetailPage.isDocumentModalVisible(), true, "document modal is not visible");
				caseDetailPage.enterDocumentName("doc 1");
				caseDetailPage.enterDocumentDate();
				caseDetailPage.enterDocumentDescription("doc description 1");
				caseDetailPage.clickOnDocumentSaveBtn();
				softAssert.assertEquals(caseDetailPage.isDocumentModalHide(), true, "document modal is not hide");
				caseDetailPage.clickOnDocumentTab();
				casePage.goToPreviousPage();
				casePage.goToPreviousPage();
			}
			BrowserUtility.scrollToDown(driver);
			WaitUtility.waitForSeconds(0.5);
			if (!casePage.isNextButtonDisabled()) {
				casePage.clickOnNextButton();
			} else {
				break;
			}
			page++;
		}
		softAssert.assertAll();
	}

	// notes tab test
	@Test(priority = 6, enabled = false)
	public void notesTab() {
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquestTest();
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickCasesLink();
		CasesPage2 casePage = new CasesPage2(driver);
		int page = 1;
		while (true) {
			System.out.println("Current Page Before Loop: " + page);
			for (int i = 0; i < casePage.getTableRowsCount(); i++) {
				casePage.clickOnLink(String.valueOf((i + 1)));
				CasesDetailPage caseDetailPage = new CasesDetailPage(driver);
				softAssert.assertEquals(caseDetailPage.isCaseDetailTabVisible(), true);
				caseDetailPage.clickOnNotesTab();
				caseDetailPage.clickOncreateNotesBtn();
				softAssert.assertEquals(caseDetailPage.isNoteModalVisible(), true, "notes modal is not visible");
				caseDetailPage.enterNoteName("Note1");
				caseDetailPage.enterNoteDate();
				caseDetailPage.enterNoteDescription("Note Description 1");
				caseDetailPage.clickOnNoteSaveBtn();
				softAssert.assertEquals(caseDetailPage.isNoteModalHide(), true, "notes modal is not hide");
				caseDetailPage.clickOnNotesTab();
				casePage.goToPreviousPage();
				casePage.goToPreviousPage();
			}
			BrowserUtility.scrollToDown(driver);
			WaitUtility.waitForSeconds(0.5);
			if (!casePage.isNextButtonDisabled()) {
				casePage.clickOnNextButton();
			} else {
				break;
			}
			page++;
		}
		softAssert.assertAll();
	}

	// contact test
	@Test(priority = 7, enabled = false)
	public void contactTabCompany() {
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquestTest();
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickCasesLink();
		CasesPage2 casePage = new CasesPage2(driver);
		int page = 1;
		while (true) {
			System.out.println("Current Page Before Loop: " + page);
			for (int i = 0; i < casePage.getTableRowsCount(); i++) {
				casePage.clickOnLink(String.valueOf((i + 1)));
				CasesDetailPage caseDetailPage = new CasesDetailPage(driver);
				softAssert.assertEquals(caseDetailPage.isCaseDetailTabVisible(), true);
				caseDetailPage.clickOnContactTab();
				caseDetailPage.clickOnContactOptions();
				caseDetailPage.clickOnCreateContact();
				softAssert.assertEquals(caseDetailPage.isCreateContactModalVisible(), true,
						"create contact modal is not visible");
				// caseDetailPage
				caseDetailPage.selectCategory("Company");
				WaitUtility.waitForSeconds(1);
				caseDetailPage.enterCompanyName("XYZ");
				caseDetailPage.enterEmail("example@xyz.com");
				caseDetailPage.enterPhoneNo("9897345687");
				caseDetailPage.enterOtherInfo("Random other info");
				caseDetailPage.enterAddres("random address");
				caseDetailPage.clickOnCreateContactSaveBtn();
				// --------------
				softAssert.assertEquals(caseDetailPage.isCreateContactModalHide(), true,
						"create contact modal is not hide");
				caseDetailPage.clickOnContactTab();
				casePage.goToPreviousPage();
			}
			BrowserUtility.scrollToDown(driver);
			WaitUtility.waitForSeconds(0.5);
			if (!casePage.isNextButtonDisabled()) {
				casePage.clickOnNextButton();
			} else {
				break;
			}
			page++;
		}
		softAssert.assertAll();
	}
	
	// contact test
		@Test(priority = 8, enabled = false )
		public void contactTabIndividual() {
			SoftAssert softAssert = new SoftAssert();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(ConfingDataProvider.Email);
			loginPage.setPassword(ConfingDataProvider.Password);
			loginPage.performAction();
			ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
			activeFirmpage.clickOnLegitquestTest();
			DashBoardPage dashBoardPage = new DashBoardPage(driver);
			dashBoardPage.clickOnManageCases();
			dashBoardPage.clickCasesLink();
			CasesPage2 casePage = new CasesPage2(driver);
			int page = 1;
			while (true) {
				System.out.println("Current Page Before Loop: " + page);
				for (int i = 0; i < casePage.getTableRowsCount(); i++) {
					casePage.clickOnLink(String.valueOf((i + 1)));
					CasesDetailPage caseDetailPage = new CasesDetailPage(driver);
					softAssert.assertEquals(caseDetailPage.isCaseDetailTabVisible(), true);
					caseDetailPage.clickOnContactTab();
					caseDetailPage.clickOnContactOptions();
					caseDetailPage.clickOnCreateContact();
					softAssert.assertEquals(caseDetailPage.isCreateContactModalVisible(), true,
							"create contact modal is not visible");
					// caseDetailPage
					caseDetailPage.selectCategory("Individual");
					WaitUtility.waitForSeconds(1);
					caseDetailPage.enterIndividualName("Abc");
					caseDetailPage.enterEmail("example@abc.com");
					caseDetailPage.enterPhoneNo("9897345687");
					caseDetailPage.enterOtherInfo("other info djfhjfhd");
					caseDetailPage.enterAddres("random address");
					caseDetailPage.clickOnCreateContactSaveBtn();
					// --------------
					softAssert.assertEquals(caseDetailPage.isCreateContactModalHide(), true,
							"create contact modal is not hide");
					caseDetailPage.clickOnContactTab();
					casePage.goToPreviousPage();
				}
				BrowserUtility.scrollToDown(driver);
				WaitUtility.waitForSeconds(0.5);
				if (!casePage.isNextButtonDisabled()) {
					casePage.clickOnNextButton();
				} else {
					break;
				}
				page++;
			}
			softAssert.assertAll();
		}

	// existing contact test
	@Test(priority = 9, enabled = false)
	public void existingContactTab() {
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquestTest();
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickCasesLink();
		CasesPage2 casePage = new CasesPage2(driver);
		int page = 1;
		while (true) {
			System.out.println("Current Page Before Loop: " + page);
			for (int i = 0; i < casePage.getTableRowsCount(); i++) {
				casePage.clickOnLink(String.valueOf((i + 1)));
				CasesDetailPage caseDetailPage = new CasesDetailPage(driver);
				softAssert.assertEquals(caseDetailPage.isCaseDetailTabVisible(), true);
				caseDetailPage.clickOnContactTab();
				caseDetailPage.clickOnContactOptions();
				caseDetailPage.clickOnExistingContact();
				softAssert.assertEquals(caseDetailPage.isExistingContactModalVisible(), true,
						"existing contact modal is not visible");
				// caseDetailPage
				caseDetailPage.selectContact("Xyz");
				// --------------
				caseDetailPage.clickOnExistingContactSaveBtn();
				softAssert.assertEquals(caseDetailPage.isExistingContactModalHide(), true,
						"existing contact modal is not hide");
				caseDetailPage.clickOnContactTab();
				casePage.goToPreviousPage();
			}
			BrowserUtility.scrollToDown(driver);
			WaitUtility.waitForSeconds(0.5);
			if (!casePage.isNextButtonDisabled()) {
				casePage.clickOnNextButton();
			} else {
				break;
			}
			page++;
		}
		softAssert.assertAll();

	}

	// invoice test
	@Test(priority = 10, enabled = false)
	public void invoiceTab() {
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquestTest();
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickCasesLink();
		CasesPage2 casePage = new CasesPage2(driver);
		for (int i = 0; i < 1; i++) {
			casePage.clickOnLink(String.valueOf((i + 1)));
			CasesDetailPage caseDetailPage = new CasesDetailPage(driver);
			softAssert.assertEquals(caseDetailPage.isCaseDetailTabVisible(), true);
			caseDetailPage.clickOnInvoiceTab();
			caseDetailPage.clickOnPostInvoiceBtn();
			softAssert.assertEquals(caseDetailPage.isInvoiceModalVisible(), true, "invoice modal is not visible");
			caseDetailPage.selectActivityCategory("Time spent onboarding new clients");
			caseDetailPage.enterCategoryDate(CommonUtility.getCurrentDate());
			caseDetailPage.selectPeopleClient("ajay");
			caseDetailPage.selectFeeType("Flat");
			caseDetailPage.enterAmount("5000");
			caseDetailPage.uploadContract("C:\\Users\\Rohit\\Documents\\resumes\\Rohit_CV_React_Developer.pdf");
			caseDetailPage.uploadInvoice("C:\\Users\\Rohit\\Documents\\resumes\\Rohit_CV_React_Developer.pdf");
			softAssert.assertEquals(caseDetailPage.isInvoiceUploaded("Rohit_CV_React_Developer.pdf"), true,
					"invoice is not uploaded.");
			caseDetailPage.enterTermDate(CommonUtility.getCurrentDate());
			caseDetailPage.enterInvoiceDate(CommonUtility.getCurrentDate());
			caseDetailPage.selectDueDate("30 Days");
			caseDetailPage.enterInvoiceDescription("this is the invoice description");
			caseDetailPage.clickOnInvoiceModalSaveBtn();
			// --------------
			softAssert.assertEquals(caseDetailPage.isInvoiceModalHide(), true, "invoice modal is not hide");
			caseDetailPage.clickOnInvoiceModalSaveBtn();
			WaitUtility.waitForSeconds(10);
		}
	}

	// related matters test
	@Test(priority = 11, enabled = false)
	public void relatedMatterTabDistrictCourt() {
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquestTest();
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickCasesLink();
		CasesPage2 casePage = new CasesPage2(driver);
		int page = 1;
		while (true) {
			System.out.println("Current Page Before Loop: " + page);
			for (int i = 0; i < casePage.getTableRowsCount(); i++) {
				casePage.clickOnLink(String.valueOf((i + 1)));
				CasesDetailPage caseDetailPage = new CasesDetailPage(driver);
				softAssert.assertEquals(caseDetailPage.isCaseDetailTabVisible(), true);
				caseDetailPage.clickOnRelatedMattersTab();
				caseDetailPage.clickOnRelatedMattersBtn();
				softAssert.assertEquals(caseDetailPage.isRelatedMattersModalVisible(), true,
						"related matters modal is not visible");

				caseDetailPage.selectCase();
				softAssert.assertEquals(caseDetailPage.isAreYouSurePopUpVisible(), true,
						"are you sure pop up is not visible");
				caseDetailPage.clickOnYesChangeBtn();
				caseDetailPage.clickOnRelatedMattersSaveBtn();
				caseDetailPage.clickOnRelatedMattersTab();
				casePage.goToPreviousPage();
				casePage.goToPreviousPage();
			}
			BrowserUtility.scrollToDown(driver);
			WaitUtility.waitForSeconds(0.5);
			if (!casePage.isNextButtonDisabled()) {
				casePage.clickOnNextButton();
			} else {
				break;
			}
			page++;
		}
		softAssert.assertAll();
	}

	// related matters test
	@Test(priority = 12, enabled = false)
	public void relatedMatterTabSupremeCourt() {
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquestTest();
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickCasesLink();
		CasesPage2 casePage = new CasesPage2(driver);
		int page = 1;
		while (true) {
			System.out.println("Current Page Before Loop: " + page);
			for (int i = 0; i < casePage.getTableRowsCount(); i++) {
				casePage.clickOnLink(String.valueOf((i + 1)));
				CasesDetailPage caseDetailPage = new CasesDetailPage(driver);
				softAssert.assertEquals(caseDetailPage.isCaseDetailTabVisible(), true);
				caseDetailPage.clickOnRelatedMattersTab();
				caseDetailPage.clickOnRelatedMattersBtn();
				softAssert.assertEquals(caseDetailPage.isRelatedMattersModalVisible(), true,
						"related matters modal is not visible");
				caseDetailPage.selectCourt("Supreme Court");
				caseDetailPage.selectCase();
				softAssert.assertEquals(caseDetailPage.isAreYouSurePopUpVisible(), true,
						"are you sure pop up is not visible");
				caseDetailPage.clickOnYesChangeBtn();
				caseDetailPage.clickOnRelatedMattersSaveBtn();
				caseDetailPage.clickOnRelatedMattersTab();
				casePage.goToPreviousPage();
				casePage.goToPreviousPage();
			}
			BrowserUtility.scrollToDown(driver);
			WaitUtility.waitForSeconds(0.5);
			if (!casePage.isNextButtonDisabled()) {
				casePage.clickOnNextButton();
			} else {
				break;
			}
			page++;
		}
		softAssert.assertAll();
	}

	// related matters test
	@Test(priority = 13, enabled = false)
	public void relatedMatterTabHighCourt() {
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquestTest();
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickCasesLink();
		CasesPage2 casePage = new CasesPage2(driver);
		int page = 1;
		while (true) {
			System.out.println("Current Page Before Loop: " + page);
			for (int i = 0; i < casePage.getTableRowsCount(); i++) {
				casePage.clickOnLink(String.valueOf((i + 1)));
				CasesDetailPage caseDetailPage = new CasesDetailPage(driver);
				softAssert.assertEquals(caseDetailPage.isCaseDetailTabVisible(), true);
				caseDetailPage.clickOnRelatedMattersTab();
				caseDetailPage.clickOnRelatedMattersBtn();
				softAssert.assertEquals(caseDetailPage.isRelatedMattersModalVisible(), true,
						"related matters modal is not visible");
				caseDetailPage.selectCourt("High Court");
				caseDetailPage.selectCase();
				softAssert.assertEquals(caseDetailPage.isAreYouSurePopUpVisible(), true,
						"are you sure pop up is not visible");
				caseDetailPage.clickOnYesChangeBtn();
				caseDetailPage.clickOnRelatedMattersSaveBtn();
				caseDetailPage.clickOnRelatedMattersTab();
				casePage.goToPreviousPage();
				casePage.goToPreviousPage();
			}
			BrowserUtility.scrollToDown(driver);
			WaitUtility.waitForSeconds(0.5);
			if (!casePage.isNextButtonDisabled()) {
				casePage.clickOnNextButton();
			} else {
				break;
			}
			page++;
		}
		softAssert.assertAll();
	}

	// related matters test
	@Test(priority = 14, enabled = false)
	public void relatedMatterTabTribunal() {
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquestTest();
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickCasesLink();
		CasesPage2 casePage = new CasesPage2(driver);
		int page = 1;
		while (true) {
			System.out.println("Current Page Before Loop: " + page);
			for (int i = 0; i < casePage.getTableRowsCount(); i++) {
				casePage.clickOnLink(String.valueOf((i + 1)));
				CasesDetailPage caseDetailPage = new CasesDetailPage(driver);
				softAssert.assertEquals(caseDetailPage.isCaseDetailTabVisible(), true);
				caseDetailPage.clickOnRelatedMattersTab();
				caseDetailPage.clickOnRelatedMattersBtn();
				softAssert.assertEquals(caseDetailPage.isRelatedMattersModalVisible(), true,
						"related matters modal is not visible");
				caseDetailPage.selectCourt("Tribunals");
				caseDetailPage.selectCase();
				softAssert.assertEquals(caseDetailPage.isAreYouSurePopUpVisible(), true,
						"are you sure pop up is not visible");
				caseDetailPage.clickOnYesChangeBtn();
				caseDetailPage.clickOnRelatedMattersSaveBtn();
				caseDetailPage.clickOnRelatedMattersTab();
				casePage.goToPreviousPage();
				casePage.goToPreviousPage();
			}
			BrowserUtility.scrollToDown(driver);
			WaitUtility.waitForSeconds(0.5);
			if (!casePage.isNextButtonDisabled()) {
				casePage.clickOnNextButton();
			} else {
				break;
			}
			page++;
		}
		softAssert.assertAll();
	}

}