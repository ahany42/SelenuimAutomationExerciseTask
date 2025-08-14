import org.testng.annotations.*;

public class SignUpTestCase extends BaseTest{
    SignUpPage signUpPage;
    @BeforeClass
    public void setUpPage() {
        signUpPage = new SignUpPage(driver,logger);
    }
    @Test
        public void SignUpScreenOneHappyPath(){
        logger.info("About to Start Sign Up Screen 1 Happy Path");
        signUpPage.SignUpScreen1();
    }
    @Test
        public void SignUpScreenTwoHappyPath(){
        logger.info("About to Start Sign Up Screen 2 Happy Path");
        signUpPage.SignUpScreen2();
    }
}
