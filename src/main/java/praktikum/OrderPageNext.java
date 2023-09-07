package praktikum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class OrderPageNext {
    final WebDriver driver;

    public static final By NAZADBUT = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']"); // кнопка назад, использую для проверки отрисовки страницы

    public static final By rentClick = By.xpath(".//div[@class='Dropdown-placeholder']"); //дропдаун для срока аренды
    private final By rentTime = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']"); //выбор пункта срока аренды
    private final By calendar = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); // дропдаун календаря

    private final By colourSelect = By.xpath(".//input[@id = 'black']"); //выбор цвета
    private final By clickZakaz = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); //клик на Заказать


    public OrderPageNext(WebDriver driver) {
        this.driver = driver;
    }
    //выбираем дату
    public OrderPageNext clickCalendar() {
        driver.findElement(calendar).click();
        driver.findElement(By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN react-datepicker-ignore-onclickoutside' and @placeholder='* Когда привезти самокат']")).sendKeys("09.08.2023");
        return this;
    }
    //заполняем срок аренды
    public OrderPageNext fillInRentTime(){
        driver.findElement(rentClick).click();
        driver.findElement(rentTime).click();
        return this;

    }
    //выбираем цвет
    public OrderPageNext selectColour(){
        driver.findElement(colourSelect).click();
        return this;
    }
    //кликаем на заказать
    public OrderPageNext zakazatClick(){
        driver.findElement(clickZakaz).click();
        return this;
    }

    //ждун отрисовки
    public  OrderPageNext wait10sec() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(NAZADBUT));
        return this;
    }
    // просто ждун без привязки к кнопкам
    public OrderPageNext waitWithDefaultTimeout(){
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT));

        return this;
    }
}
