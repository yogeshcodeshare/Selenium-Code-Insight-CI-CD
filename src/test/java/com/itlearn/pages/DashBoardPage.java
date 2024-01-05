package com.itlearn.pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends BaseTest {
	WebDriver driver;

	// constructor
	public DashBoardPage(WebDriver lDriver) {
		this.driver = lDriver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"login-list\"]/li[1]/a")
	WebElement dash;

	@FindBy(xpath = "//a[normalize-space()='Offered Academies']")  
	WebElement offerAcademies;

	@FindBy(xpath = "//*[@id=\"tab-academies\"]/div/div/ul/li[1]/form/div/button")   
	WebElement subsribebtn;

	public void dashboardportal(String dashtext) throws IOException {
		String actualdash = dash.getText();
		System.out.println(actualdash);

		if (actualdash.equals(dashtext)) {
			System.out.println("Test Passed");

		} else {
			captureScreenShot(driver, "fetchDashboardText");
		}
		assertEquals(dashtext, actualdash);

	}

	public void dashboardclick() {
		dash.click();
	}

	public void offeracad() {
		offerAcademies.click();
		System.out.println("offerAcadmic clicked");
	}

	public void subscribeClick() {
		System.out.println("Subcribe button find");
		subsribebtn.click();
		System.out.println("Subcribe button clicked");
	}

}
