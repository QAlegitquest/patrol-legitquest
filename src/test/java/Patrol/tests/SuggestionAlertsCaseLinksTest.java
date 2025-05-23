package Patrol.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.CasesDetailPage;
import Patrol.pages.DashBoardPage;
import Patrol.pages.LoginPage;
import Patrol.pages.SuggestionAlertsPage2;
import Patrol.utilities.AllureListeners;
import Patrol.utilities.BaseTest;
import Patrol.utilities.BrowserUtility;
import Patrol.utilities.CommonUtility;
import Patrol.utilities.ConfingDataProvider;
import Patrol.utilities.WaitUtility;
@Listeners(AllureListeners.class)
public class SuggestionAlertsCaseLinksTest extends BaseTest {

	SuggestionAlertsPage2 suggestionAlertPage;

	
	public void dologin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email2);
		loginPage.setPassword(ConfingDataProvider.Password2);
		loginPage.performAction();

		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquest();

		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickAlertsLink();

		suggestionAlertPage = new SuggestionAlertsPage2(driver);
		suggestionAlertPage.clickOnSuggestionAlert();
		Assert.assertEquals(suggestionAlertPage.isTableVisible(), true, "Table is not visible befor clicking on tag");
		Assert.assertEquals(suggestionAlertPage.isTagFound("Tata"), true, "Tata tag is not found");        
		suggestionAlertPage.clickOnTag("Tata");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Suggestion Alert / Tata", "Header Miss Match");
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
	
	public void checkLinks() {
		SoftAssert softAssert = new SoftAssert();
		int page = 1;
		while (true) {
			for (int i = 0; i < suggestionAlertPage.getTableRowsCount(); i++) {
				suggestionAlertPage.clickOnLinkInRow(String.valueOf((i + 1)));
				CasesDetailPage caseDetailPage = new CasesDetailPage(driver);
				String msg = "Page => pNO, Row => rNo, CaseLink => cLink";
				if(!caseDetailPage.isCaseDetailTabVisible()) {
					msg = msg.replace("pNO",String.valueOf(page));
					msg = msg.replace("rNo",String.valueOf((i+1)));
					msg = msg.replace("cLink",driver.getCurrentUrl());
				}
				softAssert.assertEquals(caseDetailPage.isCaseDetailTabVisible(), true,msg);
				suggestionAlertPage.goToPreviousPage();
				System.out.println("row no => " + (i + 1));
			}
			BrowserUtility.scrollToDown(driver);
			WaitUtility.waitForSeconds(0.5);
			if (!suggestionAlertPage.isNextButtonDisabled()) {
				suggestionAlertPage.clickOnNextButton();
			}else {
				break;
			}
			page++;
		}
		softAssert.assertAll();
	}
	
	@Test(priority = 1, enabled = false)
	public void supremeCourtCasesTest() throws InterruptedException {
		suggestionAlertPage.clickOnSupremeCourtTab();
		checkLinks();
	}
	
	@Test(priority = 2, enabled = false)
	public void highCourtCasesTest() throws InterruptedException {
		suggestionAlertPage.clickOnHighCourtTab();
		checkLinks();
	}
	
	@Test(priority = 3, enabled = false)
	public void districtCourtCasesTest() throws InterruptedException {
		suggestionAlertPage.clickOnDistrictCourtTab();
		checkLinks();
	}
	
	@Test(priority = 4, enabled = true)
	public void tribunalsCourtCasesTest() throws InterruptedException {
		suggestionAlertPage.clickOnTribunalCourtTab();
		checkLinks();
	}
	
}
