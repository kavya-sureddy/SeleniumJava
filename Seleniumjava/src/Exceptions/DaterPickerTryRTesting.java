package Exceptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DaterPickerTryRTesting {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://trytestingthis.netlify.app/");

        driver.findElement(By.id("day")).sendKeys("06/06/2026");

        // Store element value in a String variable
        String dateValue = driver.findElement(By.id("day")).getAttribute("value");
        System.out.println("Date selected: " + dateValue);

        driver.quit();
    }
}