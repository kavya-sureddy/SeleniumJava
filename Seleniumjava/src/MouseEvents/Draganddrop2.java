package MouseEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Draganddrop2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/selenium/mouse_interaction.html");

        // draggable element
        WebElement elementToHold = driver.findElement(By.id("draggable"));

        // click - normal driver click finds element, clicks, releases
        // click and hold - Actions class - press down, don't release
        Thread.sleep(2000);

        // KEY_DOWN equivalent (mouse button down, not released)
        Actions actions = new Actions(driver);
        actions.clickAndHold(elementToHold).perform();

        Thread.sleep(10000);

        driver.quit();
    }
}