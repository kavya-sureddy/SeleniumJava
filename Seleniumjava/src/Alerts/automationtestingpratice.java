package Alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.Alert;

public class automationtestingpratice {

	private static final String Y = null;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://trytestingthis.netlify.app/");
		driver.manage().window().maximize();
		System.out.println("The current Title of the website is:"+driver.getTitle());
		WebElement FirstName=driver.findElement(By.id("fname"));
		FirstName.sendKeys("kavya");
		WebElement LastName=driver.findElement(By.id("lname"));
		LastName.sendKeys("kavya");
		
		
		//Radiobuttons
	WebElement Gender1=driver.findElement(By.id("male"));
	WebElement Gender2=driver.findElement(By.id("female"));
	WebElement Gender3=driver.findElement(By.id("other"));
	
	Gender3.click();
	
	System.out.println("Radio Button Gender1 Status: " +Gender1.isSelected());
	System.out.println("Radio Button Gender2 Status: " +Gender2.isSelected());
	System.out.println("Radio Button Gender3 Status :" +Gender3.isSelected());
	
	//checkboxes
	
	WebElement option1=driver.findElement(By.name("option1"));
	WebElement option2=driver.findElement(By.name("option2"));
	WebElement option3=driver.findElement(By.name("option3"));
	
	option1.click();
	option2.click();
	
	System.out.println("CheckBox option1 Status: " +option1.isSelected());
	System.out.println("CheckBox option2 Status: " +option2.isSelected());
	System.out.println("CheckBox option3 Status :" +option3.isSelected());
	
	if(option1.isSelected())
	{
	
		option2.click();
	
	}
	
	System.out.println("CheckBox option1 Status after unselected: " +option1.isSelected());
	System.out.println("CheckBox option2 Status after unselected: " +option2.isSelected());
	System.out.println("CheckBox option3 Status after unselected :" +option3.isSelected());
	
	
	//Dropdown3
	
	WebElement guessanswer=driver.findElement(By.name("Options"));
	
	
	guessanswer.sendKeys("Strawberry");

	System.out.println("Selected value: "
	        + guessanswer.getAttribute("value"));
	
	//Alert
	
	driver.findElement(By.xpath("//button[@onclick='alertfunction()']")).click();
	Alert samplealert=driver.switchTo().alert();
	System.out.println("Alert TXT is:"+samplealert.getText());
	samplealert.dismiss();
	WebElement Demo=driver.findElement(By.id("demo"));
	System.out.println("Demo Result :" +Demo.getText());
	
	//Sample login
	
	driver.findElement(By.id("uname")).sendKeys("test");
	driver.findElement(By.id("pwd")).sendKeys("test");
	WebElement Loginbtn=driver.findElement(By.xpath("//input[@value='Login']"));
	Loginbtn.click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 wait.until(ExpectedConditions.urlToBe("https://trytestingthis.netlify.app/login.html?uname=test&pwd=test"));

	System.out.println("Current URL: " + driver.getCurrentUrl());
	WebElement successMsg = driver.findElement(By.tagName("h2"));
	System.out.println(successMsg.getText());
	driver.findElement(By.linkText("here")).click();
	System.out.println("Current page Title is:" +driver.getCurrentUrl());
	driver.quit();
	
	
	
	 

}
}
