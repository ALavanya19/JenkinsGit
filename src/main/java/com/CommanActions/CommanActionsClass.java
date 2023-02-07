package com.CommanActions;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommanActionsClass {

	
	public static void screenShot(WebDriver driver,String screenShotName) throws IOException {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d=new Date();
		FileUtils.copyFile(src, new File("./src/resources/java/com/Screenshots/"+screenShotName+".png"));
	
	}
	
	public static void dropDownSelect(WebElement dropDownElement,String optionName) {
		
		Select sel=new Select(dropDownElement);
		sel.selectByVisibleText(optionName);
		
	}
    public static void dropDownDeselect(WebElement dropDownElement,String optionName) {
		
		Select sel=new Select(dropDownElement);
		sel.deselectByVisibleText(optionName);
		
	}

    public static void click(WebElement clickElement) {
	
	        clickElement.click();
	
    }
    
    public static void sendKeys(WebElement sendkeysElement,String data) {
    	   sendkeysElement.sendKeys(data);
    }
}
