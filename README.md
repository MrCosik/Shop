# Shop
Backend for online game store


Application has been written using Java 17, Spring Framework, Docker, PostgreSQL and RabbitMQ.

 

Allowed actions:

  - Get list of all available games

  - Edit specific game (after providing games id and data to change)

  - Place an order for games you want to buy

 

In works:

  - Security (Authentication, authorization)

  - Circuit breakers

  - To move all passwords and configuration data into config server

- Fix ques

 

To start docker containers navigate to Shop folder and open it in terminal. Execute command docker-compose up -d.


Endpoints:
  Get all games:
  curl -XGET 'http://localhost:8090/games-ws/games'
  
  Get all orders:
  curl -XGET 'http://localhost:8090/orders-ws/orders'
  
  Place an order: (this one doesn't work properly, it will send messages to another microservice infinitely):
  curl -XPOST -H "Content-type: application/json" -d '{
    "gamesIds":["1","2"]
}' 'http://localhost:8090/games-ws/buy'

