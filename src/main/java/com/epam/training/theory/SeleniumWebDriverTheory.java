package com.epam.training.theory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumWebDriverTheory {
    public static void main(String[] args) throws InterruptedException {

         searchExpression(WebDriverType.CHROME.getDriver()); // use line 19 to lunch Chrome
       // searchExpression(WebDriverType.EDGE.getDriver());
        //searchExpression(WebDriverType.FIREFOX.getDriver());
    }

    public static void searchExpression(WebDriver driver) throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        searchInput.sendKeys("selenium java");
         By searchBtnSelector = By.xpath("//input[@name='btnK' and @type='submit']"); //works with Chrome
        //By searchBtnSelector = By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@value='Пошук Google']"); //works with Firefox and Edge
        WebElement searchBtn = driver.findElement(searchBtnSelector);
        searchBtn.click();
        Thread.sleep(2000);
        driver.quit();
    }
}
