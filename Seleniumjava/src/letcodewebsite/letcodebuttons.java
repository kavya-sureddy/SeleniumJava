package letcodewebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class letcodebuttons {
	
	// One shared browser variable for all methods
    // static = all methods can use same driver directly
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        // Create Chrome browser, maximize, open the page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/button");
        Thread.sleep(2000); // wait for page to load

        // main() is like a manager — just calls each test one by one
        test1_GoToHomeAndComeBack();
        test2_GetXYCoordinates();
        test3_GetButtonColor();
        test4_GetButtonSize();
        test5_IsButtonDisabled();
        test6_ClickAndHold();

        System.out.println("\n✅ All button tests completed!");
        driver.quit(); // close browser
    }

    // -------------------------------------------------------
    // TEST 1: Click "Goto Home" button → goes to home page
    //         then driver.navigate().back() → comes back
    // -------------------------------------------------------
    static void test1_GoToHomeAndComeBack() throws InterruptedException {
        System.out.println("\n--- Test 1: Goto Home and Come Back ---");

        // Find button by its text and click it
        WebElement gotoHomeBtn = driver.findElement(By.xpath("//button[contains(text(),'Goto Home')]"));
        gotoHomeBtn.click();
        Thread.sleep(2000); // wait for navigation

        System.out.println("Navigated to: " + driver.getCurrentUrl());

        // Like browser back button
        driver.navigate().back();
        Thread.sleep(2000);

        System.out.println("Came back to: " + driver.getCurrentUrl());
        System.out.println("PASS: Navigation back successful");
    }

    // -------------------------------------------------------
    // TEST 2: Find X and Y position of button on screen
    //         getLocation() returns Point object (holds both X and Y)
    //         Point is used because one variable can't hold two numbers  // Point is an inbuilt Selenium class that holds two int values — X and Y pixel coordinates
    //         getX() = distance from left | getY() = distance from top
    // -------------------------------------------------------
    static void test2_GetXYCoordinates() throws InterruptedException {
        System.out.println("\n--- Test 2: Get X & Y Co-ordinates ---");

        WebElement locationBtn = driver.findElement(By.xpath("//button[contains(text(),'Find Location')]"));
        locationBtn.click();
        Thread.sleep(1000);

        // getLocation() returns Point — a box holding X and Y together
        Point location = locationBtn.getLocation();
        int x = location.getX(); // pixels from left of screen
        int y = location.getY(); // pixels from top of screen

        System.out.println("Button X coordinate: " + x);
        System.out.println("Button Y coordinate: " + y);
        System.out.println("PASS: Location fetched X=" + x + ", Y=" + y);
    }

    // -------------------------------------------------------
    // TEST 3: Read CSS background-color of the button
    //         getCssValue() is a method — returns a String value
    //         "px" in print = just decorative text, not a Java keyword
    // -------------------------------------------------------
    static void test3_GetButtonColor() throws InterruptedException {
        System.out.println("\n--- Test 3: Find the Color of the Button ---");

        WebElement colorBtn = driver.findElement(By.xpath("//button[contains(text(),'What is my color?')]"));
        colorBtn.click();
        Thread.sleep(1000);

        // getCssValue() is a method call — reads CSS property and returns as String
        // color variable just stores that returned value (not a new object)
        String color = colorBtn.getCssValue("background-color");
        System.out.println("Button background-color (CSS): " + color);

        String textColor = colorBtn.getCssValue("color");
        System.out.println("Button text color (CSS): " + textColor);

        System.out.println("PASS: Color fetched successfully");
    }

    // -------------------------------------------------------
    // TEST 4: Get height and width of the button in pixels
    //         getSize() returns Dimension object (like Point but for size)
    //         "px" added in println is just plain text — just for readability
    // -------------------------------------------------------
    static void test4_GetButtonSize() throws InterruptedException {
        System.out.println("\n--- Test 4: Get Height & Width of the Button ---");

        WebElement sizeBtn = driver.findElement(By.xpath("//button[contains(text(),'How tall & fat I am?')]"));
        sizeBtn.click();
        Thread.sleep(1000);

        // getSize() gives Dimension object → then getHeight() / getWidth() extract numbers
        int height = sizeBtn.getSize().getHeight();
        int width  = sizeBtn.getSize().getWidth();

        // "px" here is just plain text added to make output readable — not a Java unit
        System.out.println("Button Height: " + height + "px");
        System.out.println("Button Width:  " + width + "px");
        System.out.println("PASS: Size fetched - Height=" + height + ", Width=" + width);
    }

    // -------------------------------------------------------
    // TEST 5: Check if button is disabled
    //         isEnabled() returns true/false (boolean)
    //         disabled button → isEnabled() = false → !false = true → PASS
    //         !isEnabled means NOT enabled = disabled
    // -------------------------------------------------------
    static void test5_IsButtonDisabled() throws InterruptedException {
        System.out.println("\n--- Test 5: Confirm Button is Disabled ---");

        WebElement disabledBtn = driver.findElement(By.xpath("//button[contains(text(),'Disabled')]"));

        // isEnabled() → false means button is disabled (greyed out, not clickable)
        boolean isEnabled = disabledBtn.isEnabled();

        // !isEnabled = NOT enabled = disabled → this is what we expect
        if (!isEnabled) {
            System.out.println("Button is DISABLED as expected");
            System.out.println("PASS: isEnabled() returned false");
        } else {
            System.out.println("FAIL: Button should be disabled but isEnabled() returned true");
        }
    }

    // -------------------------------------------------------
    // TEST 6: Press and hold the button for 3 seconds
    //         Normal click() just clicks instantly — can't hold
    //         Actions class handles mouse interactions like hold, drag, hover
    //         new Actions(driver) → pass driver so it knows which browser to act on
    //         clickAndHold → pause(3000ms) → release → perform() executes it all
    // -------------------------------------------------------
    static void test6_ClickAndHold() throws InterruptedException {
        System.out.println("\n--- Test 6: Click and Hold Button ---");

        WebElement holdBtn = driver.findElement(By.tagName("h2"));

        // Actions is needed because normal click() can't do hold
        // new Actions(driver) — creating object, passing driver to tell which browser
        Actions actions = new Actions(driver);

        // clickAndHold = press down | pause(3000) = hold 3 sec | release = lift up | perform = execute now
        actions.clickAndHold(holdBtn).pause(3000).release(holdBtn).perform();

        Thread.sleep(1000); // wait for page to react
        System.out.println("PASS: Click and Hold performed successfully");
	}

}
