##Compulsory: 
* Create an object-oriented model of the problem. You should have (at least) the following classes: Depot, Vehicle, Client.
* A client may be of two types, regular and premium. Use an enum in order to implement this feature.
* Each class should have appropriate constructors, getters and setters.
* Use the IDE features for code generation, such as generating getters and setters.
* The toString method form the Object class must be properly overridden for all the classes.
* Use the IDE features for code generation, for example (in NetBeans) press Alt+Ins or invoke the context menu, select "Insert Code" and then "toString()" (or simply start typing "toString" and then press Ctrl+Space).
* Create and print on the screen an object of each class.

### Output:
Time interval is: 696 hours.  
  
Depot{depotName='Audi Depot', vehiclesInDepot=[Vehicle{vehicleModel='Audi A6', depot=Audi Depot}, Vehicle{vehicleModel='Audi A5', depot=Audi Depot}, Vehicle{vehicleModel='Audi RS7', depot=Audi Depot}]}  
Depot{depotName='Toyota Depot', vehiclesInDepot=[]}  
Vehicle{vehicleModel='Toyota Elantra', depot=Toyota Depot}  
Vehicle{vehicleModel='Audi RS7', depot=Audi Depot}  
Client{clientName='Vreme Iulia', timeInterval=TimeInterval{startTime=2024-02-01T12:00, endTime=2024-03-01T12:00}, clientType=PREMIUM}  
Client{clientName='Pirlac Diana', timeInterval=TimeInterval{startTime=2024-07-01T14:00, endTime=2024-12-15T15:00}, clientType=REGULAR}  
Tour{vehicle=Vehicle{vehicleModel='Toyota Elantra', depot=Toyota Depot}, clients=[Client{clientName='Vreme Iulia', timeInterval=TimeInterval{startTime=2024-02-01T12:00, endTime=2024-03-01T12:00}, clientType=PREMIUM}, Client{clientName='Vreme Iulia', timeInterval=TimeInterval{startTime=2024-02-01T12:00, endTime=2024-03-01T12:00}, clientType=PREMIUM}]}  

