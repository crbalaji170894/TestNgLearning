package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.FBLoginPage;

public class ParametersTest {

	BaseClass base = new BaseClass();

	@Test
	
	@Parameters({ "url", "username", "password" })

	private void loginPage(String url, String name, String pass) throws IOException {

	
		WebDriver chromeBrowserInstantiation = base.chromeBrowserInstantiation();

		WebDriver driverwithWebPage = base.getURL(url, chromeBrowserInstantiation);

		FBLoginPage page = new FBLoginPage(driverwithWebPage);

		page.getUserNameTextBox().sendKeys(name);

		page.getPassTextBox().sendKeys(pass);

		page.getLoginButton().click();

	}

}
