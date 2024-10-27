package com.epam.training.student_volodymyr_volianyk.web_driver.practice3.page;

import com.epam.training.student_volodymyr_volianyk.web_driver.practice1.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CloudGoogleCalculatorPage extends AbstractPage {
    private static Logger log = LoggerFactory.getLogger(CloudGoogleCalculatorPage.class);

    private static final String HOMEPAGE_URL = "https://cloud.google.com/products/calculator/";

    public CloudGoogleCalculatorPage(WebDriver driver) {
        super(driver);
    }


    public CloudGoogleCalculatorPage openPage() {
        driver.get(HOMEPAGE_URL);
        log.info("Open page: " + HOMEPAGE_URL);
        return this;
    }
}
