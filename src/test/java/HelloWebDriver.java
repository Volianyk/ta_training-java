import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev");
        Thread.sleep(2000);
        driver.quit();

        driver = new EdgeDriver();
        driver.get("https://www.selenium.dev");
        Thread.sleep(2000);
        driver.quit();

        driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev");
        Thread.sleep(2000);
        driver.quit();
    }
}
