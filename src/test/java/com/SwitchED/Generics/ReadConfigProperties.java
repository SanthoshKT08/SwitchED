package com.SwitchED.Generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigProperties {

	public Properties pro;

	public ReadConfigProperties() 
	{
		try {
			
			File src = new File("./src/main/resources/Config.Properties");
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();
			pro.load(fis);
			
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	} 
	
	public String getUrl()
	{
		String url=pro.getProperty("URL");
		return url;
	}
	
}

