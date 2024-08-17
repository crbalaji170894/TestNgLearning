package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import base.BaseClass;
import pages.FBLoginPage;

public class FBLoginPageTest {

	public static void main(String[] args) throws IOException {

		
		System.out.println(System.getProperty("user.dir") );
		BaseClass base = new BaseClass();

		WebDriver chromeBrowserInstantiation = base.chromeBrowserInstantiation();

		WebDriver driverwithWebPage = base.getURL("https://www.facebook.com/", chromeBrowserInstantiation);

		FBLoginPage page = new FBLoginPage(driverwithWebPage);

		page.getUserNameTextBox().sendKeys("test@gmail,com");

		page.getPassTextBox().sendKeys("test@123A");

		page.getLoginButton().click();

	}

}
