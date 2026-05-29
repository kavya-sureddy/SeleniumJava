package Elementsinteractions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;


public class RadioButtonDemo {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/radio.html");
		
		WebElement option1=driver.findElement(By.id("vfb-7-1"));
		WebElement option2=driver.findElement(By.id("vfb-7-2"));
		WebElement option3=driver.findElement(By.id("vfb-7-3"));
		
		option1.click();
		
		System.out.println("Radio Button option1 Status: " +option1.isSelected());
		System.out.println("Radio Button option2 Status: " +option2.isSelected());
		System.out.println("Radio Button option3 Status :" +option3.isSelected());
		
		
        driver.quit();

	}

	}


