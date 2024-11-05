package com.epam.training.student_volodymyr_volianyk.final_task.steps;

import com.epam.training.student_volodymyr_volianyk.final_task.driver.DriverSingleton;
import io.cucumber.java.After;

public class AfterSteps {
    @After
    public void closeDriver() {
        DriverSingleton.closeDriver();

    }
//    @AfterStep
//    public void makeScreenshot(){
//        TakesScreenshot screenshot = (TakesScreenshot) driver;
//        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
//        File destFile = new File("screenshot.png");
//    }
}
