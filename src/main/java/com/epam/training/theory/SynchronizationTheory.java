package com.epam.training.theory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SynchronizationTheory {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        //implicitly wait avoid usage them!!!
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
//        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.google.com");
        WebElement searchInput = waitForElementLocatedBy(driver, By.xpath("//*[@id=\"APjFqb\"]"));
        searchInput.sendKeys("selenium java");
        By searchBtnSelector = By.xpath("//input[@name='btnK' and @type='submit']");
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy
                        (By.xpath("//input[@name='btnK' and @type='submit']"))); //explicitly wait
        WebElement searchBtn = driver.findElement(searchBtnSelector);
        searchBtn.click();
        driver.quit();
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
