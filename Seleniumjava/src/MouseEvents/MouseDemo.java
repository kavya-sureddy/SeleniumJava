package MouseEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		try {
			
			//Hover 
			
//			driver.get("https://the-internet.herokuapp.com/hovers");
//			
//			WebElement FirstIcon = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
//		
			Actions action = new Actions(driver);
//			
//			action.moveToElement(FirstIcon).perform();
//			
//			Thread.sleep(3000);
			
//			driver.get("https://the-internet.herokuapp.com/context_menu");			
//			WebElement hotSpot = driver.findElement(By.id("hot-spot"));
//			
//			action.contextClick(hotSpot).perform();
//			Thread.sleep(3000);
			
			driver.get("https://demo.guru99.com/test/simple_context_menu.html");
			
			WebElement DB = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
			
			action.doubleClick(DB).perform();
			Thread.sleep(3000);
			
		}finally {driver.quit();}
	}

}
