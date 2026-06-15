package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class saucedemo {

    public static void main(String[] args)  {

        WebDriver driver= new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Adding Product to Cart

        driver.findElement(By.id("item_4_title_link")).click();
        driver.findElement(By.id("add-to-cart")).click();

        //Click on cart

        driver.findElement(By.xpath("//span[@data-test='shopping-cart-badge']")).click();
        driver.findElement(By.id("checkout")).click();

        //adding info

        driver.findElement(By.id("first-name")).sendKeys("Kavya");
        driver.findElement(By.id("last-name")).sendKeys("Kavya");
        driver.findElement(By.id("postal-code")).sendKeys("333333");
        driver.findElement(By.id("continue")).click();

        //finish product

        driver.findElement(By.id("finish")).click();
        driver.findElement(By.id("back-to-products")).click();
        driver.quit();

}

}