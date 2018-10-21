package playmusic;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jl.player.Player;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Welikala EY
 */
public class MusicPlayer extends javax.swing.JFrame {

    //private final CyclicBarrier gate;
/**
     * Creates new form MusicPlayer
     */
    private final JFileChooser openFileChooser;
    private Player player = null;
    private Thread thread_play = null;
    //private Thread thread_array = null;
    private Mandlebrot mandlebrot = new Mandlebrot(0.5f,500);
    public MusicPlayer() {
        //this.gate = new CyclicBarrier(3);
        initComponents();
        openFileChooser = new JFileChooser();
        openFileChooser.setCurrentDirectory(new File("c\\"));
        openFileChooser.setFileFilter(new FileNameExtensionFilter("MP3","mp3"));
    }
    
    public void inputStreamToByteArray(InputStream inStream) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[8192];
        int bytesRead;
        while ((bytesRead = inStream.read(buffer)) > 0) {
            baos.write(buffer, 0, bytesRead);
            //mandlebrot.changeScale((int));
        }
        //int itr=1;
        //int MAX=0;
        for(byte b: baos.toByteArray()){
            if(b<0)b=(byte) (b*(-1));
            //mandlebrot.changeScale(b);
            //if(b>MAX)MAX=b;
            /*int number = b.intValue();*/
            System.out.println((int)b);
            //mandlebrot.changeScale((int)b+100);
            //itr++;
        }
        //return baos.toByteArray();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 0, 204));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playmusic/MusicPlayerOpen.png"))); // NOI18N
        jButton1.setText("Open");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playmusic/MusicPlayerPause.png"))); // NOI18N
        jButton3.setText("Pause");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/playmusic/MusicPlayerPlay.png"))); // NOI18N
        jButton4.setText("Play");
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(44, 44, 44)
                .addComponent(jButton3)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("X");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int value = openFileChooser.showOpenDialog(this);
        if(value == JFileChooser.APPROVE_OPTION){
            if (thread_play != null) {
                thread_play.stop();
            }
            jLabel1.setText(openFileChooser.getSelectedFile().getName());
            InputStream input;
            try{
                input = new FileInputStream(openFileChooser.getSelectedFile());
                inputStreamToByteArray(input);
                /*int bytesRead;byte[] buffer = new byte[8192];
                while ((bytesRead = input.read(buffer)) > 0) {
                    System.out.println(bytesRead);
                    //mandlebrot.changeScale(bytesRead);
                }*/
                
                /*byte [] output;
                output = inputStreamToByteArray(input);
                
                for(byte o:output){
                    //System.out.println(o);
                    int i=o;
                    if(i<0)i=i*(-1);
                    this.mandlebrot.changeScale(i);
                    //TimeUnit.SECONDS.sleep(1);
                }*/
//                thread_array = new Thread(){
//                    public void run(){
//                        try {
//                            gate.await();
//                        } catch (InterruptedException | BrokenBarrierException ex) {
//                            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        byte[] buffer = new byte[10240];
//                        int len;
//                        try {
//                            //while ((len = input.read(buffer)) != -1) {
//                            while(input.available()==1){
//                                len = input.read();
//                                //len = input.read(buffer);
//                                //output.write(buffer, 0, len);
//                            }
//                            //}
//                        } catch (IOException ex) {
//                            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        System.out.print(Arrays.toString(buffer));
//                    }
//                };
                
                /*player = new Player(input);
                thread_play = new Thread(){
                    public void run(){
                        try {
                            //gate.await();
                            player.play();
                        } catch (JavaLayerException ex) {
                            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                thread_play.start();*/
                //thread_array.start();
                //gate.await();
                
            }
            catch (IOException ex) {
                Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            jLabel1.setText("No File Selected");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(-1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        thread_play.suspend();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        thread_play.resume();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
