package de.jsfpraxis.detail.events;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author Bernd Müller
 *
 */
public class ParameterPassingIT {
	
	private static final String A = "3";
	private static final String B = "6";
	private static final String A_PLUS_B = "9";
	private static final String A_MINUS_B = "-3";
	private static final String A_TIMES_B = "18";

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "/java/libs/chromedriver");
		driver = new ChromeDriver();
		
	}
	
	@AfterClass
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void elMethodPlus() throws InterruptedException {
		driver.get("http://localhost:8080/jsf-im-detail/events/parameter-passing.jsf");
		driver.findElement(By.id("form:op10")).sendKeys(A);
		driver.findElement(By.id("form:op20")).sendKeys(B);
		driver.findElement(By.id("form:op0plus")).click();
		//Thread.sleep(100);
		Assert.assertEquals(A_PLUS_B, driver.findElement(By.id("form:res0")).getAttribute("value"));
	}

	@Test
	public void elMethodMinus() throws InterruptedException {
		driver.get("http://localhost:8080/jsf-im-detail/events/parameter-passing.jsf");
		driver.findElement(By.id("form:op10")).sendKeys(A);
		driver.findElement(By.id("form:op20")).sendKeys(B);
		driver.findElement(By.id("form:op0minus")).click();
		//Thread.sleep(100);
		Assert.assertEquals(A_MINUS_B, driver.findElement(By.id("form:res0")).getAttribute("value"));
	}

	@Test
	public void elMethodTimes() throws InterruptedException {
		driver.get("http://localhost:8080/jsf-im-detail/events/parameter-passing.jsf");
		driver.findElement(By.id("form:op10")).sendKeys(A);
		driver.findElement(By.id("form:op20")).sendKeys(B);
		driver.findElement(By.id("form:op0times")).click();
		//Thread.sleep(100);
		Assert.assertEquals(A_TIMES_B, driver.findElement(By.id("form:res0")).getAttribute("value"));
	}

	@Test
	public void propertyActionListenerPlus() throws InterruptedException {
		driver.get("http://localhost:8080/jsf-im-detail/events/parameter-passing.jsf");
		driver.findElement(By.id("form:op11")).sendKeys(A);
		driver.findElement(By.id("form:op21")).sendKeys(B);
		driver.findElement(By.id("form:op1plus")).click();
		//Thread.sleep(100);
		Assert.assertEquals(A_PLUS_B, driver.findElement(By.id("form:res1")).getAttribute("value"));
	}

	@Test
	public void propertyActionListenerMinus() throws InterruptedException {
		driver.get("http://localhost:8080/jsf-im-detail/events/parameter-passing.jsf");
		driver.findElement(By.id("form:op11")).sendKeys(A);
		driver.findElement(By.id("form:op21")).sendKeys(B);
		driver.findElement(By.id("form:op1minus")).click();
		//Thread.sleep(100);
		Assert.assertEquals(A_MINUS_B, driver.findElement(By.id("form:res1")).getAttribute("value"));
	}

	@Test
	public void propertyActionListenerTimes() throws InterruptedException {
		driver.get("http://localhost:8080/jsf-im-detail/events/parameter-passing.jsf");
		driver.findElement(By.id("form:op11")).sendKeys(A);
		driver.findElement(By.id("form:op21")).sendKeys(B);
		driver.findElement(By.id("form:op1times")).click();
		//Thread.sleep(100);
		Assert.assertEquals(A_TIMES_B, driver.findElement(By.id("form:res1")).getAttribute("value"));
	}

	@Test
	public void fParamPlus() throws InterruptedException {
		driver.get("http://localhost:8080/jsf-im-detail/events/parameter-passing.jsf");
		driver.findElement(By.id("form:op12")).sendKeys(A);
		driver.findElement(By.id("form:op22")).sendKeys(B);
		driver.findElement(By.id("form:op2plus")).click();
		//Thread.sleep(100);
		Assert.assertEquals(A_PLUS_B, driver.findElement(By.id("form:res2")).getAttribute("value"));
	}

	@Test
	public void fParamMinus() throws InterruptedException {
		driver.get("http://localhost:8080/jsf-im-detail/events/parameter-passing.jsf");
		driver.findElement(By.id("form:op12")).sendKeys(A);
		driver.findElement(By.id("form:op22")).sendKeys(B);
		driver.findElement(By.id("form:op2minus")).click();
		//Thread.sleep(100);
		Assert.assertEquals(A_MINUS_B, driver.findElement(By.id("form:res2")).getAttribute("value"));
	}

	@Test
	public void fParamTimes() throws InterruptedException {
		driver.get("http://localhost:8080/jsf-im-detail/events/parameter-passing.jsf");
		driver.findElement(By.id("form:op12")).sendKeys(A);
		driver.findElement(By.id("form:op22")).sendKeys(B);
		driver.findElement(By.id("form:op2times")).click();
		//Thread.sleep(100);
		Assert.assertEquals(A_TIMES_B, driver.findElement(By.id("form:res2")).getAttribute("value"));
	}


	@Test
	public void fAttributePlus() throws InterruptedException {
		driver.get("http://localhost:8080/jsf-im-detail/events/parameter-passing.jsf");
		driver.findElement(By.id("form:op13")).sendKeys(A);
		driver.findElement(By.id("form:op23")).sendKeys(B);
		driver.findElement(By.id("form:op3plus")).click();
		//Thread.sleep(100);
		Assert.assertEquals(A_PLUS_B, driver.findElement(By.id("form:res3")).getAttribute("value"));
	}

	@Test
	public void fAttributeMinus() throws InterruptedException {
		driver.get("http://localhost:8080/jsf-im-detail/events/parameter-passing.jsf");
		driver.findElement(By.id("form:op13")).sendKeys(A);
		driver.findElement(By.id("form:op23")).sendKeys(B);
		driver.findElement(By.id("form:op3minus")).click();
		//Thread.sleep(100);
		Assert.assertEquals(A_MINUS_B, driver.findElement(By.id("form:res3")).getAttribute("value"));
	}

	@Test
	public void fAttributeTimes() throws InterruptedException {
		driver.get("http://localhost:8080/jsf-im-detail/events/parameter-passing.jsf");
		driver.findElement(By.id("form:op13")).sendKeys(A);
		driver.findElement(By.id("form:op23")).sendKeys(B);
		driver.findElement(By.id("form:op3times")).click();
		//Thread.sleep(100);
		Assert.assertEquals(A_TIMES_B, driver.findElement(By.id("form:res3")).getAttribute("value"));
	}



}
