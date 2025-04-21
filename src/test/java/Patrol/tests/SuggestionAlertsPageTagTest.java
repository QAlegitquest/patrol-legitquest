package Patrol.tests;

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
@Listeners(AllureListeners.class)
public class SuggestionAlertsPageTagTest extends BaseTest{
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
	
   @Test(priority = 1)
   public void searchTagName() {
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
       suggestionAletrs.clickOnTagAllPages("Tata");
   }
}
