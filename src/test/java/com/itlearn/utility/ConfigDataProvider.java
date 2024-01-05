package com.itlearn.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	//properties is class in java to read the property file
	public ConfigDataProvider()   // its a constructor
	{
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis= new FileInputStream(src);
			
			pro= new Properties();
			
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load config file "+e.getMessage());
		} 
	}

	public String getBrowser() {
		// TODO Auto-generated method stub
		return pro.getProperty("browser");
	}

	public String getStagingUrl() {
		// TODO Auto-generated method stub
		return pro.getProperty("testurl");
	}
}
