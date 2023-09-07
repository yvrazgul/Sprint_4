package praktikum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PopupPage {
    public static final By FIRST_POPUP_BUTTON = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text() ='Да']");
    public static final By SECOND_POPUP_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");
    final WebDriver driver;

    public PopupPage(WebDriver driver) {
        this.driver = driver;
    }

    public PopupPage clickYESOnPopup(){
        driver.findElement(FIRST_POPUP_BUTTON).click();
        return this;
    }

    public  PopupPage clickShowStatus(){
        driver.findElement(SECOND_POPUP_BUTTON).click();
        return this;
    }
}
