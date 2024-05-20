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


## Homework
- Create the OOP model and implement functionalities of the game.
- The clients will send to the server commands such as: create game, join game, submit move, etc.
- The server is responsible with the game management and mediating the players.
- The games will be played under time control (blitz) with each player having the same amount of time at the beginning of the game. If a player's time runs out, the game is lost.

  ### Output

- Client 1

```
Connected to server at localhost:2024
Welcome to the Battleship! 
 To start the game, please enter your name: 
iulia
Commands: 
   -> 'exit' to quit
   -> 'stop' to stop the server
   -> 'create game' to create a new game 
   -> 'join game gameID' to join in the game with gameID
   -> 'make move x y' to make a hit in the position x y
   -> 'set the ships positions' to set the ships positions

This name is available!
join game 1
You joined the game with id 1! Enter 'set the ships positions' to set the ships positions!
set the ships positions
Enter the position of the ship with number 5: 
1 2
Enter the position of the ship with number 4: 
2 3
Enter the position of the ship with number 3: 
3 4
Enter the position of the ship with number 2: 
4 3
Enter the position of the ship with number 1: 
5 2
Ships positions set! Now you can start the game! Use 'start game' command to start the game!
Game started!
Opponent's turn!
Your turn! Make a move!
Player iulia's Board:
     A  B  C  D  E  F  G  H  I  J 
   +---+---+---+---+---+---+---+---+---+---+
 1 |   | h |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 2 |   |   | s |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 3 |   |   |   | s |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 4 |   |   | s |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 5 |   | s |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 6 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 7 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 8 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 9 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
10 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+

make move 1 1
You hit a ship!
Opponent's turn!
Your turn! Make a move!
Player iulia's Board:
     A  B  C  D  E  F  G  H  I  J 
   +---+---+---+---+---+---+---+---+---+---+
 1 |   | h |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 2 |   |   | s |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 3 |   |   |   | s |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 4 |   |   | s | m |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 5 |   | s |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 6 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 7 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 8 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 9 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
10 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+

make move 5 5
You missed!
Opponent's turn!
Your turn! Make a move!
Player iulia's Board:
     A  B  C  D  E  F  G  H  I  J 
   +---+---+---+---+---+---+---+---+---+---+
 1 |   | h |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 2 |   |   | h |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 3 |   |   |   | s |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 4 |   |   | s | m |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 5 |   | s |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 6 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 7 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 8 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 9 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
10 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+

Time's up! Your turn has ended.
Opponent's turn!
Your turn! Make a move!
Player iulia's Board:
     A  B  C  D  E  F  G  H  I  J 
   +---+---+---+---+---+---+---+---+---+---+
 1 |   | h |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 2 |   |   | h |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 3 |   |   |   | h |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 4 |   |   | s | m |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 5 |   | s |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 6 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 7 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 8 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 9 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
10 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+

make move 9 9
You missed!
Opponent's turn!
Your turn! Make a move!
Player iulia's Board:
     A  B  C  D  E  F  G  H  I  J 
   +---+---+---+---+---+---+---+---+---+---+
 1 |   | h |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 2 |   |   | h |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 3 |   |   |   | h |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 4 |   |   | h | m |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 5 |   | s |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 6 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 7 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 8 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 9 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
10 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+

make move 4 4
You hit a ship!
Opponent's turn!
Game over! The winner is diana
exit
GoodBye!!!!!!!!!!
```

- Client 2
```
Connected to server at localhost:2024
Welcome to the Battleship! 
 To start the game, please enter your name: 
iulia
Commands: 
   -> 'exit' to quit
   -> 'stop' to stop the server
   -> 'create game' to create a new game 
   -> 'join game gameID' to join in the game with gameID
   -> 'make move x y' to make a hit in the position x y
   -> 'set the ships positions' to set the ships positions

User already exists! Enter another name: 
diana
This name is available!
create game
Game created with 1! Waiting for an opponent to join...
iulia has joined the game! Enter 'set the ships positions' to set the ships positions!
set the ships positions
Enter the position of the ship with number 5: 
1 1
Enter the position of the ship with number 4: 
2 2
Enter the position of the ship with number 3: 
4 4
Enter the position of the ship with number 2: 
6 6
Enter the position of the ship with number 1: 
8 8
Ships positions set! Now you can start the game! Use 'start game' command to start the game!
start game
Game started!
Game started!
Your turn! Make a move!
Player diana's Board:
     A  B  C  D  E  F  G  H  I  J 
   +---+---+---+---+---+---+---+---+---+---+
 1 | s |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 2 |   | s |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 3 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 4 |   |   |   | s |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 5 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 6 |   |   |   |   |   | s |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 7 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 8 |   |   |   |   |   |   |   | s |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 9 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
10 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+

make move 1 2
You hit a ship!
Opponent's turn!
Your turn! Make a move!
Player diana's Board:
     A  B  C  D  E  F  G  H  I  J 
   +---+---+---+---+---+---+---+---+---+---+
 1 | h |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 2 |   | s |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 3 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 4 |   |   |   | s |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 5 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 6 |   |   |   |   |   | s |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 7 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 8 |   |   |   |   |   |   |   | s |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 9 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
10 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+

make move 4 4
You missed!
Opponent's turn!
Your turn! Make a move!
Player diana's Board:
     A  B  C  D  E  F  G  H  I  J 
   +---+---+---+---+---+---+---+---+---+---+
 1 | h |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 2 |   | s |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 3 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 4 |   |   |   | s |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 5 |   |   |   |   | m |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 6 |   |   |   |   |   | s |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 7 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 8 |   |   |   |   |   |   |   | s |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 9 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
10 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+

make move 2 3
You hit a ship!
Opponent's turn!
Your turn! Make a move!
Player diana's Board:
     A  B  C  D  E  F  G  H  I  J 
   +---+---+---+---+---+---+---+---+---+---+
 1 | h |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 2 |   | s |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 3 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 4 |   |   |   | s |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 5 |   |   |   |   | m |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 6 |   |   |   |   |   | s |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 7 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 8 |   |   |   |   |   |   |   | s |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 9 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
10 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+

make move 3 4
You hit a ship!
Opponent's turn!
Your turn! Make a move!
Player diana's Board:
     A  B  C  D  E  F  G  H  I  J 
   +---+---+---+---+---+---+---+---+---+---+
 1 | h |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 2 |   | s |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 3 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 4 |   |   |   | s |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 5 |   |   |   |   | m |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 6 |   |   |   |   |   | s |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 7 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 8 |   |   |   |   |   |   |   | s |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 9 |   |   |   |   |   |   |   |   | m |   |
   +---+---+---+---+---+---+---+---+---+---+
10 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+

make move 4 3
You hit a ship!
Opponent's turn!
Your turn! Make a move!
Player diana's Board:
     A  B  C  D  E  F  G  H  I  J 
   +---+---+---+---+---+---+---+---+---+---+
 1 | h |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 2 |   | s |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 3 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 4 |   |   |   | h |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 5 |   |   |   |   | m |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 6 |   |   |   |   |   | s |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 7 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 8 |   |   |   |   |   |   |   | s |   |   |
   +---+---+---+---+---+---+---+---+---+---+
 9 |   |   |   |   |   |   |   |   | m |   |
   +---+---+---+---+---+---+---+---+---+---+
10 |   |   |   |   |   |   |   |   |   |   |
   +---+---+---+---+---+---+---+---+---+---+

make move 5 2
Game over! The winner is diana
You hit a ship!
exit
GoodBye!!!!!!!!!!
```

