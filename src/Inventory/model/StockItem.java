package Inventory.model;

public class StockItem {
    private int stockNum;
    private String itemName = "N/A";
    private int stockAmt = 0;

    public int getStockNum() {return stockNum;}

    public void setStockNum(int stockNum) {this.stockNum = stockNum;}

    public String getName() {return itemName;}

    public void setName(String name) {this.itemName = name;}

    public int getStockAmt() {return stockAmt;}

    public void setStockAmt(int stockAmt) {this.stockAmt = stockAmt;}

    public void addAmt(int amount) {stockAmt += amount;}

    public String toString() {
        return "#" + stockNum + ": " + itemName + " - " + stockAmt + " in stock";
    }

    public StockItem (int num, String name, int amount) {
        stockNum = num;
        stockAmt = amount;
        itemName = name;
    }
}
