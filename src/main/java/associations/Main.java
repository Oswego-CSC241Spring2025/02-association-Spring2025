package associations;

import java.time.LocalDateTime;

public class Main {
  /**
   * Use this method to instantiate objects and test your code.
   */
  public static void main(String[] args) {


    Customer c1 = new Customer("Weihua", "Liu");
    Order o1 = new Order("KI908B", LocalDateTime.now(),c1);
    Item item1 = new Item("Bergers", o1,"Spicy Crispy",2);
    Ingredient ingre1 = new Ingredient(item1, "Potato Roll", "regular", 100.00);
    Nutrition n1=new Nutrition(ingre1,"Calcium","mcg", 30);
    Nutrition n2=new Nutrition(ingre1,"Cholesterol","mcg", 70);

    c1.setOrder(o1);
    ingre1.addNutrition(n1);
    ingre1.addNutrition(n2);

    // Show
    for (Nutrition n: ingre1.getNutritions()) {
      System.out.println(n);
    }

  }

}
