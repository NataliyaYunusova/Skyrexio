package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class CartTest extends BaseTest {
    final String goodsName = "Test.allTheThings() T-Shirt (Red)";

    @Test
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart(goodsName);
        cartPage.navigationPanel.entranceToCart();

        assertFalse(cartPage.getProductsNames().isEmpty());
        assertEquals(cartPage.getProductsNames().size(), 1);
        assertTrue(cartPage.getProductsNames().contains(goodsName));
    }
}
