package Tables;



import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Scanner;

public class scrrenshotd1 {

    public static void main(String[] args) throws Exception {

        // Step 1 — Take URL input from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the URL: ");
        String url = scanner.nextLine();

        // Step 2 — Launch browser and open URL
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(2000); // wait for page to load

        // Step 3 — Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Step 4 — Save screenshot to your local path
        File destination = new File("C:\\screenshots\\webpage_screenshot.png");
        FileUtils.copyFile(source, destination);

        System.out.println("Screenshot saved at: " + destination.getAbsolutePath());

        driver.quit();
        scanner.close();
    }
}