package main;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import entities.Player;

import java.awt.*;

public class Game implements Runnable{

    private int FPS_SET = 120;
    private Thread gameThread;
    private int UPS_SET = 200;

    private  GamePanel gamePanel;

    private Player player;
    public Game(){
        player = new Player(100,100);
        gamePanel = new GamePanel(this);
        GameWindow gameWindow = new GameWindow(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();
        startGameLoop();
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {
        double timePerFrame = 1000000000.0/FPS_SET;
        double timePerUpdate = 1000000000.0/UPS_SET;
        long previousTime =  System.nanoTime();
        long lastCheckMillies = System.currentTimeMillis();
        int frames = 0;
        int updates = 0;
        double deltaU = 0;
        double deltaF = 0;

        while(true){
            long currentTime = System.nanoTime();
            deltaU += (currentTime - previousTime)/timePerUpdate;
            deltaF += (currentTime - previousTime)/timePerFrame;
            previousTime = currentTime;
            if(deltaU > 1 ){
                update();
                updates++;
                deltaU--;
            }

            if(deltaF > 1){
                gamePanel.repaint();
                frames ++;
                deltaF --;
            }
            if (System.currentTimeMillis() - lastCheckMillies >= 1000){
                System.out.println("FPS: " + frames + " UPS: " + updates);
                frames = 0;
                updates = 0;
                lastCheckMillies = System.currentTimeMillis();
            }
        }
    }

    private void update() {
        player.update();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public void render(Graphics g){
        player.render(g);
    }

}
