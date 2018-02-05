import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

//Authored by Alex Gable 2/4/2018

public class myNewGUI extends JFrame {

    //private JButton regular;
    private JButton custom;
    private ImageIcon notPress;
    private ImageIcon isPress;
    private ImageIcon isHover;

    public myNewGUI(){
        super("");
        setLayout(new FlowLayout());

        notPress = createImageIcon("unpressed.png","my red button");
        isPress = createImageIcon("pressed.png","my clicked button");
        isHover = createImageIcon("hovered.png","my blue button");

        custom = new JButton(notPress);
        custom.setBorderPainted(false);
        custom.setFocusPainted(false);
        custom.setContentAreaFilled(false);
        custom.setPressedIcon(isPress);
        custom.setRolloverIcon(isHover);
        add(custom);

        HandlerClass handler = new HandlerClass();
        custom.addActionListener(handler);


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
            //attempts to play the sound file
            try{
                String sound = "data/beep.wav";
                File audioFile = new File(sound);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                AudioFormat format = audioStream.getFormat();
                DataLine.Info info = new DataLine.Info(Clip.class, format);
                Clip audioClip = (Clip) AudioSystem.getLine(info);
                audioClip.open(audioStream);
                audioClip.loop(1000);
                audioClip.start();
                //waits for full audio clip
                try {
                    Thread.sleep(750);
                }catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                audioClip.close();
                audioStream.close();
            }
            //catch all the exceptions
            catch(UnsupportedAudioFileException ex){
                System.out.println("The specified audio file is not supported.");
            }catch(LineUnavailableException ex){
                System.out.println("Audio line for playing back is unavailable.");
            }catch(IOException ex){
                System.out.println("Error playing the audio file.");
                ex.printStackTrace();
            }catch(Exception ex){
                System.out.println("Some other error occurring.");
                ex.printStackTrace();
            }
        }
    }

}
