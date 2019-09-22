package com.pageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {
	
	private WebDriver driver = null;
	private static String webdriver_path = "D:\\\\apps\\\\Selenium\\\\webdrivers\\\\chromedriver_win32\\\\chromedriver.exe";

	
	 public Properties properties() {
		 
		System.out.println("Hello World Digital Hub!");
		
		// Instance properties file config.properties to read the trello_user and trello_pass
		Properties prop = new Properties();
		try {
		    prop.load(new FileInputStream("resources\\config.properties"));
		} 
		catch (IOException ex) {
		    ex.printStackTrace();
		}
	
//		String trello_user = prop.getProperty("trello_user");
//		String trello_pass = prop.getProperty("trello_pass");
		return prop;
	 }
	 
	 public WebDriver openURL(String url) {
		// 1 - Open url in browser
			System.setProperty("webdriver.chrome.driver", webdriver_path);
			this.driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url); //"https://trello.com/" 
			System.out.println(driver.getTitle() + " is opening");
			
			return driver;
	 }

}
