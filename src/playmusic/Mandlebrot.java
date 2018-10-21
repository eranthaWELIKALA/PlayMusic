/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playmusic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author Welikala EY
 */
public final class Mandlebrot extends JComponent{
    
    public static final int F_HEIGHT = 800;
    public static final int F_WIDTH = 800;
    public static final int ITERATIONS = 50;
    
    private final BufferedImage buffer;
    private int SCALE;
    private final float hueoffset;
    private final JFrame frame;
    
    public Mandlebrot(float hueoffset,int scale){
        this.frame = new JFrame("MandlebrootSet");
        this.hueoffset = hueoffset;
        this.SCALE = scale;
        buffer = new BufferedImage(F_WIDTH,F_HEIGHT,BufferedImage.TYPE_INT_RGB);
        renderMandlebrotSet();
        
        
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(true);
        this.frame.getContentPane().add(this);
        this.frame.pack();
        this.frame.setVisible(true);
    }
    
    @Override
    public void addNotify(){
        setPreferredSize(new Dimension(F_WIDTH,F_HEIGHT));
    }
    
    public void renderMandlebrotSet(){
        for(int x=0;x<F_WIDTH;x++){
            for(int y=0;y<F_HEIGHT;y++){
                int color = calculatePoint((x-F_WIDTH/2f)/SCALE,(y-F_HEIGHT/2f)/SCALE);
                buffer.setRGB(x,y,color);
            }
        }
    }

    private int calculatePoint(float x, float y) {
        float cx=x,cy=y;
        int i=0;
        
        for(;i<ITERATIONS;i++){
            float nx = x*x - y*y + cx;
            float ny = 2*x*y + cy;
            x=nx;
            y=ny;
            if(x*x+y*y>4)break;
        }
        if(i==ITERATIONS)return 0x00000000;
        return Color.HSBtoRGB(((float)i/ITERATIONS+hueoffset)%1,0.5f,1); 
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(buffer,0,0,null);
    }
    
    public void changeScale(int scale){
        this.SCALE=scale;
        renderMandlebrotSet();
        
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(true);
        this.frame.getContentPane().add(this);
        this.frame.pack();
        this.frame.setVisible(true);
    }
        
}
