# CinemaRoom_REST_Service
## Description
Cinema tickets sales service.
## Features
- Customers are able to purchase and refund tickets
- Statistics of the venue is available
- Exception handling
## Dependencies
-   
-   
-  
## Running the project
To launch the service compile the file:  
CinemaRoom_REST_Service/task/src/cinema/Main.java
## API 
- ```GET /seats``` returns the information about the movie theatre: the rows, columns, and available seats. 

Our cinema room has 9 rows with 9 seats each; 

- ```POST /purchase``` returns a ticket with UUID token as JSON object, marks a booked ticket as purchased. The ticket is not available anymore.

Request body: ```row``` and  ```column``` numbers of the purchased ticket;

- ```POST /return``` returns returned ticket as JSON object, marks the ticket as available again.

Request body: ```token``` that identifies the ticket in the cinema;

- ```POST /stats``` returns the movie theatre statistics. 

URL parameters: a password key with a ```super_secret``` value;

Statistics values description:

```current_income``` — shows the total income of sold tickets.

```number_of_available_seats``` — shows how many seats are available.

```number_of_purchased_tickets``` — shows how many tickets were purchased.
## Usage
**Example 1**    
- ```GET /seats``` request

Response body:
```
{
   "total_rows":9,
   "total_columns":9,
   "available_seats":[
      {
         "row":1,
         "column":1
      },
      {
         "row":1,
         "column":2
      },
      {
         "row":1,
         "column":3
      },

      ........

      {
         "row":9,
         "column":8
      },
      {
         "row":9,
         "column":9
      }
   ]
}
```
- ```POST /purchase``` correct request

Request body:
```
{
    "row": 3,
    "column": 4
}
```

Response body:
```
{
    "token": "e739267a-7031-4eed-a49c-65d8ac11f556",
    "ticket": {
        "row": 3,
        "column": 4,
        "price": 10
    }
}
```
- ```POST /purchase``` request, the ticket is already booked

Request body:
```
{
    "row": 3,
    "column": 4
} 
```

Response body:
```
{
    "error": "The ticket has been already purchased!"
}
```
- ```POST /purchase``` request, a wrong row number

Request body:
```
{
    "row": 15,
    "column": 4
}
```

Response body:
```
{
    "error": "The number of a row or a column is out of bounds!"
}
```
- ```POST /return``` request with the correct token

Request body:
```
{
    "token": "e739267a-7031-4eed-a49c-65d8ac11f556"
}
```

Response body:
```
{
    "returned_ticket": {
        "row": 1,
        "column": 2,
        "price": 10
    }
}
```
- ```POST /return``` with an expired token

Request body:
```
{
    "token": "e739267a-7031-4eed-a49c-65d8ac11f556"
}
```

Response body:
```
{
    "error": "Wrong token!"
}
```
- ```POST /stats``` request with no parameters

Response body:
```
{
    "error": "The password is wrong!"
}
```
- ```POST /stats``` request with the correct password

Response body:
```
{
    "current_income": 30,
    "number_of_available_seats": 78,
    "number_of_purchased_tickets": 3
}
```
## Additional info
To find more about this project, please visit https://hyperskill.org/projects/189.
