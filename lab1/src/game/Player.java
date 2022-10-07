package game;

//import java.util.*;

public abstract class Player {

    protected String userID;
   

    public Player(String name ){
        this.userID = name;
        System.out.println("Player " + userID + " is created");
    }

    public String getUserId(){
        return this.userID;
    }

    public abstract int takePins(Board w);


}
