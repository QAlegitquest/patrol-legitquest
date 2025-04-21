package Patrol.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.DashBoardPage;
import Patrol.pages.LoginPage;
import Patrol.pages.SuggestionAlertsPage;
import Patrol.utilities.AllureListeners;
import Patrol.utilities.BaseTest;
import Patrol.utilities.ConfingDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Listeners(AllureListeners.class)
public class SuggestionAlertsTest extends BaseTest{
	
	@BeforeMethod
	@Override
	public void launchBrowser() {
		super.launchBrowser();
		
	}

	@AfterMethod
	@Override
	public void closeBrowser() {
		super.closeBrowser();
	}
	
	@Test
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
	
	    
	     
