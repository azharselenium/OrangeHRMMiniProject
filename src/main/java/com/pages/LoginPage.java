package com.pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {
	WebDriver driver ;
	public LoginPage(WebDriver driver) {
		this.driver=driver ;
	}
	private By username = By.name("username");
	private By password = By.name("password");
	private By loginBtn = By.xpath ("//button[@type='submit']");
	private By errorMsg = By.xpath ("//div[@class=\"oxd-alert-content oxd-alert-content--error\"]");
	public void login(String user , String pass ) {
		driver.findElement(username).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(username).sendKeys( user );
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
		driver.findElement(password).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
		driver.findElement(password).sendKeys( pass );
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
		driver.findElement(loginBtn).click();
	}
	public boolean isErrorDisplayed() {
		return driver.findElement(errorMsg).isDisplayed();
	}
}