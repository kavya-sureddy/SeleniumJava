package Assignments;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class E2E {

    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    //  Locators
    static By loginNavBtn    = By.id("login2");
    static By usernameField  = By.id("loginusername");
    static By passwordField  = By.id("loginpassword");
    static By loginSubmitBtn = By.xpath("//button[text()='Log in']");
    static By loggedInUser   = By.id("nameofuser");
    static By cartNavBtn     = By.id("cartur");

    static By addToCartBtn   = By.xpath("//a[text()='Add to cart']");

    static By deleteLinks    = By.xpath("//a[text()='Delete']");
    static By placeOrderBtn  = By.xpath("//button[text()='Place Order']");

    static By orderName      = By.id("name");
    static By orderCountry   = By.id("country");
    static By orderCity      = By.id("city");
    static By orderCard      = By.id("card");
    static By orderMonth     = By.id("month");
    static By orderYear      = By.id("year");
    static By purchaseBtn    = By.xpath("//button[text()='Purchase']");
    static By confirmOkBtn   = By.xpath("//button[text()='OK']");
    static By confirmMsg     = By.xpath("//p[@class='lead text-muted ']");

    
    public static void main(String[] args) throws InterruptedException {

        // Setup 
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait    = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);

        try {

            // ── 1. Open Site 
            driver.get("https://www.demoblaze.com/index.html");
            System.out.println(" Site opened");

            // ── 2. Login 
            scrollAndClick(loginNavBtn);

            wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
            driver.findElement(usernameField).clear();
            driver.findElement(usernameField).sendKeys("kavyatest");
            driver.findElement(passwordField).clear();
            driver.findElement(passwordField).sendKeys("12345678");

            scrollAndClick(loginSubmitBtn);

            wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInUser));
            System.out.println("Logged in: " + driver.findElement(loggedInUser).getText());

            // ── 3. Add Product 1 — Samsung Galaxy S6 
            driver.get("https://www.demoblaze.com/prod.html?idp_=1");
            wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
            scrollAndClick(addToCartBtn);
            handleAlert("Samsung Galaxy S6 added");
            Thread.sleep(1000);

            // ── 4. Add Product 2 — Nokia Lumia 1520 
            driver.get("https://www.demoblaze.com/prod.html?idp_=2");
            wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
            scrollAndClick(addToCartBtn);
            handleAlert("Nokia Lumia 1520 added");
            Thread.sleep(1000);

            // ── 5. Go to Cart 
            scrollAndClick(cartNavBtn);
            wait.until(ExpectedConditions.urlContains("cart"));
            Thread.sleep(2000);
            System.out.println("Cart opened");

            // ── 6. Check items in cart
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(deleteLinks, 0));
            List<WebElement> deleteButtons = driver.findElements(deleteLinks);
            System.out.println("Items in cart: " + deleteButtons.size());

            // ── 7. Delete first product 
            scrollAndClickElement(deleteButtons.get(0));
            Thread.sleep(2000);
            System.out.println(" First product deleted");

            List<WebElement> remaining = driver.findElements(deleteLinks);
            System.out.println(" Remaining items: " + remaining.size());

            // ── 8. Place Order 
            scrollAndClick(placeOrderBtn);
            wait.until(ExpectedConditions.visibilityOfElementLocated(orderName));
            System.out.println(" Place Order modal opened");

            // ── 9. Fill Order Form 
            driver.findElement(orderName).sendKeys("Kavya Sureddy");
            driver.findElement(orderCountry).sendKeys("India");
            driver.findElement(orderCity).sendKeys("Vijayawada");
            driver.findElement(orderCard).sendKeys("1234567890123456");
            driver.findElement(orderMonth).sendKeys("06");
            driver.findElement(orderYear).sendKeys("2026");
            System.out.println(" Order form filled");

            // ── 10. Click Purchase 
            scrollAndClick(purchaseBtn);

            // ── 11. Confirm Success 
            wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOkBtn));
            System.out.println(" Order confirmed: " + driver.findElement(confirmMsg).getText());

            scrollAndClick(confirmOkBtn);
            System.out.println(" Full E2E Flow PASSED!");

        } catch (Exception e) {
            System.out.println(" Test failed: " + e.getMessage());
            e.printStackTrace();

        } finally {
            driver.quit();
            System.out.println(" Browser closed");
        }
    }

    //  Scroll into view using Actions, then click 
    static void scrollAndClick(By locator) {
        WebElement element = wait.until(
            ExpectedConditions.elementToBeClickable(locator));
        actions.moveToElement(element).perform();
        element.click();
    }

    //  Scroll + click on already-found WebElement 
    static void scrollAndClickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        actions.moveToElement(element).perform();
        element.click();
    }

    //  Handle native JS alert 
    static void handleAlert(String context) {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert [" + context + "]: " + alert.getText());
            alert.accept();
        } catch (TimeoutException e) {
            System.out.println(" No alert for: " + context);
        }
    }
}