package com.epam.training.theory.pageobject_model.test;

import com.epam.training.theory.pageobject_model.page.without_pagefactory.W3SchoolsHomePageNoPF;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverW3SchoolsTestNoPF {
    private WebDriver driver;

    @BeforeEach
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void commonSearchTermResultsAreNotEmpty() throws InterruptedException {
        int expectedSearchResultNumber = new W3SchoolsHomePageNoPF(driver)
                .openPage()
                .searchForTerms("selenium java")
                .countResultsNumberWithSearchTerm();

        Assertions.assertTrue(expectedSearchResultNumber > 0, "search result");
    }

    @AfterEach
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
