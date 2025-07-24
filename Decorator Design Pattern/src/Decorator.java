
interface Coffee{
      double cost();
      String description();
}

class simpleCoffee implements Coffee{

    @Override
    public double cost() {
        return 500;
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }
}

abstract class coffeeDecorator implements Coffee {
    protected Coffee coffee;

    public coffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }
}

class MilkDecorator extends coffeeDecorator{
    public MilkDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public double cost() {
        return coffee.cost()+100;
    }

    @Override
    public String description() {
        return coffee.description()+",Milk";
    }
}

class SugarDecorator extends coffeeDecorator{
    public SugarDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public double cost() {
        return coffee.cost()+50;
    }

    @Override
    public String description() {
        return coffee.description()+",Sugar";
    }
}


public class Decorator {
    public static void main(String[] args) {

        Coffee coffee = new simpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println("Coffee cost: " + coffee.cost()+" Coffee description: " + coffee.description());

    }
}