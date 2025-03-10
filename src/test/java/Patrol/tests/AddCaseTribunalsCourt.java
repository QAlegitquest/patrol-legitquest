package Patrol.tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Patrol.dataprovider.add_case_page.TribunalsCourtDP;
import Patrol.pages.ActiveFirmPage;
import Patrol.pages.AddCasePage;
import Patrol.pages.CasesPage;
import Patrol.pages.DashBoardPage;
import Patrol.pages.LoginPage;
import Patrol.utilities.BaseTest2;
import Patrol.utilities.ConfingDataProvider;
import dataprovider.TribunalCourtDataProvider;

public class AddCaseTribunalsCourt extends BaseTest2 {
	
AddCasePage addCasePage;
	
	@BeforeClass()
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
	@Test(priority = 1,enabled= false,dataProvider = "tribunals_court_data_NCLT", dataProviderClass = TribunalsCourtDP.class)
	public void ByCaseNCLT(String bench, String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseNCLT(bench,caseType);
	}
	
	@Test(priority = 2,enabled= false,dataProvider = "tribunals_court_data_NCLAT", dataProviderClass = TribunalsCourtDP.class)
	public void ByCaseNCLAT(String state,String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseNCLAT(state ,caseType);
	}
	
	@Test(priority = 3,enabled= false,dataProvider = "tribunals_court_data_ITAT", dataProviderClass = TribunalsCourtDP.class)
	public void ByCaseITAT(String state,String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseITAT(state ,caseType);
	}
	
	@Test(priority = 4,enabled= false,dataProvider = "tribunals_court_data_APTEL", dataProviderClass = TribunalsCourtDP.class)
	public void ByCaseAPTEL(String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseAPTEL(caseType);
	}
	
	@Test(priority = 6,enabled= false,dataProvider = "tribunals_court_data_CONSUMMER_COURT_NCDRC", dataProviderClass = TribunalsCourtDP.class)
	public void ByCaseConsumerCourtNCDRC(String bench, String caseType,String caseTypeValue) throws IOException {
		addCasePage.tribunalsCourtByCaseConsumerCourtNCDRC(bench, caseType,caseTypeValue);
	}
	
	@Test(priority = 7,enabled= false,dataProvider = "tribunals_court_data_CONSUMMER_COURT_SCDRC", dataProviderClass = TribunalsCourtDP.class)
	public void ByCaseConsumerCourtSCDRC(String court,String bench,String state ,String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseConsumerCourtSCDRC(court,bench,state,caseType);
	}
	
	@Test(priority = 8,enabled= false,dataProvider = "tribunals_court_data_CONSUMMER_COURT_DCDRC", dataProviderClass = TribunalsCourtDP.class)
	public void ByCaseConsumerCourtDCDRC(String court,String bench, String state, String district, String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseConsumerCourtDCDRC(court,bench,state,district,caseType);
	}
	
	@Test(priority = 9,enabled= false,dataProvider = "tribunals_court_data_DRT", dataProviderClass = TribunalsCourtDP.class)
	public void ByCaseDRT(String bench, String state, String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseDRT(bench, state, caseType);
	}
	
	@Test(priority = 10,enabled= false,dataProvider = "tribunals_court_data_CAT", dataProviderClass = TribunalsCourtDP.class)
	public void ByCaseCAT(String bench, String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseCAT(bench, caseType);
	}
	
	@Test(priority = 11,enabled= false,dataProvider = "tribunals_court_data_TDSAT", dataProviderClass = TribunalsCourtDP.class)
	public void ByCaseTDSAT(String bench, String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseTDSAT(bench, caseType);
	}
	
	@Test(priority = 12,enabled= false,dataProvider = "tribunals_court_data_NGT", dataProviderClass = TribunalsCourtDP.class)
	public void ByCaseNGT(String bench, String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseNGT(bench, caseType);
	}
	
	@Test(priority = 13,enabled= false,dataProvider = "tribunals_court_data_SAT", dataProviderClass = TribunalsCourtDP.class)
	public void ByCaseSAT(String bench, String year) throws IOException {
		addCasePage.tribunalsCourtByCaseSAT(bench, year);
	}
	
	@Test(priority = 14,enabled= false,dataProvider = "tribunals_court_data_RERA", dataProviderClass = TribunalsCourtDP.class)
	public void ByCaseRERA(String state, String bench) throws IOException {
		addCasePage.tribunalsCourtByCaseRERA(state, bench);
	}
	
	@Test(priority = 15,enabled= false,dataProvider = "tribunals_court_data_CESTAT", dataProviderClass = TribunalsCourtDP.class)
	public void ByCaseCESTAT(String bench, String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseCESTAT(bench, caseType);
	}
	
	@Test(priority = 16,enabled= false,dataProvider = "tribunals_court_data_ELECTRICITY_COMMISSION", dataProviderClass = TribunalsCourtDP.class)
	public void ByCaseElectricityCommission(String bench, String caseType) throws IOException {
		addCasePage.tribunalsCourtByCaseElectricityCommission(bench, caseType);
	}

}
