package game;

public class HumanPlayer extends Player {
    public HumanPlayer(String name){
        super(name);
    }
    public int takePins(Board w){
        {
            //Scanner scan = new Scanner(System.in);
            //System.out.println("How many do you want to take " + userID +"?");
            int nbr = UserInterface.askforInt("How many do you want to take " + userID +"?");
            //int nbr = scan.nextInt();
            if((nbr < 3) && (nbr > 0)){
                w.takePins(nbr);
            }else{
                //System.out.println("invalid input value, take only one or two pins");
                UserInterface.printMessage("invalid input value, take only one or two pins");
                takePins(w);
            }
           
            return w.getNoPins();
        }
    }
    
}
