package com.page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pageObject.PageObject;

public class CreateCard_Page extends PageObject {
	
	private WebDriver driver = null;
	
	
	public CreateCard_Page(WebDriver driver) {
		this.driver = driver;
	}
	

	public CreateCard_Page() {
		super();
	}


	public WebElement openFirstBoard() {
		//  3 - Open a trello Board
		// NOTE: This code open the first trello board found it
		List<WebElement> boardElements = new ArrayList<WebElement>(); 
		boardElements = driver.findElements(By.className("board-tile-details-name"));
		System.out.println("Board element found it : " + boardElements.size());
		boardElements.get(0).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return boardElements.get(0);
	}

	public void openBoardNumbre(int board) {
		//  3 - Open a trello Board number board
		// NOTE: This code open the first trello board found it
		List<WebElement> boardElements = new ArrayList<WebElement>(); 
		boardElements = driver.findElements(By.className("board-tile-details-name"));
		System.out.println("Board element found it : " + boardElements.size());
		if (boardElements.size() >= board - 1) {
			boardElements.get(board-1).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}else {
			System.out.println("the number of board type it " + board + " is higher thant the quantity of boards found it");
		}
		
	}
	
	public void createCard(String cardText) {
		//	4 - Create a card in first list of that board
		List<WebElement> addCardElements = new ArrayList<WebElement>();
		addCardElements = driver.findElements(By.className("js-add-another-card"));
		System.out.println("Add cards elements found it : " + addCardElements.size());
		addCardElements.get(0).click(); // clicking the 0, we press the first add card from column 1
		
		// Send the title of the new card
		driver.findElement(By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']")).sendKeys(cardText);
		
		// press add card 
		driver.findElement(By.xpath("//input[@class='primary confirm mod-compact js-add-card']")).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
	
	
}
