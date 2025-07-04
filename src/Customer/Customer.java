package Customer;
import Products.*;
import Services.Cart;

public class Customer {
    private String name;
    private double currentBalance = 0;
    Cart cart = new Cart();
    public Customer(String name, int initialBalance) {
        this.name = name;
        currentBalance = initialBalance;
    }
    public String getName() {
        return name;
    }
    public double getCurrentBalance() {
        return currentBalance;
    }
    public void modifyBalance(double amountToBeDecreased) {
        currentBalance -= amountToBeDecreased;
    }
    public boolean canBuy(double amount) {
        return amount <= currentBalance;
    }

}
