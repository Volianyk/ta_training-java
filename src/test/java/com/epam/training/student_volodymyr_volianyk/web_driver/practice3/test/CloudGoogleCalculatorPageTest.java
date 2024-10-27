package com.epam.training.student_volodymyr_volianyk.web_driver.practice3.test;

import com.epam.training.student_volodymyr_volianyk.web_driver.practice3.page.CloudGoogleCalculatorPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloudGoogleCalculatorPageTest {
    private WebDriver driver;

    @BeforeEach
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void enteredWalueTest() throws InterruptedException {
        CloudGoogleCalculatorPage calculatorPage = new CloudGoogleCalculatorPage(driver);
        calculatorPage.openPage()
                .clickAddToEstimate();
    }

    @AfterEach
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
