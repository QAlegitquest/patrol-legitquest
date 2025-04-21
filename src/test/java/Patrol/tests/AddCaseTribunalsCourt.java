package Patrol.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Patrol.dataprovider.add_case_page.TribunalsCourtDP;
import Patrol.pages.ActiveFirmPage;
import Patrol.pages.AddCasePage;
import Patrol.pages.CasesPage;
import Patrol.pages.DashBoardPage;
import Patrol.pages.LoginPage;
import Patrol.utilities.AllureListeners;
import Patrol.utilities.BaseTest;
import Patrol.utilities.ConfingDataProvider;
import dataprovider.TribunalCourtDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
@Listeners(AllureListeners.class)
public class AddCaseTribunalsCourt extends BaseTest {
	
AddCasePage addCasePage;
	
	
	public void dologin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnCompany("Justice House");

		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOnManageCases();
		dashBoardPage.clickCasesLink();
		CasesPage casePage = new CasesPage(driver);
		addCasePage = casePage.clickAddCaseButton();
		addCasePage.clickOnTribunalsCourt();
		
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
	
	@Test(priority = 1,enabled= false,dataProvider = "tribunals_court_data_NCLT", dataProviderClass = TribunalsCourtDP.class)
	@Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Tribunals Court Cases Data Avilibility Check")
	public void ByCaseNCLT(String bench, String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseNCLT(bench,caseType);
	}
	
	@Test(priority = 2,enabled= true,dataProvider = "tribunals_court_data_NCLAT", dataProviderClass = TribunalsCourtDP.class)
	@Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Tribunals Court Cases Data Avilibility Check")
	public void ByCaseNCLAT(String state,String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseNCLAT(state ,caseType);
	}
	
	@Test(priority = 3,enabled= false,dataProvider = "tribunals_court_data_ITAT", dataProviderClass = TribunalsCourtDP.class)
	@Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Tribunals Court Cases Data Avilibility Check")
	public void ByCaseITAT(String state,String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseITAT(state ,caseType);
	}
	
	@Test(priority = 4,enabled= true,dataProvider = "tribunals_court_data_APTEL", dataProviderClass = TribunalsCourtDP.class)
	@Severity(SeverityLevel.MINOR)
    @Description("Test Description: Tribunals Court Cases Data Avilibility Check")
	public void ByCaseAPTEL(String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseAPTEL(caseType);
	}
	
	@Test(priority = 6,enabled= true,dataProvider = "tribunals_court_data_CONSUMMER_COURT_NCDRC", dataProviderClass = TribunalsCourtDP.class)
	@Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Tribunals Court Cases Data Avilibility Check")
	public void ByCaseConsumerCourtNCDRC(String bench, String caseType,String caseTypeValue) throws IOException {
		addCasePage.tribunalsCourtByCaseConsumerCourtNCDRC(bench, caseType,caseTypeValue);
	}
	
	@Test(priority = 7,enabled= false,dataProvider = "tribunals_court_data_CONSUMMER_COURT_SCDRC", dataProviderClass = TribunalsCourtDP.class)
	@Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Tribunals Court Cases Data Avilibility Check")
	public void ByCaseConsumerCourtSCDRC(String court,String bench,String state ,String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseConsumerCourtSCDRC(court,bench,state,caseType);
	}
	
	@Test(priority = 8,enabled= false,dataProvider = "tribunals_court_data_CONSUMMER_COURT_DCDRC", dataProviderClass = TribunalsCourtDP.class)
	@Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Tribunals Court Cases Data Avilibility Check")
	public void ByCaseConsumerCourtDCDRC(String court,String bench, String state, String district, String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseConsumerCourtDCDRC(court,bench,state,district,caseType);
	}
	
	@Test(priority = 9,enabled= false,dataProvider = "tribunals_court_data_DRT", dataProviderClass = TribunalsCourtDP.class)
	@Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Tribunals Court Cases Data Avilibility Check")
	public void ByCaseDRT(String bench, String state, String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseDRT(bench, state, caseType);
	}
	
	@Test(priority = 10,enabled= false,dataProvider = "tribunals_court_data_CAT", dataProviderClass = TribunalsCourtDP.class)
	@Severity(SeverityLevel.MINOR)
    @Description("Test Description: Tribunals Court Cases Data Avilibility Check")
	public void ByCaseCAT(String bench, String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseCAT(bench, caseType);
	}
	
	@Test(priority = 11,enabled= true,dataProvider = "tribunals_court_data_TDSAT", dataProviderClass = TribunalsCourtDP.class)
	@Severity(SeverityLevel.TRIVIAL)
    @Description("Test Description: Tribunals Court Cases Data Avilibility Check")
	public void ByCaseTDSAT(String bench, String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseTDSAT(bench, caseType);
	}
	
	@Test(priority = 12,enabled= true,dataProvider = "tribunals_court_data_NGT", dataProviderClass = TribunalsCourtDP.class)
	@Severity(SeverityLevel.TRIVIAL)
    @Description("Test Description: Tribunals Court Cases Data Avilibility Check")
	public void ByCaseNGT(String bench, String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseNGT(bench, caseType);
	}
	
	@Test(priority = 13,enabled= true,dataProvider = "tribunals_court_data_SAT", dataProviderClass = TribunalsCourtDP.class)
	@Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Tribunals Court Cases Data Avilibility Check")
	public void ByCaseSAT(String bench, String year) throws IOException {
		addCasePage.tribunalsCourtByCaseSAT(bench, year);
	}
	
	@Test(priority = 14,enabled= true,dataProvider = "tribunals_court_data_RERA", dataProviderClass = TribunalsCourtDP.class)
	@Severity(SeverityLevel.TRIVIAL)
    @Description("Test Description: Tribunals Court Cases Data Avilibility Check")
	public void ByCaseRERA(String state, String bench) throws IOException {
		addCasePage.tribunalsCourtByCaseRERA(state, bench);
	}
	
	@Test(priority = 15,enabled= true,dataProvider = "tribunals_court_data_CESTAT", dataProviderClass = TribunalsCourtDP.class)
	@Severity(SeverityLevel.MINOR)
    @Description("Test Description: Tribunals Court Cases Data Avilibility Check")
	public void ByCaseCESTAT(String bench, String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseCESTAT(bench, caseType);
	}
	
	@Test(priority = 16,enabled= false,dataProvider = "tribunals_court_data_ELECTRICITY_COMMISSION", dataProviderClass = TribunalsCourtDP.class)
	@Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Tribunals Court Cases Data Avilibility Check")
	public void ByCaseElectricityCommission(String bench, String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseElectricityCommission(bench, caseType);
	}

}
