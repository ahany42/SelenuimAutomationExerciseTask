import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class SignUpPage {
    private WebDriver driver;
    private String name;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String country;
    private String city;
    private String state;
    private String mobile;
    private String zipcode;
    private String day;
    private String month;
    private String year;
    private String gender;
    public Logger logger;
    SoftAssert softAssert = new SoftAssert();
    public SignUpPage(WebDriver driver,Logger logger){
        this.driver = driver;
        this.name = ConfigReader.get("name");
        this.email = ConfigReader.get("email");
        this.password = ConfigReader.get("password");
        this.firstName = ConfigReader.get("firstName");
        this.lastName = ConfigReader.get("lastName");
        this.company = ConfigReader.get("company");
        this.address1 = ConfigReader.get("address1");
        this.address2 = ConfigReader.get("address2");
        this.country = ConfigReader.get("country");
        this.city = ConfigReader.get("city");
        this.state = ConfigReader.get("state");
        this.mobile = ConfigReader.get("mobile");
        this.zipcode = ConfigReader.get("zipcode");
        this.day = ConfigReader.get("day");
        this.month = ConfigReader.get("month");
        this.year = ConfigReader.get("year");
        this.gender = ConfigReader.get("gender");
        this.logger = logger;
    }
    public void SignUpScreen1(){
        logger.info("Sign Up Screen 1");
        try{
            driver.findElement(By.name("name")).sendKeys(name);
            driver.findElement(By.cssSelector("[data-qa='signup-email']")).sendKeys(email);
            driver.findElement(By.cssSelector("[data-qa='signup-button']")).click();

        }
        catch (Exception e) {
            softAssert.fail("Sign Up Screen One Failed " + e.getMessage());
            logger.warn("Signup screen 1 failed {}" ,e.getMessage());

        }
    }
    public void SignUpScreen2(){
    try{
        if(gender.equals("Male")){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement genderRadio = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
        genderRadio.click();
        logger.info("Gender is Male");

        }
        else{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement genderRadio = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender2")));
            genderRadio.click();
            logger.info("Gender is Female");

        }

        driver.findElement(By.name("password")).sendKeys(password);
        WebElement dayDropdown = driver.findElement(By.id("days"));
        Select selectDay = new Select(dayDropdown);
        selectDay.selectByVisibleText(day);

        WebElement monthDropdown = driver.findElement(By.id("months"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText(month);

        WebElement yearsDropdown = driver.findElement(By.id("years"));
        Select selectYear = new Select(yearsDropdown);
        selectYear.selectByVisibleText(year);

        driver.findElement(By.id("first_name")).sendKeys(firstName);
        driver.findElement(By.id("last_name")).sendKeys(lastName);
        driver.findElement(By.id("company")).sendKeys(company);
        driver.findElement(By.id("address1")).sendKeys(address1);
        driver.findElement(By.id("address2")).sendKeys(address2);
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("state")).sendKeys(state);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("zipcode")).sendKeys(zipcode);
        driver.findElement(By.id("mobile_number")).sendKeys(mobile);
        driver.findElement(By.cssSelector("[data-qa='create-account']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement accountCreatedMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("h2[data-qa='account-created']")
                )
        );
        if (accountCreatedMessage.isDisplayed()) {
            logger.info("✅ Account Created message is visible");
        } else {
            System.out.println("❌ Account Created message is NOT visible");
        }

    }
    catch(Exception e){
        softAssert.fail("Sign Up Screen One Failed " + e.getMessage());
        logger.info("Sign Up Screen 2 Failed {}",e.getMessage());

    }
    }
}
