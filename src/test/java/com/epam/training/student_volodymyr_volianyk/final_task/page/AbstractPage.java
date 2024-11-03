package com.epam.training.student_volodymyr_volianyk.final_task.page;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected abstract AbstractPage openPage();

    protected final Duration WAIT_TIMEOUT_DURATION = Duration.ofSeconds(10);

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
