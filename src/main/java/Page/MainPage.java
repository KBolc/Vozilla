package Page;

import Help.WaitForElementHelp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends WaitForElementHelp{
    WebDriver driver;
    int time = 800;


    @FindBy(how = How.XPATH, using = ".//*[@class='logo-vozilla']")
    public WebElement logo;
    @FindBy(how = How.XPATH, using = ".//*[@class='login-wrapper custom-margin']")
    public WebElement buttonLogin;
    @FindBy(how = How.XPATH, using = ".//*[@class='register-wrapper']")
    public WebElement buttonRegister;
    @FindBy(how = How.XPATH, using = ".//*[@id='languageDropDownId']")
    public WebElement selectLanguage;
    @FindBy(how = How.XPATH, using = ".//*[@href='/contact']")
    public WebElement contact;
    @FindBy(how = How.XPATH, using = ".//*[@href='/help']")
    public WebElement help;
    @FindBy(how = How.XPATH, using = ".//*[@href='/map']")
    public WebElement map;
    @FindBy(how = How.XPATH, using = ".//*[@href='/payments']")
    public WebElement payments;
    @FindBy(how = How.XPATH, using = ".//*[@href='/']")
    public WebElement home;
    @FindBy(how = How.XPATH, using = ".//*[@class='small-hide register-wrapper custom-margin']")
    public WebElement yourAccount;



    public MainPage (WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openUrl(String url){
        driver.get(url);
        return this;
    }

    public MainPage clickRegister(){
        setWaitElementVisible(buttonLogin,driver);
        buttonRegister.click();
        return this;
    }

    public MainPage clickLogin(){
        setWaitElementVisible(buttonLogin,driver);
        setWaitVisible(driver, 500);
        buttonLogin.click();
        return this;
    }

    public MainPage clickContact(){
        setWaitElementVisible(contact,driver);
        contact.click();
        return this;
    }

    public MainPage clickHelp(){
        setWaitElementVisible(help,driver);
        help.click();
        return this;
    }

    public MainPage clickMap(){
        setWaitElementVisible(map,driver);
        map.click();
        return this;
    }

    public MainPage clickPayments(){
        setWaitElementVisible(payments,driver);
        payments.click();
        return this;
    }

    public MainPage clickHome(){
        setWaitElementVisible(home,driver);
        home.click();
        return this;
    }

    public MainPage selectLanguage(){
        setWaitElementVisible(selectLanguage,driver);
        selectLanguage.click();
        return this;
    }

    public String getTxtYourAccount(){
            String s = yourAccount.getText();
        return s;
    }


}
