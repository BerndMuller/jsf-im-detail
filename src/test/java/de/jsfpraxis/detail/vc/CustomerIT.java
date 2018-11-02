package de.jsfpraxis.detail.vc;

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
public class CustomerIT {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "/java/libs/chromedriver");
		driver = new ChromeDriver();
		
	}
	
	@AfterClass
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void saveOk() throws InterruptedException {
		driver.get("http://localhost:8080/jsf-im-detail/vc/customer.jsf");
		insertCorrectInputs();
		driver.findElement(By.id("form:save")).click();
		Assert.assertTrue(driver.getPageSource().contains("Customer wurde gespeichert"));
	}

	@Test
	public void saveWrongFirstname() throws InterruptedException {
		driver.get("http://localhost:8080/jsf-im-detail/vc/customer.jsf");
		insertCorrectInputs();
		driver.findElement(By.id("form:firstname")).clear();;
		driver.findElement(By.id("form:firstname")).sendKeys("x");
		driver.findElement(By.id("form:save")).click();
		Assert.assertTrue(driver.getPageSource().contains("muss zwischen 3 und 30 liegen"));
	}

	@Test
	public void saveWrongDob() throws InterruptedException {
		driver.get("http://localhost:8080/jsf-im-detail/vc/customer.jsf");
		insertCorrectInputs();
		driver.findElement(By.id("form:dob")).clear();;
		driver.findElement(By.id("form:dob")).sendKeys("11.11.2222");
		driver.findElement(By.id("form:save")).click();
		Assert.assertTrue(driver.getPageSource().contains("muss in der Vergangenheit liegen"));
	}

	@Test
	public void saveWrongCreditLine() throws InterruptedException {
		driver.get("http://localhost:8080/jsf-im-detail/vc/customer.jsf");
		insertCorrectInputs();
		driver.findElement(By.id("form:creditline")).clear();;
		driver.findElement(By.id("form:creditline")).sendKeys("1000000");
		driver.findElement(By.id("form:save")).click();
		Assert.assertTrue(driver.getPageSource().contains("muss kleiner oder gleich 1000 sein"));
	}

	@Test
	public void saveWrongEmailLine() throws InterruptedException {
		driver.get("http://localhost:8080/jsf-im-detail/vc/customer.jsf");
		insertCorrectInputs();
		driver.findElement(By.id("form:email")).clear();;
		driver.findElement(By.id("form:email")).sendKeys("bla");
		driver.findElement(By.id("form:save")).click();
		Assert.assertTrue(driver.getPageSource().contains("keine gültige E-Mail-Adresse"));
	}

	
	private void insertCorrectInputs() {
		driver.findElement(By.id("form:firstname")).sendKeys("Bernd");
		driver.findElement(By.id("form:lastname")).sendKeys("Müller");
		driver.findElement(By.id("form:dob")).sendKeys("29.07.1962");
		driver.findElement(By.id("form:creditline")).sendKeys("500");
		driver.findElement(By.id("form:email")).sendKeys("bernd@example.com");
	}

}
