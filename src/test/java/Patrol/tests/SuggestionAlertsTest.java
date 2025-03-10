package Patrol.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.DashBoardPage;
import Patrol.pages.LoginPage;
import Patrol.pages.SuggestionAlertsPage;
import Patrol.utilities.BaseTest;
import Patrol.utilities.ConfingDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class SuggestionAlertsTest extends BaseTest{
	
	

	@Test
	@Epic("EP002")
	@Feature("Alerts..")
	@Story("Suggestion Alerts..")
	@Description("Verifying Suggestion Alerts.....We are Veryfying whether the case number we want to check is available in the case list or not.")
	@Severity(SeverityLevel.NORMAL)
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
        suggestionAletrs.clickOnRam();
        suggestionAletrs.clickOnhighcourt();
        
        Assert.assertEquals(suggestionAletrs.findCaseNumberAllPage("COCP/400/2025"),true);        
   }
	
	
	}
	
	    
	     
