package Patrol.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.ContactsPage;
import Patrol.pages.LoginPage;
import Patrol.pages.MyCauselistPage;
import Patrol.utilities.BaseTest2;
import Patrol.utilities.CommonUtility;
import Patrol.utilities.ConfingDataProvider;
import Patrol.utilities.RetryAnalyzer;
import Patrol.utilities.WaitUtility;

public class MyCauselistPageTest extends BaseTest2{

	
	MyCauselistPage causelistPage;

	@BeforeClass()
	public void dologin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquest();
		WaitUtility.waitForSeconds(2);
		
		CommonUtility.clickOnLink(driver, "My Cause List");
		WaitUtility.waitForSeconds(5);
		causelistPage = new MyCauselistPage(driver);
	}

	@Test(priority = 1,retryAnalyzer = RetryAnalyzer.class)
	public void verifydailyTabTest() {
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Causelist", "Header Miss Match");
		Assert.assertEquals(causelistPage.isTabActive("Daily"), true, "Daily Tab is not active");
	}

	@Test(priority = 2,retryAnalyzer = RetryAnalyzer.class)
	public void verifyweeklyTabTest() {
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Causelist", "Header Miss Match");
		causelistPage.clickOnTab("Weekly");
		Assert.assertEquals(causelistPage.isTabActive("Weekly"), true, "Weekly Tab is not active");
	}

	@Test(priority =3,retryAnalyzer = RetryAnalyzer.class)
	public void verifyacchivedTabTest() {
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Causelist", "Header Miss Match");
		causelistPage.clickOnTab("Archived");
		Assert.assertEquals(causelistPage.isTabActive("Archived"), true, "Archived Tab is not active");
	}
}
