package Patrol.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Patrol.utilities.BrowserUtility;
import Patrol.utilities.ScreenShotsUtility;
import Patrol.utilities.WaitUtility;

public class ActiveFirmPage extends BasePage {

	public ActiveFirmPage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@id='ajaxStatusDiv']//img")
	private WebElement loadder;
	
	@FindBy(xpath = "//input[@id='companySearch']")
	private WebElement serach_bar_ele;
	
	@FindBy(xpath = "//p[text()='No companies found.']")
	WebElement search_message_ele;
	
	@FindBy(xpath="//a[text()='Legitquest']")
	private WebElement legitquest;
	
	@FindBy(xpath="//a[normalize-space()='LegitquestTest']") 
	WebElement legitquestTest;
	
	@FindBy(xpath="//a[normalize-space()='LQ Test']") 
	WebElement lQTest;
	
	public void clickOnLegitquest(){
        legitquest.click();
	}
	
	public void clickOnLegitquestTest(){
        legitquestTest.click();
	}
	
	public void clickOnLQTest(){
        lQTest.click();
	}
	
	public void clickOnCompany(String companyName) {
	    String xpath = "//div[contains(@class,'company-item')]//a";
	    List<WebElement> companies = driver.findElements(By.xpath(xpath));
	    boolean found = false;
	    for (WebElement company : companies) {
	    	BrowserUtility.scrollIntoView(driver, company);
	        if (company.getText().trim().equalsIgnoreCase(companyName)) {
	        	WaitUtility.waitForElementToBeVisible(driver, company);
	        	WaitUtility.waitForElementToBeClickable(driver, company);
	        	BrowserUtility.click(driver, company);
	            found = true;
	            break;
	        }
	    }
	    if (!found) {
	        System.out.println(companyName + " Not Found");
	        ScreenShotsUtility.takeScreenshot(driver);
	    }
	}
	
	public void searchCompany(String companyName) {
		BrowserUtility.sendKeys(driver, serach_bar_ele,companyName);
		WaitUtility.waitForSeconds(5);
		boolean isMsgDisplayed  = WaitUtility.waitForElementToBeVisible(driver, search_message_ele);
		if(isMsgDisplayed){
			System.out.println(companyName + " Not Found");	
			ScreenShotsUtility.addScreenshotToReport(driver);
			ScreenShotsUtility.takeScreenshot(driver);
		}else {
			ScreenShotsUtility.takeScreenshot(driver);
			clickOnCompany(companyName);
		}
	}

}
