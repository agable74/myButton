

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CustomButton extends JButton implements MouseListener {

    Dimension size = new Dimension(250,150);

    boolean hover = false;
    boolean click = false;
    private ImageIcon notPress;
    private ImageIcon isPress;

    String text = "";

    public CustomButton(String text){
        setFocusable(true);
        setContentAreaFilled(false);
        setBorderPainted(false);

        setVisible(true);
        notPress = createImageIcon("redButton.png","my red button");
        isPress = createImageIcon("blueButton.png","my blue button");


        this.text = text;
        addMouseListener(this);


    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if(click){
            g.setColor(Color.WHITE);
            g.fillRect(0,0,250,150);
        }

        g.setColor(new Color(0,50,hover ? 255 : 180));

        g.fillRect(0,0,250,7);
        g.fillRect(0,143,250,7);
        g.fillRect(0,0,7,150);
        g.fillRect(243,0,7,150);

        g.setColor(new Color(230,0,230));

        g.fillRect(14,14,222,122);

        g.setColor(Color.RED);

        g.setFont(Font.decode("arial-BOLD-24"));

        FontMetrics metrics = g.getFontMetrics();

        int width = metrics.stringWidth(text);

        g.drawString(text,125 - width / 2, 75);
    }

    @Override
    public Dimension getPreferredSize(){
        return size;
    }
    @Override
    public Dimension getMaximumSize(){
        return size;
    }
    @Override
    public Dimension getMinimumSize(){
        return size;
    }

    public void setButtonText(String text){
        this.text = text;
    }

    public String getButtonText(){
        return text;
    }

    @Override
    public void mouseEntered(MouseEvent e){
        hover = true;
    }
    @Override
    public void mouseExited(MouseEvent e){
        hover = false;
    }
    @Override
    public void mousePressed(MouseEvent e){
        click = true;
    }
    @Override
    public void mouseReleased(MouseEvent e){
        click = false;
    }
    @Override
    public void mouseClicked(MouseEvent e){

    }

    protected ImageIcon createImageIcon(String path, String description){
        java.net.URL imgURL = getClass().getResource(path);
        if(imgURL!=null){
            return new ImageIcon(imgURL,description);
        }else{
            System.err.println("Couldn't find file: " +path);
            return null;
        }
    }

}
