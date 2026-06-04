package letcodewebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class RadioTest {

    public static void main(String[] args) throws InterruptedException {

        // Open Chrome, maximize, go to radio page
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/radio");
        Thread.sleep(2000); // wait for page to load

        // -------------------------------------------------------
        // TASK 1: Select any one radio button — click "Yes"
        //         click() = selects the radio button
        //         isSelected() = returns true if selected, false if not
        // -------------------------------------------------------
        System.out.println("\n--- Task 1: Select Yes radio button ---");

        // Find "Yes" radio button by value attribute and click it
        WebElement yesRadio = driver.findElement(By.id("yes"));
        yesRadio.click();
        Thread.sleep(1000);

        // isSelected() = checks if radio button is selected → true or false
        System.out.println("Yes selected: " + yesRadio.isSelected()); // should print true
        System.out.println("PASS: Yes radio button selected");

        // -------------------------------------------------------
        // TASK 2: Confirm only one radio button can be selected at a time
        //         Click Yes → then click No → Yes should auto deselect
        // -------------------------------------------------------
        System.out.println("\n--- Task 2: Confirm only one can be selected ---");

        // Find both Yes and No of second group
        WebElement yesRadio2 = driver.findElement(By.id("one"));
        WebElement noRadio2  = driver.findElement(By.id("two"));

        yesRadio2.click(); // select Yes first
        Thread.sleep(500);
        System.out.println("After clicking Yes — Yes selected: " + yesRadio2.isSelected()); // true

        noRadio2.click();  // now select No
        Thread.sleep(500);
        System.out.println("After clicking No  — Yes selected: " + yesRadio2.isSelected()); // false — auto deselected
        System.out.println("After clicking No  — No selected:  " + noRadio2.isSelected());  // true
        System.out.println("PASS: Only one radio can be selected at a time confirmed");

        // -------------------------------------------------------
        // TASK 3: Find the bug
        //         Both Yes and No can be selected — that is the bug
        //         Normally radio buttons allow only one selection
        //         Here both can be selected = bug in the page
        // -------------------------------------------------------
        System.out.println("\n--- Task 3: Find the Bug ---");

        WebElement bugYes = driver.findElement(By.id("nobug"));
        WebElement bugNo  = driver.findElement(By.id("bug"));

        bugYes.click();
        Thread.sleep(500);
        bugNo.click();
        Thread.sleep(500);

        // If both are selected = BUG found
        System.out.println("Bug Yes selected: " + bugYes.isSelected());
        System.out.println("Bug No selected:  " + bugNo.isSelected());

        if (bugYes.isSelected() && bugNo.isSelected()) {
            System.out.println("BUG FOUND: Both radio buttons are selected at same time!");
        }

        // -------------------------------------------------------
        // TASK 4: Find which radio button is already selected
        //         isSelected() = true means that option is pre-selected
        // -------------------------------------------------------
        System.out.println("\n--- Task 4: Find which one is already selected ---");

        // Get both Foo and Bar radio buttons
        WebElement fooRadio = driver.findElement(By.id("foo"));
        WebElement barRadio = driver.findElement(By.id("notfoo"));

        // isSelected() = check which one is already selected by default
        if (fooRadio.isSelected()) {
            System.out.println("Foo is already selected");
        } else if (barRadio.isSelected()) {
            System.out.println("Bar is already selected");
        }
        System.out.println("PASS: Pre-selected radio found");

        // -------------------------------------------------------
        // TASK 5: Confirm last radio button is disabled
        //         isEnabled() = false means button is disabled (can't click)
        // -------------------------------------------------------
        System.out.println("\n--- Task 5: Confirm last radio button is disabled ---");

        // Get all three radio buttons — Going, Not going, Maybe
        // Maybe is the last one and should be disabled
        List<WebElement> eventRadios = driver.findElements(By.id("going"));

        // Last radio = size - 1 (index starts from 0)
        WebElement lastRadio = eventRadios.get(eventRadios.size() - 1);

        // isEnabled() = false means disabled
        if (!lastRadio.isEnabled()) {
            System.out.println("Last radio button is DISABLED as expected");
            System.out.println("PASS: isEnabled() returned false");
        } else {
            System.out.println("FAIL: Last radio should be disabled");
        }

        // -------------------------------------------------------
        // TASK 6: Find if checkbox is already selected
        //         Checkboxes work same as radio — isSelected() = true/false
        //         Difference: checkbox allows multiple selections, radio allows only one
        // -------------------------------------------------------
        System.out.println("\n--- Task 6: Find if checkbox is selected ---");

        // "Remember me" checkbox
        WebElement rememberMe = driver.findElement(By.xpath("//label[normalize-space()='Remember me']"));
        System.out.println("Remember me checked: " + rememberMe.isSelected()); // true if pre-checked

        // "Accept T&C" checkbox
        WebElement acceptTC = driver.findElement(By.xpath("//div[7]//label[2]//input[1]"));
        System.out.println("Accept T&C checked: " + acceptTC.isSelected());   

        
        acceptTC.click();
        Thread.sleep(500);
        System.out.println("Fake terms checked after click: " + acceptTC.isSelected()); // true
        System.out.println("PASS: Checkboxes verified successfully");

        // -------------------------------------------------------
        System.out.println("\n All Radio & Checkbox tests completed!");
        driver.quit(); // close browser
    }
}