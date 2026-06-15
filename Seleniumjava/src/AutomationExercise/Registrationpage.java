package AutomationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Registrationpage {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.navigate().to("http://automationexercise.com");

        if (driver.getCurrentUrl().equals("https://automationexercise.com/")) {
            System.out.println("PASS - Home page is visible");
        } else {
            System.out.println("FAIL - Home page not visible");
        }

        driver.findElement(By.linkText("Signup / Login")).click();

        WebElement signupText = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        if (signupText.isDisplayed()) {
            System.out.println("PASS - New User Signup! is visible");
        } else {
            System.out.println("FAIL - New User Signup! is not visible");
        }

        driver.findElement(By.name("name")).sendKeys("KavyaTest");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("kavya123@test.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        WebElement accountInfo = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        if (accountInfo.isDisplayed()) {
            System.out.println("PASS - AccountInformation is visible");
        } else {
            System.out.println("FAIL - AccountInformation is not visible");
        }

        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("password")).sendKeys("Kavya123");

        new Select(driver.findElement(By.id("days"))).selectByVisibleText("11");
        new Select(driver.findElement(By.id("months"))).selectByVisibleText("June");
        new Select(driver.findElement(By.id("years"))).selectByVisibleText("1995");

        // Checkboxes - JS click to avoid ad interference
        js.executeScript("arguments[0].click();", driver.findElement(By.id("newsletter")));
        js.executeScript("arguments[0].click();", driver.findElement(By.id("optin")));

        driver.findElement(By.id("first_name")).sendKeys("KavyaTest");
        driver.findElement(By.id("last_name")).sendKeys("KavyaTest");
        driver.findElement(By.id("company")).sendKeys("KavyaTestCompany");
        driver.findElement(By.id("address1")).sendKeys("KavyaHome");
        driver.findElement(By.id("address2")).sendKeys("MainRoad");

        new Select(driver.findElement(By.id("country"))).selectByVisibleText("Australia");

        driver.findElement(By.id("state")).sendKeys("AP");
        driver.findElement(By.id("city")).sendKeys("Vijayawada");
        driver.findElement(By.id("zipcode")).sendKeys("1234");
        driver.findElement(By.id("mobile_number")).sendKeys("123456");

        // Wait for ads to settle, then JS click
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@data-qa='create-account']")));

        Thread.sleep(2000);
        driver.quit();
    }
}