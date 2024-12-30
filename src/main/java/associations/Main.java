package associations;

public class Main {
  /**
   * Use this method to instantiate objects and test your code.
   */
  public static void main(String[] args) {
    Customer c1 = new Customer("Toler", "Larry");
    Building b1 = new Building("home", 84.4, 57.7, c1);
    c1.setBuilding(b1);
    Room rm1 = new Room("kitchen", "1st", b1);
    Device d1 = new Device("1234-abcd", "temperature", rm1, "bottom of the west wall");
    Reading r1 = new Reading(d1, "degrees F", 72);
    Reading r2 = new Reading(d1, "degrees F", 72.5);

    // Show
    for (Reading r: d1.getReadings()) {
      System.out.println(r);
    }

  }
  
}
