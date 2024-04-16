package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class registrationFoemTest {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaregform.ccbp.tech");
        WebElement firstName = driver.findElement(By.xpath("//input[@id = 'firstName']"));
        firstName.sendKeys("John");
        WebElement lastName = driver.findElement(By.xpath("//input[@id = 'lastName']"));
        lastName.sendKeys("Doe");
        WebElement submitButton = driver.findElement(By.xpath("//button[@class = 'submit-button']"));
        submitButton.submit();
        WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class = 'success-image']")));
        System.out.println("Registration Successful");
        WebElement submitAnother = driver.findElement(By.xpath("//button[@class = 'submit-button']"));
        submitAnother.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
