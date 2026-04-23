interface Coffee {
    String getDescription();
    int cost();
}

class BasicCoffee implements Coffee {
    public String getDescription() {
        return "Basic Coffee";
    }

    public int cost() {
        return 50;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    public int cost() {
        return coffee.cost() + 10;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    public int cost() {
        return coffee.cost() + 5;
    }
}

 class CoffeeTest {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();
        System.out.println(coffee.getDescription() + " = " + coffee.cost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " = " + coffee.cost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " = " + coffee.cost());
    }
}