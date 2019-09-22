package com.page;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pageObject.PageObject;

public class Login_Page extends PageObject {

	private static WebDriver driver = null;
	
	public WebDriver loginTrello() {
		driver = super.openURL("https://trello.com/");
		
		Properties prop = super.properties();
		String trello_user = prop.getProperty("trello_user");
		String trello_pass = prop.getProperty("trello_pass");
		
		// 	2 - Login with valid credentials
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		
		driver.findElement(By.xpath("//input[@name='user']")).sendKeys(trello_user);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(trello_pass);
		System.out.println("Ahora hace el click en login...");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}

}
