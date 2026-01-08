package com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class DashboardPage {
WebDriver driver ;
	public DashboardPage(WebDriver driver) {
		this.driver =driver ;
	}
	private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
	private By profileIcon = By.xpath("//span[@class='oxd-userdropdown-tab']");
	private By adminTab = By.xpath ("//span[text()='Admin']");
	private By LeaveTab = By.xpath ("//span[text()='Leave']");
	private By PIMTab = By.xpath ("//span[text()='PIM']");
	private By dashboardTab = By.xpath ("//span[text()='Dashboard']");

	public boolean isDashboardVisible() {
		return driver.findElement(dashboardHeader).isDisplayed();
	}
	public boolean isProfileIconVisible() {
		return driver.findElement(profileIcon).isDisplayed();
	}
	public void clickAdminTab() {
		driver.findElement(adminTab).click();
	}
	public void clickLeaveTab() {
		driver .findElement(LeaveTab).click();
	}
	public void clickPIMTab() {
		driver.findElement(PIMTab).click();
	}
	public void clickOnDashboard() {
		driver.findElement(dashboardTab).click();
	}
}