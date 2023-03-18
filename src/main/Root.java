package main;

import com.sun.istack.internal.NotNull;
import utils.Constants;
import static utils.SpriteAction.*;

public class Root {

    public static void testNotNullMethod(@NotNull final String a){
        System.out.println(a);
    }
    public static void main(String[] args) {
//        Game game = new Game();
//        System.out.print(Constants.PlayerSpriteConstants.getDimension(STAND_ONE));
            testNotNullMethod(null);
    }
}
