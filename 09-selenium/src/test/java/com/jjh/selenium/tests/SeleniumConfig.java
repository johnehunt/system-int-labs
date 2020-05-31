package com.jjh.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumConfig {
	private WebDriver driver;

	public SeleniumConfig() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	static {
		// Setting system properties of ChromeDriver
		// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "chromedriver");
	}

	public void close() {
		driver.close();
	}

	public WebDriver getDriver() {
		return driver;
	}
}
