package entities;

import utils.Constants;
import utils.SpriteAction;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static utils.Constants.Directions.*;
import static utils.Constants.Directions.DOWN;
import static utils.Constants.PositionConstants.IDLE;
import static utils.Constants.PositionConstants.RUNNING;

public class Player extends Entity{

    private BufferedImage bufferedImage;
    private ArrayList<SpriteAction> currentAnimationList = Constants.Actions.IDLE;
    private SpriteAction currentPlayerAnimation = SpriteAction.STAND_ONE;
    private int playerDirection = -1;
    private HashMap<SpriteAction, BufferedImage > playerImages;
    private boolean moving;
    private int playerAction;

    private int aniTick =0,aniSpeed = 15,aniIndex=0;
    boolean left,right,up,down;
    private float playerSpeed = 2.0f;

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public Player(float x, float y) {
        super(x, y);
        importImage();
        loadAnimations();
    }

    public void update(){
        updatePos();
        updateAnimation();
        setAnimation();
    }
    public void render(Graphics g){
        g.drawImage(playerImages.get(currentPlayerAnimation),(int)x,(int)y,34,44,null);
    }
    private void loadAnimations() {
        playerImages = new HashMap<>();
        for(SpriteAction s: SpriteAction.values()){
            BufferedImage spriteCurrentAction;
            List<Integer> currentCoordinates = Constants.PlayerSpriteConstants.getDimension(s);
            spriteCurrentAction = bufferedImage.getSubimage(currentCoordinates.get(0),currentCoordinates.get(1),currentCoordinates.get(2),currentCoordinates.get(3));
            playerImages.put(s,spriteCurrentAction);
        }
    }

    private void importImage() {

        InputStream is = getClass().getResourceAsStream("/sprite.png");
        try{
            bufferedImage = ImageIO.read(is);
        }
        catch (Exception e){
            System.out.println("Exception occurred: " + e);
        }
        finally {
            try {
                is.close();
            }
            catch (Exception e){
                System.out.println("Exception occurred: " + e);
            }
        }

    }
    public void setPlayerDirection(int direction){
        this.playerDirection = direction;
        if(this.playerDirection == LEFT || this.playerDirection == RIGHT){
            this.setMoving(true);
        }
    }
    public void setMoving(boolean moving){
        this.moving = moving;
    }
    public void updatePos(){
        moving = false;

        if(left && !right){
            x -= playerSpeed;
            moving = true;
        }
        else if(right && !left){
            x += playerSpeed;
            moving = true;
        }

        if(up && !down){
            y -= playerSpeed;
            moving = true;
        } else if (down && !up) {
            y += playerSpeed;
            moving = true;
        }
    }
    private void updateAnimation() {
        ArrayList<SpriteAction> currentAnimationList =  Constants.Actions.getSpriteArray(playerAction);
        aniTick++;
        if(aniSpeed<aniTick){
            aniTick = 0;
            aniIndex++;
            aniIndex %= currentAnimationList.size()-1;
            currentPlayerAnimation = currentAnimationList.get(aniIndex);
        }
    }

    private void setAnimation() {
        if(moving){
            playerAction = RUNNING;
        }
        else
            playerAction = IDLE;
    }
}
