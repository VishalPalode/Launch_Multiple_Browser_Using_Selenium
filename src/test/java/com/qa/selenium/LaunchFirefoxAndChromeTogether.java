package com.qa.selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LaunchFirefoxAndChromeTogether {
	static {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32\\chromedriver.exe");
	}

	WebDriver driver;

	@Test

	@Parameters({ "browser" })
	public void loginFFandCHROME(String browser) throws InterruptedException, IOException {
		Reporter.log(browser, true);
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
			FileInputStream configPath = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\LaunchMultipleBrowser\\src\\test\\java\\config.properties"); 
			Properties prop = new Properties(); 
			prop.load(configPath); 
			String url = prop.getProperty("https://www.facebook.com/"); 
		driver.get("url");
		WebElement un = driver.findElement(By.id("vishalpalode9899@gmail.com"));
		for (int i = 0; i < 10; i++) {
			un.sendKeys("admin" + i);
			Thread.sleep(2000);
			un.clear();
		}
		driver.close();
	}
}
