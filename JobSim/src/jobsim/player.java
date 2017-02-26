/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobsim;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author School - Chris
 */
public class player {
    private gamepannel game;
    public int x = 250;
    public int y = 190;
    int h = 80;
    int w = 120;
    int ya = 0;
	int xa = 0;
        int xx;
        int yy;
        private Boolean collide = false;
        private Rectangle gamearea = new Rectangle(0,0,600,400);
    
    public player (gamepannel g){
        game =g;
    }
    public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}
    
    public Boolean gameover(){
        if(gamearea.intersects(getBounds())){
            return false;
        }else{
            return true;
        }
    }
    
    public void move() {
        collision();
                Boolean temp = collide;
                if(xx==xa && yy==ya){
                        y=y;
                        x=x;
                        return;
                    }
            
                if(temp){
                    xx=xa;
                    yy=ya;
                    y = y- (ya*20);
                    x = x- (xa*20);
                    collide=false;
                    return;
                }
            
		if (x + xa > 0 && !temp){
                        xx=20;
			x = x + xa;
                }
                
                if (y + ya > 0 && !temp){
                        yy=20;
			y = y + ya;
                }
	}
        
        public void collision(){
            ArrayList<Rectangle> temp = game.getworld().getBounds();
            for(int i =0; i<temp.size();i++){
                if(temp.get(i).intersects(getBounds())){
                collide=true;
                return;
                }
            }
            collide= false;
        }
        
        public void setcol(){
            collide = true;
            if(xa==0 && ya==0){
            x=x+10;
            y=y+10;
            return;
            }else{
                    y = y- (ya*40);
                    x = x- (xa*40);
                    collide=false;
                    return;
            }
        }
    
    public void paint(Graphics2D g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, w, h);
    }
    
    public int getxa(){
        return xa*-1;
    }
    
    public int getya(){
        return ya*-1;
    }
    
    public void keyPressed(KeyEvent e) {  
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			xa = -1;
                }
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			xa = 1;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP)
			ya = -1;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			ya = 1;
	}
    
    public void keyReleased(KeyEvent e) {
		xa = 0;
                ya = 0;
    }
        }
