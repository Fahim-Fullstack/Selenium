package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver", "/Users/jonney/Downloads/chromedriver_mac_arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();



        Thread.sleep(5000);
        //provide username and password
        //WebElement textUserName = driver.findElement(By.name("username"));
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        //oxd-button
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
        Thread.sleep(5000);


        // verify the title of dashboard page
        /*
        String actual_title = driver.getTitle();
        String exp_title  = "OrangeHRM123";
        if(actual_title.equals(exp_title)){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test did not pass");
        } */

        //Validate after successful login
        String actual_label = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
        String exp_label = "Dashboard";
        if(actual_label.equals(exp_label)){
            System.out.println("Passed");
        } else {
            System.out.println("Test case Failed");
        }

        driver.close();
    }
}