package com.TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.BaseClass.BaseTest;
import com.ExcelOperations.ExcelFile;

public class CreateAccountPage extends BaseTest {

	String excelFilePath="./src/resources/java/com/TestDataInputFiles/Monster.xlsx";
	String excelSaveFilePath="./src/resources/java/com/TestOutResultFiles/MonsterResults.xlsx";
	
	@Test
	public void createAccountTest() throws IOException, InterruptedException {
		
		WebElement firstNameE=driver.findElement(By.xpath("//*[@name='firstName']"));
		WebElement lastNameE=driver.findElement(By.xpath("//*[@name='lastName']"));
		WebElement emailE=driver.findElement(By.xpath("//*[@name='email']"));
		WebElement userNameE=driver.findElement(By.xpath("//*[@name='username']"));
		WebElement passwordE=driver.findElement(By.xpath("//*[@name='password']"));
		WebElement confirmPasswordE=driver.findElement(By.xpath("//*[@name='confirmPassword']"));
		WebElement privacyPolicyE=driver.findElement(By.xpath("//*[@name='acceptPrivacyPolicy']"));
		WebElement cancelButtonE=driver.findElement(By.xpath("//*[text()='Cancel']"));
		WebElement saveButtonE=driver.findElement(By.xpath("//*[@id='ext-gen1040']"));
		WebElement alreadyHaveAnAccountSignInE=driver.findElement(By.xpath("//*[text()='Sign In']"));
		WebElement forgetYourPasswordE=driver.findElement(By.xpath("//*[text()='Forgot your password']"));
		WebElement forgetYourUsernameE=driver.findElement(By.xpath("//*[text()='username']"));
		List<WebElement>createAcctMandatoryFieldsE=driver.findElements(By.xpath("//*[@class='asterisk']//following::input[2]"));
	
		int rowIndex=1;
	   while(true) {
		   
		   try {
			
			firstNameE.sendKeys(ExcelFile.readExcelFileOperation(excelFilePath, "Sheet1", rowIndex,0));
			lastNameE.sendKeys(ExcelFile.readExcelFileOperation(excelFilePath, "Sheet1", rowIndex,1));
			emailE.sendKeys(ExcelFile.readExcelFileOperation(excelFilePath, "Sheet1", rowIndex,2));
			userNameE.sendKeys(ExcelFile.readExcelFileOperation(excelFilePath, "Sheet1", rowIndex,3));
			passwordE.sendKeys(ExcelFile.readExcelFileOperation(excelFilePath, "Sheet1", rowIndex,4));
			confirmPasswordE.sendKeys(ExcelFile.readExcelFileOperation(excelFilePath, "Sheet1", rowIndex,4));
			
			privacyPolicyE.click();
			
			Thread.sleep(10000);
			saveButtonE.click();
			
			rowIndex++;
			
		   }
		   catch(Exception e) {
			   break;
		   }
	   }
	   
   
	}
	
	
	
	
}
