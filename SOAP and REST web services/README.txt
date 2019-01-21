MealsRestWebService:

- to run please run the App.js as java application
urls:
	GET	localhost:8080/meals
	GET 	localhost:8080/meals/{id}
	POST 	localhost:8080/meals
	POST 	localhost:8080/meals/{id}
	DELETE 	localhost:8080/meals/{id}

- DB schema:
	meal:
	id - integer primary key
	mname - varchar(50)
	price - integer
	
MealsSOAPWebService:

-to run:
	1. run the server.WebServer
	2. run the client.WebClient