package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.page.Login_Page;
import com.pageObject.PageObject;

public class Login_Test extends PageObject{

	public WebDriver driver = null;
	Login_Page login = new Login_Page();
	

	// @BeforeTest
	@Test
	public WebDriver launchPage() {
	    System.out.println("launching Chrome browser"); 
	    driver = login.loginTrello();
	    Assert.assertTrue(true);
	    return driver;
	}
	
//	  @AfterTest
//	  public void closeDriver() {
//	      driver.close();
//		  Assert.assertTrue(true);
//	  }

}
