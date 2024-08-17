package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.FBLoginPage;

public class PriorityTest {

	BaseClass base = new BaseClass();

	@Test(priority = -1)
	private void testCase01() throws IOException {
		WebDriver chromeBrowserInstantiation = base.chromeBrowserInstantiation();

		WebDriver driverwithWebPage = base.getURL("https://www.facebook.com/", chromeBrowserInstantiation);

		FBLoginPage page = new FBLoginPage(driverwithWebPage);

		page.getUserNameTextBox().sendKeys("test@gmail,com");

		page.getPassTextBox().sendKeys("test@123A");

		page.getLoginButton().click();
	}

//	@Test(priority = -2)
//	private void testCase02() {
//		System.out.println("test case02");
//	}
//
//	@Test(priority = 2)
//	private void testCase03() {
//		System.out.println("test case03");
//	}
//
//	@Test(priority = 1)
//	private void testCase04() {
//		System.out.println("test case04");
//	}
//
//	@Test(priority = 0)
//	private void testCase05() {
//		System.out.println("test case05");
//	}

}
