package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Constants {

    public static class Actions{
        public static final ArrayList<SpriteAction> RUN = new ArrayList<SpriteAction>(
                Arrays.asList(
                        SpriteAction.RUN_ONE,
                        SpriteAction.RUN_TWO,
                        SpriteAction.RUN_THREE,
                        SpriteAction.RUN_FOUR,
                        SpriteAction.RUN_FIVE,
                        SpriteAction.RUN_SIX

                )
        );

        public static final ArrayList<SpriteAction> IDLE = new ArrayList<SpriteAction>(
                Arrays.asList(
                        SpriteAction.STAND_ONE,
                        SpriteAction.STAND_TWO
                )
        );
        public static final ArrayList<SpriteAction> LOOK_UP = new ArrayList<SpriteAction>(
                Arrays.asList(
                        SpriteAction.UP_ONE,
                        SpriteAction.UP_TWO
                )
        );
        public static final ArrayList<SpriteAction> LOOK_DOWN = new ArrayList<SpriteAction>(
                Arrays.asList(
                        SpriteAction.DOWN_ONE,
                        SpriteAction.DOWN_TWO
                )
        );
        public static final ArrayList<SpriteAction> RUN_UP = new ArrayList<SpriteAction>(
                Arrays.asList(
                        SpriteAction.UP_RUN_ONE,
                        SpriteAction.UP_RUN_TWO
                )
        );
        public static final ArrayList<SpriteAction> RUN_DOWN = new ArrayList<SpriteAction>(
                Arrays.asList(
                        SpriteAction.DOWN_RUN_ONE,
                        SpriteAction.DOWN_RUN_TWO
                )
        );

        public static ArrayList<SpriteAction> getSpriteArray(int playerAction){
            if(playerAction == PositionConstants.RUNNING)
                return RUN;
            return IDLE;
        }
    }
    public static class PositionConstants{
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMP = 2;
        public static final int Die =3;
        public static final int GROUND =4;
        public static final int HIT =5;
        public static final int ATTACK_1 =6;
        public static final int ATTACK_JUMP_1 =7;
        public static final int ATTACK_JUMP_2 =8;

    }
    public static class Directions{
        public static final int LEFT = 0;
        public static final int RIGHT = 1;
        public static final int UP = 2;
        public static final int DOWN = 3;

    }
    public static class PlayerSpriteConstants{

        public static ArrayList<Integer> getDimension(SpriteAction action){
            ArrayList<Integer> coordinates = new ArrayList<>();
            String value = action.coordinates;
            String [] splitString  = value.split("X");
            for (String s : splitString) {
                coordinates.add(Integer.parseInt(s));
            }
            return coordinates;
        }
    }
}
