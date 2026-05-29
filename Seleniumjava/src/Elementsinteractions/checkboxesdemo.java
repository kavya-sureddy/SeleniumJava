package Elementsinteractions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkboxesdemo {

	public static void main(String[] args) {
    WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/radio.html");
		
		WebElement CheckBox1=driver.findElement(By.id("vfb-6-0"));
		WebElement CheckBox2=driver.findElement(By.id("vfb-6-1"));
		WebElement CheckBox3=driver.findElement(By.id("vfb-6-2"));
		
		CheckBox1.click();
		CheckBox2.click();
		
		System.out.println("CheckBox1 Status: " +CheckBox1.isSelected());
		System.out.println("CheckBox2 Status: " +CheckBox2.isSelected());
		System.out.println("CheckBox3 Status :" +CheckBox3.isSelected());
		
		if(CheckBox1.isSelected()) {
			CheckBox1.click();
			
		}
		
		System.out.println("CheckBox1 Status After unselected: " +CheckBox1.isSelected());
		System.out.println("CheckBox2 Status After unselected: " +CheckBox2.isSelected());
		System.out.println("CheckBox3 Status After unselected: " +CheckBox3.isSelected());
		
			
		
        driver.quit();
	}

}
