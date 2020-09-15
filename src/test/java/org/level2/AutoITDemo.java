package org.level2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITDemo {
	@Test
	public void uploadFile() throws InterruptedException, IOException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		ChromeOptions chrOptions = new ChromeOptions();
		chrOptions.merge(dc);
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(chrOptions);
		driver.get("http://www.tinyupload.com/");
		WebElement uploadBtn = driver.findElement(By.xpath("//input[@name='uploaded_file']"));
		Actions acc= new Actions(driver);
		acc.click(uploadBtn).perform();
		Runtime.getRuntime().exec("C:\\AutoITScript\\UploadFile.exe");
		Thread.sleep(2000);
		driver.close();
		
	}

}
