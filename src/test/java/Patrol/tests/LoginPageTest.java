package Patrol.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Patrol.pages.LoginPage;
import Patrol.utilities.BaseTest;
import Patrol.utilities.ConfingDataProvider;
import dataprovider.LoginPageDataProvider;

public class LoginPageTest extends BaseTest{
	@Test(priority = 1, enabled = false, dataProvider = "loginTestData", dataProviderClass = LoginPageDataProvider.class)
	public void verifyLoginPage(String email,String password,boolean expected) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.isEmailFieldVisible(),"Eamil Filed is not visible");
		Assert.assertTrue(loginPage.isPasswordFieldVisible(),"Password Filed is not visible");
		loginPage.setEmail(email);
		loginPage.setPassword(password);
		loginPage.performAction();
		Assert.assertEquals(loginPage.isLoggedSuccessFull(), expected,"Login was NOT successful!");
	}
	
	// login and logout test
	@Test(enabled = true)
	public void TC001(){
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.isEmailFieldVisible(),"Eamil Filed is not visible");
		Assert.assertTrue(loginPage.isPasswordFieldVisible(),"Password Filed is not visible");
		loginPage.setEmail(ConfingDataProvider.Email);
		loginPage.setPassword(ConfingDataProvider.Password);
		loginPage.performAction();
		Assert.assertEquals(loginPage.isLoggedSuccessFull(),true,"Login was NOT successful!");
		// testing logout functionality
		loginPage.clickOnLogout();
		Assert.assertTrue(loginPage.isLoggedOutSuccessFully(),"User Not Logout!");
	}
	
}