package com.epam.training.student_volodymyr_volianyk.web_driver.practice3.page;

import com.epam.training.student_volodymyr_volianyk.web_driver.practice1.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CostEstimateSummaryPage extends AbstractPage {

    protected CostEstimateSummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
