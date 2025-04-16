package Patrol.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.DashBoardPage;
import Patrol.pages.LoginPage;
import Patrol.pages.ReportPage;
import Patrol.utilities.BaseTest2;
import Patrol.utilities.CommonUtility;
import Patrol.utilities.ConfingDataProvider;
import Patrol.utilities.RetryAnalyzer;
import Patrol.utilities.WaitUtility;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class DashBoardPageTest extends BaseTest2 {

	DashBoardPage dashboard;
	ReportPage reportpage;

	@BeforeClass()
	public void dologin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.clickOnLegitquest();
		dashboard = new DashBoardPage(driver);
		CommonUtility.clickOnLink(driver, "Dashboard");
		Assert.assertTrue(dashboard.isGraphicalViewTabVisible(), "Graphical view Tab is not visible");

	}

	@Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: Dashboard Test")
	public void viewAllcases() throws IOException {
		dashboard.clickOnviewAllCases();
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Cases", "Header Miss Match");
		
	}
	
	@Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: Dashboard Test")
	public void viewAllMatters() throws IOException {
		reportpage = new ReportPage(driver);
		reportpage.goToPreviousPage();
		dashboard.clickOnviewAllMatters();
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Matter", "Header Miss Match");
	}
	
	@Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: Dashboard Test")
	public void viewAllDocuments() throws IOException {
		reportpage.goToPreviousPage();
		dashboard.clickOnviewAllDocuments();
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Document", "Header Miss Match");
	}
	
	@Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: Dashboard Test")
	public void viewAllTasks() throws IOException {
		reportpage.goToPreviousPage();
		dashboard.clickOnviewAllTasks();
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Tasks", "Header Miss Match");
	}
	
	@Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: Dashboard Test")
	public void viewAllContacts() throws IOException {
		reportpage.goToPreviousPage();
		dashboard.clickOnviewAllContacts();
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Contacts", "Header Miss Match");
	}
	
	@Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: Dashboard Test")
	public void viewAllInvoices() throws IOException {
		reportpage.goToPreviousPage();
		dashboard.clickOnviewAllInvoice();
		WaitUtility.waitForSeconds(5);
		Assert.assertTrue(CommonUtility.isPageHeaderVisible(driver), "Header is not visible");
		Assert.assertEquals(CommonUtility.verifyPageHeader(driver), "Invoice", "Header Miss Match");
	}
}