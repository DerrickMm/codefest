**How to setup:**

1.Make sure you have Java installed in your computer.

2.Clone the repository source.

3.Import the source as a Maven project in your preferred IDE.

4.Run the application as a Java application.

5.It will launch the service and give you a port number.

6.If you do not have an IDE you can run the following command.

`$ mvn spring-boot:run`

https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-running-your-application.html

follow the link for more information.


**Documentation:**

**Simple Bank Account API**
----
  _This is a simple API for a bank account, it has two POST endpoints which are: withdraw and deposit. It also has two get endpoints which are balance and transactions._

* **URL**

  _/balance_

* **Method:**
  


  `GET` 
  

* **Success Response:**
  
  _Status code is 200 OK and it gives the balance as a JSON Object_

  * **Code:** 200 <br />
    **Content:** `{ "Balance" : 0 }`
    
    
   * **URL**
    
      _/deposit_
    
   * **Method:**
      
   `POST` 
   
   * **Data Params**
   
     _The request body should be in json format_
     
     `{ "amount" : 500 }`
 * **Success Response:**    
      _Status code is 200 OK and it gives the response as a JSON Object_
     
   * **Code:** 201 CREATED <br />
    **Content:** `{ "Response": "success" }`


 
 
 
* **Error Response:**

  The following are the error scenarios for this endpoint.
  
  
  

_If your deposit amount is greater than th maximum of 40K_

  * **Code:** 400 BAD REQUEST <br />
    **Content:** <br />
                  `{ 
                    "errorcode": 400,
                    "message": "Maximum Deposit amount is 40,0000"
                    }`



_If you have already done 4 transactions in a day_

  * **Code:** 400 BAD REQUEST <br />
    **Content:**<br />
                   `{ 
                    "errorcode": 400,
                    "message": "You have Reached your four daily maximum Deposits"
                    }`
                    

_If you have exceeded your daily maximum deposit amount_

  * **Code:** 400 BAD REQUEST <br />
    **Content:**<br />
                   `{
                        "errorcode": 400,
                        "message": "You have exceeded your maximum Deposit amount"
                    }`                      
                                                           
  * **URL**
     
       _/withdraw_
     
    * **Method:**
       
    `POST` 
    
    * **Data Params**
    
      _The request body should be in json format_
      
      `{ "amount" : 500 }`
  * **Success Response:**    
       _Status code is 200 OK and it gives the response as a JSON Object_
      
    * **Code:** 201 CREATED  <br />
     **Content:** `{ "Response": "success" }`
 
  
* **Error Response:**

  The following are the error scenarios for this endpoint.
  
  
  

_If your account balance is below the requested amount_

  * **Code:** 400 BAD REQUEST <br />
    **Content:** <br />
                  `{
                       "errorcode": 400,
                       "message": "Insufficient Funds in your account"
                   }`



_If your withdrawal amount is greater than the maximum of 20K_

  * **Code:** 400 BAD REQUEST <br />
    **Content:**<br />
                   `{
                        "errorcode": 400,
                        "message": "Maximum withdraw amount is 20,000"
                    }`
                    
_If you have exceeded your daily maximum withdrawal transactions_

  * **Code:** 400 BAD REQUEST <br />
    **Content:**<br />
                   `{
                        "errorcode": 400,
                        "message": "You have withdrawn three times today"
                    }` 
_If you have exceeded your daily maximum withdrawal amount_

  * **Code:** 400 BAD REQUEST <br />
    **Content:**<br />
                   `{
                    "errorcode": 400,
                    "message": "You have reached your withdrawal limit of 50000"
                     }` 
  
* **Notes:**

  _You can interact with the API using POSTMAN._