package Alerts;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;


public class AlertsDemo {

	private static WebElement webElement;

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//1st alert
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
	    Alert simpleAlert=driver.switchTo().alert();
	    System.out.println("Alrt text is: " + simpleAlert.getText());
	    simpleAlert.accept();
	    WebElement result=driver.findElement(By.id("result"));
	    System.out.println("result:"+ result.getText());
	    
	  
	   
	   
	   //2nd alert
	   
	   driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
	   Alert mediumAlert=driver.switchTo().alert();
	   System.out.println("Alert text is :" +mediumAlert.getText());
	   mediumAlert.accept();
	   WebElement result1=driver.findElement(By.id("result"));
	   System.out.println("result:"+ result1.getText());
	   
	   
	   
	   //3rd alert:
	    driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
	   Alert Thirdalert=driver.switchTo().alert();
	   System.out.println("Alert txt is:" +Thirdalert.getText());
	   //Thirdalert.sendKeys("kavya");
	   Thirdalert.dismiss();
	   WebElement result2=driver.findElement(By.id("result"));
	   System.out.println("result:"+ result2.getText());
	   driver.quit();
	   
	   }
}
