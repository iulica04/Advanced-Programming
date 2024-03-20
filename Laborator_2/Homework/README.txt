## Homework
* Create classes that describe the problem and its solution.
* Override the equals method form the Object class for the Depot, Vehicle, Client classes. The problem should not allow adding the same depot, vehicle or client twice.
* Vehicles may be of different types. Create dedicated classes for trucks and drones. Trucks have a capacity property, while drones have a maximum flight duration (these properties will not be used by the algorithms). The Vehicle class will become abstract.
* Implement the method getVehicles in the Problem class, returning an array of all the vehicles, form all depots.
* Assume that the times required to travel between the locations (depot-to-client or client-to-client) are known (You may generate them randomly). Implement a simple greedy algorithm for allocating clients to vehicles.
* Write doc comments in your source code and generate the class documentation using javadoc.

# Output: 

Time interval is: 696 hours.  
Depot{depotName='Scania Depot', vehiclesInDepot=[Vehicle{vehicleModel='Scania Seria S', depot=Scania Depot}, Vehicle{vehicleModel='Scania Seria R', depot=Scania Depot}]}  
Depot{depotName='DJI Depot', vehiclesInDepot=[Vehicle{vehicleModel='DJI Mini 3 Pro', depot=DJI Depot}, Vehicle{vehicleModel='DJI Mini 2 SE', depot=DJI Depot}]}  
Vehicle{vehicleModel='DJI Mini 3 Pro', depot=DJI Depot}  
Vehicle{vehicleModel='DJI Mini 2 SE', depot=DJI Depot}  
Client{clientName='Vreme Iulia', timeInterval=TimeInterval{startTime=2024-02-01T12:00, endTime=2024-03-01T12:00}, clientType=PREMIUM}  
Client{clientName='Pirlac Diana', timeInterval=TimeInterval{startTime=2024-07-01T14:00, endTime=2024-12-15T15:00}, clientType=REGULAR}  
Tour{vehicle=Vehicle{vehicleModel='Scania Seria S', depot=Scania Depot}, clients=[Client{clientName='Vreme Iulia', timeInterval=TimeInterval{startTime=2024-02-01T12:00, endTime=2024-03-01T12:00}, clientType=PREMIUM}, Client{clientName='Vreme Iulia', timeInterval=TimeInterval{startTime=2024-02-01T12:00, endTime=2024-03-01T12:00}, clientType=PREMIUM}]}  
All vehicles from all depots:   
Vehicle{vehicleModel='Scania Seria S', depot=Scania Depot}  
Vehicle{vehicleModel='Scania Seria R', depot=Scania Depot}  
Vehicle{vehicleModel='DJI Mini 3 Pro', depot=DJI Depot}  
Vehicle{vehicleModel='DJI Mini 2 SE', depot=DJI Depot}  
Intervals for depot:   
10 7 3 20 
  
Intervals for clients:   
0 12 3 5   
6 0 10 24   
1 13 0 9   
6 5 20 0   
Tour{vehicle=Vehicle{vehicleModel='Scania Seria S', depot=Scania Depot}, clients=[Client{clientName='Ana', timeInterval=TimeInterval{startTime=2024-02-01T12:00, endTime=2024-03-01T12:00}, clientType=REGULAR}, Client{clientName='Vreme Iulia', timeInterval=TimeInterval{startTime=2024-02-01T12:00, endTime=2024-03-01T12:00}, clientType=PREMIUM}, Client{clientName='Andrei', timeInterval=TimeInterval{startTime=2024-07-01T14:00, endTime=2024-12-15T15:00}, clientType=PREMIUM}, Client{clientName='Pirlac Diana', timeInterval=TimeInterval{startTime=2024-07-01T14:00, endTime=2024-12-15T15:00}, clientType=REGULAR}]}  

