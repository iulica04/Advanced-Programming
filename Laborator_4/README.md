# Laborator 4

### Collections, Java Stream API
Consider a scenario where a group of people wants to make an arrangement by sharing vehicles in order to reach a destination (carpooling, car-sharing, ride-sharing).
Instead of everyone going with their own car, participants agree on the following:
* some of them will be drivers and some of them will be passengers;
*neach person has a destination (location where he/she wants to go);
* each driver is willing to pick a passenger in his car (only one), if they have a common destination.
Take into consideration the fact that, on the road to its destination, a driver may pass through other destinations.  
The problem is to match drivers and passengers, such that the number of matchings is maximum.

## Compulsory

* Create a Maven project.
* Create an object-oriented model of the problem.
* Create a random group of persons. Use streams in order to filter the drivers and the passengers.
* Put all the drivers in a LinkedList and print them sorted by their age.
* Put all the passengers in a TreeSet and print them sorted by their name.

### Output
[Name: Driver4, Age: 34, Destination: Destination11, Type: driver  
, Name: Driver2, Age: 39, Destination: Destination21, Type: driver  
, Name: Driver0, Age: 43, Destination: Destination01, Type: driver  
]
[Name: Passenger1, Age: 29, Destination: Destination2, Type: passenger  
, Name: Passenger3, Age: 13, Destination: Destination1, Type: passenger  
, Name: Passenger5, Age: 26, Destination: Destination3, Type: passenger  
]
