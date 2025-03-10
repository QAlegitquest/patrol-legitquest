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
import Patrol.utilities.ConfingDataProvider;
import Patrol.utilities.ScreenShotsUtility;
import Patrol.utilities.WaitUtility;

public class CasesPageTest2 extends BaseTest{

	@Test(priority=1,enabled = true)
	public void verifyAllLinks() {
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnCompany("Legitquest");
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
				if(!caseDetailPage.isCaseDetailTabVisible()) {
					msg = msg.replace("pNO",String.valueOf(page));
					msg = msg.replace("rNo",String.valueOf((i+1)));
					msg = msg.replace("cLink",driver.getCurrentUrl());
				}
				softAssert.assertEquals(caseDetailPage.isCaseDetailTabVisible(), true,msg);
				casePage.goToPreviousPage();
			}
			BrowserUtility.scrollToDown(driver);
			WaitUtility.waitForSeconds(0.5);
			if (!casePage.isNextButtonDisabled()) {
				casePage.clickOnNextButton();
			}else {
				break;
			}
			page++;
		}
		softAssert.assertAll();
	}
	
	@Test(priority=2,enabled = false)
	public void verifyPagination() {
		SoftAssert softAssert = new SoftAssert();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnCompany("Legitquest");
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
				softAssert.assertEquals(casePage.isLogoDisplayed(),true,screenshotName);
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
}
