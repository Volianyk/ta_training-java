package com.epam.training.theory.pageobject_model.page.without_abstract_page;

import com.epam.training.theory.CustomConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class W3SchoolsHomePagePF {
    private static final String HOMEPAGE_URL = "https://www.w3schools.com/";
    private WebDriver driver;

    @FindBy(id = "q") //*[@id="tnb-google-search-input"]
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"tnb-google-search-submit-btn\"]")
    private WebElement searchButton;

    public W3SchoolsHomePagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public W3SchoolsHomePagePF openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public SearchResultsPagePFMixed searchForTerms (String term) {
        searchInput.sendKeys(term);
        searchButton.click();
        return new SearchResultsPagePFMixed(driver, term);
    }
}
