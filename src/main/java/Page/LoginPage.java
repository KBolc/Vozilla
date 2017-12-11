package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
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
        try {
            Thread.sleep(time);
            login.sendKeys(email);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public LoginPage writePassord(String password){
        try {
            Thread.sleep(time);
            passwordIN.sendKeys(password);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public LoginPage clickLogin(){
            try {
                Thread.sleep(time);
                buttonLogIn.click();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            return this;
    }

    public LoginPage clickForgotPassword(){
        try {
            Thread.sleep(time);
            buttonForgotPassword.click();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public LoginPage clickRegister(){
        try {
            Thread.sleep(time);
            register.click();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getErrorLogin(){
        String s = error.getText();
        return s;
    }
}
