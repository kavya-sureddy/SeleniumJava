package Elementsinteractions;

import org.openqa.selenium.chrome.ChromeDriver;
import javax.print.DocFlavor.STRING;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;


public class MutipleTabsDemo {

	public static void main(String[] args) {
		
		WebDriver driver =new ChromeDriver();
		System.out.println(" Opening First Tab ");
		driver.get("https://www.google.com");
		String firsthandle=driver.getWindowHandle();
		
		System.out.println(" Opening Second Tab ");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.flipkart.com");
		
		driver.switchTo().window(firsthandle);
		
		driver.quit();
		
		
		
		
	}

}
