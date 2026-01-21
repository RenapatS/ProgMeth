package logic;

import java.util.Random;

public class WeightItem extends Item{

    private double weight;

    public WeightItem(String name,double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice ;
    }

    @Override
    public double cost() {
//        System.out.println(unitPrice + "\n" +weight);
        return unitPrice * weight;
    }

    public double scale(){
        Random random = new Random();
        double re = 0.01 + random.nextDouble(3);
        return re;
    }
    public String toString(){
        return "UnitItem:"+this.name +"\t" + this.weight +"\t" + this.unitPrice +"\t" + this.cost();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
