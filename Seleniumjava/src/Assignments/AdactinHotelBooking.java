package Assignments;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class AdactinHotelBooking {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            driver.manage().window().maximize();
            driver.get("http://adactinhotelapp.com/index.php");

            // ---------- LOGIN ----------
            wait.until(ExpectedConditions.elementToBeClickable(By.id("username")))
                    .sendKeys("kavyaTest"); // replace with your registered username

            driver.findElement(By.id("password")).sendKeys("Kavya@1234"); // replace with your password

            driver.findElement(By.id("login")).click();

            // Confirm login success - location dropdown on Search page
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("location")));
            System.out.println("Login successful!");

            // ---------- SEARCH HOTEL ----------
            new Select(driver.findElement(By.id("location"))).selectByVisibleText("Sydney");
            new Select(driver.findElement(By.id("hotels"))).selectByVisibleText("Hotel Creek");
            new Select(driver.findElement(By.cssSelector("#room_type"))).selectByVisibleText("Super Deluxe");
            new Select(driver.findElement(By.xpath("//*[@id='room_nos']"))).selectByVisibleText("2 - Two");

            new Select(driver.findElement(By.id("adult_room"))).selectByVisibleText("2 - Two");
            new Select(driver.findElement(By.id("child_room"))).selectByVisibleText("4 - Four");

            driver.findElement(By.id("Submit")).click();

            // ---------- SELECT HOTEL FROM RESULTS (RADIO BUTTON) ----------
            WebElement firstRadio = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("radiobutton_0")));
            firstRadio.click();

            // Click Continue button (CSS selector)
            driver.findElement(By.cssSelector("input[name='continue']")).click();

            // ---------- BOOKING FORM ----------
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")));

            driver.findElement(By.id("first_name")).clear();
            driver.findElement(By.id("first_name")).sendKeys("Kavya");

            driver.findElement(By.id("last_name")).clear();
            driver.findElement(By.id("last_name")).sendKeys("Sureddy");

            // Random address details
            driver.findElement(By.id("address")).clear();
            driver.findElement(By.id("address")).sendKeys("221B Baker Street, Near Tech Park, Vijayawada, AP - 520010");

            new Select(driver.findElement(By.id("cc_type"))).selectByIndex(1);

            // Random card number and CVV
            driver.findElement(By.id("cc_num")).clear();
            driver.findElement(By.id("cc_num")).sendKeys("4539148803436467");

            driver.findElement(By.id("cc_cvv")).clear();
            driver.findElement(By.id("cc_cvv")).sendKeys("321");

            new Select(driver.findElement(By.id("cc_exp_month"))).selectByIndex(10); // index 10 -> 11th option
            new Select(driver.findElement(By.id("cc_exp_year"))).selectByIndex(5);

            // ---------- SUBMIT BOOKING ----------
            driver.findElement(By.id("book_now")).click();

            // Handle confirmation alert if present
            try {
                wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                alert.accept();
            } catch (TimeoutException te) {
                System.out.println("No alert appeared, continuing...");
            }

            // ---------- BOOKING CONFIRMATION ----------
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("order_no")));

            WebElement orderIdElement = driver.findElement(By.id("order_no"));
            String orderId = orderIdElement.getAttribute("value");

            System.out.println("Booking Confirmed! Order ID: " + orderId);

            // ---------- LOGOUT ----------
            driver.findElement(By.xpath("//a[text()='Logout']")).click();
            Thread.sleep(2000);
            System.out.println("Logout successful!");

        } catch (TimeoutException te) {
            System.out.println("Timeout occurred: " + te.getMessage());
        } catch (NoSuchElementException nse) {
            System.out.println("Element not found: " + nse.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}