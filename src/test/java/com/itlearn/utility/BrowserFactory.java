package com.itlearn.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	/* 1) define path of driver, 
	 * 2)create object of the driver 
	 * 3) using the object-
	 * use the get method to pass the URL
	 */
	public static WebDriver startApplication(WebDriver driver, String browserName, String appUrl) {
		// startApplication is the Methode Name and return type is driver object
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(op);
		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("Edge")) {
			System.setProperty("webdriver.msedge.driver", "./Drivers/msedgedriver.exe"); 
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("We do not support this browser ");
		}

		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;

	}

	public static void quitBrowser(WebDriver driver) {
		driver.close();
	}

}
