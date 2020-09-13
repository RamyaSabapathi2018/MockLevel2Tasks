package org.level2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.Base.SupportClass;
import org.Base.WebElementSupportClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task4 extends SupportClass {
	WebElementSupportClass webelementclass = new WebElementSupportClass();
	TakesScreenshot screenshot = (TakesScreenshot) driver;

	@BeforeClass
	public void launchBrowser() {
		launchChromeBrowser();
	}

	@BeforeMethod
	public void launchURL() throws IOException {
		launchURL("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		maxBrowser();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("C:\\Users\\mypc\\Desktop\\Ramya-Prep\\sc\\MainPage.png"));

	}

	@Test
	public void loginTesting() throws IOException, InterruptedException, AWTException {
		List<String> list = new ArrayList();
		list.add("Pune");
		list.add("Delhi");
		try {
			WebElement from = findLocators("//span[text()='From']", "xpath");
			from.click();
			List<WebElement> allPlace = driver.findElements(By.xpath("//li[@role='option']"));
			for (WebElement eachPlaceFrom : allPlace) {
				if (eachPlaceFrom.getText().trim().contains(list.get(0))) {
					eachPlaceFrom.click();
					break;
				}
			}
			WebElement dest = findLocators("//span[text()='To']", "xpath");
			dest.click();
			List<WebElement> allPlace1 = driver.findElements(By.xpath("//li[@role='option']"));
			for (WebElement eachPlaceTo : allPlace1) {
				if (eachPlaceTo.getText().trim().contains(list.get(1))) {
					eachPlaceTo.click();
					break;
				}
			}
			WebElement date = findLocators("//label[@for='departure']", "xpath");
			webelementclass.clickButton(date);
			WebElement dateToTravel = findLocators("(//p[text()='20'])[1]", "xpath");
			webelementclass.clickButton(dateToTravel);
			WebElement searchButton = findLocators("//a[text()='Search']", "xpath");
			webelementclass.clickButton(searchButton);
			Thread.sleep(3000);
			File screenshotFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile1, new File("C:\\Users\\mypc\\Desktop\\Ramya-Prep\\sc\\FilghtPage.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void endLogin() throws IOException {
		driver.close();

	}

}
