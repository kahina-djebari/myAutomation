package TestFacebookHome;

import base.commonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page.FacebookHome;

/**
 * Created by Kahina on 9/12/2017.
 */
public class TestLogin extends commonAPI {

    @Test
    public void testLogin(){
        FacebookHome facebookHome = PageFactory.initElements(driver, FacebookHome.class);
        facebookHome.login("hfhdh@gmail.com","hdhbdschb");
    }
}
