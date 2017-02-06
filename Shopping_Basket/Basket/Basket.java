package Basket;
import java.util.*;
import Item.*;


public class Basket {

  private ArrayList<Item> itemList;

  public Basket(){
    itemList = new ArrayList<Item>();
  }

  public int numberOfItems(){
    return itemList.size();
  }

  public void addItem(Item item){
    itemList.add(item);
    if(item.getBogof() == true){
      itemList.add(item.getFreeItem());
    }
  }

  public void removeItem(Item item){
    itemList.remove(item);
    if(item.getBogof() == true){
    itemList.remove(item.getFreeItem());
  }
}

  public void empty(){
    itemList.clear();

  }

  public double total(){
    double basketTotal = 0;
    for (Item item : itemList){
      basketTotal += item.getPrice();
    }
    return basketTotal;
  }
}
