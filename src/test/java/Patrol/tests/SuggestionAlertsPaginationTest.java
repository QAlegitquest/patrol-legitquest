package Patrol.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.DashBoardPage;
import Patrol.pages.LoginPage;
import Patrol.pages.SuggestionAlertsPage2;
import Patrol.utilities.AllureListeners;
import Patrol.utilities.BaseTest;
import Patrol.utilities.BrowserUtility;
import Patrol.utilities.CommonUtility;
import Patrol.utilities.ConfingDataProvider;
import Patrol.utilities.ScreenShotsUtility;
import Patrol.utilities.WaitUtility;
@Listeners(AllureListeners.class)
public class SuggestionAlertsPaginationTest extends BaseTest {
	SuggestionAlertsPage2 suggestionAlertPage;

	
	public void dologin() {
		
		String tag = "Tata";
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email2);
		loginPage.setPassword(ConfingDataProvider.Password2);
		loginPage.performAction();

		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnCompany("Legitquest");
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickAlertsLink();
		suggestionAlertPage = new SuggestionAlertsPage2(driver);
		suggestionAlertPage.clickOnSuggestionAlert();
		Assert.assertEquals(suggestionAlertPage.isTableVisible(), true, "Table is not visible befor clicking on tag");
		Assert.assertEquals(suggestionAlertPage.isTagFound(tag), true, tag+" tag is not found");
		suggestionAlertPage.clickOnTag(tag);
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Suggestion Alert / "+tag, "Header Miss Match");
	}
	
	@BeforeClass
	@Override
	public void launchBrowser() {
		super.launchBrowser();
		dologin();
	}

	@AfterClass
	@Override
	public void closeBrowser() {
		super.closeBrowser();
	}

	public void checkPagination() {
		SoftAssert softAssert = new SoftAssert();
		int lastPageNumber = suggestionAlertPage.getSecondLastPageNumber();
		for (int page = 2; page <= lastPageNumber; page++) {
			if (suggestionAlertPage.isLogoDisplayed()) {
				BrowserUtility.scrollToDown(driver);
				WaitUtility.waitForSeconds(2);
				suggestionAlertPage.clickOnPage(String.valueOf(page));
				WaitUtility.waitForSeconds(5);
			} else {
				String screenshotName = "Skip Page = " + page;
				softAssert.assertEquals(suggestionAlertPage.isLogoDisplayed(),true,screenshotName);
				ScreenShotsUtility.addScreenshotToReport(driver, screenshotName);
				suggestionAlertPage.goToPreviousPage();
				page++;
				BrowserUtility.scrollToDown(driver);
				WaitUtility.waitForSeconds(2);
				suggestionAlertPage.clickOnPage(String.valueOf(page));
				WaitUtility.waitForSeconds(5);
			}
		}
		softAssert.assertAll();
	}

	@Test(priority = 1, enabled = false)
	public void supremeCourtCasesTest() throws InterruptedException {
		suggestionAlertPage.clickOnSupremeCourtTab();
		checkPagination();
	}

	@Test(priority = 2, enabled = false)
	public void highCourtCasesTest() throws InterruptedException {
		suggestionAlertPage.clickOnHighCourtTab();
		checkPagination();
	}

	@Test(priority = 3, enabled = true)
	public void districtCourtCasesTest() throws InterruptedException {
		suggestionAlertPage.clickOnDistrictCourtTab();
		checkPagination();
	}

	@Test(priority = 4, enabled = false)
	public void tribunalsCourtCasesTest() throws InterruptedException {
		suggestionAlertPage.clickOnTribunalCourtTab();
		checkPagination();
	}
}