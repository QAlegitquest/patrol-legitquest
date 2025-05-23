package Patrol.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.LoginPage;
import Patrol.pages.ReportPage;
import Patrol.utilities.AllureListeners;
import Patrol.utilities.BaseTest;
import Patrol.utilities.CommonUtility;
import Patrol.utilities.ConfingDataProvider;
import Patrol.utilities.RetryAnalyzer;
import Patrol.utilities.WaitUtility;
@Listeners(AllureListeners.class)
public class ReportPageTest extends BaseTest {

	ReportPage reportpage;
	
	
	public void dologin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquest();
		WaitUtility.waitForSeconds(2);
		CommonUtility.clickOnLink(driver, "Reports");
		WaitUtility.waitForSeconds(5);
		reportpage = new ReportPage(driver);
		
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
	
	@Test(priority = 1,retryAnalyzer = RetryAnalyzer.class)
	public void HearingStatusReport() throws IOException {
		
		reportpage.clickOnHearingStatusReport();
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Case: Hearing Status Report","Header Miss Match");
		
		
	}
	
	@Test(priority = 2,retryAnalyzer = RetryAnalyzer.class)
	public void OrderReportTest() throws IOException {
		reportpage.goToPreviousPage();
		reportpage.clickOnOrderReport();
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Case: Order Report","Header Miss Match");
		
	}
	
//	@Test(priority = 3,retryAnalyzer = RetryAnalyzer.class)
//	public void MatterNextDateHearing() throws IOException {
//		reportpage.goToPreviousPage();
//		reportpage.clickOnNextHearing();
//		WaitUtility.waitForSeconds(5);
//		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
//		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Matter: Matter Next Date Hearing","Header Miss Match");
//		
//	}
//	
//	@Test(priority = 4,retryAnalyzer = RetryAnalyzer.class)
//	public void MatterOrderReport() throws IOException {
//		reportpage.goToPreviousPage();
//		reportpage.clickOnMatterOrderReport();
//		WaitUtility.waitForSeconds(5);
//		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
//		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Matter: Matter Order Report","Header Miss Match");
//		
//	}
	
	@Test(priority = 5,retryAnalyzer = RetryAnalyzer.class)
	public void DocumentReport() throws IOException {
		reportpage.goToPreviousPage();
		reportpage.clickOnDocumentReport();
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Document Report","Header Miss Match");
		
	}
	
	@Test(priority = 6,retryAnalyzer = RetryAnalyzer.class)
	public void DocumentByMatterReport() throws IOException {
		reportpage.goToPreviousPage();
		reportpage.clickOnDocumentByMatter();
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Document By Matter Report","Header Miss Match");
		
	}
	
	@Test(priority = 7,retryAnalyzer = RetryAnalyzer.class)
	public void newCourtCaseReport() throws IOException {
		reportpage.goToPreviousPage();
		reportpage.clickOnnewCourtCasesReport();
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Case: New Court Cases","Header Miss Match");
		
	}
	
	@Test(priority = 8,retryAnalyzer = RetryAnalyzer.class)
	public void disposedCaseReport() throws IOException {
		reportpage.goToPreviousPage();
		reportpage.clickOndisposedCasesReport();
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Case: Disposed Cases","Header Miss Match");
		
	}
	
	@Test(priority = 9,retryAnalyzer = RetryAnalyzer.class)
	public void orderTrackerCaseReport() throws IOException {
		reportpage.goToPreviousPage();
		reportpage.clickOnorderTrackerCasesReport();
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver),"Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Case: Order Tracker Cases","Header Miss Match");
		
	}
}