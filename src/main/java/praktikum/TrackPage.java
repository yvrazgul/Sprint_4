package praktikum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class TrackPage {
    public static final By LOAD_TRACK_FORM = By.xpath(".//div[@class='Track_OrderInfo__2fpDL']");
    public static final By CANCEL_ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text()='Отменить заказ']");
    final WebDriver driver;

    public TrackPage(WebDriver driver) {
        this.driver = driver;
    }


    public TrackPage showTrackForm(){           //проверяем загрузку формы заказа
        driver.findElement(LOAD_TRACK_FORM);
        return this;
    }
    public String findCancelOrderButton(){          //проверяем что есть кнопка Отмены заказа
        return driver.findElement(CANCEL_ORDER_BUTTON).getText();


    }
}
