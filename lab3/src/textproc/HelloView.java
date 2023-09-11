package textproc;
import java.awt.*;
import javax.swing.*;
public class HelloView {
    
    public HelloView(){
        SwingUtilities.invokeLater(() -> createWindow());
    }
    
    private void createWindow(){
        // skapa en ram  på fönstret 
        JFrame frame = new JFrame("Hello");
        
        // stänger fönstret med en kryss 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Ger en referens till behållaren för fönstret 
        Container pane = frame.getContentPane();

        // skapa en etikett (label) med texten Hellow World
        JLabel label = new JLabel("Hello world");

        // set storlek på labeln 
        label.setPreferredSize(new Dimension(200, 200));
        
        // skapa en button 
        JButton btn = new JButton("Button1");

        // lägga in labeln och button i behållaren
        // samtidigt kan man lägga olika komponenter i olika positioner 
        pane.add(label,BorderLayout.NORTH);
        pane.add(btn, BorderLayout.SOUTH);


        // sätter storlek på komponenterna 
        frame.pack();

        // gör fönstret synligt
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new HelloView();
    }



}
