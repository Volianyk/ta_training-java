package com.epam.training.theory.pageobject_model.page.with_abstract_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class W3SchoolsHomePagePFWithAbstractPO extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://www.w3schools.com/";

    @FindBy(xpath = "//input[@id=\"tnb-google-search-input\" and @aria-label='Search field']")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"tnb-google-search-submit-btn\"]")
    private WebElement searchButton;

    public W3SchoolsHomePagePFWithAbstractPO(WebDriver driver) {
        super(driver);
    }

    public W3SchoolsHomePagePFWithAbstractPO openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//*[@id=\"tnb-google-search-submit-btn\"]")));
        return this;
    }

    public SearchResultsPagePFMixedWIthAbstractPO searchForTerms(String term) throws InterruptedException {
        searchInput.sendKeys(term);
        searchButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"resInfo-0\"]")));
        return new SearchResultsPagePFMixedWIthAbstractPO(driver, term);
    }
}
