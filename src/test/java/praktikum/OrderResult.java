package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
//import praktikum.pages.*;

public class OrderResult {

    @Rule
    public DriverRule driverRule = new DriverRule();


    @Test
    public void OrderWithUpButton(){

        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()                     //открываем главную
                .clickCookies()             //кликаем по кукам
                .clickRentButtonUP();       //кликаем Заказать

        OrderPage orderPage = new OrderPage(driverRule.getDriver()); //переходим на страницу заказа
        orderPage.fillInOrderForm()                         //заполняем форму заказа
                .clickDalee();                               //кликаем далее

        OrderPageNext detailsPage = new OrderPageNext(driverRule.getDriver()); //переходим на вторую часть страницы заказа
        detailsPage.wait10sec()             //ждем на всякий случай для полной отрисовки
                .fillInRentTime()                   // заполняем срок аренды
                .clickCalendar()                    // отправляем дату в календарь
                .selectColour()                     //выбираем цвет
                .zakazatClick()
                .waitWithDefaultTimeout();

        PopupPage popupPage = new PopupPage(driverRule.getDriver());
        popupPage.clickYESOnPopup()
                .clickShowStatus();

        TrackPage trackPage = new TrackPage(driverRule.getDriver());
        trackPage.showTrackForm()       //кликаем заказать
                .findCancelOrderButton();
        MatcherAssert.assertThat(trackPage.findCancelOrderButton(), true);  // проверяем, что отрисовалась кнопка "Отменить заказ", то есть сам заказ успешно состоялся
    }

    //заказываем через нижнюю кнопку
    @Test
    public void OrderWithBottomButton(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()                             //открываем главную
                .clickCookies()                      //убираем куки
                .scrollToBottomButton()             //скроллим до нижней кнопки
                .clickRentButtonBOTTOM();           //кликаем заказать

        OrderPage orderPage = new OrderPage(driverRule.getDriver()); //открывается страница заказа

        orderPage.fillInOrderForm()             //заполняем информацию  ФИО на странице заказа
                .clickDalee();                 //кликаем далее

        OrderPageNext detailsPage = new OrderPageNext(driverRule.getDriver()); //открывается вторая страница заказа
        detailsPage.wait10sec()                         //на всякий случай ждем
                .fillInRentTime()                           //заполняем на сколько заказ
                .clickCalendar()                            //когда заказ
                .selectColour()                             //какой цвет хотим
                .zakazatClick()                            //тыкаем заказать
                .waitWithDefaultTimeout();              //ждем на всякий случай

        PopupPage popupPage = new PopupPage(driverRule.getDriver());    //открываем попап
        popupPage.clickYESOnPopup()                                     //тыкаем там ДА
                .clickShowStatus();                                     //во втором попапе тыкаем показать статус


        TrackPage trackPage = new TrackPage(driverRule.getDriver());        //открывается страница со статусом заказа
        trackPage.showTrackForm()                                      //ищем, что на странице отрисовалась форма заказа
                .findCancelOrderButton();


        MatcherAssert.assertThat(trackPage.findCancelOrderButton(), true);  // проверяем, что отрисовалась кнопка "Отменить заказ", то есть сам заказ успешно состоялся
    }
}
