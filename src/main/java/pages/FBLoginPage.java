package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class FBLoginPage {

	WebDriver driver;

	@FindBy(id = "email")
	private WebElement userNameTextBox;

	@FindBy(id = "pass")
	private WebElement passTextBox;

	@FindBy(name = "login")
	private WebElement loginButton;

	@FindBy(xpath = "//a[text()='Forgotten password?']")
	private WebElement forgotPasswordLink;

	@FindBy(xpath = "//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")
	private WebElement createAnAccount;

	@FindBy(xpath = "//img[@class='fb_logo _8ilh img']")
	private WebElement fbLogo;

	@FindBy(xpath = "//h2[text()='Facebook helps you connect and share with the people in your life.']")
	private WebElement fbHeaderContent;

	@FindBys({ @FindBy(id = "test"), @FindBy(name = "email") })

	private WebElement textuserFindBy;

	@FindAll({ @FindBy(id = "email123"), @FindBy(name = "email") }) // OR condition

	private WebElement textuserFindAll;	
	public WebElement getUserNameTextBox() {
		return userNameTextBox;
	}

//	public void setUserNameTextBox(WebElement userNameTextBox) {
//		this.userNameTextBox = userNameTextBox;
//	}

	public WebElement getPassTextBox() {
		return passTextBox;
	}

//	public void setPassTextBox(WebElement passTextBox) {
//		this.passTextBox = passTextBox;
//	}

	public WebElement getLoginButton() {
		return loginButton;
	}

//	public void setLoginButton(WebElement loginButton) {
//		this.loginButton = loginButton;
//	}

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}

//	public void setForgotPasswordLink(WebElement forgotPasswordLink) {
//		this.forgotPasswordLink = forgotPasswordLink;
//	}

	public WebElement getCreateAnAccount() {
		return createAnAccount;
	}

//	public void setCreateAnAccount(WebElement createAnAccount) {
//		this.createAnAccount = createAnAccount;
//	}

	public WebElement getFbLogo() {
		return fbLogo;
	}

//	public void setFbLogo(WebElement fbLogo) {
//		this.fbLogo = fbLogo;
//	}

	public WebElement getFbHeaderContent() {
		return fbHeaderContent;
	}

	public void setFbHeaderContent(WebElement fbHeaderContent) {
		this.fbHeaderContent = fbHeaderContent;
	}

	public FBLoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

}
