import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
public class AddCustomer extends PageObject {
    @FindBy(xpath = "//button[contains(text(), 'Bank Manager Login')]")
    WebElement customer_login_button;

    @FindBy(xpath = "//button[contains(text(), 'Add Customer')]")
    WebElement add_customer_button;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement first_name;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement last_name;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement post_code;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement submit_button;

    public AddCustomer(WebDriver driver){
        super(driver);
    }
    public ArrayList<String> ReadBankUserData() throws IOException {
        File file = new File("C:\\Users\\himanshukumar7\\Documents\\bankUserData.xls");
        FileInputStream inputStream = new FileInputStream(file);
        HSSFWorkbook wb=new HSSFWorkbook(inputStream);
        HSSFSheet sheet=wb.getSheet("Sheet1");
        HSSFRow row1=sheet.getRow(1);
        HSSFCell cell1=row1.getCell(0);
        HSSFCell cell2=row1.getCell(1);
        HSSFCell cell3=row1.getCell(2);
        HSSFCell cell4=row1.getCell(3);
        //HSSFCell cell4=row1.getCell(3);
        //HSSFCell cell5=row1.getCell(4);
        String firstname=cell1.getStringCellValue();
        String lastname=cell2.getStringCellValue();
        String pincode=String.valueOf(cell3.getNumericCellValue());
        //String fullname=cell4.getStringCellValue();
        //String lastname=cell4.getStringCellValue();
        //String zipcode= String.valueOf(cell5.getNumericCellValue());
        ArrayList<String> a = new ArrayList<String>();
        a.add(firstname);
        a.add(lastname);
        a.add(pincode);
        //a.add(fullname);
        return a;

    }
    public void pressCustomerLoginButton() throws InterruptedException {
        Thread.sleep(3000);
        customer_login_button.click();
    }
    public void pressAddCustomerButton() throws InterruptedException {
        Thread.sleep(3000);
        this.add_customer_button.click();
    }
    public void enterFirstName(String firstname) throws InterruptedException {
        Thread.sleep(3000);
        this.first_name.click();
        this.first_name.sendKeys(firstname);
    }
    public void enterLastName(String lastname) throws InterruptedException {
        Thread.sleep(3000);
        this.last_name.click();
        this.last_name.sendKeys(lastname);
    }
    public void enterPostalCode(String pincode) throws InterruptedException {
        Thread.sleep(3000);
        this.post_code.click();
        this.post_code.sendKeys(pincode);
    }
    public void addCustomerButton() throws InterruptedException {
        this.submit_button.click();
        Thread.sleep(3000);
    }

    public void customerAddedAlert() throws InterruptedException {
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }
    public void screenShot() throws IOException, InterruptedException {
        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File("C:\\Users\\himanshukumar7\\IdeaProjects\\addcustomer.jpg"));
        Thread.sleep(2000);
    }
}
