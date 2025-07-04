package Products;
import java.util.Date;
public class ExpirableShippableProduct extends ShippableProduct{
    private Date expiryDate;
    public ExpirableShippableProduct(String name, double price, int quantity, Date expiryDate, double weight) {
        super(name, price, quantity, weight);
        this.expiryDate = expiryDate;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
}
