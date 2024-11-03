package com.epam.training.student_volodymyr_volianyk.final_task.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class TestListener implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        //saveScreenshot(context);
    }

    private void saveScreenshot(ExtensionContext context) {
        // Obtain the WebDriver instance
        WebDriver driver = context.getStore(ExtensionContext.Namespace.GLOBAL).get("driver", WebDriver.class); // Ensure this method returns the current WebDriver instance

        if (driver instanceof TakesScreenshot) {
            File screenCapture = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path targetDirectory = Path.of("target/screenshots");

            try {
                // Ensure the screenshots directory exists
                Files.createDirectories(targetDirectory);

                // Save the screenshot with a timestamp
                FileUtils.copyFile(screenCapture, new File(targetDirectory.toString() + "/" + getCurrentTimeAsString() + ".png"));
                log.info("Screenshot saved at: {}/{}.png", targetDirectory, getCurrentTimeAsString());
            } catch (IOException e) {
                log.error("Failed to save screenshot: {}", e.getLocalizedMessage());
            }
        } else {
            log.warn("Driver does not support taking screenshots.");
        }
    }
//    private void saveScreenshot() {
//
//        File screenCapture = ((TakesScreenshot) DriverFactory
//                .createDriver(System.getProperty("browser", "edge")))
//                .getScreenshotAs(OutputType.FILE);
//
//        try {
//            FileUtils.copyFile(screenCapture, new File(
//                    ".//target/screenshots/"
//                            + getCurrentTimeAsString() +
//                            ".png"));
//        } catch (IOException e) {
//            log.error("Failed to save screenshot:{}", e.getLocalizedMessage());
//        }
//    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }

}
