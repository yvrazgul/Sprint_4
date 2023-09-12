package praktikum;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final By upButton = By.xpath(".//button[@class='Button_Button__ra12g']"); // кнопка Заказать вверху страницы

    private final By bottomButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button"); // кнопка Заказать внизу страницы
    final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;

    }
    //открываем главную страницу
    public MainPage open() {
        driver.get(EnvConfig.BASE_URL);

        return this;
    }
    //находим аккордеон, раскрываем согласно локатору и смотрим текст (согласна, длинновато, но как есть))
    public String getAccLocatorAndClick( int accLocator) {

        WebElement element =  driver.findElement(By.id("accordion__heading-"+accLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.id("accordion__heading-"+accLocator)).click();
        String text = driver.findElement(By.xpath(".//*[@id='accordion__panel-"+accLocator+"']/p")).getText();
        return text;
    }

    //кликаем кнопку Заказать наверху
    public void clickRentButtonUP(){
        driver.findElement(upButton).click();
    }
    //скроллим до нижней кнопки Заказать
    public MainPage scrollToBottomButton (){
        WebElement element = driver.findElement(By.xpath(".//div[@class='Home_RoadMap__2tal_']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }
    // кликаем нижнюю кнопку заказать
    public void clickRentButtonBottom() {
        driver.findElement(bottomButton).click();
    }
    //закрываем куки
    public MainPage clickCookies(){
        driver.findElement(By.id("rcc-confirm-button")).click();
        return this;
    }
}
