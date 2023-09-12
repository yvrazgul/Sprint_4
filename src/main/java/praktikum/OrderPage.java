package praktikum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class OrderPage {
    final WebDriver driver;
    private final By nameInput = By.xpath(".//div[@class='Order_Form__17u6u']/div/input[@placeholder='* Имя']"); // инпут ввода имени
    private final By lastNameInput = By.xpath(".//div[@class='Order_Form__17u6u']/div/input[@placeholder='* Фамилия']");// инпут ввода фамилии
    private final By address = By.xpath(".//div[@class='Order_Form__17u6u']/div/input[@placeholder='* Адрес: куда привезти заказ']"); // инпут ввода адреса
    private final By metro = By.className("select-search__input"); //ищем инпут метро
    private final By metroClick = By.xpath(".//div[@class='']/div/div[2]/ul/li[@data-value = '5']"); //локатор станции метро
    private final By phone = By.xpath(".//div[@class='Order_Form__17u6u']/div/input[@placeholder='* Телефон: на него позвонит курьер']"); // инпут ввода номера телефона
    private final By dalee = By.xpath(".//button[@class= 'Button_Button__ra12g Button_Middle__1CSJM']"); //кнопка далее


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //заполняем форму на первой странице заказа
    public  OrderPage fillInOrderForm(){
        driver.findElement(nameInput).sendKeys("Иван");
        driver.findElement(lastNameInput).sendKeys("Дедов");
        driver.findElement(address).sendKeys("Москва");
        driver.findElement(metro).click();
        driver.findElement(metroClick).click();
        driver.findElement(phone).sendKeys("79080008000");
        return this;
    }
    //кликаем далее
    public OrderPage clickDalee(){
        driver.findElement(dalee).click();
        return this;
    }
}
