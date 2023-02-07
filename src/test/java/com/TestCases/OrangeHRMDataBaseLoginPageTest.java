package com.TestCases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BaseClass.BaseTest;
import com.CommanActions.CommanActionsClass;
import com.Config.PropFileConfigure;
import com.Log.Log;


public class OrangeHRMDataBaseLoginPageTest extends BaseTest{

	public static String userName;
	public static String password;
	OrangeHRMDataBaseLoginPageTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void orangeHRMLoginPageTestDataFromDatabase() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException {
		
		
		//get the data from database
		
		String db_Url="jdbc:mysql://localhost:3310/";
		String db_Name="orangehrm";
		String db_Username="root";
		String db_Password="root";
		String db_Driver="com.mysql.cj.jdbc.Driver";
		String db_Query="select * from admin;";
		
		
		//Load jdbc driver
		Class.forName(db_Driver);
		Connection conn=DriverManager.getConnection(db_Url+db_Name,db_Username,db_Password);
		
		Statement stmt=conn.createStatement();
		
		ResultSet data=stmt.executeQuery(db_Query);
	
		
	    while(data.next()) {
	    	try {
	    	String userName=data.getString(1);
	    	String password=data.getString(2);
	    	loginPageTest(userName,password);
	    	 System.out.print(userName);
	 	    System.out.println(" "+password);
	    }
	    	catch(Exception e) {
	    		break;
	    	}
	    }
	   
	}
	
       
	   public void loginPageTest(String userNameFromDatabase,String passwordFromDatabase) throws IOException {
		   
	
		WebElement userNameE=driver.findElement(By.xpath("//*[@id='txtUsername']"));
		WebElement passwordE=driver.findElement(By.xpath("//*[@id='txtPassword']"));
		WebElement loginButton=driver.findElement(By.xpath("//*[@id='btnLogin']"));
		
		CommanActionsClass.sendKeys(userNameE, userNameFromDatabase);
		CommanActionsClass.sendKeys(passwordE, passwordFromDatabase);
		CommanActionsClass.click(loginButton);
		
		
		String actual_DashboardPage_Url=driver.getCurrentUrl();
		String expected_DashboardPAge_Url=PropFileConfigure.getPropFile("expected_DashboardPage_Url");
		
		if(actual_DashboardPage_Url.contains(expected_DashboardPAge_Url)) {
			
			dashboardPage();
			
		}
		else
		{
			//CommanActionsClass.screenShot(driver,userNameFromDatabase+passwordFromDatabase);
		}
		
	}
	   
	   public void dashboardPage() {
		   
		   WebElement welcomeAdminE=driver.findElement(By.xpath("//*[@id='welcome']"));
		   CommanActionsClass.click(welcomeAdminE);
		   
		   WebElement welcomeAdminLogoutE=driver.findElement(By.linkText("Logout"));
		   CommanActionsClass.click(welcomeAdminLogoutE);
		   
	   }
	
}
