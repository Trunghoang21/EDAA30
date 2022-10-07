package game;


public class hello {
    public static void main(String[] args) {
      while(true){
     int input = UserInterface.askforInt("Enter an int");
     if( input == -2){
      System.exit(0);
     }
     UserInterface.printMessage(String.valueOf(input));
    }
    }
}
