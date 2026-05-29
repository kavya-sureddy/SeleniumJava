package Elementsinteractions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;


public class MutiTabAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		System.out.println(" Opening First Tab ");
		driver.get("https://www.google.com");
		
		driver.switchTo().newWindow(WindowType.TAB);
		System.out.println(" Opening Second Tab ");
		driver.get("https://www.Flipkart.com");
		String Secondhandler = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.TAB);
		System.out.println(" Opening Third Tab ");
		driver.get("https://www.Gmail.com");
		
		driver.switchTo().newWindow(WindowType.TAB);
		System.out.println(" Opening Fourth Tab ");
		driver.get("https://www.amazon.in");
		Thread.sleep(2000);
		
	
		driver.switchTo().window(Secondhandler);
		System.out.println("Switched back to: " + driver.getTitle());
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
