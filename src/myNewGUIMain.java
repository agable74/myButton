import javax.swing.*;
import java.awt.*;

public class myNewGUIMain {
    public static void main(String[] args) {
        myNewGUI go = new myNewGUI();
        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        go.setSize(new Dimension(300,300));
        go.pack();
        go.setLocationRelativeTo(null);
        go.setVisible(true);
    }
}
