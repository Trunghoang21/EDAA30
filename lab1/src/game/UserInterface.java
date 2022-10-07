package game;
import javax.swing.*;
public class UserInterface {
    
    public static void printMessage(String msg){
            JOptionPane.showMessageDialog(null, msg);
    }

    public static int askforInt(String msg){
        String input =  JOptionPane.showInputDialog(null, msg);
        if (input == null){
            System.exit(0);
            return -2;
        }
        if(isNumeric(input)){
            int nbr = Integer.parseInt(input);
            if(nbr > 0){
                return nbr;
            }else{
                return -1;
            }
        }else{
            return -1;
        }
        
    }
    public static String askForString(String msg){
        return JOptionPane.showInputDialog(null, msg);
    }


    private static boolean isNumeric( String text){
        try{
            Integer.valueOf(text);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }



}
