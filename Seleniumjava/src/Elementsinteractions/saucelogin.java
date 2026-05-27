package Elementsinteractions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;


public class saucelogin {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		//WebElement usernamefield=driver.findElement(By.id("user-name"));
		WebElement usernamefield=driver.findElement(By.xpath("//input[@id='user-name']"));
		usernamefield.sendKeys("standard_user");
		
		
		//WebElement password=driver.findElement(By.name("password"));
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("secret_sauce");
		
		//WebElement loginbutton=driver.findElement(By.id("login-button"));
		WebElement loginbutton=driver.findElement(By.xpath("//input[@type='submit']"));
		loginbutton.click();
		
		driver.quit();
		

	}

}
