package com.websparks.core;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private static final int TIMEOUT = 5;
	private static final int POLLING = 100;

	public static final Logger logger = LogManager.getLogger("Logger");

	protected WebDriver driver;
	private WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}

	protected void openUrl(String url) {
		driver.get(url);
	}

	protected void clickOnElement(By locator) {
		driver.findElement(locator).click();
	}

	protected void setText(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

	protected void switchToCurrentWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		if (windows.size() == 1)
			return;

		Iterator<String> iterator = windows.iterator();
		while (iterator.hasNext()) {
			String childWindow = iterator.next();

			if (!parentWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				logger.info("Switch to current window.");
				break;
			}
		}
	}

	protected List<WebElement> initializeWebElementList(By locator) {
		List<WebElement> elements = driver.findElements(locator);
		return elements;
	}

	protected boolean waitUntilVisibleElement(final By locator, int timeOut, boolean exitOnError) {
		boolean elementFound = false;
		try {
			wait = new WebDriverWait(driver, timeOut);
			WebElement element = wait.until(new ExpectedCondition<WebElement>() {
				@Override
				public WebElement apply(WebDriver d) {
					WebElement el = driver.findElement(locator);
					if (el.isDisplayed())
						return el;
					return null;
				}
			});
			elementFound = (element != null);
		} catch (Exception e) {
			if (exitOnError) {
				StringBuffer message = new StringBuffer(300);
				message.append("Selenium error  :\n ").append(e.getMessage().toString());
				logger.info(message);
			}
		}
		return elementFound;
	}

	protected void implicitWait(int timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}