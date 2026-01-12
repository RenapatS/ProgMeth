package logic;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItemList; // Item item, int itemAmount
	private static int totalOrderCount = 0;
	private int orderNumber;
	
	public Order() {
		// TODO
		this.orderNumber = totalOrderCount;
		totalOrderCount++;
		orderItemList = new ArrayList<OrderItem>();
	}

	public OrderItem addItem(Item item, int amount) {
		// TODO
		// Loop the orderItemList to find if item of any orderItem equals to the given item

		for(OrderItem x:orderItemList){
			if( x.getItem().getName().equals(item.getName())){
//				amount += x.getItemAmount();
				if(x.getItemAmount() + amount>=0)x.setItemAmount(x.getItemAmount() + amount);
				return x;
			}
		}
		// if there is orderItem with given item, increase that orderItem itemAmount with amount
		// and return that orderItem

		// else create new orderItem with given item and amount, then return the new orderItem
		OrderItem newOrderItem = new OrderItem(item, amount);
		this.orderItemList.add(newOrderItem); // บรรทัดสำคัญที่หายไป!
		return newOrderItem;
	}

	public int calculateOrderTotalPrice() {
		// TODO
		// Calculate total price of the order by summing total price of each orderItem in orderItemList
		int total = 0;
		for(OrderItem x : orderItemList){
			total += x.calculateTotalPrice();
		}
		return total;
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}
	
	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	
	
}
