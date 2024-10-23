package com.epam.training.theory.pageobject_model.page.with_abstract_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPagePFMixedWIthAbstractPO extends AbstractPage {
    private final String splitRegex = "\\s";
    private String searchTerm;

    private String defaultLocator = "//div[contains(@class,'gsc-result')%s]";
    private String containsPart = " and contains(., '%s')";

    @FindBy(xpath = "//div[contains(@class,'gsc-result')]")
    private List<WebElement> generalSearchResults;

    protected SearchResultsPagePFMixedWIthAbstractPO(WebDriver driver, String searchTerm) {
        super(driver);
        this.searchTerm = searchTerm;
    }

    public int countGeneralNumberOfSearchResults() {
        System.out.println("Search results number for requested term: "
                + generalSearchResults.size());
        return generalSearchResults.size();
    }

    public int countResultsNumberWithSearchTerm() {
        List<WebElement> resultsNumberWithSearchTerm = driver.findElements(By.xpath(buildLocatorForSearch()));
        System.out.println("Search results number for requested term: "
                + resultsNumberWithSearchTerm.size());
        return resultsNumberWithSearchTerm.size();
    }

    private String buildLocatorForSearch() {
        String partWithSearchTerm = "";
        String[] terms = searchTerm.split(splitRegex);

        for (String term : terms) {
            partWithSearchTerm += String.format(containsPart, term);
        }

        String locatorForSearch = String.format(defaultLocator, partWithSearchTerm);
        System.out.println("DEBUG: Final locator with search terms: "
                + locatorForSearch);

        return locatorForSearch;
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("don use it");
    }
}
