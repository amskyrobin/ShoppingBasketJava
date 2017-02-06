package Customer;
import java.util.*;
import Basket.*;
import Item.*;

public class Customer{

  private String name;
  private boolean loyaltyCard;

  public Customer(String name, boolean loyaltyCard){
    this.name = name;
    this.loyaltyCard = loyaltyCard;
  }


  public boolean getLoyaltyCard(){
    return loyaltyCard;
  }
}