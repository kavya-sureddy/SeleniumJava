package Tables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdvancedTableDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://letcode.in/advancedtable");

        // ==========================================
        // 1. Table Information
        // ==========================================
        System.out.println("Table Info : "
                + driver.findElement(By.id("advancedtable_info")).getText());

        // ==========================================
        // 2. Change Entries
        // ==========================================
        Select select = new Select(
                driver.findElement(By.id("dt-length-0")));

        select.selectByVisibleText("10");

        List<WebElement> rows = driver.findElements(
                By.xpath("//table[@id='advancedtable']/tbody/tr"));

        System.out.println("Rows Displayed : " + rows.size());

        // ==========================================
        // 3. Search
        // ==========================================
        WebElement searchBox = driver.findElement(
                By.xpath("//input[@type='search']"));

        searchBox.sendKeys("University of Aberdeen");

        System.out.println("\nFiltered Results");

        rows = driver.findElements(
                By.xpath("//table[@id='advancedtable']/tbody/tr"));

        for (WebElement row : rows) {
            System.out.println(row.getText());
        }

     // ==========================================
        // 4. Clear Search
        // ==========================================
        searchBox.sendKeys(Keys.CONTROL + "a");
        searchBox.sendKeys(Keys.BACK_SPACE);

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//table[@id='advancedtable']/tbody/tr"), 1));

        // ==========================================
        // 5. Read Current Page Data
        // ==========================================
        System.out.println("\nCurrent Page Data");

        rows = driver.findElements(
                By.xpath("//table[@id='advancedtable']/tbody/tr"));

        for (WebElement row : rows) {
            System.out.println(row.getText());
        }

        // ==========================================
        // 6. Sort First Column
        // ==========================================
        try {

            WebElement sortColumn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//table[@id='advancedtable']//th[1]")));

            sortColumn.click();

            System.out.println("\nSorting Applied");

        } catch (Exception e) {

            System.out.println("Sorting column not found");
        }

     // ==========================================
        // 7. Go To Next Page
        // ==========================================
        WebElement nextBtn = driver.findElement(
                By.xpath("//button[@aria-label='Next']"));

        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", nextBtn);

        if (!nextBtn.getAttribute("class").contains("disabled")) {

            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", nextBtn);

            System.out.println("\nMoved To Next Page");
        }

        // ==========================================
        // 8. Return To First Page
        // ==========================================
        while (true) {

            WebElement prevBtn = driver.findElement(
                    By.xpath("//button[@aria-label='Previous']"));

            if (prevBtn.getAttribute("class").contains("disabled")) {
                break;
            }

            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", prevBtn);
        }

        // ==========================================
        // 9. Read All Pages Data
        // ==========================================
        System.out.println("\n===== ALL PAGES DATA =====");

        while (true) {

            rows = driver.findElements(
                    By.xpath("//table[@id='advancedtable']/tbody/tr"));

            for (WebElement row : rows) {
                System.out.println(row.getText());
            }

            nextBtn = driver.findElement(
                    By.xpath("//button[@aria-label='Next']"));

            if (nextBtn.getAttribute("class").contains("disabled")) {
                break;
            }

            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", nextBtn);
        }
        driver.quit();
    }
}