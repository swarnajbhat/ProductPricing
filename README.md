# My Retail - ProductPricing


myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores across the east coast. myRetail wants to make its internal data available to any number of client devices, from myRetail.com to native mobile apps. This is an end-to-end Proof-of-Concept for a products API, which will aggregate product data from Product Repository and Pricing Information from Pricing Repository and return it as a single JSON to the caller.

this represents Pricing CRUD microservice

Database: MongoDb - downaloadable here - https://www.mongodb.com/try/download/community 

Database Tools - Compass 

SpringBoot version - 2.7.0

MongoDB document / collection - pricingdb / pricinginfos

example data collection: {"_id":"123","unitPrice":"18.84","currencyCode":"USD"}

Running port - 5000


Running instructions: 

a. download mongodb. create database, collection and document as described above. 

b. git clone this repository and import it to eclipse or any IDE

c. run it as mvn spring boot. 
