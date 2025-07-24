
interface PaymentStrategy{
    void pay(double amount);

}

class cashPayment implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + "$  Paid with CASH");
    }
}

class  cardPayment implements PaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + "$  Paid with CARD");
    }
}

class shoppingCart {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void checkout(double amount) {
        strategy.pay(amount);
    }

}

public class Strategy {
    public static void main(String[] args) {

        shoppingCart shoppingCart = new shoppingCart();

        shoppingCart.setStrategy(new cardPayment());
        shoppingCart.checkout(10);

        shoppingCart.setStrategy(new cashPayment());
        shoppingCart.checkout(100);


    }
}