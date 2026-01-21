package logic;

public class OrderItem {
    private Item item;
    private int itemAmount;


    public OrderItem(Item item, int itemAmount) {
        setItem(item);
        setItemAmount(itemAmount);
    }
    public void increaseItemAmount(int amount){
        if(amount>=0) itemAmount+=amount;
    }
    public int calculateTotalPrice() {
        int TotalPrice = item.getPricePerPiece() * itemAmount;
        return TotalPrice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        if(itemAmount<0) itemAmount = 0;
        this.itemAmount = itemAmount;
    }
}