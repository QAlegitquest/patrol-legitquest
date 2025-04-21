package Patrol.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.CasesPage;
import Patrol.pages.DashBoardPage;
import Patrol.pages.LoginPage;
import Patrol.utilities.AllureListeners;
import Patrol.utilities.BaseTest;
import Patrol.utilities.ConfingDataProvider;
@Listeners(AllureListeners.class)
public class CaseDetailPageTest extends BaseTest {

	CasesPage casePage;
	
	
	public void dologin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquest();
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickCasesLink();
		casePage = new CasesPage(driver);
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
	
	@Test(priority = 0, enabled = true)
	public void allCasesTest() {
		casePage.checkLinkAllPages();
	}
	
	@Test(priority = 2, enabled = false)
	public void supremeCourtCasesTest() {
		casePage.clickOnFilter();
		casePage.clickOnSupremeCourt();
		casePage.checkLinkAllPages();
	}
	
	@Test(priority = 3, enabled = false)
	public void highCourtCasesTest() {
		casePage.clickOnFilter();
		casePage.clickOnHighCourt();
		casePage.checkLinkAllPages();
	}
	
	@Test(priority = 4, enabled = false)
	public void districtCourtCasesTest() {
		casePage.clickOnFilter();
		casePage.clickOnDistrictCourt();
		casePage.checkLinkAllPages();
	}
	
	@Test(priority = 5, enabled = false)
	public void tribunalsCourtCasesTest() {
		casePage.clickOnFilter();
		casePage.clickOnTribunalsCourt();
		casePage.checkLinkAllPages();
	}
}
