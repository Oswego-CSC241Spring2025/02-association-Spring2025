# CSC 241 Design Classes
# All About Bergers Restaurant  
In this assignment, you will create a set of Java classes with associations between them.
We are going to use these classes to simulate the data using for the All About Bergers Restaurant . 
These will allow us to work with information about customers, orders and items in the orders.

Read the specification below for each Java class. Empty source files for each class have been placed in the `src/main/java/associations` folder, and you should edit each as necessary. Each of these class definitions will require instance variables, so you should determine the name and type of each to support the required methods. In general, all instance variables should be declared `private`. Make sure to follow the exact naming conventions listed in the specification.

## Specification

### Customer
This class represents a customer visiting the restaurant. Implement each of these methods:

- A constructor that initializes the last name and first name
- getLastName() - Returns a String that is the customer’s last name
- getFirstName() - Returns a String that is the customer’s first name
- getOrder() - Returns a reference to the Order object associated with this customer
- setOrder(Order) - Sets the Order for this customer

### Order
This class represents an order placed by a customer. An Order is associated with a Customer and multiple Items.  Implement each of the following methods:
- A constructor that initializes the orderNum,orderTime and customer 
  - note 1: pay attention on the type of orderTime. 
  - note 2: Don't forget to create the empty item arraylist.

- getOrderNum() - returns a String that is the order's order number 
- getOrderTime() - Returns a reference to LocalDateTime object that is the time an order is placed 
- getCustomer() - Returns a reference to the Customer object associated with this building 
- addItem(Item) - Adds an Item object reference to an order 
- getItems() - Returns an array of Item objects associated with an order 
  - note: Use ArrayList to hold all the Item object in an order. But this method will return an array of Item objects.


### Item
This class represents an Item. It is asscoiated with an Order and multiple Ingredient.
- getName() - Returns a String that is the room name
- getFloor() - Returns a String that is the room's floor within the building
- getBuilding() - Returns a reference to the associated Building object
- addDevice(Device) - Add a Device (see below) to this room
- getDevices() - Returns an array of Device object references
- A constructor that initializes the name, floor, and building

### Ingredient
This class represents an Ingredient. It is asscoiated with an Ingredient and some Nutrition.
- A constructor that initializes the type,order, name and quantity 
- getType() - Returns a String that is the type of an item 
- getOrder() - Return a reference to the Order object associated with this Item 
- getName() - Returns a String that is the name of an item 
- getQuantity() - Returns a int that is the number of item ordered 
- addIngredients(Ingredients) - Add an Ingredient to this Item 
- getIngredients() - Returns an array of Ingredients object references


### Nutrition
This class represents the Nutrition included in an ingredient 
- A constructor method that initializes the Ingredient, name, units,and amount.
- getIngredient() - returns a reference to the Ingredient that contains this nutrition. 
- getUnits() - returns a String representing the units of measurement 
- getAmount() - returns a double corresponding to the nutrition's value 
- getName() - Returns String representing the name of the nutrition

## Testing
When you push your code back to your repository, GitHub will initiate a series of tests to verify the correct operation of each of the methods above.
