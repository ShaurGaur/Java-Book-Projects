package Inventory.model;

import java.util.ArrayList;

public class StockList {
    private ArrayList<StockItem> stock;
    public ArrayList<StockItem> getStock() {return stock;}

    public StockList() {
        stock = new ArrayList<>();
    }

    public int size() {return stock.size();}

    public StockItem itemAt(int stockNum) {return stock.get(stockNum - 1000);}

    public void addNewItem(String name, int amount) {
        stock.add(new StockItem(stock.size() + 1000, name, amount));
    }

    public void addToItem(int stockNum, int amount) {
        stock.get(stockNum - 1000).addAmt(amount);
    }

    public void discontinue(int stockNum) {
        stock.get(stockNum - 1000).setName("DISCONTINUED");
        stock.get(stockNum - 1000).setStockAmt(0);
    }
    public void setItem(int stockNum, String name, int amount) {
        stock.set(stockNum - 1000, new StockItem(stockNum, name, amount));
    }

}
