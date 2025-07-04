package Services;
import Products.*;
import java.util.ArrayList;
import java.util.List;
public class ShippingService {
    public ArrayList<Product> list;
    public ShippingService(ArrayList<Product> list) {
        this.list = list;
    }
    public double cost() {
        double total = 0;
        for(var p : list) {
            if(p instanceof ShippableProduct)
                total += ((ShippableProduct)p).getWeight()*2.5;
        }
        return total;
    }
}
