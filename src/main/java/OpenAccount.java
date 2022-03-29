//import com.thoughtworks.qdox.model.expression.Add;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;

public class OpenAccount extends AddCustomer {
    @FindBy(xpath = "//button[contains(text(), 'Open Account')]")
    WebElement Open_Account_Button;

    @FindBy(xpath = "//*[@id=\"userSelect\"]")
    WebElement UserSelect;

    @FindBy(xpath = "//option[contains(text(), 'Himanshu Kumar')]")
    WebElement customerName;

    @FindBy(id = "currency")
    WebElement Currency;

    @FindBy(xpath = "//option[contains(text(), 'Dollar')]")
    WebElement CurrencySelect;

    @FindBy(xpath = "//button[contains(text(), 'Process')]")
    WebElement proceed;

    @FindBy(xpath = "/html/body/div/div/div[2]/div")
    WebElement whiteSpace;

    @FindBy(xpath = "//button[contains(text(), 'Home')]")
    WebElement homeButton;

    public OpenAccount(WebDriver driver) {
        super(driver);
    }

    public void pressOpenAccountButton() throws InterruptedException {
        Open_Account_Button.click();
        Thread.sleep(3000);
    }

    public void userSelect() throws InterruptedException {
        UserSelect.click();
        Thread.sleep(3000);
    }

    public void customerNameSelect() throws InterruptedException {
        customerName.click();
        //customerName.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    public void currencySelection() throws InterruptedException {
        Currency.click();
        Thread.sleep(3000);
    }

    public void currencySelect() throws InterruptedException {
        Thread.sleep(3000);
        CurrencySelect.click();
    }

    public void proceedButton() throws InterruptedException {
        proceed.click();
        Thread.sleep(3000);
    }

    public void whiteSpace() {
        whiteSpace.click();
    }

    public void accountOpenedAlert() throws InterruptedException {
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    public void homeButton() {
        homeButton.click();
    }

    public void screenShot() throws IOException, InterruptedException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("C:\\Users\\himanshukumar7\\IdeaProjects\\openaccount.jpg"));
        Thread.sleep(2000);
    }
}
