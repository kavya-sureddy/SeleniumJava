package Alerts;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class DropDowns {

	private static WebElement dropdown;

	public static void main(String[] args) {
		WebDriver driver= new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try {
			driver.get("https://trytestingthis.netlify.app/");
		    driver.manage().window().maximize();
		    WebElement dropdown=driver.findElement(By.id("option"));
		    Select selectoption=new Select(dropdown);
		    
		 selectoption.selectByVisibleText("Option 3");
		 System.out.println("Successfully you have slected the objcet:" +selectoption.getFirstSelectedOption().getText());
			//selectoption.selectByValue("option 2");
			//selectoption.selectByIndex(1);
			
			
		} catch (Exception e) {
			
			System.out.println("Exception Block");
			
		}
		
		driver.quit();

	}

}

		    
		