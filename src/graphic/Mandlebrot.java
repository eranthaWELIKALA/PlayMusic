/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

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
    public static void main(String[] args){
        Mandlebrot main = new Mandlebrot();
    }
    public static final int F_HEIGHT = 800;
    public static final int F_WIDTH = 800;
    public static final int ITERATIONS = 100;
    
    private final BufferedImage buffer;
    private final int SCALE;
    private final float hueoffset;
    
    public Mandlebrot(){
        this.hueoffset = 0.5f;
        this.SCALE = 50;
        buffer = new BufferedImage(F_WIDTH,F_HEIGHT,BufferedImage.TYPE_INT_RGB);
        renderMandlebrotSet();
        JFrame frame = new JFrame("MandlebrootSet");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
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
}
