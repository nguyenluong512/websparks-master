package com.websparks.tests;

import org.testng.annotations.Test;

import com.websparks.core.BaseTest;
import com.websparks.core.Mapper;
import com.websparks.pages.Homepage;
import com.websparks.pages.LoginForm;
import com.websparks.pages.TodoListsEngine;
import com.websparks.pages.TopHeader;

public class TestTodoLists extends BaseTest {

	@Test(groups = { "TodoLists",
			"Authenticated" }, description = "WSS-13108 - Todo Lists: Authenticated | Adding and removing lists")
	public void testAuthenticatedAddingAndRemovingTodoLists() {
		String json = "./resources/data/todoLists/Data_13108.json";
		new Homepage(getDriver()).openPage(Mapper.map(json, "todoListsUrl")).goToSignInWithGithub();
		new LoginForm(getDriver()).loginWithEmail(Mapper.map(json, "email"), Mapper.map(json, "password"));
		new TopHeader(getDriver()).verifyUserIsConnected();
		new TodoListsEngine(getDriver()).addRandomTodoLists(Mapper.map(json, "nbrLists"));
		new TopHeader(getDriver()).signOut();

		new Homepage(getDriver()).verifyPageIsLoaded().goToSignInWithGithub();
		new LoginForm(getDriver()).loginWithEmail(Mapper.map(json, "email"), Mapper.map(json, "password"));
		new TopHeader(getDriver()).verifyUserIsConnected();
		new TodoListsEngine(getDriver()).removeSubTodoLists(Mapper.map(json, "startRemoveIndex"), Mapper.map(json, "endRemoveIndex"));
		new TopHeader(getDriver()).signOut();
	}
}
