package java_01_basic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Basic_05_Loop_Statements {

	public static void main(String[] args) {
		WebDriver driver;
		List<WebElement> elements;
		int i = 0;
		int y = 0;
		
		driver = new FirefoxDriver();
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		elements = driver.findElements(By.xpath("//a"));
		
		int number = elements.size();
		System.out.println("Count all links = " + number );
		
		//For
	//	for(int i = 0; i < number; i++) {
		//	System.out.println("Link in for loop = [" + i +  "] = " + elements.get(i).getAttribute("href") );
		//}
		
		//For - each (Only for Array / List)
		// Khai bao bien element -> duyet qua all 24 gia tri cua list elements.
		
		//for (WebElement element : elements) {
		//	System.out.println("For- each = " + element.getAttribute("href"));
		//}
		
		// While
		
		//while (i < number) {
		//	System.out.println("WHILE = [" + i + "] = " + elements.get(i).getAttribute("href"));
		//	i++;
		//}
		
		// Do - While (luon duoc thuc thi it nhat 1 lan)
		// Action truoc khi no kiem tra dieu kien
		
		do {
			System.out.println("Link in DO -WHILE = [" + y + "] = " + elements.get(y).getAttribute("href"));
			y++;
		} while (y < number);
		 

	}

}


















