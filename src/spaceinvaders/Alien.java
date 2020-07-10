package spaceinvaders;

import java.awt.*;

public class Alien {
    public static int ALIEN_HEIGHT = 25;
    public static int ALIEN_WIDTH = 15;
    private int leftPosition = 0;
    private int heightPosition = 0;
    private boolean isHit = false;
    private Image alienImage;
    SpaceInvaders spaceInvaders;


    public Alien(Image alien, SpaceInvaders spaceInvaders){
        this.alienImage = alien;
        this.spaceInvaders = spaceInvaders;
    }

    public boolean isHit() {
        return isHit;
    }


    public boolean hitAlien(int x, int y){
        if(isHit){
            return false;
        }
        if((x >= leftPosition) && (x <= (leftPosition + ALIEN_WIDTH))){
            if((y >= heightPosition) && (y <= (heightPosition + ALIEN_HEIGHT))){
                isHit = true;
                return true;
            }
        }
        return false;
    }

    public void setPosition(int x, int y){
        this.leftPosition = x;
        this.heightPosition = y;
    }

    public int getLeftPosition(){
        return leftPosition;
    }

    public int getHeightPosition() {
        return heightPosition;
    }

    public void drawAlien(Graphics g){
        if(!isHit){
            g.setColor(Color.red);
            g.fillRect(leftPosition, heightPosition, ALIEN_WIDTH, ALIEN_HEIGHT);
        }
    }
}
