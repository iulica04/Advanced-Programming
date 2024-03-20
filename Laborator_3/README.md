# Laborator 3
## Interfaces, Collections, Generics
A tourist is about to visit a city, in a period of time. In this city, there are various attractions: tourist sites, concerts, (football) games, etc. Each attraction has a name (title) and may have other common properties (such as a description, image, etc). Depending on its type, each location has various specific properties. If the location is a visitable, it must specify on what days of the week and at what hours is it open (can be visited, takes place, etc).  
If the location is payable, it must have the entry fee (the price of the ticket).  

## Compulsory:
* Create an object-oriented model of the problem. You should have at least the following classes Trip, Statue, Church, Concert. The natural ordering of their objects is given by their names.
* Create the interfaces Visitable and Payable. The classes above must implement these interfaces accordingly.
* The Trip class will contain the name of the city, the period of time and the List of attractions.
* Create at least one object of each class.

### Output: 

Trip{
city='Paris'
, periodOfTime=Pair{first=2024-03-01T12:00, second=2024-03-15T19:00}
, attractions=[Attraction{name='Shadows and Lights - Cultural Olympiad', description='', location='Cité de la musique - Philharmonie de Paris, 221 avenue Jean Jaurès - 75019 Paris'}, Attraction{name='Notre Dame', description='medieval Catholic cathedral', location='Ile de la Cite, Paris, France'}, Attraction{name='La Défense de Paris', description='bronze statue by French sculptor Louis-Ernest Barrias', location='the Arche de la Défense, Paris, France'}]
}

## Honmework: 
* Implement the visiting timetable of the attractions using a Map in which the keys are dates and the values are time intervals.
* Implement the time interval as a pair of LocalTime objects, using generics.
* In the Trip class, create a method to display the locations that are visitable and are not payable, sorted by their opening hour.
* Create default methods in the interface Visitable, that teturns the opening hour for a given date.
* Create the class TravelPlan. An instance of this class will specify in which day the tourist will visit each attraction.
* Create a travel plan and print it on the screen.

### Output: 
Trip{
city='Paris'
, periodOfTime=Pair{first=2024-03-18, second=2024-03-20}
, attractions=[Attraction{name='Shadows and Lights - Cultural Olympiad', description='', location='Cité de la musique - Philharmonie de Paris, 221 avenue Jean Jaurès - 75019 Paris'}, Attraction{name='Notre Dame', description='medieval Catholic cathedral', location='Ile de la Cite, Paris, France'}, Attraction{name='La Défense de Paris', description='bronze statue by French sculptor Louis-Ernest Barrias', location='the Arche de la Défense, Paris, France'}]
}
Attractions sorted by opening hour:   
Attraction{name='La Défense de Paris', description='bronze statue by French sculptor Louis-Ernest Barrias', location='the Arche de la Défense, Paris, France'}  
Attraction{name='Notre Dame', description='medieval Catholic cathedral', location='Ile de la Cite, Paris, France'}  
Number of days: 2  
Number of attractions: 3  
Number of atraction per day: 1  Rest: 1  
day 1  
Am adaugat toate locatiile free posibile de vizitat.  
In day 1: [Attraction{name='La Défense de Paris', description='bronze statue by French sculptor Louis-Ernest Barrias', location='the Arche de la Défense, Paris, France'}, Attraction{name='Notre Dame', description='medieval Catholic cathedral', location='Ile de la Cite, Paris, France'}]  
In day 2: [Attraction{name='Shadows and Lights - Cultural Olympiad', description='', location='Cité de la musique - Philharmonie de Paris, 221 avenue Jean Jaurès - 75019 Paris'}]  
