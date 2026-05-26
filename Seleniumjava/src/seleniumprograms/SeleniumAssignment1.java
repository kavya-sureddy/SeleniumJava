package seleniumprograms;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAssignment1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1st website - using driver.get()
        driver.get("https://www.gmail.com");
        Thread.sleep(2000);
        System.out.println("-----Website 1-----");
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // 2nd website - using driver.get()
        driver.get("https://www.flipkart.com");
        Thread.sleep(3000);
        System.out.println("-----Website 2-----");
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // 3rd website - using navigate().to()
        driver.navigate().to("https://www.amazon.in");
        Thread.sleep(3000);
        System.out.println("-----Website 3-----");
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // 4th website - using navigate().to()
        driver.navigate().to("https://www.abhibus.com");
        Thread.sleep(3000);
        System.out.println("-----Website 4-----");
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // click back button
        driver.navigate().back();
        Thread.sleep(2000);
        System.out.println("-----Back Clicked-----");
        System.out.println("Page Title: " + driver.getTitle());
        
        //Click Forward
        driver.navigate().forward();
        Thread.sleep(2000);
        System.out.println("-----Forward Clicked-----");
        System.out.println("Page Title: " + driver.getTitle());
        

        // page refresh
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("-----Page Refreshed-----");

        // 5th website - using navigate().to()
        driver.navigate().to("https://www.zomato.com");
        Thread.sleep(3000);
        System.out.println("-----Website 5-----");
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // page refresh
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("-----Page Refreshed-----");

        // quit browser
        driver.quit();
        System.out.println("-----Browser Closed-----");
    }
}