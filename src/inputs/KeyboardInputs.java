package inputs;

import main.GamePanel;
import utils.Constants;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import utils.Constants.Directions.*;



public class KeyboardInputs implements KeyListener {


    GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                gamePanel.getGame().getPlayer().setPlayerDirection(Constants.Directions.UP);
                break;
            case KeyEvent.VK_A:
                gamePanel.getGame().getPlayer().setPlayerDirection(Constants.Directions.LEFT);
                break;
            case KeyEvent.VK_S:
                gamePanel.getGame().getPlayer().setPlayerDirection(Constants.Directions.DOWN);
                break;
            case KeyEvent.VK_D:
                gamePanel.getGame().getPlayer().setPlayerDirection(Constants.Directions.RIGHT);
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
            case KeyEvent.VK_A:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
                gamePanel.getGame().getPlayer().setMoving(false);
                break;
        }
    }
}
