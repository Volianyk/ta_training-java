package com.epam.training.theory.pageobject_model.page.with_abstract_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        //  .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public SearchResultsPagePFMixedWIthAbstractPO searchForTerms(String term) throws InterruptedException {
        searchInput.sendKeys(term);
        searchButton.click();
        Thread.sleep(3000);
        return new SearchResultsPagePFMixedWIthAbstractPO(driver, term);
    }
}
