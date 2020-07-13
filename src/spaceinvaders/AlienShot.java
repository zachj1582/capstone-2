package spaceinvaders;

import java.awt.*;

public class AlienShot extends AbstractShot {

    protected int direction = 2;
    protected Color shotColor = Color.green;

    public AlienShot(int x, int y){
        this.x = x;
        this.shotHeight = y;
    }
//
//    @Override
//    public void Move(Graphics g) {
//
//    }
}
