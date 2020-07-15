package spaceinvaders;


import java.awt.*;

public class Ship {
    public static int SHIP_HEIGHT = 25;
    public static int SHIP_WIDTH = 15;

    private int x;
    private int heightPosition;


    ShipShot shipShot = null;

    boolean hitState = false;
    private Game game;

    public Ship(Game game){
        this.game = game;
        this.x = (Game.WIDTH/2) + (SHIP_WIDTH/2);
        this.heightPosition = Game.HEIGHT - SHIP_HEIGHT - 20;
    }



    public int getHeightPosition() {
        return heightPosition;
    }

    public int getX() {
        return x;
    }

    public void drawShip(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect(x, heightPosition, SHIP_WIDTH, SHIP_HEIGHT);
        if((shipShot != null) && (shipShot.getShotState())){
            shipShot.drawShot(g);
        }
    }

    public boolean checkShot(int x, int y){
        if((x >= this.x) && (x <= (this.x + SHIP_WIDTH))){
            if((y >= heightPosition) && (y <= (heightPosition + SHIP_HEIGHT))) {
                hitState = true;
                return true;
            }
        }
        return false;
    }

    public void hitByAlien(){
        game.shotShip();
    }


}
