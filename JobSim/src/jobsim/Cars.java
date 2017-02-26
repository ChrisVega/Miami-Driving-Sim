/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobsim;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;


public class Cars {
    Random rand = new Random();
    int x = -300;
    int y = rand.nextInt(399) + 1;;
    int w = 120;
    int h = 80;
    private gamepannel game;
    
    public Cars(gamepannel g){
        updater.start();
        game=g;
        
    }
    
    public void paint(Graphics2D g){
        g.setColor(Color.RED);
        g.fillRect(x, y, w, h);
    }
    
    public Rectangle getboundry(){
        return new Rectangle(x,y,w,h);
    }
    
    public void updatecoord(){
        if(getboundry().intersects(game.getplayer().getBounds())){
            player temp =game.getplayer();
            temp.setcol();
            x=x-(10*temp.getxa());
            y=y-(10*temp.getya());
        }else{
            x=x+1;
        }
    }
    
    public Boolean inside(){
        if(x>600){
            return true;
        }else{
            return false;
        }
    }
    
    final Timer updater = new Timer(5, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        updatecoord();
    }
    });
    
}
