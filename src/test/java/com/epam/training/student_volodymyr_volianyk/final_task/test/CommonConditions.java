package com.epam.training.student_volodymyr_volianyk.final_task.test;

import com.epam.training.student_volodymyr_volianyk.final_task.driver.DriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CommonConditions {
    protected WebDriver driver;

    @BeforeEach
    public void browserSetup() {
       // driver = DriverSingleton.getDriver();
        driver=new EdgeDriver();
    }

    @AfterEach
    public void browserTearDown() {
        //DriverSingleton.closeDriver();
        driver.quit();
    }
}
