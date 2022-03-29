
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
public class Withdrawl extends PageObject {
    @FindBy(xpath = "//button[contains(text(), 'Withdrawl')]")
    WebElement withdrawl_button;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement enter_amount;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[4]/div/form/button")
    WebElement withdraw;


    public Withdrawl(WebDriver driver){
        super(driver);
    }
    public void withdrawlButton() throws InterruptedException{
        withdrawl_button.click();
        Thread.sleep(2000);
    }
    public void enterAmountToWithdraw() throws InterruptedException{
        enter_amount.click();
        enter_amount.sendKeys("5000");
        Thread.sleep(2000);
    }
    public void withdraw() {
        withdraw.click();
    }
    public void screenShot() throws IOException, InterruptedException {
        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File("C:\\Users\\himanshukumar7\\IdeaProjects\\withdrawlFail.jpg"));
        Thread.sleep(2000);
    }
}
