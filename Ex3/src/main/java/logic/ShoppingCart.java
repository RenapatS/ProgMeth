package logic;

import java.util.ArrayList;
import java.util.Random;

public class ShoppingCart {
	private int requiredUnitItems;
	private int requiredWeightItems;
	private int discount; // in percentage 1 - 100;
	private ArrayList<Item> items;
	
	public ShoppingCart() {
		// TODO Auto-generated constructor stub
		Random random = new Random();
		requiredUnitItems = 1 + random.nextInt(3);
		requiredWeightItems = 1 + random.nextInt(3);
		discount = 20;
		items = new ArrayList<Item>();
	}
	
	public void addItem(Item item)
	{
		//fill code

		if(item instanceof UnitItem){
			if(((UnitItem) item).getUnitPrice() <=0||((UnitItem) item).getAmount() <=0) return;
		}
		if(item instanceof WeightItem){
			if(((WeightItem) item).getUnitPrice()<=0) return;
		}
		items.add(item);
//		this.items = items;
	}
	
	public double checkOut(){
		//fill code
		double tt = 0 ;
		for (Item x : items){
			tt += x.cost();
		}
		return tt;
	}
	
	public boolean isDiscounted(){
		//fill code
		int ttw=0,tta=0;
		for (Item x : items){
			if(x instanceof WeightItem) ttw++;
			if(x instanceof UnitItem) tta++;
		}
		if(ttw >= requiredWeightItems && tta >= requiredUnitItems){
			return true;
		}
		return false;
	}

	//Create Getter&Setter method for all private fields

	public int getRequiredUnitItems() {
		return requiredUnitItems;
	}

	public void setRequiredUnitItems(int requiredUnitItems) {
		this.requiredUnitItems = requiredUnitItems;
	}

	public int getRequiredWeightItems() {
		return requiredWeightItems;
	}

	public void setRequiredWeightItems(int requiredWeightItems) {
		this.requiredWeightItems = requiredWeightItems;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
}
