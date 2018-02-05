
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myNewGUI extends JFrame {

    //private JButton regular;
    private JButton custom;
    private ImageIcon notPress;
    private ImageIcon isPress;

    public myNewGUI(){
        super("");
        setLayout(new FlowLayout());

        notPress = createImageIcon("unpressed.png","my red button");
        isPress = createImageIcon("pressed.png","my blue button");

        custom = new JButton(notPress);
        custom.setBorderPainted(false);
        custom.setFocusPainted(false);
        custom.setContentAreaFilled(false);
        custom.setPressedIcon(isPress);
        add(custom);


    }


    private ImageIcon createImageIcon(String path, String description){
        java.net.URL imgURL = getClass().getResource(path);
        if(imgURL!=null){
            return new ImageIcon(imgURL,description);
        }else{
            System.err.println("Couldn't find file: " +path);
            return null;
        }
    }

    private class HandlerClass implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
