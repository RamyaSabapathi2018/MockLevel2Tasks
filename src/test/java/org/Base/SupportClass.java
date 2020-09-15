package org.Base;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SupportClass {
	public static WebDriver driver; // To have shared Memory we kept as static
	// To Launch ChromeBrowser

	public WebDriver launchChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		return driver = new ChromeDriver();
	}

	// To Launch the URL
	public void launchURL(String url) {
				driver.get(url);
	}

	// To Return the Title
	public String getBrowserTitle() {
		return driver.getTitle();
	}

	// To Return the CurrentURL
	public String getBrowserCurrentURL() {
		return driver.getCurrentUrl();
	}

	// To Return the PageSource
	public String getBrowserPageSource() {
		return driver.getPageSource();
	}

	// To Get Parent Window Id
	public String toFetchWindowId() {
		String parentWindowId = driver.getWindowHandle();
		return parentWindowId;
	}

	// To Get all Open Windows
	public Set<String> tofetchAllChildWindow() {
		Set<String> allChildWindow = driver.getWindowHandles();
		return allChildWindow;
	}

	// To close the current browser
	public void closeSingleWindow() {
		driver.close();
	}

	// To close all browser
	public void closeAllWindow() {
		driver.quit();
	}

	// To switch to Frame
	public void toSwitchFrame(String frame, WebElement e, int i) {
		if (null != frame) {
			driver.switchTo().frame(frame);
		} else if (null != e) {
			driver.switchTo().frame(e);
		} else if (i > 0) {
			driver.switchTo().frame(i);
		}
	}

	// To switch to Alert
	public Alert toSwitchAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	// To do the manage Max window
	public void toManageWindow() {
		driver.manage().window().maximize();
	}

	// To find the locators using findelements
	public WebElement findLocators(String findLocator, String locator) {
		WebElement e = null;
		int type = 0;
		if (locator.equals("id")) {
			type = 1;
		} else if (locator.equals("name")) {
			type = 2;
		} else if (locator.equals("className")) {
			type = 3;
		} else if (locator.equals("tagName")) {
			type = 4;
		} else if (locator.equals("linkText")) {
			type = 5;
		} else if (locator.equals("partialLinkText")) {
			type = 6;
		} else if (locator.equals("xpath")) {
			type = 7;
		} else if (locator.equals("cssSelector")) {
			type = 8;
		} else {
			type = 0;
		}
		switch (type) {
		case 1:
			e = driver.findElement(By.id(findLocator));
			return e;
		case 2:
			e = driver.findElement(By.name(findLocator));
			return e;
		case 3:
			e = driver.findElement(By.className(findLocator));
			return e;
		case 4:
			e = driver.findElement(By.tagName(findLocator));
			return e;
		case 5:
			e = driver.findElement(By.linkText(findLocator));
			return e;
		case 6:
			e = driver.findElement(By.partialLinkText(findLocator));
			return e;
		case 7:
			e = driver.findElement(By.xpath(findLocator));
			return e;
		case 8:
			e = driver.findElement(By.cssSelector(findLocator));
			return e;
		default:
			break;

		}
		return e;

	}

	// To Take ScreenShot
	public void toTakeScreenShot(String path) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File f = new File(path);
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, f);

	}

	// To Navigate back in the page
	public void navBack() {
		driver.navigate().back();
	}
	//Max the window
	public void maxBrowser() {
		driver.manage().window().maximize();
	}

	// To Navigate forward in the page
	public void navForward() {
		driver.navigate().forward();
	}

	// To refresh the page
	public void navRefresh() {
		driver.navigate().refresh();
	}

}
