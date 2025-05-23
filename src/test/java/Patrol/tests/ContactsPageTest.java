package Patrol.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.ContactsPage;
import Patrol.pages.LoginPage;
import Patrol.utilities.AllureListeners;
import Patrol.utilities.BaseTest;
import Patrol.utilities.CommonUtility;
import Patrol.utilities.ConfingDataProvider;
import Patrol.utilities.RetryAnalyzer;
import Patrol.utilities.WaitUtility;
@Listeners(AllureListeners.class)
public class ContactsPageTest extends BaseTest {
	
	
	ContactsPage contactPage;

	
	public void dologin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquest();
		WaitUtility.waitForSeconds(2);
		CommonUtility.clickOnLink(driver, "Manage Cases");
		WaitUtility.waitForSeconds(0.5);
		CommonUtility.clickOnLink(driver, "Contacts");
		WaitUtility.waitForSeconds(5);
		contactPage = new ContactsPage(driver);
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

	@Test(priority = 0,retryAnalyzer = RetryAnalyzer.class)
	public void verifyAllTabTest() {
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Contacts", "Header Miss Match");
		Assert.assertEquals(contactPage.isTabActive("ALL"), true, "All Tab is not active");
	}

	@Test(priority = 1,retryAnalyzer = RetryAnalyzer.class)
	public void verifyIndividualTabTest() {
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Contacts", "Header Miss Match");
		contactPage.clickOnTab("Individual");
		Assert.assertEquals(contactPage.isTabActive("Individual"), true, "Individual Tab is not active");
	}

	@Test(priority = 2,retryAnalyzer = RetryAnalyzer.class)
	public void verifyCompaniesTabTest() {
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Contacts", "Header Miss Match");
		contactPage.clickOnTab("Companies");
		Assert.assertEquals(contactPage.isTabActive("Companies"), true, "Companies Tab is not active");
	}

}