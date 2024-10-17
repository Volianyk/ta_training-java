package com.epam.training.student_volodymyr_volianyk.webdriver.theory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkWithXpath {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        searchInput.sendKeys("selenium java");
        By searchBtnSelector = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]");
        WebElement searchBtn = driver.findElement(searchBtnSelector);
        searchBtn.click();
        Thread.sleep(2000);
        driver.quit();

    }
}
