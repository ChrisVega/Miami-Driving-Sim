/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobsim;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author School - Chris
 */
public class gamepannel extends JPanel {
    private world world = new world(this);
    private player player = new player(this);
    
    public gamepannel() {
            
		addKeyListener(new KeyListener() {
		@Override
			public void keyTyped(KeyEvent e) {
			}
		@Override
			public void keyReleased(KeyEvent e) {
                            player.keyReleased(e);
			}
		@Override
			public void keyPressed(KeyEvent e) {
                            player.keyPressed(e);
			}
		});
	}
    
    public void gameover(){
        if(player.gameover()){
            JOptionPane.showMessageDialog(null,
    "Game over\nthey didnt give me anything\nso they can suck my dick.",
    "Inane error",
    JOptionPane.ERROR_MESSAGE);
            world = new world(this);
            player = new player(this);
        }
    }
    
     public void timer(){
            player.move();
            gameover();
     }
     
     public player getplayer(){
         return player;
     }
     
     public world getworld(){
         return world;
     }
    
    @Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
                world.paint(g2d);
                player.paint(g2d);
                
                g2d.dispose();
        }
    
}
