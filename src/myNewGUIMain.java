import javax.swing.*;
import java.awt.*;

//Authored by Alex Gable 2/4/2018

public class myNewGUIMain {
    public static void main(String[] args) {
        myNewGUI go = new myNewGUI();
        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        go.setSize(new Dimension(500,500));
        go.pack();
        go.setLocationRelativeTo(null);
        go.setVisible(true);

    }
}
