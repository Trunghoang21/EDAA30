package game;
import java.util.Random;
public class ComputerPlayer extends Player {
    public ComputerPlayer(String name){
        super(name);
    }
    // override a function in super class! 
    public int takePins(Board w){
        Random ran = new Random();
        int nbr = ran.nextInt(2)+1;
        w.takePins(nbr);
        UserInterface.printMessage("Computer player 2 "+ super.getUserId()+" takes " + nbr +"pins");
        return w.getNoPins();
    }
}
