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

    @FindBy(how= How.XPATH,using = ".//*[@id='email']")
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
    @FindBy(how = How.XPATH,using = ".//*[@id='u_0_f']")
    public static WebElement FNameBox;
    @FindBy(how = How.XPATH,using = ".//*[@id='u_0_h']")
    public static WebElement LNameBox;
    @FindBy(how = How.XPATH,using = ".//*[@id='u_0_k']")
    public static WebElement emailPhoneBox;
    @FindBy(how = How.XPATH,using = ".//*[@id='u_0_n']")
    public static WebElement confirmEmail;
    @FindBy(how = How.XPATH,using = ".//*[@id='u_0_r']")
    public static WebElement passBox;
    @FindBy(how = How.XPATH,using = ".//*[@id='month']")
    public static WebElement monthOfBirth;
    @FindBy(how = How.XPATH,using = ".//*[@id='day']")
    public static WebElement dayOfBirth;
    @FindBy(how = How.XPATH,using = ".//*[@id='year']")
    public static WebElement yearOfBirth;
    @FindBy(how = How.XPATH,using = ".//*[@id='u_0_6']")
    public static WebElement femaleCheckBtn;
    @FindBy(how = How.XPATH,using = " .//*[@id='u_0_x']")
    public static WebElement createAccountBtn;

    public void createAccount(String firstName, String lastName, String email, String password){
        FNameBox.sendKeys(firstName);
        LNameBox.sendKeys(lastName);
        emailPhoneBox.sendKeys(email);
        confirmEmail.sendKeys(email);
        passBox.sendKeys(password);
        Select selectMonth = new Select(monthOfBirth);
        selectMonth.selectByVisibleText("Oct");
        Select selectDay = new Select(dayOfBirth);
        selectMonth.selectByVisibleText("10");
        Select selectYear = new Select(yearOfBirth);
        selectMonth.selectByVisibleText("1970");
        femaleCheckBtn.click();
        createAccountBtn.click();
    }
}
