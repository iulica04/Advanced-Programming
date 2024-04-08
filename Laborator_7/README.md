# Laborator 6

### Concurrency
Write a program that simulates the following game between a given number of players.
At the beginning of the game there is a bag containing a number of tokens, each token being a distinct pair of numbers between 1 and n.
Each player extracts tokens successively from the bag and must create with them closed sequences of the form t1=(i1,i2), t2=(i2,i3),...,tk=(ik,i1), where ti are tokens and i1,i2,i3,...,ik are distinct numbers.
The value of a sequence is given by the number of its tokens.
The game ends when all tokens have been removed from the bag or when a player makes a sequence of length n. Each player receives a number of points equal to the value of its largest sequence.
The players might take turns (or not...) and a time limit might be imposed (or not...).

## Compulsory

* Create an object oriented model of the problem.
* Each player will have a name and they must perform in a concurrent manner, extracting repeatedly tokens from the bag.
* Simulate the game using a thread for each player (only the part where the players extract tokens from the bag).    
Pay attention to the synchronization of the threads when extracting tokens from the bag.

### Output 
Sequence length: 5
Raphael Hyatt picked token: Token[number1=1, number2=4]   
Sebastian Berge picked token: Token[number1=1, number2=3]   
Karin Gleichner picked token: Token[number1=1, number2=5]   
Tobias Franecki picked token: Token[number1=1, number2=2]   
Kizzie Skiles MD picked token: Token[number1=1, number2=5]    
Raphael Hyatt picked token: Token[number1=3, number2=5]   
Sebastian Berge picked token: Token[number1=5, number2=1]   
Karin Gleichner picked token: Token[number1=1, number2=2]    
Tobias Franecki picked token: Token[number1=4, number2=5]    
Kizzie Skiles MD picked token: Token[number1=2, number2=5]    
Raphael Hyatt picked token: Token[number1=5, number2=1]
Sebastian Berge picked token: Token[number1=1, number2=5]   
Karin Gleichner picked token: Token[number1=5, number2=1]    
Tobias Franecki picked token: Token[number1=2, number2=3]    
Kizzie Skiles MD picked token: Token[number1=1, number2=4]    
Raphael Hyatt picked token: Token[number1=2, number2=5]     
Sebastian Berge picked token: Token[number1=1, number2=2]             
Karin Gleichner picked token: Token[number1=2, number2=4]    
Tobias Franecki picked token: Token[number1=2, number2=4]    
Kizzie Skiles MD picked token: Token[number1=1, number2=4]     
Raphael Hyatt picked token: Token[number1=1, number2=4]     
Sebastian Berge picked token: Token[number1=3, number2=5]    
Karin Gleichner picked token: Token[number1=1, number2=3]     
Tobias Franecki picked token: Token[number1=5, number2=1]      
Kizzie Skiles MD picked token: Token[number1=1, number2=5]      
Raphael Hyatt picked token: Token[number1=3, number2=5]     
Sebastian Berge picked token: Token[number1=3, number2=5]     
Karin Gleichner picked token: Token[number1=3, number2=4]      
Tobias Franecki picked token: Token[number1=3, number2=5]       
Kizzie Skiles MD picked token: Token[number1=4, number2=5]       
Raphael Hyatt picked token: Token[number1=2, number2=5]     
Sebastian Berge picked token: Token[number1=5, number2=1]     
Karin Gleichner picked token: Token[number1=1, number2=3]     
Tobias Franecki picked token: Token[number1=1, number2=5]     
Kizzie Skiles MD picked token: Token[number1=2, number2=3]     
Raphael Hyatt picked token: Token[number1=2, number2=5]       
Sebastian Berge picked token: Token[number1=1, number2=3]      
Karin Gleichner picked token: Token[number1=1, number2=2]      
Tobias Franecki picked token: Token[number1=1, number2=3]    
Kizzie Skiles MD picked token: Token[number1=4, number2=5]    
OPS.....The bag is empty for player: Raphael Hyatt   
The game has stopped.