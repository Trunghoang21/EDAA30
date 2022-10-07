package game;

public class Board {
    /**
     * 
     */
    private int noPins;
    
    public Board() {
           
        this.noPins = 0;
        System.out.println("game created");

    }
    public void setUp( int nbr){
        this.noPins = nbr;
        System.out.println("A board is created with " + noPins +" pins");
    }
    public void takePins( int nbr){
        this.noPins -= nbr; 
    }

    public int getNoPins(){
        return this.noPins;
    } 
}
