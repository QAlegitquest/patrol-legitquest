package Patrol.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.CasesDetailPage;
import Patrol.pages.CasesPage2;
import Patrol.pages.DashBoardPage;
import Patrol.pages.LoginPage;
import Patrol.utilities.AllureListeners;
import Patrol.utilities.BaseTest;
import Patrol.utilities.BrowserUtility;
import Patrol.utilities.CommonUtility;
import Patrol.utilities.ConfingDataProvider;
import Patrol.utilities.FilePathUtil;
import Patrol.utilities.GenerateRandomData;
import Patrol.utilities.WaitUtility;
@Listeners(AllureListeners.class)
public class TabsTest extends BaseTest {

	@BeforeMethod
	@Override
	public void launchBrowser() {
		super.launchBrowser();
		
	}

	@AfterMethod
	@Override
	public void closeBrowser() {
		super.closeBrowser();
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
				
				caseDetailPage.selectState();
				WaitUtility.waitForSeconds(0.5);
				caseDetailPage.selectDistrict();
				WaitUtility.waitForSeconds(0.5);
				
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
				caseDetailPage.clickOnCreateNoteBtn();
				softAssert.assertEquals(caseDetailPage.isNoteModalVisible(), true, "notes modal is not visible");
				WaitUtility.waitForSeconds(0.5);
				caseDetailPage.enterNoteName("Note1");
				caseDetailPage.enterNoteDate();
				caseDetailPage.enterNotesDescription("Description1");
				caseDetailPage.clickOnNotesSaveBtn();
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
					String name = GenerateRandomData.getRandomName();
					String emailAddres = name+"@xyz.com";
					caseDetailPage.enterCompanyName(name);
					caseDetailPage.enterEmail(emailAddres);
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

	// contact test
	@Test(priority = 8, enabled = false)
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
			@Test(priority = 10, enabled = true)
			public void invoiceTest() {
				SoftAssert softAssert = new SoftAssert();
				LoginPage loginPage = new LoginPage(driver);
				loginPage.setEmail(ConfingDataProvider.Email);
				loginPage.setPassword(ConfingDataProvider.Password);
				loginPage.performAction();
				ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
				activeFirmpage.clickOnCompany("LegitquestTest");
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
						caseDetailPage.clickOnInvoiceTab();
						caseDetailPage.clickOnPostInvoiceBtn();
						softAssert.assertEquals(caseDetailPage.isInvoiceModalVisible(), true, "invoice modal is not visible");
						caseDetailPage.selectActivityCategory("Time spent onboarding new clients");
						caseDetailPage.enterCategoryDate(CommonUtility.getCurrentDate());
						caseDetailPage.selectPeopleClient("Mamta");
					    caseDetailPage.selectFeeType("Flat");
						caseDetailPage.enterAmount("5000");
						
						String contractFilePath = ".\\test-data\\invoice_tab_dummy_docs\\Swapnil_UPSC Form.pdf";
						String invoiceFilePath = ".\\test-data\\invoice_tab_dummy_docs\\Swapnil_Railway.pdf";
						
						caseDetailPage.uploadContract(FilePathUtil.getAbsolutePath(contractFilePath));
						caseDetailPage.uploadInvoice(FilePathUtil.getAbsolutePath(invoiceFilePath));
						
						softAssert.assertEquals(caseDetailPage.isInvoiceUploaded("Swapnil_Railway.pdf"), true,"invoice is not uploaded.");
						caseDetailPage.enterTermDate(CommonUtility.getCurrentDate());
						caseDetailPage.enterInvoiceDate(CommonUtility.getCurrentDate());
						caseDetailPage.selectDueDate("30 Days");
						caseDetailPage.enterInvoiceDescription("this is the invoice description");
						caseDetailPage.clickOnInvoiceModalSaveBtn();
						// --------------
						softAssert.assertEquals(caseDetailPage.isInvoiceModalHide(), true, "invoice modal is not hide");
						caseDetailPage.clickOnInvoiceTab();
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
				WaitUtility.waitForSeconds(0.5);
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

	// related matters test Supreme Court
			@Test(priority = 12, enabled = false)
			public void realatedMatterSupremeCourt() {
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
						WaitUtility.waitForSeconds(2);
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
				WaitUtility.waitForSeconds(3);
				caseDetailPage.selectSubCourt();
				WaitUtility.waitForSeconds(3);
				caseDetailPage.selectCase();
				softAssert.assertEquals(caseDetailPage.isAreYouSurePopUpVisible(), true,
						"are you sure pop up is not visible");
				caseDetailPage.clickOnYesChangeBtn();
				caseDetailPage.clickOnRelatedMattersSaveBtn();
				WaitUtility.waitForSeconds(0.5);
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
		@Test(priority = 1, enabled = false)
		public void relatedMatterTribunal() {
			SoftAssert softAssert = new SoftAssert();
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(ConfingDataProvider.Email);
			loginPage.setPassword(ConfingDataProvider.Password);
			loginPage.performAction();
			ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
			activeFirmpage.clickOnLegitquest();;
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

					try {
						caseDetailPage.selectCourt("Tribunals");
						WaitUtility.waitForSeconds(3);
						caseDetailPage.selectSubCourt();
						WaitUtility.waitForSeconds(3);
						caseDetailPage.selectCase();
						
						
					} catch (Exception e) {
						caseDetailPage.clickOnRelatedMatterModalCloseButton();
						casePage.goToPreviousPage();
						continue;
					}

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
