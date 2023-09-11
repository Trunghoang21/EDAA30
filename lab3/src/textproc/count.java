package textproc;
import java.awt.*;
import javax.swing.*;

public class count {
    private int yesCount = 0;
    private JLabel yeslabel;
    private int noCount = 0;
    private JLabel nolabel;



    public count(){
        SwingUtilities.invokeLater(() -> createWindow());
    }

    private void createWindow(){
        JFrame frame1 = new JFrame("Count");
        
        // stänger fönstret med en kryss 
       frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       Container pane = frame1.getContentPane();
       
       yeslabel = new JLabel("0"); 
       JButton btn1 = new JButton("Click for yes!");
       btn1.addActionListener((event)->{
            yesCount++;
            yeslabel.setText(Integer.toString(yesCount));
       });
       
       nolabel = new JLabel("0");
       JButton btn2 = new JButton("Click for no!");
       btn2.addActionListener(e -> {
                    noCount++;
                    nolabel.setText(Integer.toString(noCount));
       });


       JPanel panel1 = new JPanel();
       JPanel panel2 = new JPanel();
       panel1.setPreferredSize(new Dimension(200,50));
       panel2.setPreferredSize(new Dimension(200,50));


       panel1.add(btn1);
       panel1.add(yeslabel);
       
       panel2.add(btn2);
       panel2.add(nolabel);

       pane.add(panel1, BorderLayout.NORTH);
       pane.add(panel2,BorderLayout.SOUTH);

       frame1.pack();
       frame1.setVisible(true);



        
    }
    public static void main(String[] args) {
        new count();
    }

    


}

    
