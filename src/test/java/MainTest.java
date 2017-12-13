import Help.WaitForElementHelp;
import Page.MainPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

/**
     * Created by kamil on 11.04.17.
     */
    public class MainTest extends WaitForElementHelp{
        WebDriver driver;

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/lib/geckodriver.exe");
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/lib/chromedriver.exe");
            driver = new ChromeDriver();
            MainPage loginPage = new MainPage(driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            loginPage.openUrl("https://vozilla.pl/");
            waitForLoad(driver);
        }

    }



