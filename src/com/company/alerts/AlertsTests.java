package com.company.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests {
    WebDriver driver;

    @BeforeMethod
    public void initTests() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("file:///L:/%D0%9E%D0%B1%D1%83%D1%87%D0%B5%D0%BD%D0%B8%D0%B5/AlertsDemo.html");
        Thread.sleep(3000);
    }

    @Test
    public void simpleAlert() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(), 'Simple Alert')]")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        System.out.println("Simple alert text: " + alert.getText());
        alert.accept();
        Thread.sleep(3000);
    }

    @Test
    public void confirmBoxTest() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(), 'Confirm Box')]")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        System.out.println("Confirm Box: " + alert.getText());
        alert.accept();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[contains(text(), 'Confirm Box')]")).click();
        Thread.sleep(3000);
        alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
    }

    @Test
    public void promptTest() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(), 'Prompt box')]")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        System.out.println("Prompt box: " + alert.getText());
        alert.accept();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[contains(text(), 'Prompt box')]")).click();
        Thread.sleep(3000);
        alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[contains(text(), 'Prompt box')]")).click();
        Thread.sleep(3000);
        alert = driver.switchTo().alert();
        alert.sendKeys("Vasya Pupkin");
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
