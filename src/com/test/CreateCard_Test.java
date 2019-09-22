package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.page.CreateCard_Page;

public class CreateCard_Test extends Login_Test {
    
	/*
	 * Author: lmarlaire@gmail.com
	 * Create a boilerplate automation project
		1 - Open trello in browser
		2 - Login with valid credentials
		3 - Open a trello Board
		4 - Create a card in first list of that board
		5 - Verify that the card is successfully created
		
		NOTE: Please, complete the resources\config.properties file with the Trello user and password to run this test
		Complete the cardText variable with the text you want to add
	 */

	public WebDriver driver = null; 
    CreateCard_Page createCard = null;
    public String cardText = "This is the message to be added into the card created!!!";
    
  @Test(priority = 0)
  public void loginTrelloInBrowser() {
	  //Open Trello
	 driver = super.launchPage();
	 Assert.assertTrue(true);
      
  }
  
  @Test(priority = 1)
  public void openFirstBoard() {
	  createCard = new CreateCard_Page(driver);
	  WebElement board = createCard.openFirstBoard();
	  System.out.println("Board selected: " + board.getText());
	  Assert.assertTrue(true);
	  //Assert.assertEquals(actualTitle, expectedTitle);	  
  }
  
  @Test(priority = 2)
  public void createCard() {
	  createCard.createCard(cardText);
	  Assert.assertTrue(true);
  }
  
  @Test(priority = 3)
  public void lastVerification() {
		// 	5 - Verify that the card is successfully created
		// This is a simple way to validate the card was created.
		if(driver.findElements(By.partialLinkText(cardText)).size() > 0) {
			//System.out.println("VALIDATION PASSED: The text \"" + cardText + "\" was found it");
			Assert.assertTrue(true, "VALIDATION PASSED: The text \"" + cardText + "\" was found it");
		}else {
			//System.out.println("VALIDATION FAILED: card was not found it");
			Assert.assertTrue(false, "VALIDATION FAILED: card was not found it");
		}
  }
  
  @AfterTest
  public void closeWebBrowser() {
	  driver.quit();
  }

}
