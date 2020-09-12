package org.Base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class WebElementSupportClass {
	
	
	// Click the button
	public void clickButton(WebElement e) {
		e.click();
	}
	//To pass Value to field
	public void insertValue(WebElement e,String val) {
		e.sendKeys(val);
	}

	// Fetch the Text
	public String fetchText(WebElement e) {
		return e.getText();
	}

	// Fetch the Attribute Value
	public String fetchAttribute(WebElement e, String s) {
		return e.getAttribute(s);
	}

	// fetch CSS Value
	public String fetchCSSValue(WebElement e, String css) {
		return e.getCssValue(css);
	}

	// Get the Tag Name
	public String fetchTagName(WebElement e) {
		return e.getTagName();
	}

	// isDisplayed
	public boolean checkHidden(WebElement e) {
		return e.isDisplayed();
	}

	// isEnabled
	public boolean checkEnable(WebElement e) {
		return e.isEnabled();
	}

	// isSelected
	public boolean checkSelected(WebElement e) {
		return e.isSelected();
	}

	// Check the Size coordinates
	public Dimension fetchSize(WebElement e) {
		return e.getSize();
	}

	// Check the location coordinates
	public Point fetchLocation(WebElement e) {
		return e.getLocation();
	}

}
