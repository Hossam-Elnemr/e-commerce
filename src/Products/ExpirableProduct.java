package Products;

import java.util.Date;

public class ExpirableProduct extends Product {
    Date expiryDate;
    public ExpirableProduct(String name, double price, int quantity, Date expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
}
