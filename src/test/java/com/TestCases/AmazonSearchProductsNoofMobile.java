package com.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BaseClass.BaseTest;
import com.CommanActions.CommanActionsClass;
import com.Config.PropFileConfigure;

public class AmazonSearchProductsNoofMobile extends BaseTest {

	//String mobileName="(Renewed) OnePlus 5 (Slate Grey, 6GB RAM, 64GB Storage)";
	//String mobileName="OnePlus Nord 2T 5G (Jade Fog, 8GB RAM, 128GB Storage)";
	//String mobileName="Apple iPhone 11 (64GB) - White";
	//String mobileName="Apple iPhone 14 128GB Midnight";
	//String mobileName="(Renewed) OnePlus 5 (Slate Grey, 6GB RAM, 64GB Storage)";
	//String mobileName="(Renewed) OnePlus 5 (Slate Grey, 6GB RAM, 64GB Storage)";
	//String mobileName="Redmi Note 11 (Horizon Blue, 6GB RAM, 128GB Storage)|90Hz FHD+ AMOLED Display | Qualcomm® Snapdragon™ 680-6nm |";
	//String mobileName="Oppo F21s Pro 5G (Starlight Black, 8GB RAM, 128 Storage)";
	//String mobileName="Lenovo IdeaPad Slim 3 Intel Core i5 11th Gen 15.6 inches (39.62cm) FHD Thin & Light Business Laptop";
	//String mobileName="Lenovo IdeaPad Slim 3 Intel Core i3 12th Gen 15.6\" (39.62cm) FHD Thin & Light Laptop";
	String mobileName="Lenovo IdeaPad Slim 3 Ryzen 5 5500U 15.6\" (39.62cm) IPS";
	
	
	
	   @Test
       public void amazonSearch() {
    	   
    	   //SearchEngine
    	   WebElement searchEngineE=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
    	   CommanActionsClass.sendKeys(searchEngineE,PropFileConfigure.getPropFile("productToSearch"));
    	   
    	   
    	   //SerachEngineSearchButton
    	   WebElement searchEngineNavigateButton=driver.findElement(By.xpath("//*[@id='nav-search-submit-button']"));
    	   CommanActionsClass.click(searchEngineNavigateButton);
    	   
    	   //MobileList
  	       List<WebElement>mobileList=driver.findElements(By.xpath("//*[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']"));
  	        
  	      for(int mobileSno=0;mobileSno<mobileList.size();mobileSno++)
  	      {
  	    	  System.out.println(mobileList.get(mobileSno).getText());
  	    	  System.out.println((mobileList.get(mobileSno).getText()).contains(mobileName));
  	    	  
  	    	  if((mobileList.get(mobileSno).getText()).contains(mobileName))
  	    	  {
  	    		  System.out.println("Mobile matched");
  	    		  System.out.println((mobileList.get(mobileSno-1).getText()).contains("Sponsored"));
  	    		  if((mobileList.get(mobileSno-1).getText()).contains("Sponsored"))
  	    		  {
  	    			    sponsoredMobileImage();
  	    			    System.out.println(mobileName+" Sponsored clicked");
  	    			    break;
  	    		  }
  	    		  else
  	    		  {    
  	    			    mobileImage();
	    				System.out.println(mobileName+" With out sponsored");
	    	  	    	break;
	    		  }
  	    		
  	         }
        }
	}
	   
	   
	private void sponsoredMobileImage() {
		
		driver.findElement(By.xpath("//*[@class='sg-col sg-col-4-of-12 sg-col-4-of-16 sg-col-4-of-20 s-list-col-left']//*[starts-with(@alt,'Sponsored Ad - "+mobileName+"')]")).click();
	
	}
	
	private void mobileImage() {
		
		driver.findElement(By.xpath("//*[@class='sg-col sg-col-4-of-12 sg-col-4-of-16 sg-col-4-of-20 s-list-col-left']//*[starts-with(@alt,'"+mobileName+"')]")).click();
	}

	private void mobileLink() {
		driver.findElement(By.xpath("//*[@class='sg-col sg-col-4-of-12 sg-col-8-of-16 sg-col-12-of-20 s-list-col-right']//span[text()='"+mobileName+"']")).click();
	}
	   
	   
	   
}
