package letcodewebsite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lletcodedemo1 {

	public static void main(String[] args)  {
		
         WebDriver driver=new ChromeDriver();
         driver.get("https://letcode.in/test#google_vignette");
         System.out.println("The Page Title is "+driver.getTitle());
         driver.findElement(By.linkText("Edit")).click();
         System.out.println("The Page URL is "+driver.getCurrentUrl());
         driver.findElement(By.id("fullName")).sendKeys("Hruthika Sureddy");
         
//         Keys.ENTER      // Enter key
//         Keys.TAB        // Tab key
//         Keys.BACK_SPACE // Backspace
//         Keys.DELETE     // Delete
//         Keys.ESCAPE     // Esc key
//         Keys.SPACE      // Space key
//Keys.TAB is used to simulate keyboard navigation by moving focus from the current element 
         //to the next focusable element on the page.
        driver.findElement(By.id("join")).sendKeys("Working Women",Keys.TAB);
        
         //getAttribute("value") returns the text currently present inside the textbox.
         System.out.println(driver.findElement(By.id("getMe")).getAttribute("Value"));
         
         driver.findElement(By.id("clearMe")).clear();
         
         System.out.println(driver.findElement(By.id("noEdit")).isEnabled());
         
         System.out.println(driver.findElement(By.id("dontwrite")).getAttribute("readonly"));
         
         
         
         driver.close();
         
         
         
         
	}

}
