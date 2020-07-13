package spaceinvaders;

import java.awt.*;

public class ShipShot extends AbstractShot {

    protected Color shotColor = Color.white;
    protected int direction = -2;

    public ShipShot(int x, int y){
        this.x = x;
        this.shotHeight = y;
    }

}
