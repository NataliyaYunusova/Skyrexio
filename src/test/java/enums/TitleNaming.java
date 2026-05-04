package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TitleNaming {
    PRODUCTS("Productss"),
    CART("Your Cart"),
    CHECKOUT("Checkout: Your Information"),
    CONTINUE("Checkout: Overview"),
    FINISH("Checkout: Complete!");

    @Getter
    private final String displayName;
}
