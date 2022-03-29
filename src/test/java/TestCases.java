import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
//@Listeners(TestExtent.class);
@Listeners(TestExtent.class)
public class TestCases {
    //ChromeDriverManager.getInstance().setup();
    private static final WebDriver driver = new ChromeDriver();
    static Logger log = Logger.getLogger(String.valueOf(TestCases.class));
     //ChromeDriverManager.getInstance().setup();

    @BeforeSuite
    public static void main(String[] args){
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver",Utils.CHROME_DRIVER_LOCATION);
        PropertyConfigurator.configure("C:\\Users\\himanshukumar7\\IdeaProjects\\Main_Assignment_Maven\\log4j.properties");
    }


    @Test(priority = 1)
    public static void addCustomer() throws InterruptedException, IOException {
        driver.get(Utils.BASE_URL);
        AddCustomer ac = new AddCustomer(driver);
        ac.pressCustomerLoginButton();
        log.info("customer login button pressed");
        ac.pressAddCustomerButton();
        ArrayList<String> a = ac.ReadBankUserData();
        ac.enterFirstName(a.get(0));
        ac.enterLastName(a.get(1));
        ac.enterPostalCode(a.get(2));
        ac.addCustomerButton();
        //ac.screenShot();
        ac.customerAddedAlert();
        //ac.screenShot();
    }
    @Test(priority = 2)
    public static void openAccount() throws InterruptedException, IOException {
        OpenAccount oa = new OpenAccount(driver);
        oa.pressOpenAccountButton();
        oa.userSelect();
        oa.customerNameSelect();
        oa.whiteSpace();
        oa.currencySelection();
        oa.currencySelect();
        oa.proceedButton();
        //oa.screenShot();
        oa.accountOpenedAlert();
        oa.homeButton();
        //oa.screenShot();
    }

    @Test(priority = 3)
    public static void makeDeposit() throws InterruptedException, IOException {
        MakeDeposit md = new MakeDeposit(driver);
        md.customerLoginButton();
        md.yourNameDropdown();
        md.customerNameSelect();
        md.whiteSpaceSelect();
        md.loginButton();
        md.depositButton();
        md.enterAmount();
        md.deposit();
        md.screenShot();
    }

    @Test(priority = 4)
    public static void withdrawMoney() throws InterruptedException, IOException {
        Withdrawl wm = new Withdrawl(driver);
        wm.withdrawlButton();
        wm.enterAmountToWithdraw();
        wm.withdraw();
        wm.enterAmountToWithdraw();
        wm.withdraw();
        wm.screenShot();
    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
