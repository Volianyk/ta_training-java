package com.epam.training.student_volodymyr_volianyk.web_driver.practice1.test;

import com.epam.training.student_volodymyr_volianyk.web_driver.practice1.page.PastebinPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PastebinTest {
    private WebDriver driver;

    @BeforeEach
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void enteredWalueTest() throws InterruptedException {
        PastebinPage pastebinPage = new PastebinPage(driver);
        pastebinPage.openPage();
        pastebinPage.enterPasteCode("Hello from WebDriver");
        pastebinPage.selectPasteExpiration("10 Minutes"); //have issue here
        pastebinPage.enterPasteName("helloweb");
        pastebinPage.createNewPaste();

        assertNotNull(pastebinPage);
    }

    @AfterEach
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }

}
