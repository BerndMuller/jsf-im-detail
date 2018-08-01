package de.jsfpraxis.detail.el;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ValueExpressionsIT {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/jsf-im-detail/el/value-expressions.jsf");
	}
	
	@AfterClass
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void namePropertyByDom() {
		Assert.assertEquals("#{elController.name}", driver.findElement(By.xpath("/html/body/form/section/table/tbody/tr[1]/td[1]")).getText());
		Assert.assertEquals(new ExpressionLanguageController().getName(), driver.findElement(By.xpath("/html/body/form/section/table/tbody/tr[1]/td[2]")).getText());
	}

	@Test
	public void namePropertyById() {
		Assert.assertEquals("#{elController.name}", driver.findElement(By.id("form:name1")).getText());
		Assert.assertEquals(new ExpressionLanguageController().getName(), driver.findElement(By.id("form:name2")).getText());
	}

}
