package letcodewebsite;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {

    // One shared browser for all methods
    // static = all test methods can use this directly
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        // Open Chrome, maximize, go to alert page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/alert");
        Thread.sleep(2000); // wait for page to load

        // main() is manager — calls each test one by one
        test1_SimpleAlert();
        test2_ConfirmAlert();
        test3_PromptAlert();
        test4_SweetAlert();

        System.out.println("\n All alert tests completed!");
        driver.quit(); // close browser
    }

    // -------------------------------------------------------
    // TEST 1: Simple Alert — just click OK to accept
    //         switchTo().alert() = moves driver focus from webpage to alert popup
    //         Without switchTo() — driver can't see the alert, will throw error
    //         accept() = clicks OK button on alert
    // -------------------------------------------------------
    static void test1_SimpleAlert() throws InterruptedException {
        System.out.println("\n--- Test 1: Simple Alert ---");

        // Find and click "Simple Alert" button to trigger alert
        WebElement simpleAlertBtn = driver.findElement(By.xpath("//button[contains(text(),'Simple Alert')]"));
        simpleAlertBtn.click();
        Thread.sleep(2000); // wait for alert to appear

        // switchTo().alert() = switches driver focus to the alert popup
        // Alert is a Selenium interface — holds methods to handle popups
        Alert alert = driver.switchTo().alert();

        // getText() = reads the message text shown in alert
        String alertText = alert.getText();
        System.out.println("Alert message: " + alertText);

        // accept() = clicks OK button — closes the alert
        alert.accept();
        Thread.sleep(1000);

        System.out.println("PASS: Simple alert accepted successfully");
    }

    // -------------------------------------------------------
    // TEST 2: Confirm Alert — has OK and Cancel buttons
    //         getText() = print the alert message
    //         dismiss() = clicks Cancel button
    //         accept() = clicks OK button
    // -------------------------------------------------------
    static void test2_ConfirmAlert() throws InterruptedException {
        System.out.println("\n--- Test 2: Confirm Alert ---");

        // Click "Confirm Alert" button to trigger alert
        WebElement confirmAlertBtn = driver.findElement(By.xpath("//button[contains(text(),'Confirm Alert')]"));
        confirmAlertBtn.click();
        Thread.sleep(2000);

        // Switch focus to alert
        Alert alert = driver.switchTo().alert();

        // Read and print alert text
        String alertText = alert.getText();
        System.out.println("Confirm alert message: " + alertText);

        // dismiss() = clicks Cancel button on alert
        // Use accept() if you want to click OK instead
        alert.dismiss();
        Thread.sleep(1000);

        System.out.println("PASS: Confirm alert dismissed successfully");
    }

    // -------------------------------------------------------
    // TEST 3: Prompt Alert — has a text input box, OK and Cancel
    //         sendKeys() = types text into the alert input box
    //         accept() = clicks OK after typing
    // -------------------------------------------------------
    static void test3_PromptAlert() throws InterruptedException {
        System.out.println("\n--- Test 3: Prompt Alert ---");

        // Click "Prompt Alert" button to trigger alert
        WebElement promptAlertBtn = driver.findElement(By.xpath("//button[contains(text(),'Prompt Alert')]"));
        promptAlertBtn.click();
        Thread.sleep(2000);

        // Switch focus to alert
        Alert alert = driver.switchTo().alert();

        // Read alert message
        String alertText = alert.getText();
        System.out.println("Prompt alert message: " + alertText);

        // sendKeys() = types your name into the alert input box
        // This is different from normal sendKeys — here it types inside alert popup
        alert.sendKeys("Kavya");
        Thread.sleep(1000);

        // accept() = clicks OK after typing
        alert.accept();
        Thread.sleep(1000);

        System.out.println("PASS: Prompt alert filled and accepted successfully");
    }

//  So NO switchTo().alert() needed here
//         After clicking button — alert appears with a message and X close button
//         Read the message text → then close it by clicking X button
// -------------------------------------------------------
static void test4_SweetAlert() throws InterruptedException {
 System.out.println("\n--- Test 4: Sweet Alert (Modern Alert) ---");

 // Click "Modern Alert" button to trigger sweet alert
 WebElement modernAlertBtn = driver.findElement(By.xpath("//button[contains(text(),'Modern Alert')]"));
 modernAlertBtn.click();
 Thread.sleep(2000);

 // Sweet alert is part of the webpage HTML — NOT a browser popup
 // No switchTo() needed — driver already sees it as normal HTML element
// Read the message text shown inside sweet alert
 
 WebElement alertMessage = driver.findElement(By.xpath("//p[@class='title']"));
 String messageText = alertMessage.getText();
 System.out.println("Sweet alert message: " + messageText);

 // Close the sweet alert by clicking the X (close) button
 // X button has class "swal2-close" in sweet alert library
 WebElement closeBtn = driver.findElement(By.xpath("//button[@aria-label='close']"));
 closeBtn.click();
 Thread.sleep(1000);

 System.out.println("PASS: Sweet alert message read and closed using X button");
    }
}