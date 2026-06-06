package Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class datepicker4 {

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://trytestingthis.netlify.app/");

            WebElement dateField = driver.findElement(By.id("day"));

            // Enter a date
            String dateToEnter = "12/31/2027"; // change this to test
            dateField.sendKeys(dateToEnter);

            // Get the value entered
            String enteredValue = dateField.getAttribute("value");
            // value comes as YYYY-MM-DD
            int year = Integer.parseInt(enteredValue.split("-")[0]);

            int currentYear = 2026;

            // IF-ELSE logic
            if (year > currentYear) {
                System.out.println(" Future date selected: " + enteredValue);
            } else if (year == currentYear) {
                System.out.println("Current year selected: " + enteredValue);
            } else {
                System.out.println("Past date selected: " + enteredValue);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}