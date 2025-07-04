package Products;

public interface Shippable {
    String getName();
    default double getWeight() {
        return 0;
    }
}
