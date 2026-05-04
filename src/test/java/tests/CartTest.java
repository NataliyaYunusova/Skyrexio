package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static user.UserFactory.withAdminPermission;

@Epic("Корзина")
@Feature("Просмотр корзины")
public class CartTest extends BaseTest {
    final String goodsName = "Test.allTheThings() T-Shirt (Red)";

    @Story("Отображение добавленного товара в корзине")
    @Test(description = "Проверка, что добавленный товар отображается в корзине")
    public void checkGoodsInCart() {
        SoftAssert soft = new SoftAssert();
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.addToCart(goodsName);
        cartPage.navigationPanel.entranceToCart();

        soft.assertFalse(cartPage.getProductsNames().isEmpty());
        soft.assertEquals(cartPage.getProductsNames().size(), 1);
        soft.assertTrue(cartPage.getProductsNames().contains(goodsName));

        soft.assertAll();
    }
}
