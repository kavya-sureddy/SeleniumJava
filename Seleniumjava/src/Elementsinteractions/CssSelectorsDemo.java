package Elementsinteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		//WebElement username = driver.findElement(By.cssSelector("#user-name"));
		
		WebElement username = driver.findElement(By.cssSelector("input[id^='user']"));
				
		username.sendKeys("standard_user");
		
		WebElement password = driver.findElement(By.cssSelector("input[name='password']")); 
		
		
		password.sendKeys("secret_sauce");
		
		//driver.findElement(By.cssSelector(".submit-button")).click();
		
	//	driver.findElement(By.cssSelector("button[id$='-button']")).click();
		driver.findElement(By.cssSelector("input[id*='login']")).click(); 
		
		driver.quit();


		

	}

}
