package com.epam.training.student_volodymyr_volianyk.web_driver.practice3.page;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComputeEnginePage {
    private static final Logger log = LoggerFactory.getLogger(ComputeEnginePage.class);
    private WebDriver driver;

    public ComputeEnginePage(WebDriver driver) {
        this.driver = driver;
    }
}
