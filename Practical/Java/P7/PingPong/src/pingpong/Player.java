/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp43
 */
public class Player extends Thread{
    private Player mate;
    public Ball ball;
    
    public void setMate(Player mate)
    {
        this.mate = mate;
    }
    
    public Player(Ball ball)
    {
        this.ball = ball;
    }
    
    @Override
    public void run()
    {
        try 
        {
            play();
        } 
        catch (InterruptedException ex) 
        {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void play() throws InterruptedException
    {
        for(int i = 0; i < 10000; i++)
        {
            System.out.println(this.getName());
            mate.syncNotify();
            syncWait();
        }
    }
    
    public synchronized void syncNotify()
    {
        notifyAll();
    }
    
    public synchronized void syncWait() throws InterruptedException
    {
        wait();
    }
    
}
