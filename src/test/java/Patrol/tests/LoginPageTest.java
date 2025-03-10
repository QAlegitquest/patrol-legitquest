package Patrol.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Patrol.pages.LoginPage;
import Patrol.utilities.BaseTest;
import dataprovider.LoginPageDataProvider;



public class LoginPageTest extends BaseTest {
     
	@Test(dataProvider = "loginTestData", dataProviderClass =LoginPageDataProvider.class)
	public void ValidateLoginPage(String email,String password,boolean expected) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(email);
		loginPage.setPassword(password);
		loginPage.performAction();
		Assert.assertEquals(loginPage.isLoggedSuccessFull(), expected,"Login was NOT successful!");
     }
	
}