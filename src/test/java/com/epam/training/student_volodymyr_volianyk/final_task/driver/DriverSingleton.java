package com.epam.training.student_volodymyr_volianyk.final_task.driver;

import org.openqa.selenium.WebDriver;

public class DriverSingleton {

    private static WebDriver driver;


    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser", "edge");
            driver = DriverFactory.createDriver(browser);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
    }
    }
}
