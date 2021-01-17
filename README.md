# ticketing-for-airline
Sample requests are below


//Company Adding POST
http://localhost:8080/api/company/add  
{
    "companyName": "FINARTZ",
    "companyCode": "FNRZ"
}

//Company Searching GET
http://localhost:8080/api/company/FINARTZ

//Airport Adding POST
http://localhost:8080/api/airport/add 
{
    "airportName": "Ataturk Havalimanı",
    "airportCode": "AHL"
}

//Airport Searching GET
http://localhost:8080/api/airport/AHL

//Route Adding POST
http://localhost:8080/api/route/add  
{
    "arrival": "ISTANBUL",
    "departure": "PARIS",
    "routeCode": "XYR304"
}

//Route Searching GET
http://localhost:8080/api/route/XYR304

//Flight Adding
http://localhost:8080/api/flight/add
{
    "departure": "ISTANBUL",
    "arrival": "PARIS",
    "solidityRatio": 10,
    "airlineCompany": 
        {
            "companyCode": "FNRZ"
        },
    "route":{
        "routeCode": "XYR304"
    }
}

//Flight Searching GET
http://localhost:8080/api/flight/1

//Ticket Adding
http://localhost:8080/api/ticket/add
{
    "price": 1500,
    "airport": 
        {
            "airportCode": "AHL"
        },
    "flight":{
        "flightId": 1
    },
    "isSold": false
}

//Ticket Searching GET
http://localhost:8080/api/ticket/2

//Ticket Selling POST
http://localhost:8080/api/ticket/sell-ticket/2
{
    "cardNo": "3242342.asd3242_32424-",
    "expirationDate": "12/2022",
    "cvcCode": "231",
    "customer": {
        "email": "kerimsamimi@hotmail.com"
    }
}

//Ticket Cancelling GET
http://localhost:8080/api/ticket/cancel-ticket/2 
