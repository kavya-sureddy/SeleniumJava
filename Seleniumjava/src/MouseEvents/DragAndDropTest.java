package MouseEvents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        // Locate source (A) and target (B)
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        // Perform drag and drop
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();

        Thread.sleep(2000);

        // Verify
        System.out.println("Column A now shows: " + driver.findElement(By.id("column-a")).getText());
        System.out.println("Column B now shows: " + driver.findElement(By.id("column-b")).getText());

        driver.quit();
    }
}