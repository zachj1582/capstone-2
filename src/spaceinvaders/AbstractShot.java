package spaceinvaders;

import java.awt.*;

abstract class AbstractShot implements IMove {
    protected int SHOT_WIDTH = 2;
    protected int SHOT_HEIGHT = 5;

    protected int x;

    protected int shotHeight;
    protected int direction;
    protected boolean shotState = true;
    protected Color shotColor;

    Ship ship;

    protected boolean moveShot(){
        shotHeight += direction;
        if(shotHeight > Game.HEIGHT){
            shotState = false;
            return true;
        }
        return false;
    }

    public void drawShot(Graphics g){
        if(shotState){
            g.setColor(shotColor);
        } else {
            g.setColor(Color.black);
        }
        g.fillRect(x, shotHeight, SHOT_WIDTH, SHOT_HEIGHT);
    }

    public boolean getShotState(){
        return shotState;
    }

    public void Move(Graphics g){
        moveShot();
    }


}
