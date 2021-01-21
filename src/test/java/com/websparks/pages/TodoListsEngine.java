package com.websparks.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.websparks.core.BasePage;
import com.websparks.core.Utilities;

public class TodoListsEngine extends BasePage {
	
	private By input_listName = By.xpath("//*[contains(@ng-model,'home.list')]");

	private By btn_addList = By.xpath("//*[contains(@class,'btn-success') and contains(@ng-click,'add')]");
	
	private By lbl_listName = By.xpath("//*[contains(@ng-repeat,'home.lists')]//*[contains(@href,'list')]");
	
	private By btn_removeList = By.xpath("//*[contains(@class,'btn-danger') and contains(@ng-click,'delete')]");
	
	private static final String EMPTY_STRING = "";

	public TodoListsEngine(WebDriver driver) {
		super(driver);
	}

	public TodoListsEngine enterListName(String listName) {
		if (waitUntilVisibleElement(input_listName, 5, false)) {
			setText(input_listName, listName);
			logger.info("Enter list name: " + listName);
		}
		return this;
	}
	
	public TodoListsEngine submit() {
		if (waitUntilVisibleElement(btn_addList, 5, false)) {
			clickOnElement(btn_addList);
			logger.info("Submit.");
		}
		return this;
	}
	
	public TodoListsEngine addRandomTodoLists(String numberOfTodoLists) {
		String todoListName = EMPTY_STRING; 
		for (int i = 0; i < Integer.valueOf(numberOfTodoLists); i++) {
			todoListName = Utilities.generatingRandomStringBounded(15);
			logger.info("Add '" + todoListName + "' to Todo Lists");
			enterListName(todoListName);
			submit();
		}
		return this;
	}
	
	public TodoListsEngine removeSubTodoLists(String startIndex, String endIndex) {
		List<WebElement> lbl_listNames = initializeWebElementList(lbl_listName);
		List<WebElement> btn_removeLists = initializeWebElementList(btn_removeList);
		for (int i = Integer.valueOf(startIndex); i < Integer.valueOf(endIndex); i++) {
			logger.info("Remove '" + lbl_listNames.get(i).getText() + "' from Todo Lists");
			btn_removeLists.get(i).click();
		}
		return this;
	}

}
