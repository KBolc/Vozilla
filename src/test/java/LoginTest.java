import Page.LoginPage;
import Page.MainPage;
import com.gurock.testrail.APIException;
import com.gurock.testrail.Listener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;


    @Listeners(com.gurock.testrail.Listener.class)
    public class LoginTest extends MainTest {
        private static final int runId = 12;

        @Test
        @Listener.UseAsTestRailId(testCaseId = 204, testRailId = LoginTest.runId)
        public void loginCorrect() throws IOException, APIException {
            MainPage mainPage = new MainPage(driver);
            mainPage.clickLogin();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.writeLogin("mirun11@wp.pl")
                    .writePassord("Mario12345")
                    .clickLogin();
            String s = "Twoje konto";
            Assert.assertEquals(mainPage.getTxtYourAccount(), s);
        }

        @Test
        @Listener.UseAsTestRailId(testCaseId = 206, testRailId = LoginTest.runId)
        public void loginInCorrect() throws IOException, APIException {
            MainPage mainPage = new MainPage(driver);
            mainPage.clickLogin();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.writeLogin("mirun11@wp.pl")
                    .writePassord("Mario7654322")
                    .clickLogin();
            String s = "Logisn lub hasło jest niepoprawne";
            Assert.assertEquals(loginPage.getErrorLogin(), s);

        }

    }

