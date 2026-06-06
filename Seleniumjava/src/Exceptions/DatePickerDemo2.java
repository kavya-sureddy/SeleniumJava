package Exceptions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo2 {

    public static void main(String[] args) throws InterruptedException {

        // Open Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        try {
            // Open the jQuery datepicker demo page
            driver.get("https://jqueryui.com/datepicker/");

            // The datepicker is inside an iframe, so we switch into it first
            // Without this, Selenium cannot find any elements inside the iframe
            driver.switchTo().frame(0);

            // Target date we want to select: 15 August 2027
            String targetDay = "15";
            String Month     = "August";
            String Year      = "2024";

            // Click the date input box to open the calendar popup
            driver.findElement(By.id("datepicker")).click();

            // Keep clicking Next until we reach August 2027
            while (true) {

                // Read the currently displayed month and year from the calendar header
                String CurrentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
                String CurrentYear  = driver.findElement(By.className("ui-datepicker-year")).getText();

                // If we have reached the target month and year, stop navigating
                if (CurrentMonth.equals(Month) && CurrentYear.equals(Year)) {
                    break;
                }

                // Click the Next arrow to go to the next month
                driver.findElement(By.xpath("//span[text()='Prev']")).click();

                // Small pause so the calendar animation finishes before we read again
                Thread.sleep(400);
            }

            // Once we are on August 2027, get all clickable day numbers from the calendar
            // Only <a> tags inside <td> are actual selectable days (grayed-out days have no <a>)
            List<WebElement> allDays = driver.findElements(
                By.xpath("//table[@class='ui-datepicker-calendar']//td//a")
            );

            // Loop through all the day numbers and click the one that matches "15"
            for (WebElement day : allDays) {

                if (day.getText().equals(targetDay)) {
                    day.click(); // Click on 15
                    break;       // Stop looping once the date is selected
                }
            }

        } finally {
            //  finally block is empty — browser will NOT close after the test
            // Add driver.quit() here to properly close the browser
            driver.quit();
        }
    }
}