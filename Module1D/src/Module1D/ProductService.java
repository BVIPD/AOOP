package Module1D;
public class ProductService {
    public double calculateDiscount(double price, double discountPercentage) {
        if (price < 0 || discountPercentage < 0) {
            throw new IllegalArgumentException("Price and discount must be non-negative");
        }
        return price - (price * discountPercentage / 100);
    }
}
