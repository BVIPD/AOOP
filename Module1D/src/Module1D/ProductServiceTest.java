package Module1D;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private final ProductService productService = new ProductService();

    @Test
    void calculateDiscount_ValidInputs_ReturnsCorrectDiscount() {
        double price = 100.0;
        double discount = 10.0;
        double expected = 90.0;

        double result = productService.calculateDiscount(price, discount);

        assertEquals(expected, result, "The discount calculation is incorrect");
    }

    @Test
    void calculateDiscount_NegativePrice_ThrowsException() {
        double price = -100.0;
        double discount = 10.0;

        assertThrows(IllegalArgumentException.class, () -> 
            productService.calculateDiscount(price, discount),
            "Expected exception for negative price"
        );
    }
}
