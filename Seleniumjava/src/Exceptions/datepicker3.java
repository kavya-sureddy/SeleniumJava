package Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class datepicker3 {

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://trytestingthis.netlify.app/");

            WebElement dateField = driver.findElement(By.id("day"));

            // FUTURE DATE
            dateField.sendKeys("12/31/2027");
            String futureDate = dateField.getAttribute("value");
            System.out.println("Future Date selected: " + futureDate);

            // PAST DATE — clear first then send
            dateField.clear();
            dateField.sendKeys("01/15/2020");
            String pastDate = dateField.getAttribute("value");
            System.out.println("Past Date selected: " + pastDate);

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit(); // Always runs — pass or fail
            }
        }
    }
}