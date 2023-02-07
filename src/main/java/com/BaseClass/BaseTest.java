package com.BaseClass;


import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;


import com.Config.PropFileConfigure;
import com.Log.Log;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest{

	public static WebDriver driver;
	public static String propFilePath="./src/resources/java/com/PropertiesFile/PropertiesFile.properties";
	
	public BaseTest(){
		
		PropFileConfigure.loadPropFile(propFilePath);
		Log.info("Properties File Loaded");
		setUp();
	}
	

	public void setUp() {
		
		
		String browserName=PropFileConfigure.getPropFile("browser");
		
		if(browserName.equalsIgnoreCase("Edge")) {
			
			WebDriverManager.edgedriver().setup();
		    driver=new EdgeDriver();
		    Log.info("Edge Browser Lunched successfully");
		
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
		    Log.info("chrome Browser Lunched successfully");
		}
		else if(browserName.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
		    driver=new OperaDriver();
		    Log.info("opera Browser Lunched successfully");
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		    driver=new FirefoxDriver();
		    Log.info("firefox Browser Lunched successfully");
		}
		else
		{
			Log.warn("Please choose Browser");
			Log.info("warn message sent successfully");
		}
		
		driver.get(PropFileConfigure.getPropFile("amazonApplicationUrl"));
		Log.info("Application Lunched successfully");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		//Dimension d=new Dimension(1200,600);
		//driver.manage().window().setSize(d);
		driver.manage().window().maximize();
	}
	
	
	public void tearDown() {
	  driver.quit();	
	  Log.info("Edge Browser closed successfully");
	
	}
	
	
}
