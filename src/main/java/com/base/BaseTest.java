package com.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import com.utils.ConfigReader;

public class BaseTest {
private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static WebDriver getDriver() {
		return driver.get();
	}
		@Parameters("browser")
		public void initializeDriver(String browser ) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Current browser is "+browser );
			driver.set( new ChromeDriver());
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Current browser is "+browser);
			driver.set( new FirefoxDriver());
		}
		else if (browser.equalsIgnoreCase("edge")) {
			System.out.println("Current browser is "+browser);
			String edgeDriverPath=System.getProperty("user.dir") + "/drivers/msedgedriver.exe";
			System.setProperty("webdriver.edge.driver", edgeDriverPath);
			driver.set( new EdgeDriver());
	}
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().get(ConfigReader.getProperty("url"));
}
	public void quitDriver() {
		getDriver().quit();
		driver.remove();
	}
	}