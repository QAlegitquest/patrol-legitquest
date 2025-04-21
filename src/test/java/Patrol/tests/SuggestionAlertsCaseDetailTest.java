package Patrol.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.DashBoardPage;
import Patrol.pages.LoginPage;
import Patrol.pages.SuggestionAlertsPage;
import Patrol.utilities.AllureListeners;
import Patrol.utilities.BaseTest;
import Patrol.utilities.ConfingDataProvider;
@Listeners(AllureListeners.class)
public class SuggestionAlertsCaseDetailTest extends BaseTest {

	SuggestionAlertsPage suggestionAletrsPage;

	
	public void dologin() {
		LoginPage loginPage =new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquest();
		
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.clickOnManageCases();
        dashBoardPage.clickAlertsLink();
        
        suggestionAletrsPage = new SuggestionAlertsPage(driver);
        suggestionAletrsPage.clickOnSuggestionAlert();
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
	
	@Test(priority = 0, enabled = false)
	public void supremeCourtCasesTest() throws InterruptedException {
		suggestionAletrsPage.clickOnTagAllPages("Tata");
		suggestionAletrsPage.clickOnSupreamcourt();
		suggestionAletrsPage.checkLinkAllPages();
	}
	
	@Test(priority = 1, enabled = false)
	public void highCourtCasesTest() throws InterruptedException {
		suggestionAletrsPage.clickOnTagAllPages("Tata");
		suggestionAletrsPage.clickOnhighcourt();
		suggestionAletrsPage.checkLinkAllPages();
	}
	
	@Test(priority = 2, enabled = false)
	public void districtCourtCasesTest() throws InterruptedException {
		suggestionAletrsPage.clickOnTagAllPages("Tata");
		suggestionAletrsPage.clickOnDistrictCourt();
		suggestionAletrsPage.checkLinkAllPages();
	}
	
	@Test(priority = 3, enabled = true)
	public void tribunalsCourtCasesTest() throws InterruptedException {
		suggestionAletrsPage.clickOnTagAllPages("Tata");
		suggestionAletrsPage.clickOnTribunalCourt();
		suggestionAletrsPage.checkLinkAllPages();
	}

}
