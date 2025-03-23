package Patrol.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Patrol.utilities.BrowserUtility;
import Patrol.utilities.WaitUtility;

public class MatterPage extends BasePage {

	public MatterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(@class,'navbar-brand')]//img")
	WebElement logo;

	@FindBy(xpath = "//table[contains(@class,\"table\")]")
	WebElement table;

	@FindBy(xpath = "//table[contains(@class,'table')]//tbody//tr")
	List<WebElement> table_rows;

	@FindBy(css = "ul.pagination>li:last-child")
	WebElement nextButton;

	@FindBy(css = "ul.pagination>li:nth-last-child(2)")
	WebElement scecondLastPage;

	@FindBy(xpath = "//button[normalize-space()='Matter']")
	WebElement matterDetailTab;

	public boolean isMatterDetailTabVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, matterDetailTab);
	}

	public boolean isLogoDisplayed() {
		return WaitUtility.waitForElementToBeVisible(driver, logo);
	}

	public boolean isTableVisible() {
		return WaitUtility.waitForElementToBeVisible(driver, table);
	}

	public int getTableRowsCount() {
		return table_rows.size();
	}

	// Methods

	public boolean isTabVisible(String tab_name) {
		String xpath = "//nav//a[normalize-space(text())='tab_name']";
		xpath = xpath.replace("tab_name", tab_name);
		WebElement tab = driver.findElement(By.xpath(xpath));
		return WaitUtility.waitForElementToBeVisible(driver, tab);
	}

	public void clickOnTab(String tab_name) {
		String xpath = "//nav//a[normalize-space(text())='tab_name']";
		xpath = xpath.replace("tab_name", tab_name);
		WebElement tab = driver.findElement(By.xpath(xpath));
		tab.click();
	}

	public boolean isTabActive(String tab_name) {
		String xpath = "//nav//a[normalize-space(text())='tab_name']";
		xpath = xpath.replace("tab_name", tab_name);
		WebElement tab = driver.findElement(By.xpath(xpath));
		String activeClass = tab.getAttribute("class");
		if (activeClass.contains("active")) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnLink(String rowcount) {
		String xpath = ".//tbody//tr[1]";
		xpath = xpath.replace("1", rowcount);
		WaitUtility.waitForElementToBeVisible(driver, table);
		WebElement row = table.findElement(By.xpath(xpath));
		WaitUtility.waitForElementToBeVisible(driver, row);
		WebElement matterlink = row.findElement(By.xpath(".//td[2]//a[not(@class='addTag')]"));
		WaitUtility.waitForElementToBeVisible(driver, matterlink);
		BrowserUtility.scrollIntoView(driver, row, true);
		BrowserUtility.mouseToElement(driver, matterlink);
		WaitUtility.waitForElementToBeClickable(driver, matterlink);
		matterlink.click();
	}

	public boolean isNextButtonDisabled() {
		WaitUtility.waitForElementToBeVisible(driver, nextButton);
		String buttonClass = nextButton.getAttribute("class");
		if (buttonClass.contains("disabled")) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnNextButton() {
		nextButton.click();
	}

	public void goToPreviousPage() {
		driver.navigate().back();
	}

}
