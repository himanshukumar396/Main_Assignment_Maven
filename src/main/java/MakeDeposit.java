import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;

public class MakeDeposit extends PageObject {
    @FindBy(xpath = "//button[contains(text(), 'Customer Login')]")
    WebElement customer_login_button;

    @FindBy(id = "userSelect")
    WebElement your_name_dropdown;

    @FindBy(xpath = "//option[contains(text(), 'Himanshu Kumar')]")
    WebElement customer_name;

    @FindBy(xpath = "/html/body/div/div/div[2]/div")
    WebElement white_space;

    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    WebElement login_button;

    @FindBy(xpath = "//button[contains(text(), 'Deposit')]")
    WebElement deposit_button;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement enter_amount;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[4]/div/form/button")
    WebElement deposit;

    public MakeDeposit(WebDriver driver){
        super(driver);
    }
    public void customerLoginButton() throws InterruptedException {
        customer_login_button.click();
        Thread.sleep(2000);
    }
    public void yourNameDropdown() throws InterruptedException {
        your_name_dropdown.click();
        Thread.sleep(2000);
    }
    public void customerNameSelect() throws InterruptedException{
        customer_name.click();
        Thread.sleep(2000);
    }
    public void whiteSpaceSelect() {
        white_space.click();
    }
    public void loginButton() throws InterruptedException {
        login_button.click();
        Thread.sleep(2000);
    }
    public void depositButton() throws InterruptedException{
        deposit_button.click();
        Thread.sleep(3000);
    }
    public void enterAmount() throws InterruptedException{
        enter_amount.click();
        enter_amount.sendKeys("5000");
        Thread.sleep(2000);
    }
    public void deposit() {
        deposit.click();
    }
    public void screenShot() throws IOException, InterruptedException {
        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File("C:\\Users\\himanshukumar7\\IdeaProjects\\deposit_made.jpg"));
        Thread.sleep(2000);
    }
}
