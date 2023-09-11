package textproc;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.DimensionUIResource;

public class test1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();
        JLabel label = new JLabel("Hello world");
        label.setPreferredSize(new DimensionUIResource(200, 200));
        pane.add(label);
        frame.pack();
        frame.setVisible(true);
    }
}
