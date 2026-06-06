package FileInputOutputReadWrite;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExcelData {

    // Excel file that contains test data (username & password)
    private static final String FILE_PATH = "LoginTestData.xlsx";

    // Website URL we are testing login on
    private static final String LOGIN_URL = "https://practicetestautomation.com/practice-test-login/";

    // Maximum seconds to wait for a page element to appear
    private static final int WAIT_TIMEOUT = 10;

    public static void main(String[] args) {

        // Open Chrome browser
        WebDriver driver = new ChromeDriver();

        // try-with-resources automatically closes the Excel file after use
        try (
            FileInputStream fis      = new FileInputStream(FILE_PATH);
            XSSFWorkbook    workbook = new XSSFWorkbook(fis)
        ) {
            // Read the first sheet from the Excel file
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            // Wait object — pauses test until element appears (max 10 seconds)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));

            // Get total number of data rows in Excel (row 0 is header, so we skip it)
            int rowCount = sheet.getLastRowNum();

            // Loop through each data row one by one
            for (int i = 1; i <= rowCount; i++) {

                // Read username from column 0 and password from column 1
                String userName = sheet.getRow(i).getCell(0).getStringCellValue();
                String password = sheet.getRow(i).getCell(1).getStringCellValue();

                // Run login test with this username and password
                runLoginTest(driver, wait, userName, password);
            }

        } catch (IOException e) {
            // If Excel file is missing or unreadable, print the error
            System.err.println("File error: " + e.getMessage());

        } finally {
            // Always close the browser at the end, even if an error occurred
            driver.quit();
        }
    }

    // This method performs one login attempt and checks the result
    private static void runLoginTest(WebDriver driver, WebDriverWait wait,
                                      String userName, String password) {

        // Open the login page
        driver.get(LOGIN_URL);

        // Type username, password and click the Submit button
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();

        try {
            // Wait until the h1 heading appears on the page after login
            WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))
            );

            // Check if the heading says login was successful
            if (message.getText().contains("Logged In Successfully")) {
                System.out.println("PASS | User: " + userName);
            } else {
                // Login failed — print what message appeared instead
                System.out.println("FAIL | User: " + userName + " | Message: " + message.getText());
            }

        } catch (Exception e) {
            // h1 heading never appeared within 10 seconds — something went wrong
            System.out.println("FAIL | User: " + userName + " | Reason: h1 not found");
        }
    }
}