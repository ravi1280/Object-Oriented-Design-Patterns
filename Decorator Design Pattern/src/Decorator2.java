

interface Beverages{
double getprice();
String getdescription();
}

class Coffees implements Beverages{

    @Override
    public double getprice() {
        return 500;
    }

    @Override
    public String getdescription() {
        return "Coffee";
    }
}
class Tea implements Beverages{

    @Override
    public double getprice() {
        return 100;
    }

    @Override
    public String getdescription() {
        return "Tea";
    }
}
 abstract class decorator implements Beverages{
    protected Beverages beverages;
    public decorator(Beverages beverages){
        this.beverages = beverages;
    }
}

class Milk extends decorator{

    public Milk(Beverages beverages){
        super(beverages);
    }

    @Override
    public double getprice() {
        return beverages.getprice()+100;
    }

    @Override
    public String getdescription() {
        return beverages.getdescription()+" ,Milk";
    }
}

class  Sugar extends decorator {
  public Sugar(Beverages beverages){
      super(beverages);
  }

    @Override
    public double getprice() {
        return beverages.getprice()+20;
    }

    @Override
    public String getdescription() {
        return beverages.getdescription()+" ,Sugar";
    }
}

public class Decorator2 {
    public static void main(String[] args) {
        Beverages beverages = new Coffees();
        beverages = new Sugar(beverages);
        beverages = new Milk(beverages);

        System.out.println("beverages price: "+beverages.getprice());
        System.out.println("beverages description: "+beverages.getdescription());

        Beverages beverages2 = new Tea();
        beverages2 = new Sugar(beverages2);

        System.out.println("beverages price: "+beverages2.getprice());
        System.out.println("beverages description: "+beverages2.getdescription());


    }
}
