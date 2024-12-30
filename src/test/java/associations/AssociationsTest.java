package associations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class AssociationsTest {

  @Test
  void customerTest() {
    // Instantiate a customer
    Customer c1 = new Customer("Early", "James");
    assertEquals("Early", c1.getLastName(), "Last name test");
    assertEquals("James", c1.getFirstName(), "First name test");
    assertNull(c1.getBuilding(), "Initial Building reference should be null");
  }

  @Test
  void buildingTest() {
    // Instantiate a customer
    Customer c1 = new Customer("Early", "James");

    // Create a building
    Building b1 = new Building("home", 84.4, 57.7, c1);

    // Check values
    assertEquals("home", b1.getName(), "Name test");
    assertEquals(84.4, b1.getLongitude(), "Longitude test");
    assertEquals(57.7, b1.getLatitude(), "Latitude test");
    assertEquals(c1, b1.getCustomer(), "Customer test");
    assertEquals(0, b1.getRooms().length, "Initial rooms array length test");


    // Associate building with customer
    c1.setBuilding(b1);
    assertEquals(b1, c1.getBuilding(), "Customer building test");
  }

  @Test
  void roomTest() {
    // Instantiate a customer
    Customer c1 = new Customer("Early", "James");

    // Instantiate a building
    Building b1 = new Building("home", 84.4, 57.7, c1);

    // Create a room
    Room r1 = new Room("kitchen", "1st", b1);

    // Check values
    assertEquals("kitchen", r1.getName(), "Name test");
    assertEquals("1st", r1.getFloor(), "Floor test");
    assertEquals(0, r1.getDevices().length, "Initial devices array length test");
    assertEquals(b1, r1.getBuilding(), "Building reference test");

    // Associate with building
    b1.addRoom(r1);
    // Check that building was updated
    assertEquals(1, b1.getRooms().length, "Testing rooms array length");
  }

  @Test
  void deviceTest() {
    // Instantiate a customer
    Customer c1 = new Customer("Early", "James");

    // Instantiate a building
    Building b1 = new Building("home", 84.4, 57.7, c1);

    // Instantiate a room
    Room r1 = new Room("kitchen", "1st", b1);

    // Create a device
    Device d1 = new Device("abcd-1234", "Temperature",  r1, "Bottom of west wall");

    // Check values
    assertEquals("abcd-1234", d1.getId(), "Id test");
    assertEquals("Temperature", d1.getType(), "Type test");
    assertEquals(r1, d1.getRoom(), "Room reference test");
    assertEquals("Bottom of west wall", d1.getLocation(), "Location test");
    assertEquals(0, d1.getReadings().length, "Initial Readings length test");

    // Check that we can add a device to a room
    r1.addDevice(d1);
    assertEquals(1, r1.getDevices().length, "Testing devices array length");
  }

  @Test
  void readingTest() {
    // Instantiate a customer
    Customer c1 = new Customer("Early", "James");

    // Instantiate a building
    Building b1 = new Building("home", 84.4, 57.7, c1);

    // Instantiate a room
    Room r1 = new Room("kitchen", "1st", b1);

    // Instantiate a device
    Device d1 = new Device("abcd-1234", "Temperature",  r1, "Bottom of west wall");

    // Create a reading
    LocalDateTime now = LocalDateTime.now(); // Get system time
    Reading rd1 = new Reading(d1, "Degrees F", 67.5);
    long delta = Duration.between(now,rd1.getTimestamp()).toMillis();
    System.out.println("DELTA: " + delta);

    // Check values
    assertEquals(d1, rd1.getDevice(), "Device reference test");
    assertEquals("Degrees F", rd1.getUnits(), "Units test");
    assertEquals(67.5, rd1.getValue(), "Value test");
    assertTrue(delta < 4, "Timestamp less than 4ms");

    // Add reading to a device
    d1.addReading(rd1);
    // Check that reading was added
    assertEquals(1, d1.getReadings().length, "Testing readings array length");
  }
}
