package com.epam.training.student_volodymyr_volianyk.web_driver.practice3.page;

import com.epam.training.student_volodymyr_volianyk.web_driver.practice1.page.AbstractPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class ComputeEnginePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/products/calculator/";

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    public ComputeEnginePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


}
