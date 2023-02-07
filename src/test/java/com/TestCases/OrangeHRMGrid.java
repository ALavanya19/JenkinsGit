package com.TestCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BaseClass.BaseTest;

public class OrangeHRMGrid {
	

	@Test
	public void loginPageTest(String browserName) throws MalformedURLException {
	
	DesiredCapabilities cap=null;
	if(browserName.equalsIgnoreCase("edge")) {
	
		cap=DesiredCapabilities.edge();
		cap.setBrowserName("edge");
		cap.setPlatform(Platform.WINDOWS);
	
	}

	else if(browserName.equalsIgnoreCase("chrome")) {
		
		cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);

	}
	else if(browserName.equalsIgnoreCase("firefox")) {
		cap=DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WIN10);
	}
	
	RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.221.9:4444/wd/hub"), cap);
	
	driver.get("http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login");
	

	WebElement userNameE=driver.findElement(By.xpath("//*[@id='txtUsername']"));
	WebElement passwordE=driver.findElement(By.xpath("//*[@id='txtPassword']"));
	WebElement loginButton=driver.findElement(By.xpath("//*[@id='btnLogin']"));
	
	userNameE.sendKeys("ALavanya19");
	passwordE.sendKeys("ALavanya@19");
	loginButton.click();
	
	
	}
	

}
