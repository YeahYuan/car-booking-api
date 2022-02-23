# car-booking-api
Assignment for Prudential


## How to start

1. Create a database and run `sql/car_booking.sql` file;
2. Modify the database configuration in `src/main/resources/application.properties`;
3. Start the program;
4. Access to `http://localhost:8080/swagger-ui.html#` Testing;
5. Unit tests can be run `src/test/java/com/yuanjingjing/carbooking/TestCarBooking.java` .


## API design

Assumption:  
Only supports daily, continuous rental, regardless of the pick-up location time and other information.

#### 1. GET  /models  
   query all models , stock and already booking times.  
     
   **_Input parameters_**  
   
| name | type | description                                 | example | required |  
| ---- | ---- | ------------------------------------------- | ------- | -------- |  
| days | int  | Query days (default is the next seven days) | 5       | false    |  
  
    
   **_Output parameters_**  
   
| name      | type   | description                                                  | example                                               |
| --------- | ------ | ------------------------------------------------------------ | ----------------------------------------------------- |
| id        | int    | Primary key id                                               | 1                                                     |
| modelName | String | model name                                                   | BMW 650                                               |
| stock     | int    | model total stock（including  booked）                       | 2                                                     |
| dateMap   | String | key is date，value is the booked number.So the number that can be booked is the stock minus the value | { "2022-02-15": 1, "2022-02-14": 2, "2022-02-18": 2 } |
       
   Output parameters example
```json
    [ 
       {
       "id": 1,
       "modelName": "BMW 650",
       "stock": 2,
       "dateMap": {}
       },
       {
       "id": 2,
       "modelName": "Toyota Camry",
       "stock": 2,
       "dateMap": {
       "2022-02-15": 1,
       "2022-02-14": 2,
       "2022-02-18": 2
       }
       }
    ]
```

#### 2. POST /booking 预订车辆
   Description: Verify the validity of the date and check whether it is out of stock  
   
   **_Input parameters_**  
      
   | name      | type | description          | example    | required |
   | --------- | ---- | -------------------- | ---------- | -------- |
   | modelId   | int  | model primary key id | 1          | true     |
   | startDate | date | booking start date   | 2022-02-15 | true     |
   | endDate   | date | booking end date     | 2022-02-15 | true     | 
     
 Input parameters example
 
```json
    {
       "modelId": 2,
       "startDate": "2022-02-15",
       "endDate": "2022-02-15",
    }
```
   **_Output parameters_**  
      
   | name | type   | description                                     | example         |
   | ---- | ------ | ----------------------------------------------- | --------------- |
   | code | int    | 0 indicates success and non-0 indicates failure | 500             |
   | msg  | String | message of request                              | Already booked! |
           
   Output parameters example
   
   ```json
       { 
          "msg": "Already booked!", 
          "code": 500 
       }
   ```


