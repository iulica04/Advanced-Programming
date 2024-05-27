# Laborator 11
### REST Services
Continue the application created at lab 8 or lab 9 integrating the following functionalities:

Implement REST services needed to comunicate with the server side data (CRUD).
The main specifications of the application are:

## Compulsory
- Create a Spring Boot project that will contain the REST services for comunicating with the server data.
- Create a REST controller containing a method for:
  - obtaining the list of authors, via a HTTP GET request.
- Test your service using the browser and/or Postman, or RestMan, etc.

### Output

 - url : http://localhost:8090/api/authors
 - JSON: 
 ```[
    {
        "id": 1,
        "name": "J.K. Rowling"
    },
    {
        "id": 2,
        "name": "Mary GrandPrĂ©"
    },
    {
        "id": 3,
        "name": "W. Frederick Zimmerman"
    },
    {
        "id": 4,
        "name": "Douglas Adams"
    },
    {
        "id": 5,
        "name": "Stephen Fry"
    },
    {
        "id": 6,
        "name": "Bill Bryson"
    },
    {
        "id": 7,
        "name": "J.R.R. Tolkien"
    },
    {
        "id": 8,
        "name": "Alan  Lee"
    },
    {
        "id": 9,
        "name": "Chris   Smith"
    },
    {
        "id": 10,
        "name": "Christopher  Lee"
    },
    {
        "id": 11,
        "name": "Richard Taylor"
    },
    {
        "id": 12,
        "name": "Jude Fisher"
    },
    {
        "id": 13,
        "name": "Dave Thomas"
    },
    {
        "id": 14,
        "name": "David Heinemeier Hansson"
    },
    {
        "id": 15,
        "name": "Leon Breedt"
    },
    {
        "id": 16,
        "name": "Mike Clark"
    },
    {
        "id": 17,
        "name": "Thomas  Fuchs"
    },
    {
        "id": 18,
        "name": "Andreas  Schwarz"
    },
    {
        "id": 19,
        "name": "Gary Paulsen"
    },
    {
        "id": 20,
        "name": "Donna Ickes"
    },
    {
        "id": 21,
        "name": "Edward Sciranko"
    },
    {
        "id": 22,
        "name": "Keith Vasconcelles"
    }, .............
```

## Homework
- Create REST services for:
  - obtaining the list of books, via a HTTP GET request.
  - adding a new book, via a HTTP POST request.
  - modifying the name of a book, via a HTTP PUT request.
  - deleting a book, via a HTTP DELETE request.
- Create a simple client application that invokes the services above, using the support offered by Spring Boot.
- Document your services using Swagger or a similar tool.

### Output

- url (GET method) : http://localhost:8090/api/books
    ```
  [
    {
        "id": 1,
        "title": "Harry Potter and the Half-Blood Prince (Harry Potter  #6)",
        "publisher_date": "2006-09-16",
        "language": "eng",
        "number_of_pages": 652,
        "average_rating": 4.57,
        "isbn": "0439785960",
        "isbn13": "9780439785969",
        "rating_count": 2095690,
        "text_reviews_count": 27591,
        "authorNames": [
            "J.K. Rowling",
            "Mary GrandPrĂ©"
        ]
    },
    {
        "id": 2,
        "title": "Harry Potter and the Order of the Phoenix (Harry Potter  #5)",
        "publisher_date": "2004-09-01",
        "language": "eng",
        "number_of_pages": 870,
        "average_rating": 4.49,
        "isbn": "0439358078",
        "isbn13": "9780439358071",
        "rating_count": 2153167,
        "text_reviews_count": 29221,
        "authorNames": [
            "J.K. Rowling",
            "Mary GrandPrĂ©"
        ]
    },
    {
        "id": 3,
        "title": "Harry Potter and the Chamber of Secrets (Harry Potter  #2)",
        "publisher_date": "2003-11-01",
        "language": "eng",
        "number_of_pages": 352,
        "average_rating": 4.42,
        "isbn": "0439554896",
        "isbn13": "9780439554893",
        "rating_count": 6333,
        "text_reviews_count": 244,
        "authorNames": [
            "J.K. Rowling",
            "Mary GrandPrĂ©"
        ]
    },
    {
        "id": 4,
        "title": "Harry Potter and the Prisoner of Azkaban (Harry Potter  #3)",
        "publisher_date": "2004-05-01",
        "language": "eng",
        "number_of_pages": 435,
        "average_rating": 4.56,
        "isbn": "043965548X",
        "isbn13": "9780439655484",
        "rating_count": 2339585,
        "text_reviews_count": 36325,
        "authorNames": [
            "J.K. Rowling",
            "Mary GrandPrĂ©"
        ]
    },
    {
        "id": 5,
        "title": "Harry Potter Boxed Set  Books 1-5 (Harry Potter  #1-5)",
        "publisher_date": "2004-09-13",
        "language": "eng",
        "number_of_pages": 2690,
        "average_rating": 4.78,
        "isbn": "0439682584",
        "isbn13": "9780439682589",
        "rating_count": 41428,
        "text_reviews_count": 164,
        "authorNames": [
            "J.K. Rowling",
            "Mary GrandPrĂ©"
        ]
    },
    { ....... 
  ```
