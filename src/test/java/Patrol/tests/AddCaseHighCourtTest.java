package Patrol.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Patrol.dataprovider.add_case_page.HighCourtDP;
import Patrol.pages.ActiveFirmPage;
import Patrol.pages.AddCasePage;
import Patrol.pages.CasesPage;
import Patrol.pages.DashBoardPage;
import Patrol.pages.LoginPage;
import Patrol.utilities.AllureListeners;
import Patrol.utilities.BaseTest;
import Patrol.utilities.ConfingDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
@Listeners(AllureListeners.class)
public class AddCaseHighCourtTest extends BaseTest {

	AddCasePage addCasePage;

	
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
		CasesPage casePage = new CasesPage(driver);
		addCasePage = casePage.clickAddCaseButton();
		addCasePage.clickOnHighCourt();
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

	@Test(priority = 1, enabled = false, dataProvider = "high_court_data_By_Case", dataProviderClass = HighCourtDP.class)
	@Severity(SeverityLevel.NORMAL)
    @Description("Test Description: High Court Cases, Data Avilibility Check")
	public void high_court_data_By_Case(String court, String bench, String caseType) throws IOException {
		addCasePage.clickOnTab("By Case");
		addCasePage.highCourtByCase(court, bench, caseType);
	}

	@Test(priority = 2, enabled = false, dataProvider = "high_court_data_By_CNR_Number", dataProviderClass = HighCourtDP.class)
	@Severity(SeverityLevel.NORMAL)
    @Description("Test Description: High Court Cases, Data Avilibility Check")
	public void high_court_data_By_CNR_Number(String cnr) throws IOException {
		addCasePage.clickOnTab("By CNR Number");
		addCasePage.highCourtByCNR(cnr);
	}

	@Test(priority = 3, enabled = true, dataProvider = "high_court_data_By_Party_Name", dataProviderClass = HighCourtDP.class)
	@Severity(SeverityLevel.NORMAL)
    @Description("Test Description: High Court Cases, Data Avilibility Check")
	public void high_court_data_By_Party_Name(String Court, String CaseStatus, String year, String PartyName)
			throws IOException {
		addCasePage.clickOnTab("By Party Name");
		addCasePage.highCourtByPartyName(Court, CaseStatus, year, PartyName);
	}

	@Test(priority = 4, enabled = false, dataProvider = "high_court_data_By_Advocate", dataProviderClass = HighCourtDP.class)
	@Severity(SeverityLevel.NORMAL)
    @Description("Test Description: High Court Cases, Data Avilibility Check")
	public void high_court_data_By_Advocate(String Court, String Advocate) throws IOException {
		addCasePage.clickOnTab("By Advocate");
		addCasePage.highCourtByAdvocate(Court, Advocate);
	}

}