package Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

	
	public class DatapickerDemo {
	    public static void main(String[] args) {
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        
	        // 1. Navigate to the website
	        driver.get("https://jqueryui.com/datepicker/");

	        // 2. Switch to the iframe that contains the datepicker
	        // The calendar is inside an HTML <iframe>, so we must switch to it first
	        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

	        // 3. Click the input field to open the calendar
	        driver.findElement(By.id("datepicker")).click();

	        // 4. Logic to navigate to "August 2026"
	        String targetMonthYear = "August 2027";
	        
	        while (true) {
	            String currentMonthYear = driver.findElement(By.className("ui-datepicker-title")).getText();
	            
	            if (currentMonthYear.equals(targetMonthYear)) {
	                break; // Found it!
	            } else {
	                // Click the 'Next' button
	                driver.findElement(By.xpath("//a[@title='Next']")).click();
	            }
	        }

	        // 5. Select the 15th day
	        driver.findElement(By.xpath("//a[text()='15']")).click();
	        
	        System.out.println("Date selected successfully.");
	        
	        driver.quit();
	    }
	}

