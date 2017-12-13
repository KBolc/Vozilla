package Page;

import Help.WaitForElementHelp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends WaitForElementHelp{
    WebDriver driver;
    int time = 800;

    @FindBy(how = How.XPATH, using = ".//*[@name='username']")
    public WebElement login;
    @FindBy(how = How.XPATH, using = ".//*[@name='password']")
    public WebElement passwordIN;
    @FindBy(how = How.XPATH, using = ".//*[@class='btn btn-default']")
    public WebElement buttonLogIn;
    @FindBy(how = How.XPATH, using = ".//*[@class='form-control btn-default-empty center']")
    public WebElement register;
    @FindBy(how = How.XPATH, using = ".//*[@href='/account/forgot-password']")
    public WebElement buttonForgotPassword;
    @FindBy(how = How.XPATH, using = ".//*[@class='toast-message']")
    public WebElement error;


    public LoginPage (WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage openUrl(String url){
        driver.get(url);
        return this;
    }

    public LoginPage writeLogin(String email){
        setWaitElementVisible(login,driver);
        login.sendKeys(email);
        return this;
    }

    public LoginPage writePassord(String password){
        setWaitElementVisible(login,driver);
        passwordIN.sendKeys(password);
        return this;
    }

    public LoginPage clickLogin(){
        setWaitElementVisible(buttonLogIn,driver);
        buttonLogIn.click();
            return this;
    }

    public LoginPage clickForgotPassword(){
        setWaitElementVisible(buttonForgotPassword,driver);
        buttonForgotPassword.click();
        return this;
    }

    public LoginPage clickRegister(){
        setWaitElementVisible(register,driver);
        register.click();
        return this;
    }

    public String getErrorLogin(){
        String s = error.getText();
        return s;
    }
}
