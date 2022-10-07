package game;
import java.util.*;
public class ComputerPlayerGen2 extends Player{
    public ComputerPlayerGen2(String name){
        super(name);
    }
    public int takePins(Board w){
        Random ran = new Random();
        int nbr = 0;
        
        if(w.getNoPins() == 5){
            nbr = 2;
        }else if (w.getNoPins() == 4){
            nbr = 1;
        }else if(w.getNoPins() == 3){
            nbr = 1;
        }else if( w.getNoPins() == 2){
            nbr = 2;
        }else if( w.getNoPins() == 1){
            nbr = 1;
        }
        else{
            nbr =ran.nextInt(2)+1;
        }
        w.takePins(nbr);

        UserInterface.printMessage("Computer player 2 "+ super.getUserId()+" takes " + nbr +"pins");
        return w.getNoPins();


        
    }
}
