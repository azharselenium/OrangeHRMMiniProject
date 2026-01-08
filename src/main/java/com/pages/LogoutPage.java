package com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LogoutPage {
WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}
	private By profileIcon = By.xpath("//span[@class='oxd-userdropdown-tab']");
	private By logoutBtn = By.xpath("//a[text()='Logout']");
	public void logout() {
	driver.findElement(profileIcon).click();
	driver.findElement(logoutBtn).click();
	}
}