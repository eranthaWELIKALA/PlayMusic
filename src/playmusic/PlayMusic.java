/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playmusic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Welikala EY
 */
public class PlayMusic {

    /**
     * @param args the command line arguments
     * @throws javazoom.jl.decoder.JavaLayerException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws JavaLayerException, InterruptedException {
        //Mandlebrot mandlebrot = new Mandlebrot(0.5f,500);
        //TimeUnit.SECONDS.sleep(5);
        /*int [] array = {100,400,300,80,220};
        for(int i : array ){
            mandlebrot.changeScale(500-i);//TimeUnit.SECONDS.sleep(1);
        }*/
        /*Random random = new Random();
        for(int i=0;i<100;i++){
            mandlebrot.changeScale(random.nextInt((450)+80));
        }*/
        
        //mandlebrot.changeScale(150);
//        Random rand = new Random();
//        for(int i=0;i<100;i++){
//            mandlebrot.changeScale(rand.nextInt(200) + 100);TimeUnit.SECONDS.sleep(5);
//        }
        MusicPlayer music = new MusicPlayer();
        music.setVisible(true);
        //playMusic("Music\\\\GRTF.mp3");
    }
    
    public static void playMusic(String filepath) throws JavaLayerException{
        InputStream input;
        try{
            input = new FileInputStream(new File(filepath));
            Player player = new Player(input);
            player.play();
//            AudioStream audio = new AudioStream(input);
//            AudioPlayer.player.start(audio);
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    
}
