package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	
	public ConfigDataProvider()
	{
		File src=new File("./Configuration/config.properties");
		
		try {
			
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is" +e.getMessage());
			
			
		}
	}
	public String getApplicationUrl()
	{
		String url=pro.getProperty("url");
		return url;
	}
	public String getChromePath()
	{
		String path=pro.getProperty("chromePath");
		return path;
	}
	public String getFirefoxPath()
	{
		String path=pro.getProperty("firefoxPath");
		return path;
	}
	

}
