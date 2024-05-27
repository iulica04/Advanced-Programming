# Laborator 9

## Compulsory 

- Create a persistence unit (use EclipseLink or Hibernate or other JPA implementation).
- Verify the presence of the persistence.xml file in your project. Make sure that the driver for EclipseLink or Hibernate was added to to your project classpath (or add it yourself).
- Define the entity classes for your model (at least one) and put them in a dedicated package. You may use the IDE support in order to generate entity classes from database tables.
- Create a singleton responsible with the management of an EntityManagerFactory object.
- Define repository clases for your entities (at least one). They must contain the following methods:
  - create - receives an entity and saves it into the database;
  - findById - returns an entity based on its primary key;
  - findByName - returns a list of entities that match a given name pattern. Use a named query in order to implement this method.
- Test your application.



## Homework 

- In addition to the properties already existing, consider that each book has a publishing house.
- Create all entity classes and repositories. Implement properly the one-to-many and many-to-many relationships.
- Create a generic AbstractRepository using generics in order to simplify the creation of the repository classes. You may take a look at the CrudRepository interface from Spring Framework.
- Use the Java logger in order to log the exceptions and the execution time of your JPQL statements (you should write the log messages both on screen and in a file).

### Output
```
Author found by id 1400: Jacqueline Hazard Bridgeman   
Author found by name John Leech: John Leech
No books published by Example Publishing House
```
