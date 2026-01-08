package com.tests;
import com.base.BaseTest;
import com.pages.*;
import com.utils.*;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import com.listerners.*;
@Listeners(TestListener.class)
public class RegressionTests extends BaseTest {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {
		initializeDriver(browser);
		loginPage = new LoginPage(getDriver());
		dashboardPage = new DashboardPage(getDriver());
	}
	@Test(groups = "regression")
	public void REG_01_loginWithInvalidUsername() {
		StepLogger.info("Login with invalid username");
		loginPage.login("invalidUser", ConfigReader.getProperty("password"));
		Assert.assertTrue(loginPage.isErrorDisplayed());
		StepLogger.pass("Error displayed for invalid username");
	}
	@Test(groups = "regression")
	public void REG_02_loginWithInvalidPassword() {
		StepLogger.info("Login with invalid password");
		loginPage.login(ConfigReader.getProperty("username"), "wrongPass");
		Assert.assertTrue(loginPage.isErrorDisplayed());
		StepLogger.pass("Error displayed for invalid password");
	}
	@Test(groups = "regression")
	public void REG_03_verifyValidLoginRedirectsToDashboard() {
		StepLogger.info("Login with valid credentials");
		loginPage.login(
		ConfigReader.getProperty("username"),
		ConfigReader.getProperty("password"));
		Assert.assertTrue(dashboardPage.isDashboardVisible());
		StepLogger.pass("User redirected to dashboard");
	}
	@Test(groups = "regression")
	public void REG_04_verifyPIMModule() {
		StepLogger.info("verify PIM Module test");
		dashboardPage.clickPIMTab();
		StepLogger.pass("PIM Tab is clicked");
	}
	@Test(groups = "regression")
	public void REG_05_verifyLeaveModule() {
		StepLogger.info("verify Leave Module test");
		dashboardPage.clickLeaveTab();
		StepLogger.pass("Leave Tab is clicked");
	}
	@Test(groups = "regression")
	public void REG_06_verifyAdminModule() {
		StepLogger.info("verify Admin Module test");
		dashboardPage.clickAdminTab();
		StepLogger.pass("Admin Tab is clicked");
		dashboardPage.clickOnDashboard();
		StepLogger.pass("Dashboard is clicked");
	}
	@Test(groups = "regression")
	public void REG_07_verifyPageRefreshAfterLogin() {
		StepLogger.info("Refreshing dashboard page");
		getDriver().navigate().refresh();
		Assert.assertTrue(dashboardPage.isDashboardVisible());
		StepLogger.pass("Dashboard retained after refresh");
	}
	@Test(groups = "regression")
	public void REG_08_verifySessionStillActive() {
		StepLogger.info("Validating active session");
		Assert.assertTrue(dashboardPage.isDashboardVisible());
		StepLogger.pass("Session is still active");
	}
	@AfterClass
	public void tearDown() {
		StepLogger.info("Closing browser for regression tests");
		quitDriver();
	}
}