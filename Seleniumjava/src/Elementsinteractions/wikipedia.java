package Elementsinteractions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class wikipedia {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		
		WebElement searchfield=driver.findElement(By.id("searchInput"));
		searchfield.sendKeys("selenium");
		
		WebElement searchbutton=driver.findElement(By.xpath("//button[@type='submit']"));
		searchbutton.click();
		
		System.out.println("Current URL is:" +driver.getCurrentUrl());
		
		System.out.println("Current Page Title is:" +driver.getTitle());
		
		driver.quit();
		
		
		
		
	}

}
