package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kahina on 9/12/2017.
 */
public class commonAPI {

    public static WebDriver driver = null;
    private String saucelabs_username = "ninadjebari";
    private String browserstack_username = "kdjebari1";
    private String saucelabs_accesskey = "c020bb68-ab4f-40e8-a95d-5bdd9d945cbf";
    private String browserstack_accesskey = "Hfq87qUG7MHf8wakph7G";
    @Parameters({"useCloudEnv","cloudEnvName","os","os_version","browserName","browserVersion","url"})
    @BeforeMethod
    public void setUp(boolean useCloudEnv, String cloudEnvName, String os, String os_version,
                      String browseName, String browserVersion, String url) throws IOException{
        if(useCloudEnv == true){
            if(cloudEnvName.equalsIgnoreCase("saucelabs")){
                getCloudDriver(cloudEnvName,saucelabs_username,saucelabs_accesskey,os,os_version,browseName,browserVersion);
            }else if(cloudEnvName.equalsIgnoreCase("browserstack")){
                getCloudDriver(cloudEnvName,browserstack_accesskey,browserstack_username,os,os_version,browseName,browserVersion);
            }
        }else{
            getLocalDriver(browseName, os);
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    public WebDriver getLocalDriver(String browserName, String os) {
        if (browserName.equalsIgnoreCase("chrome")) {
            if(os.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.chrome.driver","C:\\Users\\Kahina\\IdeaProjects\\myAutomation\\generic\\driver\\chromedriver");
            }else if(os.equalsIgnoreCase("windows")){
                System.setProperty("sebdriver.chrome.driver","C:\\Users\\Kahina\\IdeaProjects\\myAutomation\\generic\\driver\\chromedriver.exe" );
            }
            driver = new ChromeDriver();

        }else if(browserName.equalsIgnoreCase("firefox")){
            if(os.equalsIgnoreCase("OS X")){
                System.setProperty("webdriver.gecko.driver","C:\\Users\\Kahina\\IdeaProjects\\myAutomation\\generic\\driver\\geckodriver");
            }else if(os.equalsIgnoreCase("windows")){
                System.setProperty("webdriver.gecko.driver","C:\\Users\\Kahina\\IdeaProjects\\myAutomation\\generic\\driver\\geckodriver.exe");
            }
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public WebDriver getCloudDriver(String envName,String username, String accessKey,String os, String os_version,String browserName,
                                    String browserVersion) throws IOException{
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browserName", browserName);
        cap.setCapability("browserVersion", browserVersion);
        cap.setCapability("os",os);
        cap.setCapability("os_version", os_version);

        if (envName.equalsIgnoreCase("saucelabs")){
            driver = new RemoteWebDriver(new URL("http://" + username + ":" + accessKey +
                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
        }else if(envName.equalsIgnoreCase("browserstack")){
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + username + ":" + accessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), cap);
        }

        return driver;
    }
    @AfterMethod
    public void cleanUp(){
        driver.close();
    }
}
