package com.epam.training.theory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum WebDriverType {
    CHROME {
        @Override
        public WebDriver getDriver() {
            return new ChromeDriver();
        }
    },
    FIREFOX {
        @Override
        public WebDriver getDriver() {
            return new FirefoxDriver();
        }
    },
    EDGE {
        @Override
        public WebDriver getDriver() {
            return new EdgeDriver();
        }

        ;

    };

    public abstract WebDriver getDriver();
}
