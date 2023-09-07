package praktikum;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;
import java.time.Duration;

public class DriverRule extends ExternalResource {
    WebDriver driver;
    @Override

    protected void before() throws Throwable {

        if ("firefox".equals(System.getProperty("browser")))
            setUpFireFox();
        else
            setUpChrome();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    private void setUpChrome() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/opt/homebrew/bin/chromedriver"))
                .build();
        driver = new ChromeDriver(service);
    }

    public void setUpFireFox(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        var service = new GeckoDriverService.Builder()
                .usingDriverExecutable(new File("opt/homebrew/bin/geckodriver"))
                .build();
        var options = new FirefoxOptions().setBinary("erazgulina/Program Files/Firefox/firefox");
        driver = new FirefoxDriver(service, options);
    }

    @Override
    protected void after(){
        driver.quit();
    }
    public WebDriver getDriver() {
        return driver;
    }
}
