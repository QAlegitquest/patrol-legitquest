package Patrol.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.LoginPage;
import Patrol.pages.MatterPage;
import Patrol.utilities.BaseTest2;
import Patrol.utilities.BrowserUtility;
import Patrol.utilities.CommonUtility;
import Patrol.utilities.ConfingDataProvider;
import Patrol.utilities.RetryAnalyzer;
import Patrol.utilities.WaitUtility;

public class MatterPageTest extends BaseTest2 {

	@BeforeClass()
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
	
	@Test(priority=1,enabled = true)
	public void verifyAllLinksMatter() {
		SoftAssert softAssert = new SoftAssert();
		
		MatterPage matterPage = new MatterPage(driver);
		int page = 1;
		while (true) {
			
			for (int i = 0; i < matterPage.getTableRowsCount(); i++) {
				matterPage.clickOnLink(String.valueOf((i + 1)));
				
				String msg = "Page => pNO, Row => rNo, MatterLink => cLink";
				if(!matterPage.isMatterDetailTabVisible()) {
					msg = msg.replace("pNO",String.valueOf(page));
					msg = msg.replace("rNo",String.valueOf((i+1)));
					msg = msg.replace("cLink",driver.getCurrentUrl());
				}
				softAssert.assertEquals(matterPage.isMatterDetailTabVisible(), true,msg);
				matterPage.goToPreviousPage();
			}
			BrowserUtility.scrollToDown(driver);
			WaitUtility.waitForSeconds(0.5);
			if (!matterPage.isNextButtonDisabled()) {
				matterPage.clickOnNextButton();
			}else {
				break;
			}
			page++;
		}
		softAssert.assertAll();
	}
	
	@Test(priority=2,enabled = false,retryAnalyzer = RetryAnalyzer.class)
	public void verifyAllTabTest(){
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Matter","Header Miss Match");
		MatterPage matterPage = new MatterPage(driver);
		Assert.assertEquals(matterPage.isTabActive("ALL"),true,"All Tab is not active");
	}
	
	@Test(priority=3,enabled = false,retryAnalyzer = RetryAnalyzer.class)
	public void verifyOpenTabTest(){
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Matter","Header Miss Match");
		MatterPage matterPage = new MatterPage(driver);
		matterPage.clickOnTab("Open");
		Assert.assertEquals(matterPage.isTabActive("Open"),true,"Open Tab is not active");
	}
	
	@Test(priority=4,enabled = false,retryAnalyzer = RetryAnalyzer.class)
	public void verifyPendingTabTest(){
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Matter","Header Miss Match");
		MatterPage matterPage = new MatterPage(driver);
		matterPage.clickOnTab("Pending");
		Assert.assertEquals(matterPage.isTabActive("Pending"),true,"Pending Tab is not active");
	}

	@Test(priority=5,enabled = false,retryAnalyzer = RetryAnalyzer.class)
	public void verifyClosedTabTest(){
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Matter","Header Miss Match");
		MatterPage matterPage = new MatterPage(driver);
		matterPage.clickOnTab("Closed");
		Assert.assertEquals(matterPage.isTabActive("Closed"),true,"Closed Tab is not active");
	}

}
