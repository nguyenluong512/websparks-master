package com.websparks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.websparks.core.BasePage;

public class LoginForm extends BasePage {

	private By input_username = By.xpath("//*[@id='login_field']");

	private By input_password = By.xpath("//*[@id='password']");

	private By btn_submit = By.xpath("//*[contains(@type,'submit')]");

	public LoginForm(WebDriver driver) {
		super(driver);
	}

	public LoginForm enterEmail(String email) {
		if (waitUntilVisibleElement(input_username, 5, false)) {
			setText(input_username, email);
			logger.info("Enter email: " + email);
		}
		return this;
	}

	public LoginForm enterPassword(String password) {
		if (waitUntilVisibleElement(input_password, 5, false)) {
			setText(input_password, password);
			logger.info("Enter password: " + password);
		}
		return this;
	}

	public LoginForm submit() {
		if (waitUntilVisibleElement(btn_submit, 5, false)) {
			clickOnElement(btn_submit);
			logger.info("Submit.");
		}
		return this;
	}

	public LoginForm loginWithEmail(String email, String password) {
		implicitWait(5); /* Handle the 2nd login time */
		switchToCurrentWindow();
		if (waitUntilVisibleElement(input_username, 5, false)) {
			enterEmail(email);
			enterPassword(password);
			submit();
			switchToCurrentWindow();
			logger.info("Log In with email.");
		}
		return this;
	}

}
