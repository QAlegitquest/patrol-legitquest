package Patrol.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.CasesDetailPage;
import Patrol.pages.CasesPage2;
import Patrol.pages.DashBoardPage;
import Patrol.pages.LoginPage;
import Patrol.pages.NotificationPage;
import Patrol.utilities.AllureListeners;
import Patrol.utilities.BaseTest;
import Patrol.utilities.BrowserUtility;
import Patrol.utilities.CommonUtility;
import Patrol.utilities.ConfingDataProvider;
import Patrol.utilities.RetryAnalyzer;
import Patrol.utilities.WaitUtility;
@Listeners(AllureListeners.class)
public class NotificationPageTest extends BaseTest {

	
	public void dologin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquest();
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
	
	@Test(priority=8,enabled = true,retryAnalyzer = RetryAnalyzer.class)
	public void verifyTabsAll(){
		CommonUtility.clickOnLink(driver, "Notification");
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Notification","Header Miss Match");
		NotificationPage notificationPage = new NotificationPage(driver);
		Assert.assertEquals(notificationPage.isTabVisible("All"),true,"All Tab is not visible");
		notificationPage.clickOnTab("All");
		Assert.assertEquals(notificationPage.isTabActive("All"),true,"All Tab is not active");
	}
	
	@Test(priority=2,enabled = true,retryAnalyzer = RetryAnalyzer.class)
	public void verifyTabsCaseDetail(){
		CommonUtility.clickOnLink(driver, "Notification");
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Notification","Header Miss Match");
		NotificationPage notificationPage = new NotificationPage(driver);
		Assert.assertEquals(notificationPage.isTabVisible("Case Detail"),true,"Case Detail Tab is not visible");
		notificationPage.clickOnTab("Case Detail");
		Assert.assertEquals(notificationPage.isTabActive("Case Detail"),true,"Case Detail Tab is not active");
	}
	
	@Test(priority=3,enabled = true,retryAnalyzer = RetryAnalyzer.class)
	public void verifyTabsCauseList(){
		CommonUtility.clickOnLink(driver, "Notification");
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Notification","Header Miss Match");
		NotificationPage notificationPage = new NotificationPage(driver);
		Assert.assertEquals(notificationPage.isTabVisible("Cause List"),true,"Cause List Tab is not visible");
		notificationPage.clickOnTab("Cause List");
		Assert.assertEquals(notificationPage.isTabActive("Cause List"),true,"Cause List Tab is not active");
	}
	
	@Test(priority=4,enabled = true,retryAnalyzer = RetryAnalyzer.class)
	public void verifyTabsNextDate(){
		CommonUtility.clickOnLink(driver, "Notification");
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Notification","Header Miss Match");
		NotificationPage notificationPage = new NotificationPage(driver);
		Assert.assertEquals(notificationPage.isTabVisible("Next Date"),true,"Next Date Tab is not visible");
		notificationPage.clickOnTab("Next Date");
		Assert.assertEquals(notificationPage.isTabActive("Next Date"),true,"Next Date Tab is not active");
	}
	
	@Test(priority=5,enabled = true,retryAnalyzer = RetryAnalyzer.class)
	public void verifyTabsOrder(){
		CommonUtility.clickOnLink(driver, "Notification");
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Notification","Header Miss Match");
		NotificationPage notificationPage = new NotificationPage(driver);
		Assert.assertEquals(notificationPage.isTabVisible("Order"),true,"Order Tab is not visible");
		notificationPage.clickOnTab("Order");
		Assert.assertEquals(notificationPage.isTabActive("Order"),true,"Order Tab is not active");
	}
	
	@Test(priority=6,enabled = true,retryAnalyzer = RetryAnalyzer.class)
	public void verifyTabsMisc(){
		CommonUtility.clickOnLink(driver, "Notification");
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Notification","Header Miss Match");
		NotificationPage notificationPage = new NotificationPage(driver);
		Assert.assertEquals(notificationPage.isTabVisible("Misc"),true,"Misc Tab is not visible");
		notificationPage.clickOnTab("Misc");
		Assert.assertEquals(notificationPage.isTabActive("Misc"),true,"Misc Tab not active");
	}
	
	@Test(priority=7,enabled = true,retryAnalyzer = RetryAnalyzer.class)
	public void verifyTabsInvoice(){
		CommonUtility.clickOnLink(driver, "Notification");
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Notification","Header Miss Match");
		NotificationPage notificationPage = new NotificationPage(driver);
		Assert.assertEquals(notificationPage.isTabVisible("Invoice"),true,"Invoice Tab is not visible");
		notificationPage.clickOnTab("Invoice");
		Assert.assertEquals(notificationPage.isTabActive("Invoice"),true,"Invoice Tab is not active");
	}
	
	
	
	
}
