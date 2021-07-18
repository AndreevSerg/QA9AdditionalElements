package com.company.windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsHandling {
    WebDriver driver;

    @BeforeMethod
    public void initTests() throws InterruptedException {
        driver= new ChromeDriver();
        driver.get("https://www.w3schools.com/");
        Thread.sleep(4000);
    }
    @Test
    public void windowsHandlingTest() throws InterruptedException {
        // ------print first window handle (code)---
        String firstWindowHandle = driver.getWindowHandle();
        System.out.println("First window (active) handle: " + firstWindowHandle);
        //-----Open second window by 'Try it Yourself' button ----
        driver.findElement(By.xpath("//*[contains(text(),'Try it Yourself')]")).click();
        Thread.sleep(5000);
        System.out.println("Active window handle: " + driver.getWindowHandle());

        //System.out.println("Run button name: " + driver.findElement(By.xpath("//*[contains(text(),'Run »')]")).getText());

        System.out.println("Header text: " + driver.findElement(By.tagName("h1")).getText());

        String secondWindowHandle = "";
        for(String handle: driver.getWindowHandles()){
            System.out.println("Handle: " + handle);
            if(!handle.equals(firstWindowHandle)) secondWindowHandle = handle;
        }
        driver.switchTo().window(secondWindowHandle);
        System.out.println("Active window handle: " + driver.getWindowHandle());
        System.out.println("Run button name: " + driver.findElement(By.xpath("//*[contains(text(),'Run »')]")).getText());
        //----Window closing----
        driver.close();
        Thread.sleep(3000);
        driver.switchTo().window(firstWindowHandle);
        System.out.println("Active window handle: " + driver.getWindowHandle());

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
