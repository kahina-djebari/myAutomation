package page;

import base.commonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Kahina on 9/12/2017.
 */
public class FacebookHome extends commonAPI {

    @FindBy(how = How.XPATH,using = ".//*[@id='email']")
    public static WebElement emailBox;
    @FindBy(how = How.XPATH,using = ".//*[@id='pass']")
    public static WebElement passwordBox;
    @FindBy(how = How.XPATH,using = ".//*[@id='u_0_2']")
    public static WebElement loginBtn;

    public void login(String email, String password){
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        loginBtn.click();
    }

    @FindBy(how = How.NAME,using = "firstname")
    public static WebElement firstname;
    @FindBy(how = How.NAME,using = "lastname")
    public static WebElement lastname;
    @FindBy(how = How.NAME,using = "reg_email__")
    public static WebElement emailOrPhone;
    @FindBy(how = How.NAME,using = "reg_email_confirmation__")
    public static WebElement confirmEmail;
    @FindBy(how = How.NAME,using = "reg_passwd__")
    public static WebElement password;
    @FindBy(how = How.ID,using = "month")
    public static WebElement monthOfBirth;
    @FindBy(how = How.ID,using = "day")
    public static WebElement dayOfBirth;
    @FindBy(how = How.ID,using = "year")
    public static WebElement yearOfBirth;
    @FindBy(how = How.XPATH,using = ".//*[@id='u_0_6']")
    public static WebElement femaleCheckbox;
    @FindBy(how = How.NAME,using = "websubmit")
    public static WebElement createAccountBtn;

    public void createAccount(String FName, String LName, String email, String passwrd){
        firstname.sendKeys(FName);
        lastname.sendKeys(LName);
        emailOrPhone.sendKeys(email);
        confirmEmail.sendKeys(email);
        password.sendKeys(passwrd);
        Select selectMonth = new Select(monthOfBirth);
        selectMonth.selectByVisibleText("Oct");
        Select selectDay = new Select(dayOfBirth);
        selectDay.selectByVisibleText("10");
        Select selectYear = new Select(yearOfBirth);
        selectYear.selectByVisibleText("1970");
        femaleCheckbox.click();
        createAccountBtn.click();
    }
}
