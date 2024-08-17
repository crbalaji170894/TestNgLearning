package test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationSequence {

	@Test
	private void testCase01() {
		System.out.println("test case01");
	}

	@Test
	private void testCase02() {
		System.out.println("test case02");
	}

	@Test
	private void testCase03() {
		System.out.println("test case03");
	}

	@BeforeClass
	private void beforeClass() {
		System.out.println("Before Class ");

	}

	@BeforeMethod
	private void beforeMethod() {
		System.out.println("before  Method");
	}

	@AfterClass
	private void afterClassMethod() {
		System.out.println("After Class ");

	}

	@AfterMethod
	private void aftermethod() {
		System.out.println("After  Method");

	}

}
