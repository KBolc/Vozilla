import Page.LoginPage;
import Page.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends MainTest {

    @Test
    public void loginCorrect() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.writeLogin("mirun11@wp.pl")
                .writePassord("Mario7654321")
                .clickLogin();
        String s = "Twoje konto";
        Assert.assertEquals(mainPage.getTxtYourAccount(), s);
    }

    @Test
    public void loginInCorrect() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.writeLogin("mirun11@wp.pl")
                .writePassord("Mario7654322")
                .clickLogin();
        String s = "Login lub hasło jest niepoprawne";
        Assert.assertEquals(loginPage.getErrorLogin(), s);
    }
}

