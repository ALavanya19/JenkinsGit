package com.Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropFileConfigure {

	//     "C:\\Users\\lenovo\\Desktop\\AutomationPractice\\Project\\src\\resources\\java\\com\\PropertiesFile\\PropertiesFile.properties"
	private static FileInputStream propFile;
	private static Properties prop;
	
	public static void loadPropFile(String propFilePath) {
		try {
			
			propFile=new FileInputStream(propFilePath);
		    prop=new Properties();
		    prop.load(propFile);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getPropFile(String propName) {
	
		return prop.getProperty(propName);
		
	}
	
	
	
	
}
