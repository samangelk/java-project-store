package com.ata.stepseven;

import com.ata.AbstractShopTest;
import com.ata.ShopRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

public class ShopRunnerStepSevenIntegrationTest extends AbstractShopTest {

    @Test
    public void main_selectCheckoutWithEmptyCart_printsEmptyCartMessage() {
        String hintMessage = "Check your code for how you implemented checkout with an empty cart.";

        String[] expectedContentInCommandLineOutput = Stream.of(
                EXPECTED_GREETING_LINES,
                EXPECTED_MENU,
                new String[] {
                    "Your cart is currently empty. Please add at least one product to check out."
                },
                EXPECTED_MENU,
                new String[] {
                    EXITING_NOW_MENU_ITEM_OUTPUT
                }
            )
            .flatMap(Stream::of)
            .toArray(String[]::new);

        // GIVEN
        provideUserInput(SHOPPER_NAME, "5", "0");

        System.setIn(in);

        // WHEN
        ShopRunner.main(null);

        // THEN
        assertExpectedContentInCommandLineOutputMatchesActualOutput(
            expectedContentInCommandLineOutput,
            hintMessage
        );
    }

    @ParameterizedTest
    @CsvSource({
        "0,Crew Neck",
        "1,V-Neck",
        "2,Polo",
        "3,Boat Neck",
        "4,Tank Top"
    })
    public void main_selectBuyProductValidProductSelected_printsConfirmation(
        String productId, String productName) {

        String hintMessage = "Check your code for how you implemented adding a valid product to the cart.";

        String[] expectedContentInCommandLineOutput = Stream.of(
                EXPECTED_GREETING_LINES,
                EXPECTED_MENU,
                new String[] {
                    "Please enter the ID of the product you would like to purchase:",
                    String.format("%s has been added to your cart.", productName)
                },
                EXPECTED_MENU,
                new String[] {
                    EXITING_NOW_MENU_ITEM_OUTPUT
                }
            )
            .flatMap(Stream::of)
            .toArray(String[]::new);

        // GIVEN
        provideUserInput(SHOPPER_NAME, "2", productId, "0");

        System.setIn(in);

        // WHEN
        ShopRunner.main(null);

        // THEN
        assertExpectedContentInCommandLineOutputMatchesActualOutput(
            expectedContentInCommandLineOutput,
            hintMessage
        );
    }

    @Test
    public void main_selectBuyProductInvalidProductSelected_printsProductNotFoundMessage() {
        String hintMessage = "Check your code for how you implemented adding an invalid product to the cart.";

        String[] expectedContentInCommandLineOutput = Stream.of(
                EXPECTED_GREETING_LINES,
                EXPECTED_MENU,
                new String[] {
                    "Please enter the ID of the product you would like to purchase:",
                    "That item ID is invalid and could not be added to the cart."
                },
                EXPECTED_MENU,
                new String[] {
                    EXITING_NOW_MENU_ITEM_OUTPUT
                }
            )
            .flatMap(Stream::of)
            .toArray(String[]::new);

        // GIVEN
        provideUserInput(SHOPPER_NAME, "2", "999", "0");

        System.setIn(in);

        // WHEN
        ShopRunner.main(null);

        // THEN
        assertExpectedContentInCommandLineOutputMatchesActualOutput(
            expectedContentInCommandLineOutput,
            hintMessage
        );
    }

    @ParameterizedTest
    @CsvSource({
        "0,Crew Neck",
        "1,V-Neck",
        "2,Polo",
        "3,Boat Neck",
        "4,Tank Top"
    })
    public void main_selectShowCartAfterProductAddedToCart_printsCartContents(
        String productId, String productName) {

        String hintMessage = "Check your code for how you implemented adding a valid " +
            "product to the cart and showing the cart contents.";

        String[] expectedContentInCommandLineOutput = Stream.of(
                EXPECTED_GREETING_LINES,
                EXPECTED_MENU,
                new String[] {
                    "Please enter the ID of the product you would like to purchase:",
                    String.format("%s has been added to your cart.", productName)
                },
                EXPECTED_MENU,
                new String[] {
                    "--Cart--",
                    "Item Count: 1",
                    "Items:",
                    String.format("%s: \\$(\\d{1,2}.\\d{1,2})", productName),
                    "",
                    "Pre-Tax Total: \\$(\\d{1,2}.\\d{1,2})",
                    "Post-Tax Total \\(10.00% Tax\\): \\$(\\d{1,2}.\\d{1,2})",
                },
                EXPECTED_MENU,
                new String[] {
                    EXITING_NOW_MENU_ITEM_OUTPUT
                }
            )
            .flatMap(Stream::of)
            .toArray(String[]::new);

        // GIVEN
        provideUserInput(SHOPPER_NAME, "2", productId, "4", "0");

        System.setIn(in);

        // WHEN
        ShopRunner.main(null);

        // THEN
        assertExpectedContentInCommandLineOutputMatchesActualOutput(
            expectedContentInCommandLineOutput,
            hintMessage
        );
    }

