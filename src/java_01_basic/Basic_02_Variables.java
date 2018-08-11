package java_01_basic;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Basic_02_Variables {
WebDriver driver;
String username, password, loginUrl;
@BeforeClass
public void beforeClass() {
	driver = new FirefoxDriver();
	driver.get("http://demo.guru99.com/v4/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();	
}

@Test
public void TC_01_Login_CreateUser() {
	loginUrl = driver.getCurrentUrl();
	driver.findElement(By.xpath("//a[text()='here']")).click();
	driver.findElement(By.xpath("//input[@name = 'emailid']")).sendKeys("kimthuy.ht106" + randomNumber() + "@gmail.com");;
	driver.findElement(By.xpath("//input[@name = 'btnLogin']")).click();
	Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Access details to demo site.']")).isDisplayed());
	username = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
	password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
}
@Test
public void TC_Login_02_LoginToApplication() {
	driver.get(loginUrl);
	driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	WebElement welcomeMsg = driver.findElement(By.xpath("//marquee"));
	Assert.assertEquals("Welcome To Manager's Page of Guru99 Bank", welcomeMsg.getText());
	WebElement containUserID = driver.findElement(By.xpath("//td[text()='Manger Id :'" + username + "']"));
	Assert.assertTrue(containUserID.isDisplayed());
}

@AfterClass
public void afterClass() {
	driver.close();
}
	
public int randomNumber() {
	Random random = new Random();
	int number = random.nextInt(999999);
	return number;
}
}



