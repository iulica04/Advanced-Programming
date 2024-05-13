# Laborator 10

### Networking
Create an implementation of the Battleship game, that allows remote players to start or join games. The application will contain two parts (create a project for each one):

- The server is responsible with the game management and mediating the players.
- The client will communicate with the server, sending it commands such as: 
    - create or join a game,
    - submit a move, etc.

## Compulsory
- Create the project ServerApplication. This will contain (at least) the classes: GameServer and ClientThread.
- Create the class GameServer. An instance of this class will create a ServerSocket running at a specified port. The server will receive requests (commands) from clients and it will execute them.
- Create the class ClientThread. An instance of this class will be responsible with communicating with a client Socket. If the server receives the command stop it will stop and will return to the client the respons "Server stopped", otherwise it return: "Server received the request ... ".
- Create the project ClientApplication. This will contain (at least) the class: GameClient.
- Create the class GameClient. An instance of this class will read commands from the keyboard and it will send them to the server. The client stops when it reads from the keyboard the string "exit".

### Output
```
Task :ClientApplication:GameClient.main()
Connected to server at localhost:2024
Commands: 
   -> 'exit' to quit
   -> 'stop' to stop the server
   -> create game 
   -> join game 
   -> submit move

Enter command: join  game
Server received the request: join  game
Enter command: stop
Server stopped...Goodbye from server!
Enter command: exit
Goodbye!
```
