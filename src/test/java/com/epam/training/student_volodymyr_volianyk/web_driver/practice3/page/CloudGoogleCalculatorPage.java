package com.epam.training.student_volodymyr_volianyk.web_driver.practice3.page;

import com.epam.training.student_volodymyr_volianyk.web_driver.practice1.page.AbstractPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class CloudGoogleCalculatorPage extends AbstractPage {
    // private static Logger log = LoggerFactory.getLogger(CloudGoogleCalculatorPage.class);

    private static final String HOMEPAGE_URL = "https://cloud.google.com/products/calculator/";

    @FindBy(xpath = "//span[text()='Add to estimate' and @class='UywwFc-vQzf8d']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//*[@class='honxjf' and text()='Compute Engine']")
    private WebElement computeEngineSelect;

    public CloudGoogleCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleCalculatorPage openPage() {
        driver.get(HOMEPAGE_URL);
        log.info("Open page: " + HOMEPAGE_URL);
        return this;
    }

    public ComputeEnginePage clickAddToEstimate() {
        addToEstimateButton.click();
        //waitForVisibility(computeEngineSelect).click();
        log.info("click Add to estimate button");
        return new ComputeEnginePage(driver);
    }
}
