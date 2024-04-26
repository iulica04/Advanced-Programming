# Laborator 8

### JDBC
Write an application that allows to connect to a relational database by using JDBC, submit SQL statements and display the results.
The application will manage a collection of books. Each book has some properties, such as: title, one or more authors, language, publication date, number of pages, etc..

## Compulsory
* Create a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.).
* Write an SQL script that will create the required tables in order to store the books.
* Update pom.xml, in order to add the database driver to the project libraries.
* Create a singleton class in order to manage a connection to the database.
* Create a DAO class for managing the authors.

## Homework 
* Create an object-oriented model of the data managed by the Java application.
* Implement all the DAO classes.
* Use a connection pool in order to manage database connections, such as C3PO, HikariCP or Apache Commons DBCP.
* Create a tool to import data from a real dataset, such as Goodreads-books or other.

## Ouput for Compulosry + Homework: 

Genres:  
  --> Id: 1, Genre: Horror  
  --> Id: 2, Genre: Romance  
  --> Id: 3, Genre: Science Fiction   
  --> Id: 4, Genre: Fantasy  
  --> Id: 5, Genre: Mystery  
  --> Id: 6, Genre: Thriller  
  --> Id: 7, Genre: Historical Fiction  
  --> Id: 8, Genre: Biography  
  --> Id: 9, Genre: Autobiography  
  --> Id: 10, Genre: Self-Help  
  --> Id: 11, Genre: Comedy  
  ..... more others (I print all but I will not write them here...)

Authors:  
--> Id: 1, Name: J.K. Rowling  
--> Id: 2, Name: Mary GrandPré  
--> Id: 3, Name: W. Frederick Zimmerman  
--> Id: 4, Name: Douglas Adams  
--> Id: 5, Name: Stephen Fry  
--> Id: 6, Name: Bill Bryson  
--> Id: 7, Name: J.R.R. Tolkien  
--> Id: 8, Name: Alan  Lee  
--> Id: 9, Name: Chris   Smith  
--> Id: 10, Name: Christopher  Lee  
--> Id: 11, Name: Richard Taylor  
..... more others (all authors from books.csv : 9236 authors)

Books:  
Book with id: 7646  
--> Title: The Polar Express  
--> Authors:  
----> Chris Van Allsburg  
--> Publisher Date: 2005-10-19  
--> Language: en-US  
--> Number of Pages: 32    
--> Publisher: HMH Books for Young Readers  
--> Average Rating: 4.3  
--> ISBN: 061861169X  
--> ISBN13: 9780618611690  
--> Rating Count: 88  
--> Text Reviews Count: 13  


Book with id: 7647  
--> Title: Trip To The North Pole (The Polar Express: The Movie)  
--> Authors:   
----> Ellen Weiss  
----> Doyle Partners  
----> Robert Zemeckis  
--> Publisher Date: 2004-10-12  
--> Language: eng  
--> Number of Pages: 128  
--> Publisher: HMH Books for Young Readers  
--> Average Rating: 3.62  
--> ISBN: 061847790X  
--> ISBN13: 9780618477906  
--> Rating Count: 55  
--> Text Reviews Count: 7  


Book with id: 7648  
--> Title: Blow Fly (Kay Scarpetta  #12)  
--> Authors:  
----> Patricia Cornwell  
--> Publisher Date: 2004-09-07  
--> Language: eng  
--> Number of Pages: 467  
--> Publisher: Berkley  
--> Average Rating: 3.77  
--> ISBN: 0425198731  
--> ISBN13: 9780425198735  
--> Rating Count: 31942  
--> Text Reviews Count: 732  

....more others(10347 books in total) (csv file contains 11127 book, but some data of them are invalid (like the publisher date is november 31))
