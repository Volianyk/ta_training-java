package com.epam.training.theory.pageobject_model.page.without_pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class W3SchoolsHomePageNoPF {

    private static final String HOMEPAGE_URL = "https://www.w3schools.com/";
    private final By searchInputLocator = By.xpath("//input[@id=\"tnb-google-search-input\" and @aria-label='Search field']");
    private final By searchButtonLocator = By.xpath("//*[@id=\"tnb-google-search-submit-btn\"]");
    private final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    private WebDriver driver;

    public W3SchoolsHomePageNoPF(WebDriver driver) {
        this.driver = driver;
    }

    public W3SchoolsHomePageNoPF openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        //    .until();
        return this;
    }

    public SearchResultsPageNoPF searchForTerms(String term) throws InterruptedException {
        WebElement searchInput = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(searchInputLocator));
        searchInput.sendKeys(term);

        WebElement searchButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(searchButtonLocator));
        searchButton.click();
        Thread.sleep(3000); // need to fix waits for new page
        return new SearchResultsPageNoPF(driver, term);
    }
}
