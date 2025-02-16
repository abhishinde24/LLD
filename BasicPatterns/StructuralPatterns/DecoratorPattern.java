package StructuralPatterns;

interface Coffee{
    public double getCost();
    public String getDescription();
}

class Expresso implements Coffee{
    @Override
    public double getCost() {
        return 5.0;
    }

    @Override
    public String getDescription(){
        return "Expresso";
    }
}

class SimpleCoffee implements Coffee{

    @Override
    public double getCost() {
        return 4.0;
    }

    @Override
    public String getDescription(){
        return "Simple Coffee";
    }
}

abstract class CoffeeDecorator implements Coffee{
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee){
       this.decoratedCoffee = coffee;
    }

    @Override
    public double getCost(){
        return decoratedCoffee.getCost();
    }

    @Override
    public String getDescription(){
        return decoratedCoffee.getDescription();
    }
}

class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ",Milk";
    }
}
class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ",Sugar";
    }
}

public class DecoratorPattern{
    public static void main(String[] args){
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " cost " + coffee.getCost());


        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " cost " + coffee.getCost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " cost " + coffee.getCost());
    }
}
