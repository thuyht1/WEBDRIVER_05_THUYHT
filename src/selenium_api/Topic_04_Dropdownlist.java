package selenium_api;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Dropdownlist {

	WebDriver driver;
	String username, password, name, dob, address, city, state, pin, phone, email;
	
	@BeforeClass
	public void beforeClass() {
		
	 driver = new FirefoxDriver();	
	 
	 username = "mngr144625";
	 password = "zazyzab";
	 name ="Automation Test";
	 dob = "1989-06-01";
	 address = "123 Address";
	 city = "HN";
	 state = "DongAnh";
	 pin = "123456";
	 phone = "0123456789";
	email = "kimthuy.ht106" + randomNumber() + "@gmail.com";
	 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}
	
	@Test
	public void TC_01_HandleDropdownList() {
		
		 driver.get("http://daominhdam.890m.com/");
		
		Select job1 = new Select (driver.findElement(By.xpath("//select[@id='job1']")));
	    Assert.assertFalse(job1.isMultiple());
	    
	    job1.selectByVisibleText("Automation Tester");
	    Assert.assertEquals("Automation Tester", job1.getFirstSelectedOption().getText());
	    
	    job1.selectByValue("manual");
	    Assert.assertEquals("Manual Tester", job1.getFirstSelectedOption().getText());
	    
	    job1.selectByIndex(3);
	    Assert.assertEquals("Mobile Tester", job1.getFirstSelectedOption().getText());
	    
	    Assert.assertEquals(5, job1.getOptions().size());
	}

	@Test
	public void TC_02_HandlTextbox_Textarea() {
		driver.get("http://demo.guru99.com/v4/");
		
		//LOGIN
		WebElement userTextbox = driver.findElement(By.xpath("//input[@name='uid']"));
		WebElement passTextbox = driver.findElement(By.xpath("//input[@name='password']"));
		userTextbox.sendKeys(username);
		passTextbox.sendKeys(password);
		WebElement loginButton = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		loginButton.click();
		
		//CREATE USER CUSTOMER
		WebElement newCustomerLink = driver.findElement(By.xpath("//a[text()= 'New Customer']"));
		newCustomerLink.click();
		
		WebElement nameTextbox = driver.findElement(By.xpath("//input[@name='name']"));
		nameTextbox.sendKeys(name);
		
		WebElement femailRadio = driver.findElement(By.xpath("//input[@value='f']"));
		femailRadio.click();
		
		WebElement dobTextbox = driver.findElement(By.xpath("//input[@name='dob']"));
		dobTextbox.sendKeys(dob);
		
		WebElement addressTextArea = driver.findElement(By.xpath("//textarea[@name='addr']"));
		addressTextArea.sendKeys(address);
		
		WebElement cityTextbox = driver.findElement(By.xpath("//input[@name='city']"));
		cityTextbox.sendKeys(city);
		
		WebElement stateTextbox = driver.findElement(By.xpath("//input[@name='state']"));
		stateTextbox.sendKeys(state);
		
		WebElement pinTextbox = driver.findElement(By.xpath("//input[@name='pinno']"));
		pinTextbox.sendKeys(pin);
		
		WebElement mobileTextbox = driver.findElement(By.xpath("//input[@name='telephoneno']"));
		mobileTextbox.sendKeys(phone);
		
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@name='emailid']"));
		emailTextbox.sendKeys(email);
		
		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@name='password']"));
		passwordTextbox.sendKeys(password);
		
		WebElement submitButton = driver.findElement(By.xpath("//input[@name='sub']"));
		submitButton.click();
		
		// VERYFY CUSTOMER CREATE SUCCESS MESSAGE
		WebElement createdSuccessMsg = driver.findElement(By.xpath("//p[@class = 'heading3' and text()='Customer Registered Successfully!!!']"));
		Assert.assertTrue(createdSuccessMsg.isDisplayed());
		
		// GET CUSTOMER ID TEXT -> NEXT STEP/ METHOD/TESTCASE
		String customerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
	 
	// VERYFY CUSTOMER INFORMATION CREATED
	 Assert.assertEquals(name, driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText());
	 Assert.assertEquals("female", driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText());
	 Assert.assertEquals(dob, driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText());
	 Assert.assertEquals(address, driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText());
	 Assert.assertEquals(city, driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText());
	 Assert.assertEquals(state, driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText());
	 Assert.assertEquals(pin, driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText());
	 Assert.assertEquals(phone, driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText());
	 Assert.assertEquals(email, driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText());
	
	 // CREATE EDIT CUSTOMER
	  WebElement editCustomerLink = driver.findElement(By.xpath("//a[text()='Edit Customer']"));
	  editCustomerLink.click();
	  
	  WebElement customerIDTextbox = driver.findElement(By.xpath("//input[@name='cusid']"));
	  customerIDTextbox.sendKeys(customerID);
	}
	
	@AfterClass
	public void afterClass() {
		
		driver.close();
	}
		 private int randomNumber() {
			 Random random = new Random();
			 int number = random.nextInt(999999);
			 System.out.println("Radom number = " + number);
			 return number;
		 }
		 
		/*private void removeAttributeInDOM(WebElement element, String attributeName) {
			JavascriptExecutor javascript = (JavascriptExecutor) driver;
			javascript.executeScript("arguments[0].removeAttribute('" + attributeName  +"')", element);
		}	*/
	}


