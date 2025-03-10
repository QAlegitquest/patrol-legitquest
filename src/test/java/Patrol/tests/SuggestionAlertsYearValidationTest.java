package Patrol.tests;

import org.testng.annotations.Test;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.DashBoardPage;
import Patrol.pages.LoginPage;
import Patrol.pages.SuggestionAlertsPage;
import Patrol.utilities.BaseTest;
import Patrol.utilities.ConfingDataProvider;

public class SuggestionAlertsYearValidationTest extends BaseTest {

	
	@Test
	public void verifySuggestionAlert() throws InterruptedException {
		LoginPage loginPage =new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquest();
		
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.clickOnManageCases();
        dashBoardPage.clickAlertsLink();
        
        SuggestionAlertsPage suggestionAletrs= new SuggestionAlertsPage(driver);
        suggestionAletrs.clickOnSuggestionAlert();
        suggestionAletrs.clickOnTataTag();
        suggestionAletrs.clickOnhighcourt();
       // suggestionAletrs.clickOnDistrictCourt();
        suggestionAletrs.matchCaseNumberAllPages("2025");
   }
}
