package Patrol.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportPage extends BasePage {

	public ReportPage (WebDriver driver) {
		super(driver); 
	}
	
	@FindBy(xpath="//span[normalize-space()='Reports']") 
	WebElement reports;
	

    @FindBy(xpath="//a[normalize-space()='Order Report']") 
    WebElement orderReport;

    @FindBy(xpath="//a[normalize-space()='Hearing Status Report']") 
    WebElement hearingStatusReport;

    @FindBy(xpath="//a[contains(text(),'Next Hearing')]") 
    WebElement nextHearing;

    @FindBy(xpath="//a[normalize-space()='Matter Order Report']")  
    WebElement matterOrderReport;

    @FindBy(xpath="//a[normalize-space()='Document Report']") 
    WebElement documentReport;

    @FindBy(xpath="//a[normalize-space()='Document By Matter']") 
    WebElement documentByMatter;
    
    public void clickOnReport() {
		reports.click();
	}
    
    public void clickOnOrderReport() {
    	orderReport.click();
	}
    
    public void clickOnHearingStatusReport() {
    	hearingStatusReport.click();
	}
    
    public void clickOnNextHearing() {
    	nextHearing.click();
	}
    
    public void clickOnMatterOrderReport() {
    	matterOrderReport.click();
	}
    
    public void clickOnDocumentReport() {
    	documentReport.click();
	}
    
    public void clickOnDocumentByMatter() {
    	documentByMatter.click();
	}
    
    public void goToPreviousPage() {
		driver.navigate().back();
	}

}


