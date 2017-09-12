package TestFacebookHome;

import base.commonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page.FacebookHome;

/**
 * Created by Kahina on 9/12/2017.
 */
public class TestCreateAccount extends commonAPI {

    @Test
    public void testCreateAccount(){
        FacebookHome facebookHome = PageFactory.initElements(driver, FacebookHome.class);
        facebookHome.createAccount("hdbhdbvdj","hfhgfdjfh","gdvdhv@gmail.com","gdhgsdh");
    }
}
