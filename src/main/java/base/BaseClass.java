package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	WebDriver driver;

//	WebDriver fireFoxDriver = new FirefoxDriver();
//
//	WebDriver internetExplorerDriver = new InternetExplorerDriver();

	// Alert alert = driver.switchTo().alert();

	public WebDriver chromeBrowserInstantiation() throws IOException {

		System.setProperty(Constants.chromeDriverKey, System.getProperty("user.dir") + Constants.chromeDriverPath);

		driver = new ChromeDriver();

		return driver;

	}

	public WebDriver getURL(String url, WebDriver driver) {
		
		driver.get(url);

		return driver;
	}

	public WebDriver firefoxBrowserInstantiaon() throws IOException {

		System.setProperty(Constants.geckoDriverKey, System.getProperty("user.dir") + Constants.geckoDriverPath);

//		String url = AccessProperties.accessPropertiesValues("fb_URL");
//
//		fireFoxDriver.get(url);
//
//		return fireFoxDriver;

		WebDriver fireFoxDriver = new FirefoxDriver();
		
		
		return fireFoxDriver;

	}

	public List brokenLinks(WebDriver driver1) {
		List<WebElement> allLinksElements = driver1.findElements(By.tagName("a"));

		List<String> brokenURLS = new LinkedList();

		for (WebElement eachElement : allLinksElements) {

			try {
				String webLinkURL = eachElement.getAttribute("href");

//				System.out.println(webLinkURL);

				URL urlLink = new URL(webLinkURL);

				URLConnection openConnection = urlLink.openConnection();

				HttpURLConnection httpurlconnection = (HttpURLConnection) openConnection;

				httpurlconnection.setConnectTimeout(5000);

				httpurlconnection.connect();

				if (httpurlconnection.getResponseCode() >= 400) {
//					System.out.println(httpurlconnection.getResponseMessage());
//					System.out.println("This is broken Link");
//					System.out.println(webLinkURL);
					brokenURLS.add(webLinkURL);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		return brokenURLS;

	}

	public void IeBrowserInstantiation() throws IOException {

		System.setProperty(Constants.ieDriverKey, System.getProperty("user.dir") + Constants.ieDriverPath);
		
		WebDriver internetExplorerDriver = new InternetExplorerDriver();

//		String url = AccessProperties.accessPropertiesValues("gmail_URL");
//
//		internetExplorerDriver.get(url);

	}

	public WebDriver moveToElementMethod(WebDriver driver, WebElement element) {

		Actions acc = new Actions(driver);

		acc.moveToElement(element).perform();

		return driver;

	}

	public WebDriver dragAndDropMethod(WebDriver driver, WebElement sourceElement, WebElement destinationElement) {

		Actions acc = new Actions(driver);

		acc.dragAndDrop(sourceElement, destinationElement).perform();

		return driver;

	}

	public WebDriver rightClick(WebDriver driver, WebElement element) {

		Actions acc = new Actions(driver);

		acc.contextClick(element).perform();

		return driver;

	}

	public WebDriver doubleClick(WebDriver driver, WebElement element) {

		Actions acc = new Actions(driver);

		acc.doubleClick(element).perform();

		return driver;

	}

	public WebDriver clickMethod(WebElement element, WebDriver driver) {
		element.click();
		return driver;
	}

	public WebDriver getPage(String url, WebDriver driver) {

		driver.get(url);
		return driver;

	}

	public Robot robotClass() throws AWTException {

		Robot robot = new Robot();

		return robot;

	}

	public Alert alertMethod(WebDriver driver) {

		Alert alert = driver.switchTo().alert();
		return alert;
	}

	public void alertAccept(WebDriver driver) {
		Alert alertMethod = alertMethod(driver);
		alertMethod.accept();

	}

	public void alertDismiss(WebDriver driver) {
		Alert alertMethod = alertMethod(driver);
		alertMethod.dismiss();

	}

	public void sendKeysAlert(WebDriver driver, String text) {
		Alert alertMethod = alertMethod(driver);
		alertMethod.sendKeys(text);

	}

	public void takeScreenShot(WebDriver driver, String filePath) throws IOException {
		TakesScreenshot screenShot = (TakesScreenshot) driver;

		File srcFile = screenShot.getScreenshotAs(OutputType.FILE);

		File destnationFile = new File(filePath);

		FileUtils.copyFile(srcFile, destnationFile);

	}

	public void dropDownSelectByIndex(int n, WebElement element) {

		Select sel_obj = new Select(element);

		sel_obj.selectByIndex(n);

	}

	public List<WebElement> dropDowngetAllOptions(WebElement element) {

		Select sel_obj = new Select(element);

		List<WebElement> options = sel_obj.getOptions();

		return options;

	}

	public void dropDownSelectVisibleText(WebElement element) {

		List<WebElement> dropDowngetAllOptions = dropDowngetAllOptions(element);

		Select sel_obj = new Select(element);

		for (WebElement eachOption : dropDowngetAllOptions) {
			sel_obj.selectByVisibleText(eachOption.getText());

		}

	}

	public void deSelectall(WebElement element) {
		Select sel_obj = new Select(element);

		sel_obj.deselectAll();
	}

	public boolean isMultiplecheck(WebElement element) {
		Select sel_obj = new Select(element);

		boolean multiple = sel_obj.isMultiple();

		return multiple;
	}

	public void switchToFrame(WebDriver driver, List<WebElement> allFrameElements) {

		for (int i = 0; i <= allFrameElements.size(); i++) {
			driver.switchTo().frame(i);

		}
	}

	public void SwitchToParentFrame(WebDriver driver) {

		driver.switchTo().parentFrame();

	}

	public void defaultContetFrame(WebDriver driver) {

		driver.switchTo().defaultContent();

	}

	public WebDriver switchToWindow(WebDriver driver) {

		String parentWindowId = driver.getWindowHandle();

		Set<String> allWindowId = driver.getWindowHandles();

		for (String eachWindowId : allWindowId) {

			if (!eachWindowId.equals(parentWindowId)) {
				driver.switchTo().window(eachWindowId);
			}
		}

		return driver;

	}

	public void defaultContetWindow(WebDriver driver) {
		WebDriver switchToWindow = switchToWindow(driver);

		switchToWindow.switchTo().defaultContent();

	}

	public JavascriptExecutor clickjsExecutor(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[1].click();", element);

		return js;

	}

	public JavascriptExecutor scrollDown(WebDriver driver, WebElement scrollDownElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);", scrollDownElement);

		return js;

	}

	public JavascriptExecutor scrollUp(WebDriver driver, WebElement scrollUpElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(false);", scrollUpElement);

		return js;

	}
}
