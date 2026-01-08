package com.tests;
import com.base.BaseTest;
import com.pages.*;
import com.utils.*;
import org.testng.Assert;
import org.testng.annotations.*;
import com.listerners.*;
@Listeners(TestListener.class)
public class SmokeTests extends BaseTest {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	LogoutPage logoutPage;
	@BeforeClass(alwaysRun = true)
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser) {
		initializeDriver(browser);
		loginPage = new LoginPage(getDriver());
		dashboardPage = new DashboardPage(getDriver());
		logoutPage = new LogoutPage(getDriver());
	}
	@Test(groups = "smoke")
	public void SMOKE_01_verifyApplicationLaunch() {
		StepLogger.info("Verifying application launch");
		Assert.assertTrue(getDriver().getTitle().contains("OrangeHRM"),
		"Application title mismatch");
		StepLogger.pass("Application launched successfully");
	}
	@Test(groups = "smoke")
	public void SMOKE_02_verifyValidLogin() {
		StepLogger.info("Performing login with valid credentials");
		loginPage.login(
		ConfigReader.getProperty("username"),
		ConfigReader.getProperty("password"));
		Assert.assertTrue(dashboardPage.isDashboardVisible(),
		"Dashboard not visible after login");
		StepLogger.pass("Valid login successful");
	}
	@Test(groups = "smoke")
	public void SMOKE_03_verifyDashboardLoaded() {
		StepLogger.info("Verifying dashboard page");
		Assert.assertTrue(dashboardPage.isDashboardVisible(),
		"Dashboard page not loaded");
		StepLogger.pass("Dashboard loaded correctly");
	}
	@Test(groups = "smoke")
	public void SMOKE_04_verifyLogoutOptionVisible() {
		StepLogger.info("Checking logout option visibility");
		Assert.assertTrue(dashboardPage.isProfileIconVisible(),
		"Profile icon not visible");
		StepLogger.pass("Logout option is visible");
	}
	@Test(groups = "smoke")
	public void SMOKE_05_verifyLogoutFunctionality() {
		StepLogger.info("Performing logout");
		logoutPage.logout();
		Assert.assertTrue(getDriver().getCurrentUrl().contains("login"),
		"User not redirected to login page after logout");
		StepLogger.pass("Logout successful");
	}
	@AfterClass
	public void tearDown() {
		StepLogger.info("Closing browser for smoke tests");
		quitDriver();
	}
}