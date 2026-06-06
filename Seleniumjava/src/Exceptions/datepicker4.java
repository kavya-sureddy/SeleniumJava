package Exceptions;

/*
 * SHADOW DOM vs IFRAME - Key Difference
 *
 * SHADOW DOM (Example: trytestingthis.netlify.app date picker)
 * - The date picker is a native browser element <input type="date">
 * - Browser hides the inner parts (day/month/year spinners) inside #shadow-root
 * - Selenium CANNOT inspect or locate elements inside shadow DOM
 * - Solution: Just use sendKeys("MM/DD/YYYY") directly on the input element
 * - No switching needed, no extra steps needed
 *
 * IFRAME (Example: jqueryui.com/datepicker)
 * - The date picker is a custom calendar built using jQuery JavaScript library
 * - It is placed inside an <iframe> which is like a mini webpage inside main webpage
 * - Selenium CAN inspect and locate elements inside iframe
 * - BUT you must switch into the iframe first using driver.switchTo().frame()
 * - After your work is done, switch back using driver.switchTo().defaultContent()
 * - Without switching, Selenium will throw NoSuchElementException
 *
 * SIMPLE RULE TO REMEMBER:
 * Shadow DOM = Browser locked it, no way in, use sendKeys() as back door
 * iFrame     = Has a door, just knock first using switchTo().frame()
 */

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

//Normal DOM is the HTML written by the developer — it is like an open room where Selenium can walk in freely and access any element directly. 
//Shadow DOM is the hidden HTML created automatically by the browser — it is like a locked room where Selenium cannot enter.
//So instead of going inside we use sendKeys as a way to pass things under the door!"

