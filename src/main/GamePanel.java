package main;

import inputs.KeyboardInputs;
import utils.Constants;
import utils.SpriteAction;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import utils.Constants.*;

import static utils.Constants.Directions.*;
import static utils.Constants.PositionConstants.*;

public class GamePanel extends JPanel {

    Game game;
    public GamePanel(Game game){
        this.game = game;
        KeyboardInputs keyboardInputs= new KeyboardInputs(this);
        setWindowSize();
        addKeyListener(keyboardInputs);
    }

    public void setWindowSize(){
        Dimension size = new Dimension(1280,800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
    }

    public void updateGame() {
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
