package Patrol.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.DashBoardPage;
import Patrol.pages.LoginPage;
import Patrol.pages.PageNavigationAlertsPage;
import Patrol.utilities.AllureListeners;
import Patrol.utilities.BaseTest;
import Patrol.utilities.BrowserUtility;
import Patrol.utilities.ConfingDataProvider;
import Patrol.utilities.WaitUtility;
@Listeners(AllureListeners.class)
public class PageNavigationAlertsTest extends BaseTest {

	PageNavigationAlertsPage suggestionAlertPage;

	
	public void dologin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();

		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquest();

		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickAlertsLink();

		PageNavigationAlertsPage suggestionAlertPage = new PageNavigationAlertsPage(driver);
		suggestionAlertPage.clickOnSuggestionAlert();

		suggestionAlertPage.clickOnTag("Tata");

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

	@Test(priority = 1, enabled = false)
	public void supremeCourtTest() {

		PageNavigationAlertsPage suggestionAlertPage = new PageNavigationAlertsPage(driver);
		suggestionAlertPage.clickOnSupremeCourtTab();

		int lastPageNumber = suggestionAlertPage.getSecondLastPageNumber();

		for (int page = 2; page <= lastPageNumber; page++) {
			if (suggestionAlertPage.isLogoDisplayed()) {
				BrowserUtility.scrollToDown(driver);
				WaitUtility.waitForSeconds(2);
				suggestionAlertPage.clickOnPage(String.valueOf(page));
				System.out.println("Page = " + page);
				WaitUtility.waitForSeconds(5);
			} else {
				suggestionAlertPage.goToPreviousPage();
				page++;
				BrowserUtility.scrollToDown(driver);
				WaitUtility.waitForSeconds(2);
				suggestionAlertPage.clickOnPage(String.valueOf(page));
				System.out.println("Page = " + page);
				WaitUtility.waitForSeconds(5);
			}

		}

	}

	@Test(priority = 2, enabled = false)
	public void highCourtTest() {
		PageNavigationAlertsPage suggestionAlertPage = new PageNavigationAlertsPage(driver);

		suggestionAlertPage.clickOnHighCourtTab();

		int lastPageNumber = suggestionAlertPage.getSecondLastPageNumber();

		for (int page = 2; page <= lastPageNumber; page++) {
			if (suggestionAlertPage.isLogoDisplayed()) {
				BrowserUtility.scrollToDown(driver);
				WaitUtility.waitForSeconds(2);
				suggestionAlertPage.clickOnPage(String.valueOf(page));
				System.out.println("Page = " + page);
				WaitUtility.waitForSeconds(5);
			} else {
				suggestionAlertPage.goToPreviousPage();
				page++;
				BrowserUtility.scrollToDown(driver);
				WaitUtility.waitForSeconds(2);
				suggestionAlertPage.clickOnPage(String.valueOf(page));
				System.out.println("Page = " + page);
				WaitUtility.waitForSeconds(5);
			}

		}

	}

	@Test(priority = 3, enabled = false)
	public void districtCourtTest() {
		PageNavigationAlertsPage suggestionAlertPage = new PageNavigationAlertsPage(driver);
		suggestionAlertPage.clickOnDistrictCourtTab();

		int lastPageNumber = suggestionAlertPage.getSecondLastPageNumber();

		for (int page = 2; page <= lastPageNumber; page++) {
			if (suggestionAlertPage.isLogoDisplayed()) {
				BrowserUtility.scrollToDown(driver);
				WaitUtility.waitForSeconds(2);
				suggestionAlertPage.clickOnPage(String.valueOf(page));
				System.out.println("Page = " + page);
				WaitUtility.waitForSeconds(5);
			} else {
				suggestionAlertPage.goToPreviousPage();
				page++;
				BrowserUtility.scrollToDown(driver);
				WaitUtility.waitForSeconds(2);
				suggestionAlertPage.clickOnPage(String.valueOf(page));
				System.out.println("Page = " + page);
				WaitUtility.waitForSeconds(5);
			}

		}

	}

	@Test(priority = 4, enabled = false)
	public void tribunalCourtTest() {
		PageNavigationAlertsPage suggestionAlertPage = new PageNavigationAlertsPage(driver);
		suggestionAlertPage.clickOnTribunalCourtTab();

		int lastPageNumber = suggestionAlertPage.getSecondLastPageNumber();

		for (int page = 2; page <= lastPageNumber; page++) {
			if (suggestionAlertPage.isLogoDisplayed()) {
				BrowserUtility.scrollToDown(driver);
				WaitUtility.waitForSeconds(2);
				suggestionAlertPage.clickOnPage(String.valueOf(page));
				System.out.println("Page = " + page);
				WaitUtility.waitForSeconds(5);
			} else {
				suggestionAlertPage.goToPreviousPage();
				page++;
				BrowserUtility.scrollToDown(driver);
				WaitUtility.waitForSeconds(2);
				suggestionAlertPage.clickOnPage(String.valueOf(page));
				System.out.println("Page = " + page);
				WaitUtility.waitForSeconds(5);
			}

		}

	}

}
