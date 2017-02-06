package Item;
import java.util.*;
import Basket.*;

public class Item{

  private double price;
  private String description;
  private boolean bogof;
  private Item freeItem;


  public Item(double price, String description, boolean bogof){
    this.price = price;
    this.description = description;
    this.bogof = bogof;
    if(bogof)
      this.freeItem = new Item(0, description, false);
  }

  public double getPrice(){
    return price;
  }

  public boolean getBogof(){
    return bogof;
  }


  public boolean setBogof(boolean bogof){
    return this.bogof = bogof;
  }

public double setPrice(double price){
  return this.price = price;

}

public Item getFreeItem(){
  return this.freeItem;
}

}