- url (POST method): http://localhost:8090/api/books  
body : 
`{
  "title": "Numele cărții",
  "publisher_date": "2024-05-27",
  "language": "Engleză",
  "number_of_pages": 300,
  "average_rating": 4.5,
  "isbn": "1234567890",
  "isbn13": "9781234567890",
  "rating_count": 100,
  "text_reviews_count": 50,
  "authors": ["Autor1", "Autor2"]
  }`

  ```{
    "id": 10350,
    "title": "Numele cărții",
    "authors": [
        {
            "id": 9249,
            "name": "Autor1"
        },
        {
            "id": 9250,
            "name": "Autor2"
        }
    ],
    "publisher_date": "2024-05-27",
    "language": "Engleză",
    "number_of_pages": 300,
    "average_rating": 4.5,
    "isbn": "1234567890",
    "isbn13": "9781234567890",
    "rating_count": 100,
    "text_reviews_count": 50
  } 
  ```
- url (PUT method) : http://localhost:8090/api/books/3
  ```
  {
    "id": 3,
    "title": "noul nume",
    "authors": [
        {
            "id": 2,
            "name": "Mary GrandPrĂ©"
        },
        {
            "id": 1,
            "name": "J.K. Rowling"
        }
    ],
    "publisher_date": "2003-11-01",
    "language": "eng",
    "number_of_pages": 352,
    "average_rating": 4.42,
    "isbn": "0439554896",
    "isbn13": "9780439554893",
    "rating_count": 6333,
    "text_reviews_count": 244
  }
  ```
  
- url (DELETE method) : http://localhost:8090/api/books/3 (si cu id-ul 2)
  ```
   {
        "id": 1,
        "title": "Harry Potter and the Half-Blood Prince (Harry Potter  #6)",
        "publisher_date": "2006-09-16",
        "language": "eng",
        "number_of_pages": 652,
        "average_rating": 4.57,
        "isbn": "0439785960",
        "isbn13": "9780439785969",
        "rating_count": 2095690,
        "text_reviews_count": 27591,
        "authorNames": [
            "J.K. Rowling",
            "Mary GrandPrĂ©"
        ]
    },
    {
        "id": 4,
        "title": "Harry Potter and the Prisoner of Azkaban (Harry Potter  #3)",
        "publisher_date": "2004-05-01",
        "language": "eng",
        "number_of_pages": 435,
        "average_rating": 4.56,
        "isbn": "043965548X",
        "isbn13": "9780439655484",
        "rating_count": 2339585,
        "text_reviews_count": 36325,
        "authorNames": [
            "J.K. Rowling",
            "Mary GrandPrĂ©"
        ]
    },
  ```


