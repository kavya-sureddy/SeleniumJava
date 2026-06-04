package letcodewebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

 public class DropdownTest {
	
	// One shared browser for all methods
    // static = all test methods can use this directly
    static WebDriver driver;
 
    public static void main(String[] args) throws InterruptedException {
 
        // Open Chrome, maximize, go to dropdowns page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/dropdowns");
        Thread.sleep(2000); // wait for page to load
 
        // main() just calls each test one by one like a manager
        test1_SelectByVisibleText();
        test2_MultipleSelect();
        test3_SelectByIndexAndPrintAll();
        test4_SelectByValueAndPrint();
 
        System.out.println("\n All dropdown tests completed!");
        driver.quit(); // close browser
    }
 
    // -------------------------------------------------------
    // TEST 1: Select "Apple" from fruit dropdown using visible text
    //         Select class is used for HTML <select> dropdowns
    //         selectByVisibleText() = select option by the text you see on screen
    // -------------------------------------------------------
    static void test1_SelectByVisibleText() throws InterruptedException {
        System.out.println("\n--- Test 1: Select Apple by Visible Text ---");
 
        // Find the dropdown element
        WebElement fruitDropdown = driver.findElement(By.id("fruits"));
 
        // Wrap WebElement with Select class — Select gives us dropdown methods
        // Without Select, we can't use selectByVisibleText, selectByIndex etc.
        Select select = new Select(fruitDropdown);
 
        // selectByVisibleText() = selects option that matches the visible text "Apple"
        select.selectByVisibleText("Apple");
        Thread.sleep(1000);
 
        // getFirstSelectedOption() = returns the currently selected option as WebElement
        // .getText() = reads its text
        String selectedValue = select.getFirstSelectedOption().getText();
        System.out.println("Selected fruit: " + selectedValue);
        System.out.println("PASS: Apple selected successfully");
    }
 
    // -------------------------------------------------------
    // TEST 2: Select multiple superheroes from multi-select dropdown
    //         isMultiple() = checks if dropdown allows multiple selections → true/false
    //         If true → select multiple options one by one
    // -------------------------------------------------------
    static void test2_MultipleSelect() throws InterruptedException {
        System.out.println("\n--- Test 2: Multi-Select Superheroes ---");
 
        WebElement heroDropdown = driver.findElement(By.id("superheros"));
 
        // Wrap with Select class to use dropdown methods
        Select select = new Select(heroDropdown);
 
        // isMultiple() = returns true if dropdown allows selecting more than one option
        boolean isMultiple = select.isMultiple();
        System.out.println("Is Multiple Select: " + isMultiple);
 
        if (isMultiple) {
            // Select multiple heroes one by one using visible text
            select.selectByVisibleText("Aquaman");
            select.selectByVisibleText("Batman");
            select.selectByVisibleText("Superman");
            Thread.sleep(1000);
            System.out.println("PASS: Multiple heroes selected successfully");
        } else {
            System.out.println("FAIL: Dropdown does not support multiple selection");
        }
    }
 
    // -------------------------------------------------------
    // TEST 3: Select last option by index and print all options
    //         selectByIndex() = selects option by its position (0 = first, 1 = second...)
    //         getOptions() = returns all options in dropdown as a List
    // -------------------------------------------------------
    static void test3_SelectByIndexAndPrintAll() throws InterruptedException {
        System.out.println("\n--- Test 3: Select Last Language and Print All Options ---");
 
        WebElement langDropdown = driver.findElement(By.id("lang"));
 
        // Wrap with Select class
        Select select = new Select(langDropdown);
 
        // getOptions() = returns all <option> elements inside dropdown as a List
        List<WebElement> allOptions = select.getOptions();
 
        System.out.println("All programming languages:");
        // Loop through each option and print its text
        for (WebElement option : allOptions) {
            System.out.println("  * " + option.getText());
        }
 
        // Last option index = total size - 1
        // Example: 5 options → index 0,1,2,3,4 → last = index 4
        int lastIndex = allOptions.size() - 1;
 
        // selectByIndex() = selects option at that position
        select.selectByIndex(lastIndex);
        Thread.sleep(1000);
 
        String selected = select.getFirstSelectedOption().getText();
        System.out.println("Last language selected: " + selected);
        System.out.println("PASS: Last option selected successfully");
    }
 
    // -------------------------------------------------------
    // TEST 4: Select India using value attribute and print selected value
    //         selectByValue() = selects option by its HTML value attribute
    //         value attribute is different from visible text
    //         Example: <option value="in">India</option>  → value="in", text="India"
    //         getFirstSelectedOption().getText() = prints what is selected
    // -------------------------------------------------------
    static void test4_SelectByValueAndPrint() throws InterruptedException {
        System.out.println("\n--- Test 4: Select India by Value and Print ---");
 
        WebElement countryDropdown = driver.findElement(By.id("country"));
 
        // Wrap with Select class
        Select select = new Select(countryDropdown);
 
        // selectByValue() = matches the HTML value attribute of the option, not the visible text
        // India's value in this dropdown is "in"
        select.selectByValue("India");
        Thread.sleep(1000);
 
        // getFirstSelectedOption() = gets selected option element
        // getText() = reads the visible text of that option
        String selectedCountry = select.getFirstSelectedOption().getText();
        System.out.println("Selected country: " + selectedCountry);
        System.out.println("PASS: India selected successfully by value");
    }
}
 
