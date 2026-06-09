package Tables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tabled3 {

	public static void main(String[] args) throws InterruptedException {
	       WebDriver driver = new ChromeDriver();
	       driver.get("https://the-internet.herokuapp.com/tables#edit");

	        driver.manage().window().maximize();
//	        String Table1=driver.findElement(By.id("table1")).getText();
//	        System.out.println(Table1);
	        
	        List<WebElement> Headers = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
	        
	        for (WebElement header : Headers) {
			    System.out.print(header.getText() + " | ");
			}
			System.out.println();
			
			List<WebElement> Rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
			
			for (int i =0 ; i < Rows.size(); i++)
			{
				
			List<WebElement>cols = Rows.get(i).findElements(By.tagName("td"));
			
			for (WebElement col : cols) {
				
				System.out.print(col.getText() + "|");
			}
				System.out.println();
			}
			
			System.out.println(" =======================Redaing the Table 2================================");
			
			System.out.println("=== Table 2 - Row 1 BEFORE Sorting ===");

			List<WebElement> Rows2Before = driver.findElements(By.xpath("//table[@id='table2']/tbody/tr"));

			// index 0 = first row only
			List<WebElement> firstRowCols = Rows2Before.get(1).findElements(By.tagName("td"));
			for (WebElement col : firstRowCols) {
			    System.out.print(col.getText() + " | ");
			}
			System.out.println();
			
			// Sort Table 2 by "Last Name" column — click the header
			WebElement sortByLastName = driver.findElement(By.xpath("//table[@id='table2']/thead/tr/th[1]"));
			sortByLastName.click();

			// Small wait for sort to apply
			Thread.sleep(1000);

			// Now read Table 2 headers
			System.out.println("=== Table 2 After Sorting by Last Name ===");

			List<WebElement> Headers2 = driver.findElements(By.xpath("//table[@id='table2']/thead/tr/th"));
			for (WebElement header : Headers2) {
			    System.out.print(header.getText() + " | ");
			}
			System.out.println();

			// Read Table 2 rows after sort
			List<WebElement> Rows1 = driver.findElements(By.xpath("//table[@id='table2']/tbody/tr"));
			for (int j = 0; j < Rows1.size(); j++) {
			    List<WebElement> cols2 = Rows1.get(j).findElements(By.tagName("td"));
			    for (WebElement col : cols2) {
			        System.out.print(col.getText() + " | ");
			    }
			    System.out.println();
			}
	        driver.quit();

	}

}
