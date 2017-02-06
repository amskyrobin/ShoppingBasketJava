import static org.junit.Assert.assertEquals;
import org.junit.*;
import Basket.*;
import Item.*;
import Customer.*;

public class ShoppingBasketTest{

  Basket basket;
  Item item;
  Item itemBogof;
  Customer customer;

  @Before
  public void before(){

    basket = new Basket();
    item = new Item(100, "sausage", false);
    itemBogof = new Item(150, "banana", true);
    customer = new Customer("Amy", true);
  }

  @Test
  public void canCheckNumberOfItemsInBasket(){
    assertEquals(0, basket.numberOfItems());
  }

  @Test
  public void canAddItemsToBasket(){
    basket.addItem(item);
    assertEquals(1, basket.numberOfItems());
  }

  @Test
  public void canRemoveItemFromBasket(){
    basket.addItem(item);
    basket.removeItem(item);
    assertEquals(0, basket.numberOfItems());
  }

  @Test
  public void canRemoveBogofItems(){
    basket.addItem(itemBogof);
    basket.removeItem(itemBogof);
    assertEquals(0, basket.numberOfItems());
  }

  @Test
  public void canCheckIfBasketIsEmpty(){
    basket.addItem(item);
    basket.empty();
    assertEquals(0, basket.numberOfItems());
  }

  @Test
  public void canGetBasketTotal(){
    basket.addItem(item);
    basket.addItem(item);
    assertEquals(200, basket.total(), 0.00);
  }

  @Test
  public void canCheckIfBogofDealOnItem(){
    itemBogof.getBogof();
    assertEquals(true, itemBogof.getBogof());
  }

  @Test
  public void canCheckIfFreeItemAddedAfterBogof(){
    basket.addItem(itemBogof);
    assertEquals(2, basket.numberOfItems());
  }

  @Test
  public void canCheckIfFreeItemIsActuallyFree(){
    basket.addItem(itemBogof);
    assertEquals(150, basket.total(), 0.00);
  }

  @Test
  public void canCheckIfTenPercentDiscount(){
    basket.addItem(itemBogof);
    basket.discountTen();
    assertEquals(135, basket.discountTen(), 0.00);
  }

  @Test
  public void canCheckIfCustomerHasLoyaltyCard(){
    customer.getLoyaltyCard();
    assertEquals(true, customer.getLoyaltyCard());
  }

  @Test
  public void canCheckIfLoyaltyCardActivatesDiscount(){
    basket.addItem(itemBogof);
    basket.discountLoyaltyCard(customer);
    assertEquals(132.3, basket.discountLoyaltyCard(customer), 0.00);
  }
}