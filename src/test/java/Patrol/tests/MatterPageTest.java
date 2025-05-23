package Patrol.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.LoginPage;
import Patrol.pages.MatterPage;
import Patrol.utilities.AllureListeners;
import Patrol.utilities.BaseTest;
import Patrol.utilities.CommonUtility;
import Patrol.utilities.ConfingDataProvider;
import Patrol.utilities.RetryAnalyzer;
import Patrol.utilities.WaitUtility;
@Listeners(AllureListeners.class)
public class MatterPageTest extends BaseTest {
	
	
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
		CommonUtility.clickOnLink(driver, "Matters");
		WaitUtility.waitForSeconds(5);
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
	
	@Test(priority=1,enabled = true,retryAnalyzer = RetryAnalyzer.class)
	public void verifyAllTabTest(){
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Matter","Header Miss Match");
		MatterPage matterPage = new MatterPage(driver);
		Assert.assertEquals(matterPage.isTabActive("ALL"),true,"All Tab is not active");
	}
	
	@Test(priority=2,enabled = true,retryAnalyzer = RetryAnalyzer.class)
	public void verifyOpenTabTest(){
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Matter","Header Miss Match");
		MatterPage matterPage = new MatterPage(driver);
		matterPage.clickOnTab("Open");
		Assert.assertEquals(matterPage.isTabActive("Open"),true,"Open Tab is not active");
	}
	
	@Test(priority=3,enabled = true,retryAnalyzer = RetryAnalyzer.class)
	public void verifyPendingTabTest(){
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Matter","Header Miss Match");
		MatterPage matterPage = new MatterPage(driver);
		matterPage.clickOnTab("Pending");
		Assert.assertEquals(matterPage.isTabActive("Pending"),true,"Pending Tab is not active");
	}

	@Test(priority=4,enabled = true,retryAnalyzer = RetryAnalyzer.class)
	public void verifyClosedTabTest(){
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Matter","Header Miss Match");
		MatterPage matterPage = new MatterPage(driver);
		matterPage.clickOnTab("Closed");
		Assert.assertEquals(matterPage.isTabActive("Closed"),true,"Closed Tab is not active");
	}

}