    @Test
    public void main_selectShowCartAfterInvalidProductAddedToCart_printsEmptyCartMessage() {
        String hintMessage = "Check your code for how you implemented adding an invalid " +
            "product to the cart and then showing the cart.";

        String[] expectedContentInCommandLineOutput = Stream.of(
                EXPECTED_GREETING_LINES,
                EXPECTED_MENU,
                new String[] {
                    "Please enter the ID of the product you would like to purchase:",
                    "That item ID is invalid and could not be added to the cart."
                },
                EXPECTED_MENU,
                new String[] {
                    "The cart is empty. Please add at least one product to see it in the cart."
                },
                EXPECTED_MENU,
                new String[] {
                    EXITING_NOW_MENU_ITEM_OUTPUT
                }
            )
            .flatMap(Stream::of)
            .toArray(String[]::new);

        // GIVEN
        provideUserInput(SHOPPER_NAME, "2", "999", "4", "0");

        System.setIn(in);

        // WHEN
        ShopRunner.main(null);

        // THEN
        assertExpectedContentInCommandLineOutputMatchesActualOutput(
            expectedContentInCommandLineOutput,
            hintMessage
        );
    }

    @Test
    public void main_selectShowCartWhenCartEmpty_printsEmptyCartMessage() {
        String emptyCartHintMessage = "Check your code for how you implemented showing an empty cart.";
        String[] expectedContentInCommandLineOutput = Stream.of(
                EXPECTED_GREETING_LINES,
                EXPECTED_MENU,
                new String[] {
                    "The cart is empty. Please add at least one product to see it in the cart."
                },
                EXPECTED_MENU,
                new String[] {
                    EXITING_NOW_MENU_ITEM_OUTPUT
                }
            )
            .flatMap(Stream::of)
            .toArray(String[]::new);

        // GIVEN
        provideUserInput(SHOPPER_NAME, "4", "0");

        System.setIn(in);

        // WHEN
        ShopRunner.main(null);

        // THEN
        assertExpectedContentInCommandLineOutputMatchesActualOutput(
            expectedContentInCommandLineOutput,
            emptyCartHintMessage
        );
    }

    @ParameterizedTest
    @CsvSource({
        "0,Crew Neck",
        "1,V-Neck",
        "2,Polo",
        "3,Boat Neck",
        "4,Tank Top"
    })
    public void main_2_printsEmptyCart(
        String productId, String productName) {

        String hintMessage = "Check your code for how you implemented adding a valid " +
            "product to the cart, checking out, and showing the cart contents.";

        String[] expectedContentInCommandLineOutput = Stream.of(
                EXPECTED_GREETING_LINES,
                EXPECTED_MENU,
                new String[] {
                    "Please enter the ID of the product you would like to purchase:",
                    String.format("%s has been added to your cart.", productName)
                },
                EXPECTED_MENU,
                new String[] {
                    "--Cart--",
                    "Item Count: 1",
                    "Items:",
                    String.format("%s: \\$(\\d{1,2}.\\d{1,2})", productName),
                    "",
                    "Pre-Tax Total: \\$(\\d{1,2}.\\d{1,2})",
                    "Post-Tax Total \\(10.00% Tax\\): \\$(\\d{1,2}.\\d{1,2})"
                },
                EXPECTED_MENU,
                new String[] {
                    "Your total is \\$(\\d{1,2}.\\d{1,2})",
                    "Thank you for shopping at T-Shirt Mart."
                },
                EXPECTED_MENU,
                new String[] {
                    "The cart is empty. Please add at least one product to see it in the cart."
                },
                EXPECTED_MENU,
                new String[] {
                    EXITING_NOW_MENU_ITEM_OUTPUT
                }
            )
            .flatMap(Stream::of)
            .toArray(String[]::new);

        // GIVEN
        provideUserInput(SHOPPER_NAME, "2", productId, "4", "5", "4", "0");

        System.setIn(in);

        // WHEN
        ShopRunner.main(null);

        // THEN
        assertExpectedContentInCommandLineOutputMatchesActualOutput(
            expectedContentInCommandLineOutput,
            hintMessage
        );
    }
}
