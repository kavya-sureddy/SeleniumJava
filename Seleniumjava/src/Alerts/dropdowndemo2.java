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
