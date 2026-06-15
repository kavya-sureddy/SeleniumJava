package FileInputOutputReadWrite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileuploadDemo1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/upload");

        String path = "C:\\Users\\kavya\\Downloads\\test.txt";
        System.out.println("Path of the file: " + path);

        WebElement fileInput = driver.findElement(By.id("fileInput"));
        fileInput.sendKeys(path);

        driver.findElement(By.id("fileSubmit")).click();

        WebElement successMsg = driver.findElement(By.id("uploaded-files"));
        System.out.println("Status: " + successMsg.getText());
    }
}