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

public class SuggetionAlertSanityTest extends BaseTest2{
	
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
		CommonUtility.clickOnLink(driver, "Contacts");
		WaitUtility.waitForSeconds(5);
		suggestionAlertsPage = new SuggestionAlertsPage(driver);
	}

	@Test(priority = 1)
	public void verifyappealTabTest() {
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Contacts", "Header Miss Match");
		Assert.assertEquals(suggestionAlertsPage.isTabActive("ALL"), true, "All Tab is not active");
	}

	@Test(priority = 2)
	public void verifysuggestionAlertTabTest() {
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Contacts", "Header Miss Match");
		suggestionAlertsPage.clickOnTab("Individual");
		Assert.assertEquals(suggestionAlertsPage.isTabActive("Individual"), true, "Individual Tab is not active");
	}

	@Test(priority = 3)
	public void verifyadvocateTabTest() {
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Contacts", "Header Miss Match");
		suggestionAlertsPage.clickOnTab("Companies");
		Assert.assertEquals(suggestionAlertsPage.isTabActive("Companies"), true, "Companies Tab is not active");
	}
	
	@Test(priority = 4)
	public void verifyusersTabTest() {
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Contacts", "Header Miss Match");
		suggestionAlertsPage.clickOnTab("Companies");
		Assert.assertEquals(suggestionAlertsPage.isTabActive("Companies"), true, "Companies Tab is not active");
	}

}
