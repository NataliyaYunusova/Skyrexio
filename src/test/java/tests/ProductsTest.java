package tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class ProductsTest extends BaseTest {
    List<String> goodsList =
            List.of(
                    "Sauce Labs Bike Light",
                    "Test.allTheThings() T-Shirt (Red)",
                    "Sauce Labs Bolt T-Shirt"
            );

    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertTrue(productsPage.pageTitleDisplayed());
        assertEquals(productsPage.getGoodsQuantity(), 6);
        for (String goods : goodsList) {
            productsPage.addToCart(goods);
        }
        productsPage.addToCart();
        assertEquals(productsPage.navigationPanel.checkCounterValue(), "4");
        assertEquals(productsPage.navigationPanel.checkCounterColor(), "rgba(226, 35, 26, 1)");
        cartPage.navigationPanel.entranceToCart();
        assertEquals(cartPage.getTitle(), "Your Cart");
    }
}
