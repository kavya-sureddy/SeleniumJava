package Tables;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		
		List<WebElement> headers = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th"));
		
		for (WebElement header : headers) {
		    System.out.print(header.getText() + " | ");
		}
		System.out.println();
			
		
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));

		System.out.println("-----Reading Values From TABLE--------------");
		
		for (int i =0 ; i < rows.size(); i++)
		{
			
		List<WebElement>cols = rows.get(i).findElements(By.tagName("td"));
		
		for (WebElement col : cols) {
			
			System.out.print(col.getText() + "|");
		}
			System.out.println();
		}
		
File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
File destinationFile = new File("Screenshots/08062026.png");
FileUtils.copyFile(screenshotFile, destinationFile);

System.out.println("Screenshot is successfull");

		driver.quit();
	}

}


