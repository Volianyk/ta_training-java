package com.epam.training.student_volodymyr_volianyk.final_task.test;

import com.epam.training.student_volodymyr_volianyk.final_task.driver.DriverSingleton;
import com.epam.training.student_volodymyr_volianyk.final_task.util.TestListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(TestListener.class)
public class CommonConditions {
    protected WebDriver driver;

    @BeforeEach
    public void browserSetup() {
        driver = DriverSingleton.getDriver();

    }

    @AfterEach
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
