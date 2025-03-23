package Patrol.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.ContactsPage;
import Patrol.pages.LoginPage;
import Patrol.pages.MyCauselistPage;
import Patrol.pages.SuggestionAlertsPage;
import Patrol.utilities.BaseTest2;
import Patrol.utilities.CommonUtility;
import Patrol.utilities.ConfingDataProvider;
import Patrol.utilities.WaitUtility;

public class SuggetionAlertPageTestTest extends BaseTest2{
	
	SuggestionAlertsPage suggestionAlertsPage;

	@BeforeClass()
	public void dologin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnCompany("Legitquest");
		WaitUtility.waitForSeconds(2);
		CommonUtility.clickOnLink(driver, "Manage Cases");
		WaitUtility.waitForSeconds(0.5);
		CommonUtility.clickOnLink(driver, "Alerts");
		
		suggestionAlertsPage = new SuggestionAlertsPage(driver);
	}

	@Test(priority = 1)
	public void verifyappealTabTest() {
		
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Appeal Alert", "Header Miss Match");
		Assert.assertEquals(suggestionAlertsPage.isTabActive("Appeal Alert"), true, "Appeal Alert Tab is not active");
	}

	@Test(priority = 2)
	public void verifysuggestionAlertTabTest() {
		suggestionAlertsPage.clickOnSuggestionAlert();
		WaitUtility.waitForSeconds(0.5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Suggestion Alert", "Header Miss Match");
		
		Assert.assertEquals(suggestionAlertsPage.isTabActive("Suggestion Alert"), true, "Suggestion Alert Tab is not active");
	}

	@Test(priority = 3)
	public void verifyadvocateTabTest() {
		suggestionAlertsPage.clickOnTab("Advocate Alert");
		WaitUtility.waitForSeconds(0.5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Advocate Alert", "Header Miss Match");
		
		Assert.assertEquals(suggestionAlertsPage.isTabActive("Advocate Alert"), true, "Advocate Alert Tab is not active");
	}
	
	@Test(priority = 4)
	public void verifysuggestionAlertTabSCTest() {
		suggestionAlertsPage.clickOnTab("Suggestion Alert");
		WaitUtility.waitForSeconds(0.5);
		suggestionAlertsPage.clickOnTataTag();
		WaitUtility.waitForSeconds(2);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), " Suggestion Alert / Tata", "Header Miss Match");
		
		Assert.assertEquals(suggestionAlertsPage.isTabActive("Supreme Court"), true, "Supreme Court Tab is not active");
	}
	
	@Test(priority = 5)
	public void verifysuggestionAlertTabHCTest() {
		suggestionAlertsPage.clickOnhighcourt();
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Suggestion Alert / Tata", "Header Miss Match");
		
		Assert.assertEquals(suggestionAlertsPage.isTabActive("High Court"), true, "High Court Tab is not active");
	}
	
	@Test(priority = 6)
	public void verifysuggestionAlertTabDCTest() {
		suggestionAlertsPage.clickOnDistrictCourt();
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Suggestion Alert / Tata", "Header Miss Match");
		
		Assert.assertEquals(suggestionAlertsPage.isTabActive("District Court"), true, "District Court Tab is not active");
	}
	
	@Test(priority = 7)
	public void verifysuggestionAlertTabTCTest() {
		suggestionAlertsPage.clickOnTribunalCourt();
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Suggestion Alert / Tata", "Header Miss Match");
		
		Assert.assertEquals(suggestionAlertsPage.isTabActive("Tribunal Court"), true, "Tribunal Court Tab is not active");
	}
	
	
}
