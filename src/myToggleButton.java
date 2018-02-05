import javax.swing.*;
import java.awt.*;

public class myToggleButton {

        public static final void main(final String[] args) {
            SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run() {
                    createAndShowGUI();
                }
            });
        }
        private static final void createAndShowGUI(){
            final JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout()); // For presentation purposes only.
            final JToggleButton button = new JToggleButton(UIManager.getIcon("blueButton2.png"));
            button.setSelectedIcon(UIManager.getIcon("redButton.png"));
            frame.add(button);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }

