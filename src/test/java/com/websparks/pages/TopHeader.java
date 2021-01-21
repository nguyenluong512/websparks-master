package com.websparks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.websparks.core.BasePage;

public class TopHeader extends BasePage {
	
	private By btn_signOut = By.xpath("//*[contains(@ng-click,'signOut')]");

	public TopHeader(WebDriver driver) {
		super(driver);
	}

	public TopHeader verifyUserIsConnected() {
		if (waitUntilVisibleElement(btn_signOut, 5, false)) {
			logger.info("Verify user is connected.");
		} else {
			logger.info("User is disconnected.");
		}
		return this;
	}
	
	public TopHeader signOut() {
		if (waitUntilVisibleElement(btn_signOut, 5, false)) {
			clickOnElement(btn_signOut);
			logger.info("Sign out.");
		}
		return this;
	}

}
