package associations;

import java.lang.reflect.Modifier;
import java.time.Duration;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssociationsTest {

  @Test
  void customerTest() {
    // Instantiate a customer
    Customer c1 = new Customer("Weihua", "Liu");
    assertEquals("Liu", c1.getLastName(), "Last name test");
    assertEquals("Weihua", c1.getFirstName(), "First name test");
    assertNull(c1.getOrder(), "Initial Order reference should be null");
  }

  @Test
  void orderTest() {
    // Instantiate a customer
    Customer c1 = new Customer("Weihua", "Liu");
    // Create an Order
    Order o1 = new Order("DineIn","KL09M", LocalDateTime.now(), c1);
    //check orderTime
    long delta = Duration.between(LocalDateTime.now(), o1.getOrderTime()).toMillis();
    System.out.println("DELTA: " + delta);
    assertTrue(delta < 4, "Timestamp less than 4ms");

    //check orderNum, customer
    assertEquals("DineIn", o1.getOrderType(), "Order Type test");
    assertEquals("KL09M", o1.getOrderNum(), "Order number test");
    assertEquals(c1, o1.getCustomer(), "Customer test");
    assertEquals(0, o1.getItems().length, "Initial rooms array length test");


    //  Associate order with customer
    c1.setOrder(o1);
    assertEquals(o1, c1.getOrder(), "Customer building test");
  }

  @Test void inspectPublicModifier() {
    // Make sure Order is public
    try {
      Class<?> c1 = Class.forName("associations.Order");
      Class<?> c2 = Class.forName("associations.Customer");
      // Inspect modifiers
      String modifiers1 = Modifier.toString(c1.getModifiers());
      String modifiers2 = Modifier.toString(c2.getModifiers());
      assertEquals(modifiers1, "public", "Order is not 'public'");
      assertEquals(modifiers2, "public", "Customer is not 'public'");
    } catch (Exception e){
      // Report exception
      fail("Could not inspect Order class");
    }

  }

  @Test
  void itemTest() {
    // Instantiate a customer
    Customer c1 = new Customer("Weihua", "Liu");

    // Instantiate an Order
    Order b1 = new Order("DineIn","KI908B", LocalDateTime.now(),c1);

    // Create an Item
    Item r1 = new Item("Burger", b1,"Spicy Crispy",2);

    // Check values
    assertEquals("Burger", r1.getType(), "Type test");
    assertEquals(b1, r1.getOrder(), "Order reference test");
    assertEquals("Spicy Crispy", r1.getName(), "Name test");
    assertEquals(2, r1.getQuantity(), "Quantity test");

    assertEquals(0, r1.getIngredients().length, "Initial Ingredients array length test");


    // Associate with building
    b1.addItems(r1);
    // Check that building was updated
    assertEquals(1, b1.getItems().length, "Testing rooms array length");
  }

  @Test
  void IngredientTest() {
    // Instantiate a customer
    Customer c1 = new Customer("Weihua", "Liu");

    // Instantiate an Order
    Order o1 = new Order("Dine-in","KI908B", LocalDateTime.now(),c1);

    // Create an Item
    Item item1 = new Item("Bergers", o1,"Spicy Crispy",2);

    // Create an Ingredient
    Ingredient ingre1 = new Ingredient(item1, "Potato Roll", "regular", 100.00);

    // Check values

    assertEquals(item1, ingre1.getItem(), "Item reference test");
    assertEquals("Potato Roll", ingre1.getName(), "Name test");
    assertEquals("regular", ingre1.getCustomized(), "Customized test");
    assertEquals(100.00, ingre1.getCalorie(), "Calorie test");
    assertEquals(0, ingre1.getNutritions().length, "Initial Nutritions length test");

    // Check that we can add a device to a room
    item1.addIngredient(ingre1);
    assertEquals(1, item1.getIngredients().length, "Testing Ingredients array length");
  }

  @Test
  void nutritionTest()  {
    // Instantiate a customer
    Customer c1 = new Customer("Weihua", "Liu");

    // Instantiate an Order
    Order o1 = new Order("Dine-in","KI908B", LocalDateTime.now(),c1);

    // Create an Item
    Item item1 = new Item("Bergers", o1,"Spicy Crispy",2);

    // Create an Ingredient
    Ingredient ingre1 = new Ingredient(item1, "Potato Roll", "regular", 100.00);

    // Create a Nutrition
    Nutrition n1=new Nutrition(ingre1,"Calcium","mcg", 30);

    // Check values
    assertEquals(ingre1, n1.getIngredient(), "Ingredient reference test");
    assertEquals("mcg", n1.getUnits(), "Unit test");
    assertEquals(30,n1.getAmount(), "Amount test");
    assertEquals("Calcium",n1.getName(), "Name test");

    // Add reading to a device
    ingre1.addNutrition(n1);
    // Check that reading was added
    assertEquals(1, ingre1.getNutritions().length, "Testing readings array length");
  }
}
