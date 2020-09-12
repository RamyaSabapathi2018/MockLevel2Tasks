package org.level2;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.Base.SupportClass;
import org.Base.WebElementSupportClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task3 extends SupportClass {
	
	WebElementSupportClass webelementclass= new WebElementSupportClass();
	TakesScreenshot screenshot = (TakesScreenshot)driver;
	@BeforeClass
	public void launchBrowser() {
		launchChromeBrowser();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

		
	@Test
	public void loginTesting() throws IOException, InterruptedException {
		launchURL("https://www.facebook.com/");
		maxBrowser();
	    WebElement email = findLocators("email","id");
	    webelementclass.insertValue(email, "mailramya26@gmail.com");
	    WebElement password = findLocators("pass","id");
	    webelementclass.insertValue(password, "12345");
	    WebElement login = findLocators("u_0_b","id");
	    Thread.sleep(3000);
	    
	    	File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\mypc\\Desktop\\Ramya-Prep\\sc\\BeforeLogin.png"));
	    	    Thread.sleep(3000);
	    webelementclass.clickButton(login);
	    Thread.sleep(3000);
	    	File screenshotFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshotFile1, new File("C:\\Users\\mypc\\Desktop\\Ramya-Prep\\sc\\AfterLogin.png"));
	    
	        
	}
	
	@AfterClass
	public void endLogin() throws IOException {
		driver.close();
		
	}

}
