# CSC 241 Class Associations
In this assignment, you will create a set of Java classes with associations between them. We are going to use these classes to simulate the data used by a home automation system. These will allow us to work with information about sensor devices, rooms, and buildings.

Read the specification below for each Java class. Empty source files for each class have been placed in the `src/main/java/associations` folder, and you should edit each as necessary. Each of these class definitions will require instance variables, so you should determine the name and type of each to support the required methods. In general, all instance variables should be declared `private`. Make sure to follow the exact naming conventions listed in the specification.

## Specification

### Customer
This class represents a person using the system. Implement each of these methods:
- getLastName() - Returns a String that is the customer’s last name
- getFirstName() - Returns a String that is the customer’s first name
- getBuilding() - Returns a reference to the Building object (see below) associated with this customer
- setBuilding(Building) - Sets the Building for this customer
- A constructor that initializes the last name and first name.

### Building
This class represents a building that is being monitored. A building is associated with a Customer and multiple Rooms.  Implement each of the following methods:
- getName() - returns a String that is the name of the building
- getLongitude - returns a double that is the building's longitude
- getLatitude - returns a double that is the building's latitude
- getCustomer() - Returns a reference to the Customer object associated with this building
- addRoom(Room) - Adds a Room object reference (see below) to a building
- getRooms() - Returns an array of Room objects associated with a building
- A constructor that initializes the name, longitude, latitude, and Customer

### Room
This class represents a Room. It is asscoiated with a Building and multiple Devices.
- getName() - Returns a String that is the room name
- getFloor() - Returns a String that is the room's floor within the building
- getBuilding() - Returns a reference to the associated Building object
- addDevice(Device) - Add a Device (see below) to this room
- getDevices() - Returns an array of Device object references
- A constructor that initializes the name, floor, and building

### Device
This class represents an individual sensor device. A device can produce multiple Readings.
- getId() - Returns a String that is the sensor's identifier
- getType() - Returns a String that is the sensor's type
- getRoom() - Returns a reference to the Room where the sensor is located
- getLocation() - Returns a String indicating where in the Room the device was placed
- addReading(Reading) - Adds a Reading (see below) to a device
- getReadings() - Returns an array of device readings 
- A constructor that initializes id, type, room, and location

### Reading
This class represents a reading produced by a device
- getDevice() - returns a reference to the Device that produced the reading
- getUnits() - returns a String representing the units of measurement
- getValue() - returns a double corresponding to the reading's value
- getTimestamp() - Returns a reference to LocalDateTime object that is the timestamp of the reading
- A constructor method that initializes the Device, units, and value, and sets the timestamp to the current system time

## Testing
When you push your code back to your repository, GitHub will initiate a series of tests to verify the correct operation of each of the methods above.
