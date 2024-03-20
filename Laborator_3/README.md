# Laborator 3

An instance of the Vehicle Routing Problem (VRP) consists of depots, vehicles and clients.

* Each vehicle belongs to a single depot. It starts from there and it may return there at any time.
* Each client has a name and a visiting time interval.
* Each vehicle will perform a single tour, starting from its depot, visiting a number of clients, and ending in the same depot.
We consider the problem of allocating clients to vehicles, such that all clients are visited (if possible).

## Compulsory:
* Create an object-oriented model of the problem. You should have (at least) the following classes: Depot, Vehicle, Client.
* A client may be of two types, regular and premium. Use an enum in order to implement this feature.
* Each class should have appropriate constructors, getters and setters.
* Use the IDE features for code generation, such as generating getters and setters.
* The toString method form the Object class must be properly overridden for all the classes.
* Use the IDE features for code generation, for example (in NetBeans) press Alt+Ins or invoke the context menu, select "Insert Code" and then "toString()" (or simply start typing "toString" and then press Ctrl+Space).
* Create and print on the screen an object of each class.

# Output: 

Trip{
city='Paris'
, periodOfTime=Pair{first=2024-03-01T12:00, second=2024-03-15T19:00}
, attractions=[Attraction{name='Shadows and Lights - Cultural Olympiad', description='', location='Cité de la musique - Philharmonie de Paris, 221 avenue Jean Jaurès - 75019 Paris'}, Attraction{name='Notre Dame', description='medieval Catholic cathedral', location='Ile de la Cite, Paris, France'}, Attraction{name='La Défense de Paris', description='bronze statue by French sculptor Louis-Ernest Barrias', location='the Arche de la Défense, Paris, France'}]
}

Process finished with exit code 0
