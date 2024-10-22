package com.epam.training.theory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LocatorsTheory {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/");
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"search2\"]"));
        searchInput.sendKeys("selenium java");
        By searchBtnSelector = By.xpath("//*[@id=\"learntocode_searchbtn\"]");
        WebElement searchBtn = driver.findElement(searchBtnSelector);
        searchBtn.click();
        Thread.sleep(3000); // need to see the result
        driver.quit();
    }
}