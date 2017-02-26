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
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import javax.swing.Timer;

/**
 *
 * @author School - Chris
 */
public class world {
    private gamepannel game;
    private int armdx = 5;
    private int arm1 = 270;
    private int arm2 = 280;
    private Boolean typing = false;
    private java.util.Timer timer;
    Random rand = new Random();
    int  n = rand.nextInt(3) + 1;
    int dashx1 = 600;
    int dashx2= 0;
    private ArrayList<Cars> cars = new ArrayList<Cars>();
    
    private ArrayList<Rectangle> rect = new ArrayList<Rectangle>(){{
        add(new Rectangle(0,0,600,1));//boundry for the map
        add(new Rectangle(0,0,1,400));
        add(new Rectangle(600,0,1,400));
        add(new Rectangle(0,399,600,10));
    }};
    
    public world (gamepannel g){
        timer = new java.util.Timer();
        this.game = g;
        start(n);
        updater.start();
    }
    
    public void paint(Graphics2D g){
        
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,600,400);
        
        g.setColor(Color.WHITE);
        g.fillRect(dashx1 +0,100,100,5);//group1
        g.fillRect(dashx1 +0,200,100,5);
        g.fillRect(dashx1 +0,300,100,5);
        
        g.fillRect(dashx1 +200,100,100,5);
        g.fillRect(dashx1 +200,200,100,5);
        g.fillRect(dashx1 +200,300,100,5);
        
        g.fillRect(dashx1 +400,100,100,5);
        g.fillRect(dashx1 +400,200,100,5);
        g.fillRect(dashx1 +400,300,100,5);//group1
        
        g.fillRect(dashx2 +0,100,100,5);//group2
        g.fillRect(dashx2 +0,200,100,5);
        g.fillRect(dashx2 +0,300,100,5);
        
        g.fillRect(dashx2 +200,100,100,5);
        g.fillRect(dashx2 +200,200,100,5);
        g.fillRect(dashx2 +200,300,100,5);
        
        g.fillRect(dashx2 +400,100,100,5);
        g.fillRect(dashx2 +400,200,100,5);
        g.fillRect(dashx2 +400,300,100,5);//group2
        
        if(dashx1==0){
            dashx2=599;
        }else if(dashx2==0){
            dashx1=599;
        }
        
        for(int i = 0;i<cars.size();i++){
            Rectangle temp = cars.get(0).getboundry();
            if(cars.get(i).inside()){
                cars.remove(i);
                i=i-1;
            }else{
            cars.get(i).paint(g);
            }
    }
    }
    
    public void newcar(){
        cars.add(new Cars(game));
        n = rand.nextInt(2) + 1;
        start(n);
    }
    
    public ArrayList<Rectangle> getBounds() {
		return rect;
	}
    
    public Boolean typing(){
        return typing;
    }
    
    public void keyPressed(KeyEvent e) {

			}
    
    public void keyReleased(KeyEvent e) {
    }
    public void start(int n){
        
  timer = new java.util.Timer();
TimerTask myTask = new TimerTask() {
    @Override
    public void run() {
        newcar();
    }
};

timer.schedule(myTask, 1000*n);

    }
    
    final Timer updater = new Timer(5, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        dashx1=dashx1-1;
        dashx2=dashx2-1;
    }
    });
}
