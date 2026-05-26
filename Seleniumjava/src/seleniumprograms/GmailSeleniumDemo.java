package seleniumprograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailSeleniumDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.gmail.com");

        driver.manage().window().maximize();

        System.out.println("-----Gmail Info-------");

        // getting the page title
        String gmailTitle = driver.getTitle();
        System.out.println(" Page Title: " + gmailTitle);

        // capture the Current URL
        String gmailurl = driver.getCurrentUrl();
        System.out.println(" Current URL: " + gmailurl);

        // using navigate method
        driver.navigate().to("https://www.google.com");
        System.out.println(" New Title: " + driver.getTitle());

        Thread.sleep(3000);

        driver.navigate().back();
        System.out.println(" Back is clicked: " + driver.getTitle());

        Thread.sleep(3000);

        driver.navigate().forward();
        System.out.println(" Forward is clicked: " + driver.getTitle());

        Thread.sleep(3000);

        driver.navigate().refresh();

        System.out.println("Page Source length: " + driver.getPageSource().length());
        // System.out.println("Page Source is: " + driver.getPageSource());
        
        driver.quit();
    }
}