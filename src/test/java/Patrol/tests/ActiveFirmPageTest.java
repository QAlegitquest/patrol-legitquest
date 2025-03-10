package Patrol.tests;

import org.testng.annotations.Test;

import Patrol.pages.ActiveFirmPage;
import Patrol.pages.LoginPage;
import Patrol.utilities.BaseTest;
import Patrol.utilities.ConfingDataProvider;
import Patrol.utilities.ScreenShotsUtility;

public class ActiveFirmPageTest extends BaseTest{
	@Test(priority=1 )
	public void verifyAlert() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();

		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.searchCompany("Legitquest");
		ScreenShotsUtility.takeScreenshot(driver);
	}
}
