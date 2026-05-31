package Alerts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdowndemo2 {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		
//Implicit Wait is a global wait in Selenium that tells the WebDriver to wait for a fixed time while searching for any web element before throwing NoSuchElementException.

//It is applied to all findElement() calls in the script.
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try {
			driver.get("https://trytestingthis.netlify.app/");
			driver.manage().window().maximize();
			WebElement secondDropdown= driver.findElement(By.id("owc"));
			
			Select selectoption = new Select(secondDropdown);
			
			selectoption.selectByVisibleText("Option 1");
			selectoption.selectByVisibleText("Option 3");
			
			System.out.print("The options selected are: ");

			for (WebElement option : selectoption.getAllSelectedOptions()) {
			    System.out.print(option.getText() + " ");
			}

		}
		
		catch(Exception e) {
			System.out.println("Exception Block");
			
			}
		
		driver.quit();
	}

}
