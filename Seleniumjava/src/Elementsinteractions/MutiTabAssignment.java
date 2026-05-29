package Elementsinteractions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;


public class MutiTabAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		System.out.println(" Opening First Tab ");
		driver.get("https://www.google.com");
		String firsthandler = driver.getWindowHandle();
		System.out.println(" FirstTab Window handle ID is:" +firsthandler); 
		
		
		driver.switchTo().newWindow(WindowType.TAB);
		System.out.println(" Opening Second Tab ");
		driver.get("https://www.Flipkart.com");
		System.out.println(" Before SwitchBack : " + driver.getTitle());
		String secondhandler = driver.getWindowHandle();
		System.out.println("SecondTab Window handle ID is:" +secondhandler); 
		
		driver.switchTo().newWindow(WindowType.TAB);
		System.out.println(" Opening Third Tab ");
		driver.get("https://www.Gmail.com");
		String thirdhandler = driver.getWindowHandle();
		System.out.println(" ThirdTab Window handle ID is:" +thirdhandler ); 
		
		driver.switchTo().newWindow(WindowType.TAB);
		System.out.println(" Opening Fourth Tab ");
		driver.get("https://www.amazon.in");
		Thread.sleep(2000);
		System.out.println(" current Title is: " + driver.getTitle());
		String fourthhandler = driver.getWindowHandle();
		System.out.println(" FourthTab Window handle ID is:" +fourthhandler); 
		Thread.sleep(2000);
		
	
		driver.switchTo().window(secondhandler);
		System.out.println("Switched back to: " + driver.getTitle());
		System.out.println(" 2ndTab Window handle ID is:" +secondhandler); 
		
		driver.quit();
		
		}

}
