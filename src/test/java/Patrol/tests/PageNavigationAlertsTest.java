package Patrol.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.DashBoardPage;
import Patrol.pages.LoginPage;
import Patrol.pages.PageNavigationAlertsPage;
import Patrol.utilities.BaseTest;
import Patrol.utilities.BaseTest2;
import Patrol.utilities.BrowserUtility;
import Patrol.utilities.ConfingDataProvider;
import Patrol.utilities.WaitUtility;

public class PageNavigationAlertsTest extends BaseTest2 {

	PageNavigationAlertsPage suggestionAlertPage;

	@BeforeClass()
	public void verifyPagination() {
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

	@Test(priority = 4, enabled = true)
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
