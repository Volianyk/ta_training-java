package com.epam.training.student_volodymyr_volianyk.webdriver.theory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driverChrome = new ChromeDriver();
        driverChrome.get("https://www.selenium.dev");
        Thread.sleep(2000);
        driverChrome.quit();

        WebDriver driverEdge = new EdgeDriver();
        driverEdge.get("https://www.selenium.dev");
        Thread.sleep(2000);
        driverEdge.quit();

        WebDriver driverFirefox = new FirefoxDriver();
        driverFirefox.get("https://www.selenium.dev");
        Thread.sleep(2000);
        driverFirefox.quit();
    }
}
