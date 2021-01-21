package com.websparks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.websparks.core.BasePage;

public class Homepage extends BasePage {
	
	private By blk_loginController = By.xpath("//*[contains(@ng-controller,'loginCtrl')]");

	private By btn_signInWithGithub = By.xpath("//*[contains(@class,'btn-github')]");

	public Homepage(WebDriver driver) {
		super(driver);
	}

	public Homepage openPage(String url) {
		driver.manage().window().maximize();
		openUrl(url);
		waitUntilVisibleElement(blk_loginController, 5, false);
		logger.info("Open page: " + url);
		return this;
	}
	
	public Homepage verifyPageIsLoaded() {
		waitUntilVisibleElement(blk_loginController, 5, false);
		logger.info("Verify page is loaded.");
		return this;
	}
	
	public Homepage goToSignInWithGithub() {
		if (waitUntilVisibleElement(btn_signInWithGithub, 5, false)) {
			clickOnElement(btn_signInWithGithub);
			logger.info("Go to Sign In with Github.");
		}
		return this;
	}
	
}