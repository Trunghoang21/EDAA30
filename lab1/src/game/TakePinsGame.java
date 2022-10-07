package game;
//import java.util.*;
public class TakePinsGame {
    public static void main(String[] args) {
        Board myBoard = new Board();
       // Scanner input = new Scanner(System.in);
        boolean player1turn = true;
        UserInterface.printMessage("Hi! Let's play a game, don't be a loser! ");
        //System.out.println("how many pins do you want yo play with?");
        myBoard.setUp(UserInterface.askforInt("how many pins do you want yo play with?"));
        //System.out.println("Enter a namne for player1: ");
        //String nameofplayer1 = input.next();
        HumanPlayer gamer1 = new HumanPlayer(UserInterface.askForString("Enter a name for player 1:"));
        //System.out.println("Enter a name for player2(Computer): ");
        //String nameofplayer2 = input.next();
        ComputerPlayerGen2 gamer2 = new ComputerPlayerGen2(UserInterface.askForString("Enter a name for player 2(Computer):"));
        //System.out.println(" 1: for player1 plays first or 2: for player 2 plays first: ");
        
        if(UserInterface.askforInt("1: for player1 to  play first or 2: for player 2 to play first: ") == 2){
            player1turn = false;
        }
        while(myBoard.getNoPins() > 0){
            if(player1turn){
                //System.out.println(gamer1.getUserId() +" turn to play!");
               UserInterface.printMessage(gamer1.getUserId() +"'s turn to play!");
                //System.out.println("There is "+ gamer1.takePins(myBoard)+" pins left");
                UserInterface.printMessage("There is "+ gamer1.takePins(myBoard)+" pins left");
                
                player1turn = false;
            }
            else if ( !player1turn){
                UserInterface.printMessage(gamer2.getUserId() +"'s turn to play!");
                
                UserInterface.printMessage("There is "+ gamer2.takePins(myBoard)+" pins left");
                
                player1turn = true;
            }
           
        }
        whoWin(player1turn,gamer1,gamer2);
    }
    private static void whoWin(boolean lastTake, Player player1, Player player2){
        if(lastTake){
            UserInterface.printMessage("player2 " +player2.getUserId()+" wins!");
        }else{
            UserInterface.printMessage("Player 1 "+player1.getUserId() + " wins!");
        }
    }
}
/*

i Programmet för spelet använder vi arv(superklassen Player och subklasserna HumanPlayer, ComputerPlayer ). Vad har man vunnit med det ?

Man kan återanvända koden medan man kan själv modifiera koden i subklass efter sin behov. Olika subclasser används för olika syfte men man kan se att 
koppling mellan olika klasser, det leder till att programmet kan betraktas som en helhet 



Det finns abstrakt metod i superklassen Player, Vad är en abstrakt metod? Varför finns den där ?
   klasser som kan inte instansieras, vilket innebär att det går inte skapa objekt av klaseen 
   Istället får man definera en klass som ärver den abstrakta.

Fördel är attman måste skapa en subklass som ärva efter superklaseen 
 

 */