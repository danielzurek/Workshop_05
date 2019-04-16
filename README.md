# JEE Workshop V

REST API of a book store or a library.

## Technologies

REST API, JSON, Spring MVC, Spring Boot, ...

## References

1. [Slides](https://materialy.coderslab.pl/build/JEE_Presentations/v3.1/M_05_S_03_Warsztaty_5?1544697634#/)

## Requirements

* Apache Maven (3.5.2)
* JDK 8 (Oracle 1.8.0_191)

## Running

Build runnable Java archive with Spring Boot Maven plugin.

```shell
$ mvn package
```

Run JAR directly.

```shell
$ java -jar target/bookstore-0.0.1-SNAPSHOT.jar
```

## API

### GET /books

Retrieve all books.

#### Request

```shell
$ curl -s -X GET http://localhost:8080/books/ | python -m json.tool
```

#### Response

```json
[
    {
        "author": "Bruce Eckel",
        "id": 1,
        "isbn": "9788324631766",
        "publisher": "Helion",
        "title": "Thinking in Java",
        "type": "programming"
    },
    {
        "author": "Sierra Kathy, Bates Bert",
        "id": 2,
        "isbn": "9788324627738",
        "publisher": "Helion",
        "title": "Rusz glowa, Java.",
        "type": "programming"
    },
    {
        "author": "Cay Horstmann, Gary Cornell",
        "id": 3,
        "isbn": "9780130819338",
        "publisher": "Helion",
        "title": "Java 2. Podstawy",
        "type": "programming"
    }
]
```

### GET /books/{id}

Retrieve a book with the given ID.

#### Request

```shell
$ curl -s -X GET http://localhost:8080/books/1 | python -m json.tool
```

#### Response

```json
{
    "author": "Bruce Eckel",
    "id": 1,
    "isbn": "9788324631766",
    "publisher": "Helion",
    "title": "Thinking in Java",
    "type": "programming"
}
```

### POST /books

Add a new book (will automatically assign next available ID).

#### Request

```shell
$ curl -s -X POST http://localhost:8080/books -H 'Content-Type: application/json' --data '{"isbn": "9780134685991", "title": "Effective Java", "author": "Joshua Bloch", "publisher": "Addison-Wesley", "type": "programming"}' | python -m json.tool
```

#### Response

```json
{
    "author": "Joshua Bloch",
    "id": 4,
    "isbn": "9780134685991",
    "publisher": "Addison-Wesley",
    "title": "Effective Java",
    "type": "programming"
}
```

### PUT /books/{id}

Update one or more fields of an existing book (except for ID field).

#### Request

```shell
$ curl -s -X PUT http://localhost:8080/books/1 -H 'Content-Type: application/json' --data '{"type": "fiction", "title": "Foobar"}' | python -m json.tool
```

#### Response

```json
{
    "author": "Bruce Eckel",
    "id": 1,
    "isbn": "9788324631766",
    "publisher": "Helion",
    "title": "Foobar",
    "type": "fiction"
}
```

### DELETE /books/{id}

Delete a book with the given ID.

#### Request

```shell
$ curl -s -X DELETE http://localhost:8080/books/1 | python -m json.tool
```

#### Response

```json
{
    "author": "Bruce Eckel",
    "id": 1,
    "isbn": "9788324631766",
    "publisher": "Helion",
    "title": "Foobar",
    "type": "fiction"
}
```
