import static org.junit.Assert.assertEquals;
import org.junit.*;
import Basket.*;
import Item.*;

public class ShoppingBasketTest{

  Basket basket;
  Item item;
  Item itemBogof;

  @Before
  public void before(){

    basket = new Basket();
    item = new Item(100, "sausage", false);
    itemBogof = new Item(150, "banana", true);
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
    Basket discountedBasket = basket.addItem(itemBogof);
    discountedBasket.discountTen();
    assertEquals(135, basket.total(), 0.00);
  }
}